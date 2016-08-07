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

package com.liferay.content.targeting.rule.mail.keywords;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.api.model.BaseJSPRule;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.exception.InvalidRuleException;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.categories.BehaviorRuleCategory;
import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;
import com.liferay.content.targeting.rule.mail.keywords.service.KeywordMatchLocalService;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

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
public class MailKeywordsRule extends BaseJSPRule {

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

		KeywordMatch keywordMatch = _keywordMatchLocalService.fetchKeywordMatch(
			anonymousUser.getAnonymousUserId(),
			ruleInstance.getRuleInstanceId());

		if (keywordMatch != null) {
			return true;
		}

		return false;
	}

	public boolean evaluate(
		Map<String, Object> context, RuleInstance ruleInstance,
		AnonymousUser anonymousUser) {

		String typeSettings = ruleInstance.getTypeSettings();

		String messageBody = GetterUtil.getString(context.get("messageBody"));

		messageBody = StringUtil.toLowerCase(messageBody);

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(typeSettings);

			for (Object object : jsonArray) {
				String keyword = GetterUtil.getString(object);

				keyword = StringUtil.toLowerCase(keyword);

				if (messageBody.contains(keyword)) {
					return true;
				}
			}
		}
		catch (JSONException jsone) {
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

	@Override
	public String getSummary(RuleInstance ruleInstance, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		String typeSettings = ruleInstance.getTypeSettings();

		String summary = StringPool.DASH;

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(typeSettings);

			StringBundler sb = new StringBundler(jsonArray.length()*2 - 1);

			for (Object object : jsonArray) {
				if (sb.length() > 0) {
					sb.append(StringPool.COMMA_AND_SPACE);
				}

				sb.append(GetterUtil.getString(object));
			}

			String keywords = sb.toString();

			summary = ResourceBundleUtil.getString(
				resourceBundle, locale, "mail-contains-keywords",
				new Object[] {keywords});
		}
		catch (JSONException jsone) {
		}

		return summary;
	}

	public String processRule(
			PortletRequest portletRequest, PortletResponse portletResponse,
			String id, Map<String, String> values)
		throws InvalidRuleException {

		String keywords = values.get("keywords");

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		String[] keywordsArray = keywords.split("[\\,\\;\\s]");

		for (String keyword : keywordsArray) {
			jsonArray.put(keyword);
		}

		return jsonArray.toJSONString();
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.mail.keywords.web)",
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

		String keywords = StringPool.BLANK;

		if (!values.isEmpty()) {
			keywords = values.get("keywords");
		}
		else if (ruleInstance != null) {
			String typeSettings = ruleInstance.getTypeSettings();

			try {
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(
					typeSettings);

				StringBundler sb = new StringBundler(jsonArray.length()*2 - 1);

				for (Object object : jsonArray) {
					if (sb.length() > 0) {
						sb.append(StringPool.COMMA);
					}

					sb.append(GetterUtil.getString(object));
				}

				keywords = sb.toString();
			}
			catch (JSONException jsone) {
			}
		}

		context.put("keywords", keywords);
	}

	@Reference(unbind = "-")
	protected void setKeywordMatchLocalService(
		KeywordMatchLocalService
			keywordMatchLocalService) {

		_keywordMatchLocalService = keywordMatchLocalService;
	}

	private KeywordMatchLocalService _keywordMatchLocalService;

}