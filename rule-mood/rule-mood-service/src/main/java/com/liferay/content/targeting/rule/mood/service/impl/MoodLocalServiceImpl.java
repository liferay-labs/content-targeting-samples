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

package com.liferay.content.targeting.rule.mood.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mood.model.Mood;
import com.liferay.content.targeting.rule.mood.service.base.MoodLocalServiceBaseImpl;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

/**
 * The implementation of the mood local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.mood.service.MoodLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MoodLocalServiceBaseImpl
 * @see com.liferay.content.targeting.rule.mood.service.MoodLocalServiceUtil
 */
@ProviderType
public class MoodLocalServiceImpl extends MoodLocalServiceBaseImpl {

	@Override
	public Mood addMood(
		long anonymousUserId, long ruleInstanceId, int moodTtl,
		ServiceContext serviceContext) {

		long moodId = counterLocalService.increment();

		Mood mood = moodPersistence.create(moodId);

		mood.setCompanyId(serviceContext.getCompanyId());
		mood.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		mood.setAnonymousUserId(anonymousUserId);
		mood.setRuleInstanceId(ruleInstanceId);
		mood.setTimeToLive(moodTtl);

		moodPersistence.update(mood);

		return mood;
	}

	@Override
	public Mood fetchMood(long anonymousUserId, long ruleInstanceId) {
		return moodPersistence.fetchByA_R(anonymousUserId, ruleInstanceId);
	}

}