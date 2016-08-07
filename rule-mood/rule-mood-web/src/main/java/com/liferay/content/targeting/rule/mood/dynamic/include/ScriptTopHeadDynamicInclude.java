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

package com.liferay.content.targeting.rule.mood.dynamic.include;

import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.rule.mood.MoodRule;
import com.liferay.content.targeting.service.RuleInstanceLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(immediate = true, service = DynamicInclude.class)
public class ScriptTopHeadDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		DynamicQuery dynamicQuery = _ruleInstanceLocalService.dynamicQuery();

		Property ruleKey = PropertyFactoryUtil.forName("ruleKey");

		dynamicQuery.add(ruleKey.eq(MoodRule.class.getSimpleName()));

		List<RuleInstance> ruleInstances =
			_ruleInstanceLocalService.dynamicQuery(dynamicQuery);

		request.setAttribute("ruleInstances", ruleInstances);

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher(_JSP_PATH);

		try {
			requestDispatcher.include(request, response);
		}
		catch (ServletException se) {
			_log.error("Unable to include JSP " + _JSP_PATH, se);

			throw new IOException("Unable to include JSP " + _JSP_PATH, se);
		}
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"/html/common/themes/top_head.jsp#post");
	}

	@Reference(unbind = "-")
	protected void setRuleInstanceLocalService(
		RuleInstanceLocalService ruleInstanceLocalService) {

		_ruleInstanceLocalService = ruleInstanceLocalService;
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.content.targeting.rule.mood.web)",
		unbind = "-"
	)
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final String _JSP_PATH = "/include/top_js-ext.jsp";

	private static final Log _log = LogFactoryUtil.getLog(
		ScriptTopHeadDynamicInclude.class);

	private RuleInstanceLocalService _ruleInstanceLocalService;
	private ServletContext _servletContext;

}