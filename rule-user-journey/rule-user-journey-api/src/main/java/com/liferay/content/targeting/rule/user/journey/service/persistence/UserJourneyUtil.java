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

package com.liferay.content.targeting.rule.user.journey.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.user.journey.model.UserJourney;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the user journey service. This utility wraps {@link com.liferay.content.targeting.rule.user.journey.service.persistence.impl.UserJourneyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserJourneyPersistence
 * @see com.liferay.content.targeting.rule.user.journey.service.persistence.impl.UserJourneyPersistenceImpl
 * @generated
 */
@ProviderType
public class UserJourneyUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserJourney userJourney) {
		getPersistence().clearCache(userJourney);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserJourney> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserJourney> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserJourney> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserJourney> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserJourney update(UserJourney userJourney) {
		return getPersistence().update(userJourney);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserJourney update(UserJourney userJourney,
		ServiceContext serviceContext) {
		return getPersistence().update(userJourney, serviceContext);
	}

	/**
	* Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchUserJourneyException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching user journey
	* @throws NoSuchUserJourneyException if a matching user journey could not be found
	*/
	public static UserJourney findByA_R(long anonymousUserId,
		long ruleInstanceId)
		throws com.liferay.content.targeting.rule.user.journey.exception.NoSuchUserJourneyException {
		return getPersistence().findByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching user journey, or <code>null</code> if a matching user journey could not be found
	*/
	public static UserJourney fetchByA_R(long anonymousUserId,
		long ruleInstanceId) {
		return getPersistence().fetchByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user journey, or <code>null</code> if a matching user journey could not be found
	*/
	public static UserJourney fetchByA_R(long anonymousUserId,
		long ruleInstanceId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByA_R(anonymousUserId, ruleInstanceId,
			retrieveFromCache);
	}

	/**
	* Removes the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the user journey that was removed
	*/
	public static UserJourney removeByA_R(long anonymousUserId,
		long ruleInstanceId)
		throws com.liferay.content.targeting.rule.user.journey.exception.NoSuchUserJourneyException {
		return getPersistence().removeByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the number of user journeies where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching user journeies
	*/
	public static int countByA_R(long anonymousUserId, long ruleInstanceId) {
		return getPersistence().countByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Caches the user journey in the entity cache if it is enabled.
	*
	* @param userJourney the user journey
	*/
	public static void cacheResult(UserJourney userJourney) {
		getPersistence().cacheResult(userJourney);
	}

	/**
	* Caches the user journeies in the entity cache if it is enabled.
	*
	* @param userJourneies the user journeies
	*/
	public static void cacheResult(List<UserJourney> userJourneies) {
		getPersistence().cacheResult(userJourneies);
	}

	/**
	* Creates a new user journey with the primary key. Does not add the user journey to the database.
	*
	* @param userJourneyId the primary key for the new user journey
	* @return the new user journey
	*/
	public static UserJourney create(long userJourneyId) {
		return getPersistence().create(userJourneyId);
	}

	/**
	* Removes the user journey with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey that was removed
	* @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	*/
	public static UserJourney remove(long userJourneyId)
		throws com.liferay.content.targeting.rule.user.journey.exception.NoSuchUserJourneyException {
		return getPersistence().remove(userJourneyId);
	}

	public static UserJourney updateImpl(UserJourney userJourney) {
		return getPersistence().updateImpl(userJourney);
	}

	/**
	* Returns the user journey with the primary key or throws a {@link NoSuchUserJourneyException} if it could not be found.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey
	* @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	*/
	public static UserJourney findByPrimaryKey(long userJourneyId)
		throws com.liferay.content.targeting.rule.user.journey.exception.NoSuchUserJourneyException {
		return getPersistence().findByPrimaryKey(userJourneyId);
	}

	/**
	* Returns the user journey with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey, or <code>null</code> if a user journey with the primary key could not be found
	*/
	public static UserJourney fetchByPrimaryKey(long userJourneyId) {
		return getPersistence().fetchByPrimaryKey(userJourneyId);
	}

	public static java.util.Map<java.io.Serializable, UserJourney> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the user journeies.
	*
	* @return the user journeies
	*/
	public static List<UserJourney> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the user journeies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserJourneyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user journeies
	* @param end the upper bound of the range of user journeies (not inclusive)
	* @return the range of user journeies
	*/
	public static List<UserJourney> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the user journeies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserJourneyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user journeies
	* @param end the upper bound of the range of user journeies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user journeies
	*/
	public static List<UserJourney> findAll(int start, int end,
		OrderByComparator<UserJourney> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the user journeies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link UserJourneyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user journeies
	* @param end the upper bound of the range of user journeies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of user journeies
	*/
	public static List<UserJourney> findAll(int start, int end,
		OrderByComparator<UserJourney> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the user journeies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user journeies.
	*
	* @return the number of user journeies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserJourneyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserJourneyPersistence, UserJourneyPersistence> _serviceTracker =
		ServiceTrackerFactory.open(UserJourneyPersistence.class);
}