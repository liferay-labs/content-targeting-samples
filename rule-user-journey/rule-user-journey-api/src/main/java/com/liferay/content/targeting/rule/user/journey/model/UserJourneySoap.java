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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.rule.user.journey.service.http.UserJourneyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.user.journey.service.http.UserJourneyServiceSoap
 * @generated
 */
@ProviderType
public class UserJourneySoap implements Serializable {
	public static UserJourneySoap toSoapModel(UserJourney model) {
		UserJourneySoap soapModel = new UserJourneySoap();

		soapModel.setUserJourneyId(model.getUserJourneyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setRuleInstanceId(model.getRuleInstanceId());
		soapModel.setCurrentPlid(model.getCurrentPlid());
		soapModel.setFinished(model.getFinished());

		return soapModel;
	}

	public static UserJourneySoap[] toSoapModels(UserJourney[] models) {
		UserJourneySoap[] soapModels = new UserJourneySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserJourneySoap[][] toSoapModels(UserJourney[][] models) {
		UserJourneySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserJourneySoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserJourneySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserJourneySoap[] toSoapModels(List<UserJourney> models) {
		List<UserJourneySoap> soapModels = new ArrayList<UserJourneySoap>(models.size());

		for (UserJourney model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserJourneySoap[soapModels.size()]);
	}

	public UserJourneySoap() {
	}

	public long getPrimaryKey() {
		return _userJourneyId;
	}

	public void setPrimaryKey(long pk) {
		setUserJourneyId(pk);
	}

	public long getUserJourneyId() {
		return _userJourneyId;
	}

	public void setUserJourneyId(long userJourneyId) {
		_userJourneyId = userJourneyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;
	}

	public long getRuleInstanceId() {
		return _ruleInstanceId;
	}

	public void setRuleInstanceId(long ruleInstanceId) {
		_ruleInstanceId = ruleInstanceId;
	}

	public long getCurrentPlid() {
		return _currentPlid;
	}

	public void setCurrentPlid(long currentPlid) {
		_currentPlid = currentPlid;
	}

	public boolean getFinished() {
		return _finished;
	}

	public boolean isFinished() {
		return _finished;
	}

	public void setFinished(boolean finished) {
		_finished = finished;
	}

	private long _userJourneyId;
	private long _companyId;
	private Date _modifiedDate;
	private long _anonymousUserId;
	private long _ruleInstanceId;
	private long _currentPlid;
	private boolean _finished;
}