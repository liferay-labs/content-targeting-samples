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

import com.liferay.content.targeting.anonymous.users.model.AnonymousUser;
import com.liferay.content.targeting.anonymous.users.util.AnonymousUsersManager;
import com.liferay.content.targeting.rule.mood.model.Mood;
import com.liferay.content.targeting.rule.mood.service.base.MoodServiceBaseImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.Date;

/**
 * The implementation of the mood remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.content.targeting.rule.mood.service.MoodService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MoodServiceBaseImpl
 * @see com.liferay.content.targeting.rule.mood.service.MoodServiceUtil
 */
@ProviderType
public class MoodServiceImpl extends MoodServiceBaseImpl {

	@Override
	public Mood saveMoodChange(
			long ruleInstanceId, int moodTtl, ServiceContext serviceContext)
		throws Exception {

		long userId = serviceContext.getUserId();

		AnonymousUser anonymousUser = _anonymousUsersManager.getAnonymousUser(
			serviceContext.getRequest(), userId);

		Mood mood = moodLocalService.fetchMood(
			anonymousUser.getAnonymousUserId(), ruleInstanceId);

		if (mood == null) {
			return moodLocalService.addMood(
				anonymousUser.getAnonymousUserId(), ruleInstanceId, moodTtl,
				serviceContext);
		}

		mood.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		return moodLocalService.updateMood(mood);
	}

	@ServiceReference(type = AnonymousUsersManager.class)
	private AnonymousUsersManager _anonymousUsersManager;

}