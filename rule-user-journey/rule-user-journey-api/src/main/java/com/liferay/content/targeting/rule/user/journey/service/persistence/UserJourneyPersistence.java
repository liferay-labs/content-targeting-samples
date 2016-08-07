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

import com.liferay.content.targeting.rule.user.journey.exception.NoSuchUserJourneyException;
import com.liferay.content.targeting.rule.user.journey.model.UserJourney;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the user journey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.user.journey.service.persistence.impl.UserJourneyPersistenceImpl
 * @see UserJourneyUtil
 * @generated
 */
@ProviderType
public interface UserJourneyPersistence extends BasePersistence<UserJourney> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserJourneyUtil} to access the user journey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchUserJourneyException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching user journey
	* @throws NoSuchUserJourneyException if a matching user journey could not be found
	*/
	public UserJourney findByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchUserJourneyException;

	/**
	* Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching user journey, or <code>null</code> if a matching user journey could not be found
	*/
	public UserJourney fetchByA_R(long anonymousUserId, long ruleInstanceId);

	/**
	* Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching user journey, or <code>null</code> if a matching user journey could not be found
	*/
	public UserJourney fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache);

	/**
	* Removes the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the user journey that was removed
	*/
	public UserJourney removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchUserJourneyException;

	/**
	* Returns the number of user journeies where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching user journeies
	*/
	public int countByA_R(long anonymousUserId, long ruleInstanceId);

	/**
	* Caches the user journey in the entity cache if it is enabled.
	*
	* @param userJourney the user journey
	*/
	public void cacheResult(UserJourney userJourney);

	/**
	* Caches the user journeies in the entity cache if it is enabled.
	*
	* @param userJourneies the user journeies
	*/
	public void cacheResult(java.util.List<UserJourney> userJourneies);

	/**
	* Creates a new user journey with the primary key. Does not add the user journey to the database.
	*
	* @param userJourneyId the primary key for the new user journey
	* @return the new user journey
	*/
	public UserJourney create(long userJourneyId);

	/**
	* Removes the user journey with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey that was removed
	* @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	*/
	public UserJourney remove(long userJourneyId)
		throws NoSuchUserJourneyException;

	public UserJourney updateImpl(UserJourney userJourney);

	/**
	* Returns the user journey with the primary key or throws a {@link NoSuchUserJourneyException} if it could not be found.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey
	* @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	*/
	public UserJourney findByPrimaryKey(long userJourneyId)
		throws NoSuchUserJourneyException;

	/**
	* Returns the user journey with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userJourneyId the primary key of the user journey
	* @return the user journey, or <code>null</code> if a user journey with the primary key could not be found
	*/
	public UserJourney fetchByPrimaryKey(long userJourneyId);

	@Override
	public java.util.Map<java.io.Serializable, UserJourney> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the user journeies.
	*
	* @return the user journeies
	*/
	public java.util.List<UserJourney> findAll();

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
	public java.util.List<UserJourney> findAll(int start, int end);

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
	public java.util.List<UserJourney> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserJourney> orderByComparator);

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
	public java.util.List<UserJourney> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserJourney> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the user journeies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of user journeies.
	*
	* @return the number of user journeies
	*/
	public int countAll();
}