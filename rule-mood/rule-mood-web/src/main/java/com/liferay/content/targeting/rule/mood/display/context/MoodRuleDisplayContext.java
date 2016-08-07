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

package com.liferay.content.targeting.rule.mood.display.context;

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Pavel Savinov
 */
public class MoodRuleDisplayContext extends BaseRuleDisplayContext {

	public MoodRuleDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	public String getMood() {
		if (Validator.isNull(_mood)) {
			_mood = GetterUtil.getString(context.get("mood"));
		}

		return _mood;
	}

	public String[] getMoods() {
		return _MOODS;
	}

	public double getMoodThreshold() {
		if (Validator.isNull(_moodThreshold)) {
			_moodThreshold = GetterUtil.getDouble(context.get("moodThreshold"));
		}

		return _moodThreshold;
	}

	public double getMoodTtl() {
		if (Validator.isNull(_moodTtl)) {
			_moodTtl = GetterUtil.getInteger(context.get("moodTtl"));
		}

		return _moodTtl;
	}

	private static final String[] _MOODS = {
		"angry", "happy", "sad", "surprised"
	};

	private String _mood;
	private Double _moodThreshold;
	private Integer _moodTtl;

}