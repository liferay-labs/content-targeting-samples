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

package com.liferay.content.targeting.rule.user.journey.display.context;

import com.liferay.content.targeting.display.context.BaseRuleDisplayContext;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Pavel Savinov
 */
public class UserJourneyRuleDisplayContext extends BaseRuleDisplayContext {

	public UserJourneyRuleDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	public ItemSelector getItemSelector() {
		if (Validator.isNull(_itemSelector)) {
			_itemSelector = (ItemSelector)context.get("itemSelector");
		}

		return _itemSelector;
	}

	public JSONArray getJourneyArray() {
		if (Validator.isNull(_journeyArray)) {
			_journeyArray = (JSONArray)context.get("journeyArray");
		}

		if (Validator.isNull(_journeyArray)) {
			_journeyArray = JSONFactoryUtil.createJSONArray();
		}

		return _journeyArray;
	}

	public boolean isInterrumpible() {
		if (Validator.isNull(_interrumpible)) {
			_interrumpible = GetterUtil.getBoolean(
				context.get("interrumpible"));
		}

		return _interrumpible;
	}

	private Boolean _interrumpible;
	private ItemSelector _itemSelector;
	private JSONArray _journeyArray;

}