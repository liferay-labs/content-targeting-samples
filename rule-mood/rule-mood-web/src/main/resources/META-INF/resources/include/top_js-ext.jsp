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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="com.liferay.content.targeting.model.RuleInstance" %>
<%@ page import="com.liferay.portal.kernel.model.*" %>
<%@ page import="com.liferay.portal.kernel.service.PortletLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%@ page import="java.util.List" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
String ruleNamespace = "CT_MoodRule_";
Portlet portlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());

List<RuleInstance> ruleInstances = (List<RuleInstance>)request.getAttribute("ruleInstances");
%>

<script data-senna-track="temporary" src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/clmtrackr.js", "minifierBundleId=content.targeting.files", portlet.getTimestamp())) %>" type="text/javascript"></script>
<script data-senna-track="temporary" src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/emotion_classifier.js", "minifierBundleId=content.targeting.files", portlet.getTimestamp())) %>" type="text/javascript"></script>
<script data-senna-track="temporary" src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/emotionmodel.js", "minifierBundleId=content.targeting.files", portlet.getTimestamp())) %>" type="text/javascript"></script>
<script data-senna-track="temporary" src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/model_pca_20_svm_emotionDetection.js", "minifierBundleId=content.targeting.files", portlet.getTimestamp())) %>" type="text/javascript"></script>
<script data-senna-track="temporary" src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/Stats.js", "minifierBundleId=content.targeting.files", portlet.getTimestamp())) %>" type="text/javascript"></script>
<script data-senna-track="temporary" src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, PortalUtil.getPathContext(request) + "/js/utils.js", "minifierBundleId=content.targeting.files", portlet.getTimestamp())) %>" type="text/javascript"></script>

<div class="hidden" id="<%= ruleNamespace %>videoContainer">
	<video height="300" id="<%= ruleNamespace %>videoel" preload="auto" style="-o-transform : scaleX(-1);-webkit-transform : scaleX(-1);transform : scaleX(-1);-ms-filter : fliph; /*IE*/filter : fliph; /*IE*/width : 600px;height : 450px;" width="400" loop></video>
	<canvas height="300" id="<%= ruleNamespace %>overlay" style="position: absolute;top: 0px;left: 0px;-o-transform : scaleX(-1);-webkit-transform : scaleX(-1);transform : scaleX(-1);-ms-filter : fliph; /*IE*/filter : fliph; /*IE*/width : 600px;height : 450px;" width="400"></canvas>
</div>

<aui:script>
	<%= ruleNamespace %>saveMoodChange = function(moodThreshold) {
		if (!<%= ruleNamespace %>lock) {
			Liferay.Service(
				'/ct_mood.mood/save-mood-change',
				{
					ruleInstanceId: moodThreshold.ruleInstanceId,
					moodTtl: moodThreshold.moodTtl
				},
				function(obj) {
					if (obj && obj.moodId) {
						<%= ruleNamespace %>lock = true;

						setTimeout(
							function() {
								<%= ruleNamespace %>lock = false;
							},
							moodThreshold.moodTtl * 60000
						);
					}
				}
			);
		}
	};

	<%= ruleNamespace %>getMoodThresholds = function() {
		var thresholds = [];

		<%
		for (int idx = 0; idx < ruleInstances.size(); idx++) {
			RuleInstance ruleInstance = ruleInstances.get(idx);
		%>

			var threshold = AUI().JSON.parse('<%= ruleInstance.getTypeSettings() %>');
			var ruleInstanceId = <%= ruleInstance.getRuleInstanceId() %>;

			threshold.ruleInstanceId = ruleInstanceId;

			thresholds.push(threshold);

		<%
		}
		%>

		return thresholds;
	};

	<%= ruleNamespace %>lock = false;

	var videoElement = document.getElementById('<%= ruleNamespace %>videoel');
	var overlayElement = document.getElementById('<%= ruleNamespace %>overlay');
	var overlay2d = overlayElement.getContext('2d');

	var clmTracker = new clm.tracker({useWebGL : true});
	clmTracker.init(pModel);

	var emoClassifier = new emotionClassifier();
	emoClassifier.init(emotionModel);
	var emotionData = emoClassifier.getBlank();

	<%= ruleNamespace %>checkMood = function(currentState) {
		var moodThresholds = <%= ruleNamespace %>getMoodThresholds();

		for (var k in moodThresholds) {
			var moodThreshold = moodThresholds[k];

			if (currentState.emotion === moodThreshold.mood && currentState.value >= moodThreshold.moodThreshold) {
				<%= ruleNamespace %>saveMoodChange(moodThreshold);
			}
		}
	};

	<%= ruleNamespace %>saveReaction = function(data) {
		for (var k in data) {
			<%= ruleNamespace %>checkMood(data[k]);
		}
	};

	<%= ruleNamespace %>drawLoop = function() {
		requestAnimFrame(<%= ruleNamespace %>drawLoop);
		overlay2d.clearRect(0, 0, 400, 300);

		if (clmTracker.getCurrentPosition()) {
			clmTracker.draw(overlayElement);
		}

		var parameters = clmTracker.getCurrentParameters();

		var reaction = emoClassifier.meanPredict(parameters);
		if (reaction) {
	<%= ruleNamespace %>saveReaction(reaction);
		}
	};

	<%= ruleNamespace %>startVideo = function() {
		videoElement.play();

		clmTracker.start(videoElement);

		<%= ruleNamespace %>drawLoop();
	};

	navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.msGetUserMedia;
	window.URL = window.URL || window.webkitURL || window.msURL || window.mozURL;

	if (navigator.getUserMedia) {
		var videoSelector = {video : true};

		if (window.navigator.appVersion.match(/Chrome\/(.*?) /)) {
			var chromeVersion = parseInt(window.navigator.appVersion.match(/Chrome\/(\d+)\./)[1], 10);
			if (chromeVersion < 20) {
				videoSelector = "video";
			}
		};

		navigator.getUserMedia(videoSelector, function( stream ) {
			if (videoElement.mozCaptureStream) {
				videoElement.mozSrcObject = stream;
			} else {
				videoElement.src = (window.URL && window.URL.createObjectURL(stream)) || stream;
			}

			<%= ruleNamespace %>startVideo();
		}, function() {
			// TODO: webcam problem
		});
	} else {
		// TODO: no webcam
	}
</aui:script>