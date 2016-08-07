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

package com.liferay.content.targeting.rule.mail.keywords.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the keyword match service. This utility wraps {@link com.liferay.content.targeting.rule.mail.keywords.service.persistence.impl.KeywordMatchPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatchPersistence
 * @see com.liferay.content.targeting.rule.mail.keywords.service.persistence.impl.KeywordMatchPersistenceImpl
 * @generated
 */
@ProviderType
public class KeywordMatchUtil {
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
	public static void clearCache(KeywordMatch keywordMatch) {
		getPersistence().clearCache(keywordMatch);
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
	public static List<KeywordMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<KeywordMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<KeywordMatch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<KeywordMatch> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static KeywordMatch update(KeywordMatch keywordMatch) {
		return getPersistence().update(keywordMatch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static KeywordMatch update(KeywordMatch keywordMatch,
		ServiceContext serviceContext) {
		return getPersistence().update(keywordMatch, serviceContext);
	}

	/**
	* Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchKeywordMatchException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching keyword match
	* @throws NoSuchKeywordMatchException if a matching keyword match could not be found
	*/
	public static KeywordMatch findByA_R(long anonymousUserId,
		long ruleInstanceId)
		throws com.liferay.content.targeting.rule.mail.keywords.exception.NoSuchKeywordMatchException {
		return getPersistence().findByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching keyword match, or <code>null</code> if a matching keyword match could not be found
	*/
	public static KeywordMatch fetchByA_R(long anonymousUserId,
		long ruleInstanceId) {
		return getPersistence().fetchByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching keyword match, or <code>null</code> if a matching keyword match could not be found
	*/
	public static KeywordMatch fetchByA_R(long anonymousUserId,
		long ruleInstanceId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByA_R(anonymousUserId, ruleInstanceId,
			retrieveFromCache);
	}

	/**
	* Removes the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the keyword match that was removed
	*/
	public static KeywordMatch removeByA_R(long anonymousUserId,
		long ruleInstanceId)
		throws com.liferay.content.targeting.rule.mail.keywords.exception.NoSuchKeywordMatchException {
		return getPersistence().removeByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Returns the number of keyword matchs where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching keyword matchs
	*/
	public static int countByA_R(long anonymousUserId, long ruleInstanceId) {
		return getPersistence().countByA_R(anonymousUserId, ruleInstanceId);
	}

	/**
	* Caches the keyword match in the entity cache if it is enabled.
	*
	* @param keywordMatch the keyword match
	*/
	public static void cacheResult(KeywordMatch keywordMatch) {
		getPersistence().cacheResult(keywordMatch);
	}

	/**
	* Caches the keyword matchs in the entity cache if it is enabled.
	*
	* @param keywordMatchs the keyword matchs
	*/
	public static void cacheResult(List<KeywordMatch> keywordMatchs) {
		getPersistence().cacheResult(keywordMatchs);
	}

	/**
	* Creates a new keyword match with the primary key. Does not add the keyword match to the database.
	*
	* @param keywordMatchId the primary key for the new keyword match
	* @return the new keyword match
	*/
	public static KeywordMatch create(long keywordMatchId) {
		return getPersistence().create(keywordMatchId);
	}

	/**
	* Removes the keyword match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match that was removed
	* @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	*/
	public static KeywordMatch remove(long keywordMatchId)
		throws com.liferay.content.targeting.rule.mail.keywords.exception.NoSuchKeywordMatchException {
		return getPersistence().remove(keywordMatchId);
	}

	public static KeywordMatch updateImpl(KeywordMatch keywordMatch) {
		return getPersistence().updateImpl(keywordMatch);
	}

	/**
	* Returns the keyword match with the primary key or throws a {@link NoSuchKeywordMatchException} if it could not be found.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match
	* @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	*/
	public static KeywordMatch findByPrimaryKey(long keywordMatchId)
		throws com.liferay.content.targeting.rule.mail.keywords.exception.NoSuchKeywordMatchException {
		return getPersistence().findByPrimaryKey(keywordMatchId);
	}

	/**
	* Returns the keyword match with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match, or <code>null</code> if a keyword match with the primary key could not be found
	*/
	public static KeywordMatch fetchByPrimaryKey(long keywordMatchId) {
		return getPersistence().fetchByPrimaryKey(keywordMatchId);
	}

	public static java.util.Map<java.io.Serializable, KeywordMatch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the keyword matchs.
	*
	* @return the keyword matchs
	*/
	public static List<KeywordMatch> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the keyword matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KeywordMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of keyword matchs
	* @param end the upper bound of the range of keyword matchs (not inclusive)
	* @return the range of keyword matchs
	*/
	public static List<KeywordMatch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the keyword matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KeywordMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of keyword matchs
	* @param end the upper bound of the range of keyword matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of keyword matchs
	*/
	public static List<KeywordMatch> findAll(int start, int end,
		OrderByComparator<KeywordMatch> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the keyword matchs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link KeywordMatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of keyword matchs
	* @param end the upper bound of the range of keyword matchs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of keyword matchs
	*/
	public static List<KeywordMatch> findAll(int start, int end,
		OrderByComparator<KeywordMatch> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the keyword matchs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of keyword matchs.
	*
	* @return the number of keyword matchs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static KeywordMatchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<KeywordMatchPersistence, KeywordMatchPersistence> _serviceTracker =
		ServiceTrackerFactory.open(KeywordMatchPersistence.class);
}