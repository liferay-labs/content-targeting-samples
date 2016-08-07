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

package com.liferay.content.targeting.rule.mail.keywords.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link KeywordMatch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatch
 * @generated
 */
@ProviderType
public class KeywordMatchWrapper implements KeywordMatch,
	ModelWrapper<KeywordMatch> {
	public KeywordMatchWrapper(KeywordMatch keywordMatch) {
		_keywordMatch = keywordMatch;
	}

	@Override
	public Class<?> getModelClass() {
		return KeywordMatch.class;
	}

	@Override
	public String getModelClassName() {
		return KeywordMatch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("keywordMatchId", getKeywordMatchId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("ruleInstanceId", getRuleInstanceId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long keywordMatchId = (Long)attributes.get("keywordMatchId");

		if (keywordMatchId != null) {
			setKeywordMatchId(keywordMatchId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		Long ruleInstanceId = (Long)attributes.get("ruleInstanceId");

		if (ruleInstanceId != null) {
			setRuleInstanceId(ruleInstanceId);
		}
	}

	@Override
	public KeywordMatch toEscapedModel() {
		return new KeywordMatchWrapper(_keywordMatch.toEscapedModel());
	}

	@Override
	public KeywordMatch toUnescapedModel() {
		return new KeywordMatchWrapper(_keywordMatch.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _keywordMatch.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _keywordMatch.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _keywordMatch.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _keywordMatch.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<KeywordMatch> toCacheModel() {
		return _keywordMatch.toCacheModel();
	}

	@Override
	public int compareTo(KeywordMatch keywordMatch) {
		return _keywordMatch.compareTo(keywordMatch);
	}

	@Override
	public int hashCode() {
		return _keywordMatch.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _keywordMatch.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new KeywordMatchWrapper((KeywordMatch)_keywordMatch.clone());
	}

	/**
	* Returns the anonymous user uuid of this keyword match.
	*
	* @return the anonymous user uuid of this keyword match
	*/
	@Override
	public java.lang.String getAnonymousUserUuid() {
		return _keywordMatch.getAnonymousUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _keywordMatch.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _keywordMatch.toXmlString();
	}

	/**
	* Returns the modified date of this keyword match.
	*
	* @return the modified date of this keyword match
	*/
	@Override
	public Date getModifiedDate() {
		return _keywordMatch.getModifiedDate();
	}

	/**
	* Returns the anonymous user ID of this keyword match.
	*
	* @return the anonymous user ID of this keyword match
	*/
	@Override
	public long getAnonymousUserId() {
		return _keywordMatch.getAnonymousUserId();
	}

	/**
	* Returns the company ID of this keyword match.
	*
	* @return the company ID of this keyword match
	*/
	@Override
	public long getCompanyId() {
		return _keywordMatch.getCompanyId();
	}

	/**
	* Returns the keyword match ID of this keyword match.
	*
	* @return the keyword match ID of this keyword match
	*/
	@Override
	public long getKeywordMatchId() {
		return _keywordMatch.getKeywordMatchId();
	}

	/**
	* Returns the primary key of this keyword match.
	*
	* @return the primary key of this keyword match
	*/
	@Override
	public long getPrimaryKey() {
		return _keywordMatch.getPrimaryKey();
	}

	/**
	* Returns the rule instance ID of this keyword match.
	*
	* @return the rule instance ID of this keyword match
	*/
	@Override
	public long getRuleInstanceId() {
		return _keywordMatch.getRuleInstanceId();
	}

	@Override
	public void persist() {
		_keywordMatch.persist();
	}

	/**
	* Sets the anonymous user ID of this keyword match.
	*
	* @param anonymousUserId the anonymous user ID of this keyword match
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_keywordMatch.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Sets the anonymous user uuid of this keyword match.
	*
	* @param anonymousUserUuid the anonymous user uuid of this keyword match
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_keywordMatch.setAnonymousUserUuid(anonymousUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_keywordMatch.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this keyword match.
	*
	* @param companyId the company ID of this keyword match
	*/
	@Override
	public void setCompanyId(long companyId) {
		_keywordMatch.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_keywordMatch.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_keywordMatch.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_keywordMatch.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the keyword match ID of this keyword match.
	*
	* @param keywordMatchId the keyword match ID of this keyword match
	*/
	@Override
	public void setKeywordMatchId(long keywordMatchId) {
		_keywordMatch.setKeywordMatchId(keywordMatchId);
	}

	/**
	* Sets the modified date of this keyword match.
	*
	* @param modifiedDate the modified date of this keyword match
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_keywordMatch.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_keywordMatch.setNew(n);
	}

	/**
	* Sets the primary key of this keyword match.
	*
	* @param primaryKey the primary key of this keyword match
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_keywordMatch.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_keywordMatch.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rule instance ID of this keyword match.
	*
	* @param ruleInstanceId the rule instance ID of this keyword match
	*/
	@Override
	public void setRuleInstanceId(long ruleInstanceId) {
		_keywordMatch.setRuleInstanceId(ruleInstanceId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof KeywordMatchWrapper)) {
			return false;
		}

		KeywordMatchWrapper keywordMatchWrapper = (KeywordMatchWrapper)obj;

		if (Objects.equals(_keywordMatch, keywordMatchWrapper._keywordMatch)) {
			return true;
		}

		return false;
	}

	@Override
	public KeywordMatch getWrappedModel() {
		return _keywordMatch;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _keywordMatch.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _keywordMatch.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_keywordMatch.resetOriginalValues();
	}

	private final KeywordMatch _keywordMatch;
}