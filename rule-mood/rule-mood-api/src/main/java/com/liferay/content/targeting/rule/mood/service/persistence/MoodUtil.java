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

package com.liferay.content.targeting.rule.mood.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mood.model.Mood;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the mood service. This utility wraps {@link com.liferay.content.targeting.rule.mood.service.persistence.impl.MoodPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MoodPersistence
 * @see com.liferay.content.targeting.rule.mood.service.persistence.impl.MoodPersistenceImpl
 * @generated
 */
@ProviderType
public class MoodUtil {
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
	public static void clearCache(Mood mood) {
		getPersistence().clearCache(mood);
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
	public static List<Mood> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Mood> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Mood> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Mood update(Mood mood) {
		return getPersistence().update(mood);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Mood update(Mood mood, ServiceContext serviceContext) {
		return getPersistence().update(mood, serviceContext);
	}

	/**
	* Returns all the moods where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @return the matching moods
	*/
	public static List<Mood> findByAnonymousUserId(long anonymousUserId) {
		return getPersistence().findByAnonymousUserId(anonymousUserId);
	}

	/**
	* Returns a range of all the moods where anonymousUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @return the range of matching moods
	*/
	public static List<Mood> findByAnonymousUserId(long anonymousUserId,
		int start, int end) {
		return getPersistence()
				   .findByAnonymousUserId(anonymousUserId, start, end);
	}

	/**
	* Returns an ordered range of all the moods where anonymousUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching moods
	*/
	public static List<Mood> findByAnonymousUserId(long anonymousUserId,
		int start, int end, OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .findByAnonymousUserId(anonymousUserId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the moods where anonymousUserId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param anonymousUserId the anonymous user ID
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching moods
	*/
	public static List<Mood> findByAnonymousUserId(long anonymousUserId,
		int start, int end, OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAnonymousUserId(anonymousUserId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public static Mood findByAnonymousUserId_First(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence()
				   .findByAnonymousUserId_First(anonymousUserId,
			orderByComparator);
	}

	/**
	* Returns the first mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public static Mood fetchByAnonymousUserId_First(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .fetchByAnonymousUserId_First(anonymousUserId,
			orderByComparator);
	}

	/**
	* Returns the last mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public static Mood findByAnonymousUserId_Last(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence()
				   .findByAnonymousUserId_Last(anonymousUserId,
			orderByComparator);
	}

	/**
	* Returns the last mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public static Mood fetchByAnonymousUserId_Last(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .fetchByAnonymousUserId_Last(anonymousUserId,
			orderByComparator);
	}

	/**
	* Returns the moods before and after the current mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param moodId the primary key of the current mood
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mood
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public static Mood[] findByAnonymousUserId_PrevAndNext(long moodId,
		long anonymousUserId, OrderByComparator<Mood> orderByComparator)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence()
				   .findByAnonymousUserId_PrevAndNext(moodId, anonymousUserId,
			orderByComparator);
	}

	/**
	* Removes all the moods where anonymousUserId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	*/
	public static void removeByAnonymousUserId(long anonymousUserId) {
		getPersistence().removeByAnonymousUserId(anonymousUserId);
	}

	/**
	* Returns the number of moods where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @return the number of matching moods
	*/
	public static int countByAnonymousUserId(long anonymousUserId) {
		return getPersistence().countByAnonymousUserId(anonymousUserId);
	}

	/**
	* Returns all the moods where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @return the matching moods
	*/
	public static List<Mood> findByRuleInstanceId(long ruleInstanceId) {
		return getPersistence().findByRuleInstanceId(ruleInstanceId);
	}

	/**
	* Returns a range of all the moods where ruleInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleInstanceId the rule instance ID
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @return the range of matching moods
	*/
	public static List<Mood> findByRuleInstanceId(long ruleInstanceId,
		int start, int end) {
		return getPersistence().findByRuleInstanceId(ruleInstanceId, start, end);
	}

	/**
	* Returns an ordered range of all the moods where ruleInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleInstanceId the rule instance ID
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching moods
	*/
	public static List<Mood> findByRuleInstanceId(long ruleInstanceId,
		int start, int end, OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .findByRuleInstanceId(ruleInstanceId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the moods where ruleInstanceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ruleInstanceId the rule instance ID
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching moods
	*/
	public static List<Mood> findByRuleInstanceId(long ruleInstanceId,
		int start, int end, OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByRuleInstanceId(ruleInstanceId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public static Mood findByRuleInstanceId_First(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence()
				   .findByRuleInstanceId_First(ruleInstanceId, orderByComparator);
	}

	/**
	* Returns the first mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public static Mood fetchByRuleInstanceId_First(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .fetchByRuleInstanceId_First(ruleInstanceId,
			orderByComparator);
	}

	/**
	* Returns the last mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public static Mood findByRuleInstanceId_Last(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence()
				   .findByRuleInstanceId_Last(ruleInstanceId, orderByComparator);
	}

	/**
	* Returns the last mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public static Mood fetchByRuleInstanceId_Last(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator) {
		return getPersistence()
				   .fetchByRuleInstanceId_Last(ruleInstanceId, orderByComparator);
	}

	/**
	* Returns the moods before and after the current mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param moodId the primary key of the current mood
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mood
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public static Mood[] findByRuleInstanceId_PrevAndNext(long moodId,
		long ruleInstanceId, OrderByComparator<Mood> orderByComparator)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence()
				   .findByRuleInstanceId_PrevAndNext(moodId, ruleInstanceId,
			orderByComparator);
	}

	/**
	* Removes all the moods where ruleInstanceId = &#63; from the database.
	*
	* @param ruleInstanceId the rule instance ID
	*/
	public static void removeByRuleInstanceId(long ruleInstanceId) {
		getPersistence().removeByRuleInstanceId(ruleInstanceId);
	}

	/**
	* Returns the number of moods where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching moods
	*/
	public static int countByRuleInstanceId(long ruleInstanceId) {
		return getPersistence().countByRuleInstanceId(ruleInstanceId);
	}

	/**
	* Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchMoodException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public static Mood findByA_R(long anonymousUserId, long ruleInstanceId)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence().findByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public static Mood fetchByA_R(long anonymousUserId, long ruleInstanceId) {
		return getPersistence().fetchByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public static Mood fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByA_R(anonymousUserId, ruleInstanceId,
			retrieveFromCache);
	}

	/**
	* Removes the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the mood that was removed
	*/
	public static Mood removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence().removeByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the number of moods where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching moods
	*/
	public static int countByA_R(long anonymousUserId, long ruleInstanceId) {
		return getPersistence().countByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Caches the mood in the entity cache if it is enabled.
	*
	* @param mood the mood
	*/
	public static void cacheResult(Mood mood) {
		getPersistence().cacheResult(mood);
	}

	/**
	* Caches the moods in the entity cache if it is enabled.
	*
	* @param moods the moods
	*/
	public static void cacheResult(List<Mood> moods) {
		getPersistence().cacheResult(moods);
	}

	/**
	* Creates a new mood with the primary key. Does not add the mood to the database.
	*
	* @param moodId the primary key for the new mood
	* @return the new mood
	*/
	public static Mood create(long moodId) {
		return getPersistence().create(moodId);
	}

	/**
	* Removes the mood with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param moodId the primary key of the mood
	* @return the mood that was removed
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public static Mood remove(long moodId)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence().remove(moodId);
	}

	public static Mood updateImpl(Mood mood) {
		return getPersistence().updateImpl(mood);
	}

	/**
	* Returns the mood with the primary key or throws a {@link NoSuchMoodException} if it could not be found.
	*
	* @param moodId the primary key of the mood
	* @return the mood
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public static Mood findByPrimaryKey(long moodId)
		throws com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException {
		return getPersistence().findByPrimaryKey(moodId);
	}

	/**
	* Returns the mood with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param moodId the primary key of the mood
	* @return the mood, or <code>null</code> if a mood with the primary key could not be found
	*/
	public static Mood fetchByPrimaryKey(long moodId) {
		return getPersistence().fetchByPrimaryKey(moodId);
	}

	public static java.util.Map<java.io.Serializable, Mood> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the moods.
	*
	* @return the moods
	*/
	public static List<Mood> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the moods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @return the range of moods
	*/
	public static List<Mood> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the moods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of moods
	*/
	public static List<Mood> findAll(int start, int end,
		OrderByComparator<Mood> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the moods.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MoodModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of moods
	* @param end the upper bound of the range of moods (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of moods
	*/
	public static List<Mood> findAll(int start, int end,
		OrderByComparator<Mood> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the moods from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of moods.
	*
	* @return the number of moods
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MoodPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MoodPersistence, MoodPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MoodPersistence.class);
}