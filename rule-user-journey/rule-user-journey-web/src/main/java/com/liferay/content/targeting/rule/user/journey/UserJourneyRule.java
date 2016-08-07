/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.rule.user.journey;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.content.targeting.rule.user.journey.model.UserJourney;
import com.liferay.content.targeting.rule.user.journey.service.UserJourneyLocalService;
import com.liferay.content.targeting.rule.user.journey.util.JourneyStepsComparator;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = Rule.class)
public class UserJourneyRule extends BaseJSPRule {

	@Activate
	@Override
	public void activate() {
		super.activate();
	}

	@Deactivate
	@Override
	public void deActivate() {
		super.deActivate();
	}

	@Override
	public boolean evaluate(
			HttpServletRequest request, RuleInstance ruleInstance,
			AnonymousUser anonymousUser)
		throws Exception {

		UserJourney userJourney = _userJourneyLocalService.fetchUserJourney(
			anonymousUser.getAnonymousUserId(),
			ruleInstance.getRuleInstanceId());

		if ((userJourney != null) && userJourney.isFinished()) {
			return true;
		}

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
			ruleInstance.getTypeSettings());

		boolean interrumpible = jsonObject.getBoolean("interrumpible");

		JSONArray jsonArray = jsonObject.getJSONArray("journeyArray");

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		long userPlid = themeDisplay.getPlid();

		int userStep = getStep(jsonArray, userPlid);

		if ((userStep == -1) && !interrumpible) {
			if (userJourney != null) {
				_userJourneyLocalService.deleteUserJourney(userJourney);
			}

			return false;
		}

		if (userJourney != null) {
			long currentPlid = userJourney.getCurrentPlid();
			int currentStep = getStep(jsonArray, currentPlid);

			int stepsDiff = userStep - currentStep;

			if (stepsDiff != 1) {
				if (!interrumpible) {
					_userJourneyLocalService.deleteUserJourney(userJourney);
				}

				return false;
			}

			userJourney.setCurrentPlid(userPlid);
			userJourney.setFinished(userStep == jsonArray.length());
			userJourney.setModifiedDate(
				serviceContext.getModifiedDate(new Date()));

			_userJourneyLocalService.updateUserJourney(userJourney);

			return userJourney.isFinished();
		}
		else if ((userJourney == null) && (userStep == 1)) {
			userJourney = _userJourneyLocalService.addUserJourney(
				anonymousUser.getAnonymousUserId(),
				ruleInstance.getRuleInstanceId(), userPlid,
				(userStep == jsonArray.length()), serviceContext);

			return userJourney.isFinished();
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-envelope";
	}

	@Override
	public String getRuleCategoryKey() {
		return BehaviorRuleCategory.KEY;
	}

	public int getStep(JSONArray jsonArray, long plid) {
		Iterator<org.json.JSONObject> iterator = jsonArray.iterator();

		while (iterator.hasNext()) {
			org.json.JSONObject jsonObject = iterator.next();

			if (jsonObject.getLong("plid") == plid) {
				return jsonObject.getInt("step");
			}
		}

		return -1;
	}

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.DASH;

		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
				typeSettings);

			JSONArray journeyArray = jsonObject.getJSONArray("journeyArray");

			List<org.json.JSONObject> journeySteps = new ArrayList<>();

			Iterator<org.json.JSONObject> iterator = journeyArray.iterator();

			while (iterator.hasNext()) {
				journeySteps.add(iterator.next());
			}

			Collections.sort(journeySteps, new JourneyStepsComparator());

			StringBundler sb = new StringBundler(journeyArray.length() * 2 - 1);

			for (org.json.JSONObject stepObject : journeySteps) {
				Layout layout = _layoutLocalService.getLayout(
					stepObject.getLong("plid"));

				if (sb.length() > 0) {
					sb.append(StringPool.COMMA_AND_SPACE);
				}

				sb.append(layout.getName(locale));
			}

			summary = ResourceBundleUtil.getString(
				resourceBundle, locale, "user-journey-x",
				new Object[] {sb.toString()});
		}
		catch (Exception jsone) {
		}

		return summary;
	}

	public String processRule(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String id, Map<String, String> values)
		throws InvalidRuleException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			jsonObject.put(
				"interrumpible",
				GetterUtil.getBoolean(values.get("interrumpible")));

			JSONArray objArray = JSONFactoryUtil.createJSONArray(
				values.get("journeyArray"));

			JSONArray journeyArray = JSONFactoryUtil.createJSONArray();

			Iterator<org.json.JSONObject> iterator = objArray.iterator();

			while (iterator.hasNext()) {
				org.json.JSONObject obj = iterator.next();

				JSONObject step = JSONFactoryUtil.createJSONObject();

				step.put("step", obj.get("step"));

				Layout layout = _layoutLocalService.fetchLayoutByUuidAndGroupId(
					obj.getString("uuid"), themeDisplay.getScopeGroupId(),
					false);

				if (layout == null) {
					layout = _layoutLocalService.fetchLayoutByUuidAndGroupId(
						obj.getString("uuid"), themeDisplay.getScopeGroupId(),
						true);
				}

				if (layout == null) {
					continue;
				}

				step.put("plid", layout.getPlid());

				journeyArray.put(step);
			}

			jsonObject.put("journeyArray", journeyArray);
		}
		catch (JSONException jsone) {
		}

		return jsonObject.toJSONString();
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.user.journey.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	public boolean supportsOfflineEvaluation() {
		return true;
	}

	@Override
	protected void populateContext(
		RuleInstance ruleInstance, Map<String, Object> context,
		Map<String, String> values) {

		boolean interrumpible = false;
		JSONArray journeyArray = JSONFactoryUtil.createJSONArray();

		if (!values.isEmpty()) {
			interrumpible = GetterUtil.getBoolean(values.get("interrumpible"));

			try {
				journeyArray = JSONFactoryUtil.createJSONArray(
					values.get("journeyArray"));
			}
			catch (JSONException jsone) {
			}
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
					typeSettings);

				interrumpible = jsonObject.getBoolean("interrumpible");

				journeyArray = jsonObject.getJSONArray("journeyArray");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("interrumpible", interrumpible);
		context.put("journeyArray", journeyArray);
		context.put("itemSelector", _itemSelector);
	}

	@Reference(unbind = "-")
	protected void setItemSelector(ItemSelector itemSelector) {
		_itemSelector = itemSelector;
	}

	@Reference(unbind = "-")
	protected void setLayoutLocalService(
		LayoutLocalService layoutLocalService) {

		_layoutLocalService = layoutLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserJourneyLocalService(
		UserJourneyLocalService userJourneyLocalService) {

		_userJourneyLocalService = userJourneyLocalService;
	}

	private ItemSelector _itemSelector;
	private LayoutLocalService _layoutLocalService;
	private UserJourneyLocalService _userJourneyLocalService;

}