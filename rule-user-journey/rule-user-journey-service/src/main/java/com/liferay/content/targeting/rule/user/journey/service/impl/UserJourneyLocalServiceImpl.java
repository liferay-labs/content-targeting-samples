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

package com.liferay.content.targeting.rule.user.journey.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.user.journey.model.UserJourney;
import com.liferay.content.targeting.rule.user.journey.service.base.UserJourneyLocalServiceBaseImpl;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the user journey local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.user.journey.service.UserJourneyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserJourneyLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.user.journey.service.UserJourneyLocalServiceUtil
 */
@ProviderType
public class UserJourneyLocalServiceImpl
	extends UserJourneyLocalServiceBaseImpl {

	@Override
	public UserJourney addUserJourney(
		long anonymousUserId, long ruleInstanceId, long plid, boolean finished,
		ServiceContext serviceContext) {

		long userJourneyId = counterLocalService.increment();

		UserJourney userJourney = userJourneyPersistence.create(userJourneyId);

		userJourney.setCompanyId(serviceContext.getCompanyId());
		userJourney.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		userJourney.setAnonymousUserId(anonymousUserId);
		userJourney.setRuleInstanceId(ruleInstanceId);
		userJourney.setCurrentPlid(plid);
		userJourney.setFinished(finished);

		userJourneyPersistence.update(userJourney);

		return userJourney;
	}

	@Override
	public UserJourney fetchUserJourney(
		long anonymousUserId, long ruleInstanceId) {

		return userJourneyPersistence.fetchByA_R(
			anonymousUserId, ruleInstanceId);
	}

}