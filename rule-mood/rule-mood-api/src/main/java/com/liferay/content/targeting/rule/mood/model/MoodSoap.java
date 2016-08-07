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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.rule.mood.service.http.MoodServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.mood.service.http.MoodServiceSoap
 * @generated
 */
@ProviderType
public class MoodSoap implements Serializable {
	public static MoodSoap toSoapModel(Mood model) {
		MoodSoap soapModel = new MoodSoap();

		soapModel.setMoodId(model.getMoodId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setRuleInstanceId(model.getRuleInstanceId());
		soapModel.setTimeToLive(model.getTimeToLive());

		return soapModel;
	}

	public static MoodSoap[] toSoapModels(Mood[] models) {
		MoodSoap[] soapModels = new MoodSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MoodSoap[][] toSoapModels(Mood[][] models) {
		MoodSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MoodSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MoodSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MoodSoap[] toSoapModels(List<Mood> models) {
		List<MoodSoap> soapModels = new ArrayList<MoodSoap>(models.size());

		for (Mood model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MoodSoap[soapModels.size()]);
	}

	public MoodSoap() {
	}

	public long getPrimaryKey() {
		return _moodId;
	}

	public void setPrimaryKey(long pk) {
		setMoodId(pk);
	}

	public long getMoodId() {
		return _moodId;
	}

	public void setMoodId(long moodId) {
		_moodId = moodId;
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

	public long getTimeToLive() {
		return _timeToLive;
	}

	public void setTimeToLive(long timeToLive) {
		_timeToLive = timeToLive;
	}

	private long _moodId;
	private long _companyId;
	private Date _modifiedDate;
	private long _anonymousUserId;
	private long _ruleInstanceId;
	private long _timeToLive;
}