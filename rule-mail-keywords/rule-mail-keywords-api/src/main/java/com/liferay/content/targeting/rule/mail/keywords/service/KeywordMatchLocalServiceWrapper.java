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

package com.liferay.content.targeting.rule.mail.keywords.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link KeywordMatchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatchLocalService
 * @generated
 */
@ProviderType
public class KeywordMatchLocalServiceWrapper implements KeywordMatchLocalService,
	ServiceWrapper<KeywordMatchLocalService> {
	public KeywordMatchLocalServiceWrapper(
		KeywordMatchLocalService keywordMatchLocalService) {
		_keywordMatchLocalService = keywordMatchLocalService;
	}

	/**
	* Adds the keyword match to the database. Also notifies the appropriate model listeners.
	*
	* @param keywordMatch the keyword match
	* @return the keyword match that was added
	*/
	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch addKeywordMatch(
		com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch keywordMatch) {
		return _keywordMatchLocalService.addKeywordMatch(keywordMatch);
	}

	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch addKeywordMatch(
		long anonymousUserId, long ruleInstanceId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _keywordMatchLocalService.addKeywordMatch(anonymousUserId,
			ruleInstanceId, serviceContext);
	}

	/**
	* Creates a new keyword match with the primary key. Does not add the keyword match to the database.
	*
	* @param keywordMatchId the primary key for the new keyword match
	* @return the new keyword match
	*/
	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch createKeywordMatch(
		long keywordMatchId) {
		return _keywordMatchLocalService.createKeywordMatch(keywordMatchId);
	}

	/**
	* Deletes the keyword match from the database. Also notifies the appropriate model listeners.
	*
	* @param keywordMatch the keyword match
	* @return the keyword match that was removed
	*/
	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch deleteKeywordMatch(
		com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch keywordMatch) {
		return _keywordMatchLocalService.deleteKeywordMatch(keywordMatch);
	}

	/**
	* Deletes the keyword match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match that was removed
	* @throws PortalException if a keyword match with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch deleteKeywordMatch(
		long keywordMatchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _keywordMatchLocalService.deleteKeywordMatch(keywordMatchId);
	}

	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch fetchKeywordMatch(
		long anonoymousUserId, long ruleInstanceId) {
		return _keywordMatchLocalService.fetchKeywordMatch(anonoymousUserId,
			ruleInstanceId);
	}

	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch fetchKeywordMatch(
		long keywordMatchId) {
		return _keywordMatchLocalService.fetchKeywordMatch(keywordMatchId);
	}

	/**
	* Returns the keyword match with the primary key.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match
	* @throws PortalException if a keyword match with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch getKeywordMatch(
		long keywordMatchId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _keywordMatchLocalService.getKeywordMatch(keywordMatchId);
	}

	/**
	* Updates the keyword match in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param keywordMatch the keyword match
	* @return the keyword match that was updated
	*/
	@Override
	public com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch updateKeywordMatch(
		com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch keywordMatch) {
		return _keywordMatchLocalService.updateKeywordMatch(keywordMatch);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _keywordMatchLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _keywordMatchLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _keywordMatchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _keywordMatchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _keywordMatchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of keyword matchs.
	*
	* @return the number of keyword matchs
	*/
	@Override
	public int getKeywordMatchsCount() {
		return _keywordMatchLocalService.getKeywordMatchsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _keywordMatchLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _keywordMatchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _keywordMatchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _keywordMatchLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the keyword matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of keyword matchs
	* @param end the upper bound of the range of keyword matchs (not inclusive)
	* @return the range of keyword matchs
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch> getKeywordMatchs(
		int start, int end) {
		return _keywordMatchLocalService.getKeywordMatchs(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _keywordMatchLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _keywordMatchLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public KeywordMatchLocalService getWrappedService() {
		return _keywordMatchLocalService;
	}

	@Override
	public void setWrappedService(
		KeywordMatchLocalService keywordMatchLocalService) {
		_keywordMatchLocalService = keywordMatchLocalService;
	}

	private KeywordMatchLocalService _keywordMatchLocalService;
}