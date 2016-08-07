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

package com.liferay.content.targeting.rule.user.journey.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.user.journey.model.UserJourney;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserJourney in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see UserJourney
 * @generated
 */
@ProviderType
public class UserJourneyCacheModel implements CacheModel<UserJourney>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserJourneyCacheModel)) {
			return false;
		}

		UserJourneyCacheModel userJourneyCacheModel = (UserJourneyCacheModel)obj;

		if (userJourneyId == userJourneyCacheModel.userJourneyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userJourneyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{userJourneyId=");
		sb.append(userJourneyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
		sb.append(", ruleInstanceId=");
		sb.append(ruleInstanceId);
		sb.append(", currentPlid=");
		sb.append(currentPlid);
		sb.append(", finished=");
		sb.append(finished);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserJourney toEntityModel() {
		UserJourneyImpl userJourneyImpl = new UserJourneyImpl();

		userJourneyImpl.setUserJourneyId(userJourneyId);
		userJourneyImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			userJourneyImpl.setModifiedDate(null);
		}
		else {
			userJourneyImpl.setModifiedDate(new Date(modifiedDate));
		}

		userJourneyImpl.setAnonymousUserId(anonymousUserId);
		userJourneyImpl.setRuleInstanceId(ruleInstanceId);
		userJourneyImpl.setCurrentPlid(currentPlid);
		userJourneyImpl.setFinished(finished);

		userJourneyImpl.resetOriginalValues();

		return userJourneyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userJourneyId = objectInput.readLong();

		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		anonymousUserId = objectInput.readLong();

		ruleInstanceId = objectInput.readLong();

		currentPlid = objectInput.readLong();

		finished = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userJourneyId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(anonymousUserId);

		objectOutput.writeLong(ruleInstanceId);

		objectOutput.writeLong(currentPlid);

		objectOutput.writeBoolean(finished);
	}

	public long userJourneyId;
	public long companyId;
	public long modifiedDate;
	public long anonymousUserId;
	public long ruleInstanceId;
	public long currentPlid;
	public boolean finished;
}