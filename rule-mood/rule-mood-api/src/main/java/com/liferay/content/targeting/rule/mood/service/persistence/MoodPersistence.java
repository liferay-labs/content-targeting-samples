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

import com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException;
import com.liferay.content.targeting.rule.mood.model.Mood;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the mood service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.mood.service.persistence.impl.MoodPersistenceImpl
 * @see MoodUtil
 * @generated
 */
@ProviderType
public interface MoodPersistence extends BasePersistence<Mood> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MoodUtil} to access the mood persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the moods where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @return the matching moods
	*/
	public java.util.List<Mood> findByAnonymousUserId(long anonymousUserId);

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
	public java.util.List<Mood> findByAnonymousUserId(long anonymousUserId,
		int start, int end);

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
	public java.util.List<Mood> findByAnonymousUserId(long anonymousUserId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

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
	public java.util.List<Mood> findByAnonymousUserId(long anonymousUserId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public Mood findByAnonymousUserId_First(long anonymousUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException;

	/**
	* Returns the first mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public Mood fetchByAnonymousUserId_First(long anonymousUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

	/**
	* Returns the last mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public Mood findByAnonymousUserId_Last(long anonymousUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException;

	/**
	* Returns the last mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public Mood fetchByAnonymousUserId_Last(long anonymousUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

	/**
	* Returns the moods before and after the current mood in the ordered set where anonymousUserId = &#63;.
	*
	* @param moodId the primary key of the current mood
	* @param anonymousUserId the anonymous user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mood
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public Mood[] findByAnonymousUserId_PrevAndNext(long moodId,
		long anonymousUserId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException;

	/**
	* Removes all the moods where anonymousUserId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	*/
	public void removeByAnonymousUserId(long anonymousUserId);

	/**
	* Returns the number of moods where anonymousUserId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @return the number of matching moods
	*/
	public int countByAnonymousUserId(long anonymousUserId);

	/**
	* Returns all the moods where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @return the matching moods
	*/
	public java.util.List<Mood> findByRuleInstanceId(long ruleInstanceId);

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
	public java.util.List<Mood> findByRuleInstanceId(long ruleInstanceId,
		int start, int end);

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
	public java.util.List<Mood> findByRuleInstanceId(long ruleInstanceId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

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
	public java.util.List<Mood> findByRuleInstanceId(long ruleInstanceId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public Mood findByRuleInstanceId_First(long ruleInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException;

	/**
	* Returns the first mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public Mood fetchByRuleInstanceId_First(long ruleInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

	/**
	* Returns the last mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public Mood findByRuleInstanceId_Last(long ruleInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException;

	/**
	* Returns the last mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public Mood fetchByRuleInstanceId_Last(long ruleInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

	/**
	* Returns the moods before and after the current mood in the ordered set where ruleInstanceId = &#63;.
	*
	* @param moodId the primary key of the current mood
	* @param ruleInstanceId the rule instance ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next mood
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public Mood[] findByRuleInstanceId_PrevAndNext(long moodId,
		long ruleInstanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException;

	/**
	* Removes all the moods where ruleInstanceId = &#63; from the database.
	*
	* @param ruleInstanceId the rule instance ID
	*/
	public void removeByRuleInstanceId(long ruleInstanceId);

	/**
	* Returns the number of moods where ruleInstanceId = &#63;.
	*
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching moods
	*/
	public int countByRuleInstanceId(long ruleInstanceId);

	/**
	* Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchMoodException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching mood
	* @throws NoSuchMoodException if a matching mood could not be found
	*/
	public Mood findByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchMoodException;

	/**
	* Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public Mood fetchByA_R(long anonymousUserId, long ruleInstanceId);

	/**
	* Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching mood, or <code>null</code> if a matching mood could not be found
	*/
	public Mood fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache);

	/**
	* Removes the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the mood that was removed
	*/
	public Mood removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchMoodException;

	/**
	* Returns the number of moods where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching moods
	*/
	public int countByA_R(long anonymousUserId, long ruleInstanceId);

	/**
	* Caches the mood in the entity cache if it is enabled.
	*
	* @param mood the mood
	*/
	public void cacheResult(Mood mood);

	/**
	* Caches the moods in the entity cache if it is enabled.
	*
	* @param moods the moods
	*/
	public void cacheResult(java.util.List<Mood> moods);

	/**
	* Creates a new mood with the primary key. Does not add the mood to the database.
	*
	* @param moodId the primary key for the new mood
	* @return the new mood
	*/
	public Mood create(long moodId);

	/**
	* Removes the mood with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param moodId the primary key of the mood
	* @return the mood that was removed
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public Mood remove(long moodId) throws NoSuchMoodException;

	public Mood updateImpl(Mood mood);

	/**
	* Returns the mood with the primary key or throws a {@link NoSuchMoodException} if it could not be found.
	*
	* @param moodId the primary key of the mood
	* @return the mood
	* @throws NoSuchMoodException if a mood with the primary key could not be found
	*/
	public Mood findByPrimaryKey(long moodId) throws NoSuchMoodException;

	/**
	* Returns the mood with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param moodId the primary key of the mood
	* @return the mood, or <code>null</code> if a mood with the primary key could not be found
	*/
	public Mood fetchByPrimaryKey(long moodId);

	@Override
	public java.util.Map<java.io.Serializable, Mood> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the moods.
	*
	* @return the moods
	*/
	public java.util.List<Mood> findAll();

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
	public java.util.List<Mood> findAll(int start, int end);

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
	public java.util.List<Mood> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator);

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
	public java.util.List<Mood> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the moods from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of moods.
	*
	* @return the number of moods
	*/
	public int countAll();
}