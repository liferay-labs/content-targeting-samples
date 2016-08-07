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

package com.liferay.content.targeting.rule.mood.model;

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
 * This class is a wrapper for {@link Mood}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Mood
 * @generated
 */
@ProviderType
public class MoodWrapper implements Mood, ModelWrapper<Mood> {
	public MoodWrapper(Mood mood) {
		_mood = mood;
	}

	@Override
	public Class<?> getModelClass() {
		return Mood.class;
	}

	@Override
	public String getModelClassName() {
		return Mood.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("moodId", getMoodId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("ruleInstanceId", getRuleInstanceId());
		attributes.put("timeToLive", getTimeToLive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long moodId = (Long)attributes.get("moodId");

		if (moodId != null) {
			setMoodId(moodId);
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

		Long timeToLive = (Long)attributes.get("timeToLive");

		if (timeToLive != null) {
			setTimeToLive(timeToLive);
		}
	}

	@Override
	public Mood toEscapedModel() {
		return new MoodWrapper(_mood.toEscapedModel());
	}

	@Override
	public Mood toUnescapedModel() {
		return new MoodWrapper(_mood.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _mood.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _mood.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _mood.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _mood.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Mood> toCacheModel() {
		return _mood.toCacheModel();
	}

	@Override
	public int compareTo(Mood mood) {
		return _mood.compareTo(mood);
	}

	@Override
	public int hashCode() {
		return _mood.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mood.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new MoodWrapper((Mood)_mood.clone());
	}

	/**
	* Returns the anonymous user uuid of this mood.
	*
	* @return the anonymous user uuid of this mood
	*/
	@Override
	public java.lang.String getAnonymousUserUuid() {
		return _mood.getAnonymousUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _mood.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _mood.toXmlString();
	}

	/**
	* Returns the modified date of this mood.
	*
	* @return the modified date of this mood
	*/
	@Override
	public Date getModifiedDate() {
		return _mood.getModifiedDate();
	}

	/**
	* Returns the anonymous user ID of this mood.
	*
	* @return the anonymous user ID of this mood
	*/
	@Override
	public long getAnonymousUserId() {
		return _mood.getAnonymousUserId();
	}

	/**
	* Returns the company ID of this mood.
	*
	* @return the company ID of this mood
	*/
	@Override
	public long getCompanyId() {
		return _mood.getCompanyId();
	}

	/**
	* Returns the mood ID of this mood.
	*
	* @return the mood ID of this mood
	*/
	@Override
	public long getMoodId() {
		return _mood.getMoodId();
	}

	/**
	* Returns the primary key of this mood.
	*
	* @return the primary key of this mood
	*/
	@Override
	public long getPrimaryKey() {
		return _mood.getPrimaryKey();
	}

	/**
	* Returns the rule instance ID of this mood.
	*
	* @return the rule instance ID of this mood
	*/
	@Override
	public long getRuleInstanceId() {
		return _mood.getRuleInstanceId();
	}

	/**
	* Returns the time to live of this mood.
	*
	* @return the time to live of this mood
	*/
	@Override
	public long getTimeToLive() {
		return _mood.getTimeToLive();
	}

	@Override
	public void persist() {
		_mood.persist();
	}

	/**
	* Sets the anonymous user ID of this mood.
	*
	* @param anonymousUserId the anonymous user ID of this mood
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_mood.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Sets the anonymous user uuid of this mood.
	*
	* @param anonymousUserUuid the anonymous user uuid of this mood
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_mood.setAnonymousUserUuid(anonymousUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mood.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this mood.
	*
	* @param companyId the company ID of this mood
	*/
	@Override
	public void setCompanyId(long companyId) {
		_mood.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_mood.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_mood.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_mood.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this mood.
	*
	* @param modifiedDate the modified date of this mood
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_mood.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the mood ID of this mood.
	*
	* @param moodId the mood ID of this mood
	*/
	@Override
	public void setMoodId(long moodId) {
		_mood.setMoodId(moodId);
	}

	@Override
	public void setNew(boolean n) {
		_mood.setNew(n);
	}

	/**
	* Sets the primary key of this mood.
	*
	* @param primaryKey the primary key of this mood
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_mood.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_mood.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rule instance ID of this mood.
	*
	* @param ruleInstanceId the rule instance ID of this mood
	*/
	@Override
	public void setRuleInstanceId(long ruleInstanceId) {
		_mood.setRuleInstanceId(ruleInstanceId);
	}

	/**
	* Sets the time to live of this mood.
	*
	* @param timeToLive the time to live of this mood
	*/
	@Override
	public void setTimeToLive(long timeToLive) {
		_mood.setTimeToLive(timeToLive);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MoodWrapper)) {
			return false;
		}

		MoodWrapper moodWrapper = (MoodWrapper)obj;

		if (Objects.equals(_mood, moodWrapper._mood)) {
			return true;
		}

		return false;
	}

	@Override
	public Mood getWrappedModel() {
		return _mood;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _mood.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _mood.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_mood.resetOriginalValues();
	}

	private final Mood _mood;
}