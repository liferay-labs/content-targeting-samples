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

package com.liferay.content.targeting.rule.mail.keywords.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing KeywordMatch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatch
 * @generated
 */
@ProviderType
public class KeywordMatchCacheModel implements CacheModel<KeywordMatch>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KeywordMatchCacheModel)) {
			return false;
		}

		KeywordMatchCacheModel keywordMatchCacheModel = (KeywordMatchCacheModel)obj;

		if (keywordMatchId == keywordMatchCacheModel.keywordMatchId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, keywordMatchId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{keywordMatchId=");
		sb.append(keywordMatchId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", anonymousUserId=");
		sb.append(anonymousUserId);
		sb.append(", ruleInstanceId=");
		sb.append(ruleInstanceId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public KeywordMatch toEntityModel() {
		KeywordMatchImpl keywordMatchImpl = new KeywordMatchImpl();

		keywordMatchImpl.setKeywordMatchId(keywordMatchId);
		keywordMatchImpl.setCompanyId(companyId);

		if (modifiedDate == Long.MIN_VALUE) {
			keywordMatchImpl.setModifiedDate(null);
		}
		else {
			keywordMatchImpl.setModifiedDate(new Date(modifiedDate));
		}

		keywordMatchImpl.setAnonymousUserId(anonymousUserId);
		keywordMatchImpl.setRuleInstanceId(ruleInstanceId);

		keywordMatchImpl.resetOriginalValues();

		return keywordMatchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		keywordMatchId = objectInput.readLong();

		companyId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		anonymousUserId = objectInput.readLong();

		ruleInstanceId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(keywordMatchId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(anonymousUserId);

		objectOutput.writeLong(ruleInstanceId);
	}

	public long keywordMatchId;
	public long companyId;
	public long modifiedDate;
	public long anonymousUserId;
	public long ruleInstanceId;
}