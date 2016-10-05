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
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.UUIDItemSelectorReturnType;
import com.liferay.layout.item.selector.criterion.LayoutItemSelectorCriterion;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;

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

	public PortletURL getItemSelectorURL() {
		String eventName =
			liferayPortletResponse.getNamespace() + "selectPageNode";

		ItemSelector itemSelector = getItemSelector();

		LayoutItemSelectorCriterion layoutItemSelectorCriterion =
			new LayoutItemSelectorCriterion();

		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes =
			new ArrayList<>();

		desiredItemSelectorReturnTypes.add(new UUIDItemSelectorReturnType());

		layoutItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
			desiredItemSelectorReturnTypes);

		PortletURL itemSelectorURL = itemSelector.getItemSelectorURL(
			RequestBackedPortletURLFactoryUtil.create(liferayPortletRequest),
			eventName, layoutItemSelectorCriterion);

		return itemSelectorURL;
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

	public boolean isInterruptible() {
		if (Validator.isNull(_interruptible)) {
			_interruptible = GetterUtil.getBoolean(
				context.get("interruptible"));
		}

		return _interruptible;
	}

	private Boolean _interruptible;
	private ItemSelector _itemSelector;
	private JSONArray _journeyArray;

}