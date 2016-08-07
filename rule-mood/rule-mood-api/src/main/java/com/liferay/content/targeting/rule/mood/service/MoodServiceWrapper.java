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

package com.liferay.content.targeting.rule.mood.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MoodService}.
 *
 * @author Brian Wing Shun Chan
 * @see MoodService
 * @generated
 */
@ProviderType
public class MoodServiceWrapper implements MoodService,
	ServiceWrapper<MoodService> {
	public MoodServiceWrapper(MoodService moodService) {
		_moodService = moodService;
	}

	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood saveMoodChange(
		long ruleInstanceId, int moodTtl,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws java.lang.Exception {
		return _moodService.saveMoodChange(ruleInstanceId, moodTtl,
			serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _moodService.getOSGiServiceIdentifier();
	}

	@Override
	public MoodService getWrappedService() {
		return _moodService;
	}

	@Override
	public void setWrappedService(MoodService moodService) {
		_moodService = moodService;
	}

	private MoodService _moodService;
}