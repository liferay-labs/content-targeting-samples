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

<aui:select label="mood" name="mood">

	<%
	for (String availableMood : moodRuleDisplayContext.getMoods()) {
	%>

		<aui:option label="<%= availableMood %>" selected="<%= moodRuleDisplayContext.getMood().equals(availableMood) %>" value="<%= availableMood %>" />

	<%
	}
	%>

</aui:select>

<aui:input label="mood-threshold" name="moodThreshold" value="<%= moodRuleDisplayContext.getMoodThreshold() %>">
	<aui:validator name="number" />
	<aui:validator name="min">[0.1]</aui:validator>
	<aui:validator name="max">[1.0]</aui:validator>
</aui:input>

<aui:input helpMessage="mood-ttl-help" label="mood-ttl" name="moodTtl" value="<%= moodRuleDisplayContext.getMoodTtl() %>">
	<aui:validator name="number" />
	<aui:validator name="min">[1]</aui:validator>
	<aui:validator name="max">[1440]</aui:validator>
</aui:input>