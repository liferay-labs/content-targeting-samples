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

package com.liferay.content.targeting.rule.mood;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.content.targeting.rule.mood.model.Mood;
import com.liferay.content.targeting.rule.mood.service.MoodLocalService;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringPool;

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
public class MoodRule extends BaseJSPRule {

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

		Mood mood = _moodLocalService.fetchMood(
			anonymousUser.getAnonymousUserId(),
			ruleInstance.getRuleInstanceId());

		boolean expired = false;

		if (mood != null) {
			long modifiedDate = mood.getModifiedDate().getTime();
			long ttl = mood.getTimeToLive() * 60000 + modifiedDate;

			expired = System.currentTimeMillis() > ttl;

			return !expired;
		}

		return false;
	}

	@Override
	public String getIcon() {
		return "icon-smile";
	}

	@Override
	public String getRuleCategoryKey() {
		return BehaviorRuleCategory.KEY;
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

			String moodName = ResourceBundleUtil.getString(
				resourceBundle, jsonObject.getString("mood"));

			String moodThreshold = jsonObject.getString("moodThreshold");

			String moodTtl = jsonObject.getString("moodTtl");

			summary = ResourceBundleUtil.getString(
				resourceBundle, locale, "user-mood-is-x-for-x-minutes",
				new Object[] {moodName, moodThreshold, moodTtl});
		}
		catch (JSONException jsone) {
		}

		return summary;
	}

	public String processRule(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String id, Map<String, String> values)
		throws InvalidRuleException {

		String mood = values.get("mood");
		double moodThreshold = GetterUtil.getDouble(
			values.get("moodThreshold"));
		int moodTtl = GetterUtil.getInteger(values.get("moodTtl"));

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("mood", mood);
		jsonObject.put("moodThreshold", moodThreshold);
		jsonObject.put("moodTtl", moodTtl);

		return jsonObject.toJSONString();
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.mood.web)",
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

		String mood = StringPool.BLANK;
		double moodThreshold = 0.5;
		int moodTtl = 10;

		if (!values.isEmpty()) {
			mood = values.get("mood");
			moodThreshold = GetterUtil.getDouble(values.get("moodThreshold"));
			moodTtl = GetterUtil.getInteger(values.get("moodTtl"));
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject(
					typeSettings);

				mood = jsonObject.getString("mood");
				moodThreshold = jsonObject.getDouble("moodThreshold");
				moodTtl = jsonObject.getInt("moodTtl");
			}
			catch (JSONException jsone) {
			}
		}

		context.put("mood", mood);
		context.put("moodThreshold", moodThreshold);
		context.put("moodTtl", moodTtl);
	}

	@Reference(unbind = "-")
	protected void setMoodLocalService(MoodLocalService moodLocalService) {
		_moodLocalService = moodLocalService;
	}

	private MoodLocalService _moodLocalService;

}