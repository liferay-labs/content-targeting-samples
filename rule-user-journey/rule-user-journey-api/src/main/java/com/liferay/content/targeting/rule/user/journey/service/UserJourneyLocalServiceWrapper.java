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

package com.liferay.content.targeting.rule.user.journey.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserJourneyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserJourneyLocalService
 * @generated
 */
@ProviderType
public class UserJourneyLocalServiceWrapper implements UserJourneyLocalService,
	ServiceWrapper<UserJourneyLocalService> {
	public UserJourneyLocalServiceWrapper(
		UserJourneyLocalService userJourneyLocalService) {
		_userJourneyLocalService = userJourneyLocalService;
	}

	/**
	* Adds the user journey to the database. Also notifies the appropriate model listeners.
	*
	* @param userJourney the user journey
	* @return the user journey that was added
	*/
	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney addUserJourney(
		com.liferay.content.targeting.rule.user.journey.model.UserJourney userJourney) {
		return _userJourneyLocalService.addUserJourney(userJourney);
	}

	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney addUserJourney(
		long anonymousUserId, long ruleInstanceId, long plid, boolean finished,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _userJourneyLocalService.addUserJourney(anonymousUserId,
			ruleInstanceId, plid, finished, serviceContext);
	}

	/**
	* Creates a new user journey with the primary key. Does not add the user journey to the database.
	*
	* @param userJourneyId the primary key for the new user journey
	* @return the new user journey
	*/
	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney createUserJourney(
		long userJourneyId) {
		return _userJourneyLocalService.createUserJourney(userJourneyId);
	}

	/**
	* Deletes the user journey from the database. Also notifies the appropriate model listeners.
	*
	* @param userJourney the user journey
	* @return the user journey that was removed
	*/
	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney deleteUserJourney(
		com.liferay.content.targeting.rule.user.journey.model.UserJourney userJourney) {
		return _userJourneyLocalService.deleteUserJourney(userJourney);
	}

	/**
	* Deletes the user journey with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey that was removed
	* @throws PortalException if a user journey with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney deleteUserJourney(
		long userJourneyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userJourneyLocalService.deleteUserJourney(userJourneyId);
	}

	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney fetchUserJourney(
		long anonymousUserId, long ruleInstanceId) {
		return _userJourneyLocalService.fetchUserJourney(anonymousUserId,
			ruleInstanceId);
	}

	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney fetchUserJourney(
		long userJourneyId) {
		return _userJourneyLocalService.fetchUserJourney(userJourneyId);
	}

	/**
	* Returns the user journey with the primary key.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey
	* @throws PortalException if a user journey with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney getUserJourney(
		long userJourneyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userJourneyLocalService.getUserJourney(userJourneyId);
	}

	/**
	* Updates the user journey in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userJourney the user journey
	* @return the user journey that was updated
	*/
	@Override
	public com.liferay.content.targeting.rule.user.journey.model.UserJourney updateUserJourney(
		com.liferay.content.targeting.rule.user.journey.model.UserJourney userJourney) {
		return _userJourneyLocalService.updateUserJourney(userJourney);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _userJourneyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userJourneyLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _userJourneyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userJourneyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _userJourneyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of user journeies.
	*
	* @return the number of user journeies
	*/
	@Override
	public int getUserJourneiesCount() {
		return _userJourneyLocalService.getUserJourneiesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userJourneyLocalService.getOSGiServiceIdentifier();
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
		return _userJourneyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.user.journey.model.impl.UserJourneyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userJourneyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.user.journey.model.impl.UserJourneyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userJourneyLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the user journeies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.user.journey.model.impl.UserJourneyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user journeies
	* @param end the upper bound of the range of user journeies (not inclusive)
	* @return the range of user journeies
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.rule.user.journey.model.UserJourney> getUserJourneies(
		int start, int end) {
		return _userJourneyLocalService.getUserJourneies(start, end);
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
		return _userJourneyLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userJourneyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public UserJourneyLocalService getWrappedService() {
		return _userJourneyLocalService;
	}

	@Override
	public void setWrappedService(
		UserJourneyLocalService userJourneyLocalService) {
		_userJourneyLocalService = userJourneyLocalService;
	}

	private UserJourneyLocalService _userJourneyLocalService;
}