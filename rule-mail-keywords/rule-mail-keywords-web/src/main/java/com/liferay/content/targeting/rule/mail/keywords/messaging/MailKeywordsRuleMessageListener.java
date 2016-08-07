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

package com.liferay.content.targeting.rule.mail.keywords.messaging;

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.service.AnonymousUserLocalService;
import com.liferay.content.targeting.api.model.Rule;
import com.liferay.content.targeting.model.RuleInstance;
import com.liferay.content.targeting.model.UserSegment;
import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;
import com.liferay.content.targeting.rule.mail.keywords.service.KeywordMatchLocalService;
import com.liferay.content.targeting.service.UserSegmentLocalService;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Pavel Savinov
 */
@Component(
	immediate = true, property = {"destination.name=" + DestinationNames.MAIL},
	service = MessageListener.class
)
public class MailKeywordsRuleMessageListener extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		Object payload = message.getPayload();

		if (!(payload instanceof MailMessage)) {
			return;
		}

		MailMessage mailMessage = (MailMessage)payload;

		InternetAddress[] toAddresses = mailMessage.getTo();

		User user = null;

		long companyId = CompanyThreadLocal.getCompanyId();

		List<Group> activeGroups = _groupLocalService.getActiveGroups(
			companyId, true);

		List<Long> groupIdList = new ArrayList<>();

		for (Group group : activeGroups) {
			groupIdList.add(group.getGroupId());
		}

		List<UserSegment> userSegments =
			_userSegmentLocalService.getUserSegments(
				ArrayUtil.toLongArray(groupIdList));

		Map<String, Object> context = new HashMap<>();

		context.put("messageBody", mailMessage.getBody());

		List<AnonymousUser> anonymousUsers = new ArrayList<>();

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		if (serviceContext == null) {
			serviceContext = new ServiceContext();
		}

		serviceContext.setCompanyId(companyId);

		for (InternetAddress internetAddress : toAddresses) {
			String email = internetAddress.getAddress();

			user = _userLocalService.fetchUserByEmailAddress(companyId, email);

			if (user == null) {
				continue;
			}

			AnonymousUser anonymousUser =
				_anonymousUserLocalService.fetchAnonymousUserByUserId(
					user.getUserId());

			if (anonymousUser == null) {
				anonymousUser = _anonymousUserLocalService.addAnonymousUser(
					user.getUserId(), "", "", serviceContext);
			}

			anonymousUsers.add(anonymousUser);
		}

		for (AnonymousUser anonymousUser : anonymousUsers) {
			saveMatches(anonymousUser, context, userSegments, serviceContext);
		}
	}

	protected void saveMatch(
		AnonymousUser anonymousUser, Map<String, Object> context,
		UserSegment userSegment, ServiceContext serviceContext) {

		for (RuleInstance ruleInstance : userSegment.getRuleInstances()) {
			if (!ruleInstance.getRuleKey().equals(_rule.getRuleKey())) {
				continue;
			}

			if (!_rule.evaluate(context, ruleInstance, anonymousUser)) {
				continue;
			}

			updateAnonymousUserUserSegment(
				anonymousUser, ruleInstance, serviceContext);
		}
	}

	protected void saveMatches(
		AnonymousUser anonymousUser, Map<String, Object> context,
		List<UserSegment> userSegments, ServiceContext serviceContext) {

		for (UserSegment userSegment : userSegments) {
			saveMatch(anonymousUser, context, userSegment, serviceContext);
		}
	}

	@Reference(unbind = "-")
	protected void setAnonymousUserLocalService(
		AnonymousUserLocalService anonymousUserLocalService) {

		_anonymousUserLocalService = anonymousUserLocalService;
	}

	@Reference(unbind = "-")
	protected void setGroupLocalService(GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}

	@Reference(unbind = "-")
	protected void setKeywordMatchLocalService(
		KeywordMatchLocalService keywordMatchLocalService) {

		_keywordMatchLocalService = keywordMatchLocalService;
	}

	@Reference(
		target = "(component.name=com.liferay.content.targeting.rule.mail.keywords.MailKeywordsRule)",
		unbind = "-"
	)
	protected void setRule(Rule rule) {
		_rule = rule;
	}

	@Reference(unbind = "-")
	protected void setUserLocalServiceUtil(UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}

	@Reference(unbind = "-")
	protected void setUserSegmentLocalService(
		UserSegmentLocalService userSegmentLocalService) {

		_userSegmentLocalService = userSegmentLocalService;
	}

	protected void updateAnonymousUserUserSegment(
		AnonymousUser anonymousUser, RuleInstance ruleInstance,
		ServiceContext serviceContext) {

		KeywordMatch keywordMatch = _keywordMatchLocalService.fetchKeywordMatch(
			anonymousUser.getAnonymousUserId(),
			ruleInstance.getRuleInstanceId());

		if (keywordMatch == null) {
			_keywordMatchLocalService.addKeywordMatch(
				anonymousUser.getAnonymousUserId(),
				ruleInstance.getRuleInstanceId(), serviceContext);

			return;
		}

		keywordMatch.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));

		_keywordMatchLocalService.updateKeywordMatch(keywordMatch);
	}

	private AnonymousUserLocalService _anonymousUserLocalService;
	private GroupLocalService _groupLocalService;
	private KeywordMatchLocalService _keywordMatchLocalService;
	private Rule _rule;
	private UserLocalService _userLocalService;
	private UserSegmentLocalService _userSegmentLocalService;

}