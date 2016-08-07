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

package com.liferay.content.targeting.rule.mood.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MoodLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MoodLocalService
 * @generated
 */
@ProviderType
public class MoodLocalServiceWrapper implements MoodLocalService,
	ServiceWrapper<MoodLocalService> {
	public MoodLocalServiceWrapper(MoodLocalService moodLocalService) {
		_moodLocalService = moodLocalService;
	}

	/**
	* Adds the mood to the database. Also notifies the appropriate model listeners.
	*
	* @param mood the mood
	* @return the mood that was added
	*/
	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood addMood(
		com.liferay.content.targeting.rule.mood.model.Mood mood) {
		return _moodLocalService.addMood(mood);
	}

	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood addMood(
		long anonymousUserId, long ruleInstanceId, int moodTtl,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _moodLocalService.addMood(anonymousUserId, ruleInstanceId,
			moodTtl, serviceContext);
	}

	/**
	* Creates a new mood with the primary key. Does not add the mood to the database.
	*
	* @param moodId the primary key for the new mood
	* @return the new mood
	*/
	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood createMood(
		long moodId) {
		return _moodLocalService.createMood(moodId);
	}

	/**
	* Deletes the mood from the database. Also notifies the appropriate model listeners.
	*
	* @param mood the mood
	* @return the mood that was removed
	*/
	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood deleteMood(
		com.liferay.content.targeting.rule.mood.model.Mood mood) {
		return _moodLocalService.deleteMood(mood);
	}

	/**
	* Deletes the mood with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param moodId the primary key of the mood
	* @return the mood that was removed
	* @throws PortalException if a mood with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood deleteMood(
		long moodId) throws com.liferay.portal.kernel.exception.PortalException {
		return _moodLocalService.deleteMood(moodId);
	}

	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood fetchMood(
		long anonymousUserId, long ruleInstanceId) {
		return _moodLocalService.fetchMood(anonymousUserId, ruleInstanceId);
	}

	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood fetchMood(
		long moodId) {
		return _moodLocalService.fetchMood(moodId);
	}

	/**
	* Returns the mood with the primary key.
	*
	* @param moodId the primary key of the mood
	* @return the mood
	* @throws PortalException if a mood with the primary key could not be found
	*/
	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood getMood(
		long moodId) throws com.liferay.portal.kernel.exception.PortalException {
		return _moodLocalService.getMood(moodId);
	}

	/**
	* Updates the mood in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param mood the mood
	* @return the mood that was updated
	*/
	@Override
	public com.liferay.content.targeting.rule.mood.model.Mood updateMood(
		com.liferay.content.targeting.rule.mood.model.Mood mood) {
		return _moodLocalService.updateMood(mood);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _moodLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _moodLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _moodLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _moodLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _moodLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of moods.
	*
	* @return the number of moods
	*/
	@Override
	public int getMoodsCount() {
		return _moodLocalService.getMoodsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _moodLocalService.getOSGiServiceIdentifier();
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
		return _moodLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.mood.model.impl.MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _moodLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.mood.model.impl.MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _moodLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the moods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.rule.mood.model.impl.MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @return the range of moods
	*/
	@Override
	public java.util.List<com.liferay.content.targeting.rule.mood.model.Mood> getMoods(
		int start, int end) {
		return _moodLocalService.getMoods(start, end);
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
		return _moodLocalService.dynamicQueryCount(dynamicQuery);
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
		return _moodLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public MoodLocalService getWrappedService() {
		return _moodLocalService;
	}

	@Override
	public void setWrappedService(MoodLocalService moodLocalService) {
		_moodLocalService = moodLocalService;
	}

	private MoodLocalService _moodLocalService;
}