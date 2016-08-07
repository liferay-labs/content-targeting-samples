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

package com.liferay.content.targeting.rule.mood.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mood.model.Mood;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Mood in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Mood
 * @generated
 */
@ProviderType
public class MoodCacheModel implements CacheModel<Mood>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MoodCacheModel)) {
			return false;
		}

		MoodCacheModel moodCacheModel = (MoodCacheModel)obj;

		if (moodId == moodCacheModel.moodId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, moodId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{moodId=");
		sb.append(moodId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
		sb.append(", ruleInstanceId=");
		sb.append(ruleInstanceId);
		sb.append(", timeToLive=");
		sb.append(timeToLive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Mood toEntityModel() {
		MoodImpl moodImpl = new MoodImpl();

		moodImpl.setMoodId(moodId);
		moodImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			moodImpl.setModifiedDate(null);
		}
		else {
			moodImpl.setModifiedDate(new Date(modifiedDate));
		}

		moodImpl.setAnonymousUserId(anonymousUserId);
		moodImpl.setRuleInstanceId(ruleInstanceId);
		moodImpl.setTimeToLive(timeToLive);

		moodImpl.resetOriginalValues();

		return moodImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		moodId = objectInput.readLong();

		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		anonymousUserId = objectInput.readLong();

		ruleInstanceId = objectInput.readLong();

		timeToLive = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(moodId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(anonymousUserId);

		objectOutput.writeLong(ruleInstanceId);

		objectOutput.writeLong(timeToLive);
	}

	public long moodId;
	public long companyId;
	public long modifiedDate;
	public long anonymousUserId;
	public long ruleInstanceId;
	public long timeToLive;
}