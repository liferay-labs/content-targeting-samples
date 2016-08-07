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

package com.liferay.content.targeting.rule.mail.keywords.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;
import com.liferay.content.targeting.rule.mail.keywords.service.base.KeywordMatchLocalServiceBaseImpl;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the keyword match local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.mail.keywords.service.KeywordMatchLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatchLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.mail.keywords.service.KeywordMatchLocalServiceUtil
 */
@ProviderType
public class KeywordMatchLocalServiceImpl
	extends KeywordMatchLocalServiceBaseImpl {

	@Override
	public KeywordMatch addKeywordMatch(
		long anonymousUserId, long ruleInstanceId,
		ServiceContext serviceContext) {

		long keywordMatchId = counterLocalService.increment();

		KeywordMatch keywordMatch = keywordMatchPersistence.create(
			keywordMatchId);

		keywordMatch.setCompanyId(serviceContext.getCompanyId());
		keywordMatch.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));

		keywordMatch.setAnonymousUserId(anonymousUserId);
		keywordMatch.setRuleInstanceId(ruleInstanceId);

		keywordMatchPersistence.update(keywordMatch);

		return keywordMatch;
	}

	@Override
	public KeywordMatch fetchKeywordMatch(
		long anonoymousUserId, long ruleInstanceId) {

		return keywordMatchPersistence.fetchByA_R(
			anonoymousUserId, ruleInstanceId);
	}

}