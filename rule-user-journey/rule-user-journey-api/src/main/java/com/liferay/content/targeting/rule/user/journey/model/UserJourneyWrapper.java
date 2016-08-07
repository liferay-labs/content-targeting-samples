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

package com.liferay.content.targeting.rule.user.journey.model;

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
 * This class is a wrapper for {@link UserJourney}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserJourney
 * @generated
 */
@ProviderType
public class UserJourneyWrapper implements UserJourney,
	ModelWrapper<UserJourney> {
	public UserJourneyWrapper(UserJourney userJourney) {
		_userJourney = userJourney;
	}

	@Override
	public Class<?> getModelClass() {
		return UserJourney.class;
	}

	@Override
	public String getModelClassName() {
		return UserJourney.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userJourneyId", getUserJourneyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("ruleInstanceId", getRuleInstanceId());
		attributes.put("currentPlid", getCurrentPlid());
		attributes.put("finished", getFinished());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userJourneyId = (Long)attributes.get("userJourneyId");

		if (userJourneyId != null) {
			setUserJourneyId(userJourneyId);
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

		Long currentPlid = (Long)attributes.get("currentPlid");

		if (currentPlid != null) {
			setCurrentPlid(currentPlid);
		}

		Boolean finished = (Boolean)attributes.get("finished");

		if (finished != null) {
			setFinished(finished);
		}
	}

	@Override
	public UserJourney toEscapedModel() {
		return new UserJourneyWrapper(_userJourney.toEscapedModel());
	}

	@Override
	public UserJourney toUnescapedModel() {
		return new UserJourneyWrapper(_userJourney.toUnescapedModel());
	}

	/**
	* Returns the finished of this user journey.
	*
	* @return the finished of this user journey
	*/
	@Override
	public boolean getFinished() {
		return _userJourney.getFinished();
	}

	@Override
	public boolean isCachedModel() {
		return _userJourney.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _userJourney.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this user journey is finished.
	*
	* @return <code>true</code> if this user journey is finished; <code>false</code> otherwise
	*/
	@Override
	public boolean isFinished() {
		return _userJourney.isFinished();
	}

	@Override
	public boolean isNew() {
		return _userJourney.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _userJourney.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<UserJourney> toCacheModel() {
		return _userJourney.toCacheModel();
	}

	@Override
	public int compareTo(UserJourney userJourney) {
		return _userJourney.compareTo(userJourney);
	}

	@Override
	public int hashCode() {
		return _userJourney.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userJourney.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new UserJourneyWrapper((UserJourney)_userJourney.clone());
	}

	/**
	* Returns the anonymous user uuid of this user journey.
	*
	* @return the anonymous user uuid of this user journey
	*/
	@Override
	public java.lang.String getAnonymousUserUuid() {
		return _userJourney.getAnonymousUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _userJourney.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userJourney.toXmlString();
	}

	/**
	* Returns the modified date of this user journey.
	*
	* @return the modified date of this user journey
	*/
	@Override
	public Date getModifiedDate() {
		return _userJourney.getModifiedDate();
	}

	/**
	* Returns the anonymous user ID of this user journey.
	*
	* @return the anonymous user ID of this user journey
	*/
	@Override
	public long getAnonymousUserId() {
		return _userJourney.getAnonymousUserId();
	}

	/**
	* Returns the company ID of this user journey.
	*
	* @return the company ID of this user journey
	*/
	@Override
	public long getCompanyId() {
		return _userJourney.getCompanyId();
	}

	/**
	* Returns the current plid of this user journey.
	*
	* @return the current plid of this user journey
	*/
	@Override
	public long getCurrentPlid() {
		return _userJourney.getCurrentPlid();
	}

	/**
	* Returns the primary key of this user journey.
	*
	* @return the primary key of this user journey
	*/
	@Override
	public long getPrimaryKey() {
		return _userJourney.getPrimaryKey();
	}

	/**
	* Returns the rule instance ID of this user journey.
	*
	* @return the rule instance ID of this user journey
	*/
	@Override
	public long getRuleInstanceId() {
		return _userJourney.getRuleInstanceId();
	}

	/**
	* Returns the user journey ID of this user journey.
	*
	* @return the user journey ID of this user journey
	*/
	@Override
	public long getUserJourneyId() {
		return _userJourney.getUserJourneyId();
	}

	@Override
	public void persist() {
		_userJourney.persist();
	}

	/**
	* Sets the anonymous user ID of this user journey.
	*
	* @param anonymousUserId the anonymous user ID of this user journey
	*/
	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_userJourney.setAnonymousUserId(anonymousUserId);
	}

	/**
	* Sets the anonymous user uuid of this user journey.
	*
	* @param anonymousUserUuid the anonymous user uuid of this user journey
	*/
	@Override
	public void setAnonymousUserUuid(java.lang.String anonymousUserUuid) {
		_userJourney.setAnonymousUserUuid(anonymousUserUuid);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userJourney.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this user journey.
	*
	* @param companyId the company ID of this user journey
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userJourney.setCompanyId(companyId);
	}

	/**
	* Sets the current plid of this user journey.
	*
	* @param currentPlid the current plid of this user journey
	*/
	@Override
	public void setCurrentPlid(long currentPlid) {
		_userJourney.setCurrentPlid(currentPlid);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_userJourney.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_userJourney.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_userJourney.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this user journey is finished.
	*
	* @param finished the finished of this user journey
	*/
	@Override
	public void setFinished(boolean finished) {
		_userJourney.setFinished(finished);
	}

	/**
	* Sets the modified date of this user journey.
	*
	* @param modifiedDate the modified date of this user journey
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_userJourney.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_userJourney.setNew(n);
	}

	/**
	* Sets the primary key of this user journey.
	*
	* @param primaryKey the primary key of this user journey
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userJourney.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_userJourney.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rule instance ID of this user journey.
	*
	* @param ruleInstanceId the rule instance ID of this user journey
	*/
	@Override
	public void setRuleInstanceId(long ruleInstanceId) {
		_userJourney.setRuleInstanceId(ruleInstanceId);
	}

	/**
	* Sets the user journey ID of this user journey.
	*
	* @param userJourneyId the user journey ID of this user journey
	*/
	@Override
	public void setUserJourneyId(long userJourneyId) {
		_userJourney.setUserJourneyId(userJourneyId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserJourneyWrapper)) {
			return false;
		}

		UserJourneyWrapper userJourneyWrapper = (UserJourneyWrapper)obj;

		if (Objects.equals(_userJourney, userJourneyWrapper._userJourney)) {
			return true;
		}

		return false;
	}

	@Override
	public UserJourney getWrappedModel() {
		return _userJourney;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _userJourney.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _userJourney.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_userJourney.resetOriginalValues();
	}

	private final UserJourney _userJourney;
}