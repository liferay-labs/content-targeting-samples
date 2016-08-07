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

import com.liferay.content.targeting.rule.mail.keywords.exception.NoSuchKeywordMatchException;
import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the keyword match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.rule.mail.keywords.service.persistence.impl.KeywordMatchPersistenceImpl
 * @see KeywordMatchUtil
 * @generated
 */
@ProviderType
public interface KeywordMatchPersistence extends BasePersistence<KeywordMatch> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link KeywordMatchUtil} to access the keyword match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchKeywordMatchException} if it could not be found.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching keyword match
	* @throws NoSuchKeywordMatchException if a matching keyword match could not be found
	*/
	public KeywordMatch findByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchKeywordMatchException;

	/**
	* Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the matching keyword match, or <code>null</code> if a matching keyword match could not be found
	*/
	public KeywordMatch fetchByA_R(long anonymousUserId, long ruleInstanceId);

	/**
	* Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching keyword match, or <code>null</code> if a matching keyword match could not be found
	*/
	public KeywordMatch fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache);

	/**
	* Removes the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the keyword match that was removed
	*/
	public KeywordMatch removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchKeywordMatchException;

	/**
	* Returns the number of keyword matchs where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	*
	* @param anonymousUserId the anonymous user ID
	* @param ruleInstanceId the rule instance ID
	* @return the number of matching keyword matchs
	*/
	public int countByA_R(long anonymousUserId, long ruleInstanceId);

	/**
	* Caches the keyword match in the entity cache if it is enabled.
	*
	* @param keywordMatch the keyword match
	*/
	public void cacheResult(KeywordMatch keywordMatch);

	/**
	* Caches the keyword matchs in the entity cache if it is enabled.
	*
	* @param keywordMatchs the keyword matchs
	*/
	public void cacheResult(java.util.List<KeywordMatch> keywordMatchs);

	/**
	* Creates a new keyword match with the primary key. Does not add the keyword match to the database.
	*
	* @param keywordMatchId the primary key for the new keyword match
	* @return the new keyword match
	*/
	public KeywordMatch create(long keywordMatchId);

	/**
	* Removes the keyword match with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match that was removed
	* @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	*/
	public KeywordMatch remove(long keywordMatchId)
		throws NoSuchKeywordMatchException;

	public KeywordMatch updateImpl(KeywordMatch keywordMatch);

	/**
	* Returns the keyword match with the primary key or throws a {@link NoSuchKeywordMatchException} if it could not be found.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match
	* @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	*/
	public KeywordMatch findByPrimaryKey(long keywordMatchId)
		throws NoSuchKeywordMatchException;

	/**
	* Returns the keyword match with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param keywordMatchId the primary key of the keyword match
	* @return the keyword match, or <code>null</code> if a keyword match with the primary key could not be found
	*/
	public KeywordMatch fetchByPrimaryKey(long keywordMatchId);

	@Override
	public java.util.Map<java.io.Serializable, KeywordMatch> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the keyword matchs.
	*
	* @return the keyword matchs
	*/
	public java.util.List<KeywordMatch> findAll();

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
	public java.util.List<KeywordMatch> findAll(int start, int end);

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
	public java.util.List<KeywordMatch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KeywordMatch> orderByComparator);

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
	public java.util.List<KeywordMatch> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<KeywordMatch> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the keyword matchs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of keyword matchs.
	*
	* @return the number of keyword matchs
	*/
	public int countAll();
}