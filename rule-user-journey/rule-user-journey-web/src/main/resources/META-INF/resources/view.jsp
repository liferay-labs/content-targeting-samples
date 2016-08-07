<%--
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
--%>

<%@ include file="/init.jsp" %>

<aui:input helpMessage="interrumpible-help" label="interrumpible" name="interrumpible" type="toggle-switch" value="<%= userJourneyRuleDisplayContext.isInterrumpible() %>" />

<aui:input name="journeyArray" type="hidden" value="[]" />

<div class="user-journey-builder">
</div>

<aui:button name="addNodePage" value="add-step" />

<%
String eventName = liferayPortletResponse.getNamespace() + "selectPageNode";

ItemSelector itemSelector = userJourneyRuleDisplayContext.getItemSelector();

LayoutItemSelectorCriterion layoutItemSelectorCriterion = new LayoutItemSelectorCriterion();

List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<ItemSelectorReturnType>();

desiredItemSelectorReturnTypes.add(new UUIDItemSelectorReturnType());

layoutItemSelectorCriterion.setDesiredItemSelectorReturnTypes(desiredItemSelectorReturnTypes);

PortletURL itemSelectorURL = itemSelector.getItemSelectorURL(RequestBackedPortletURLFactoryUtil.create(liferayPortletRequest), eventName, layoutItemSelectorCriterion);
%>

<aui:script use="aui-base,user-journey-selector">
	var userJourneySelector = new UserJourneySelector(
		{
			buttonNode: '#<portlet:namespace/>addNodePage',
			eventName: '<%= eventName %>',
			itemSelectorURL: '<%= itemSelectorURL %>',
			journeyArray: <%= userJourneyRuleDisplayContext.getJourneyArray().toString() %>,
			outputNode: '#<portlet:namespace/>journeyArray',
			selectorNode: '.user-journey-builder',
			strings: {
				add: '<liferay-ui:message key="done" />',
				title: '<liferay-ui:message key="select-page" />'
			}
		}
	);
</aui:script>

<style>
	.user-journey-arrow {
		background: transparent;
		font-size: xx-large;
		font-weight: bolder;
		margin-top: -30px;
		margin-bottom: -15px;
		text-align: center;

		user-select: none;
		-moz-user-select: none;
		-khtml-user-select: none;
		-webkit-user-select: none;
		-o-user-select: none;
	}

	.user-journey-node {
		background-color: cornflowerblue;
		color: white;
		font-weight: bold;
		border-radius: 5px;
		margin: 0 auto 10px auto;
		padding: 10px;
		text-align: center;
		width: 60%;
	}

	.user-journey-delete-node {
		color: black;
		display: inline-block;
		position: absolute;
		right: 0px;
		left: 62%;
	}
</style>