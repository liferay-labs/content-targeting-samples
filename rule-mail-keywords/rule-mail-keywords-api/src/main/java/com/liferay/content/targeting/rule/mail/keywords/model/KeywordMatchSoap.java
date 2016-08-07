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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.content.targeting.rule.mail.keywords.service.http.KeywordMatchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.mail.keywords.service.http.KeywordMatchServiceSoap
 * @generated
 */
@ProviderType
public class KeywordMatchSoap implements Serializable {
	public static KeywordMatchSoap toSoapModel(KeywordMatch model) {
		KeywordMatchSoap soapModel = new KeywordMatchSoap();

		soapModel.setKeywordMatchId(model.getKeywordMatchId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setAnonymousUserId(model.getAnonymousUserId());
		soapModel.setRuleInstanceId(model.getRuleInstanceId());

		return soapModel;
	}

	public static KeywordMatchSoap[] toSoapModels(KeywordMatch[] models) {
		KeywordMatchSoap[] soapModels = new KeywordMatchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static KeywordMatchSoap[][] toSoapModels(KeywordMatch[][] models) {
		KeywordMatchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new KeywordMatchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new KeywordMatchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static KeywordMatchSoap[] toSoapModels(List<KeywordMatch> models) {
		List<KeywordMatchSoap> soapModels = new ArrayList<KeywordMatchSoap>(models.size());

		for (KeywordMatch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new KeywordMatchSoap[soapModels.size()]);
	}

	public KeywordMatchSoap() {
	}

	public long getPrimaryKey() {
		return _keywordMatchId;
	}

	public void setPrimaryKey(long pk) {
		setKeywordMatchId(pk);
	}

	public long getKeywordMatchId() {
		return _keywordMatchId;
	}

	public void setKeywordMatchId(long keywordMatchId) {
		_keywordMatchId = keywordMatchId;
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

	private long _keywordMatchId;
	private long _companyId;
	private Date _modifiedDate;
	private long _anonymousUserId;
	private long _ruleInstanceId;
}