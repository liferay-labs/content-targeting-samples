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

package com.liferay.content.targeting.rule.mail.keywords.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mail.keywords.exception.NoSuchKeywordMatchException;
import com.liferay.content.targeting.rule.mail.keywords.model.KeywordMatch;
import com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchImpl;
import com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchModelImpl;
import com.liferay.content.targeting.rule.mail.keywords.service.persistence.KeywordMatchPersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the keyword match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatchPersistence
 * @see com.liferay.content.targeting.rule.mail.keywords.service.persistence.KeywordMatchUtil
 * @generated
 */
@ProviderType
public class KeywordMatchPersistenceImpl extends BasePersistenceImpl<KeywordMatch>
	implements KeywordMatchPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link KeywordMatchUtil} to access the keyword match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = KeywordMatchImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchModelImpl.FINDER_CACHE_ENABLED, KeywordMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchModelImpl.FINDER_CACHE_ENABLED, KeywordMatchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_A_R = new FinderPath(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchModelImpl.FINDER_CACHE_ENABLED, KeywordMatchImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			KeywordMatchModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK |
			KeywordMatchModelImpl.RULEINSTANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_R = new FinderPath(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchKeywordMatchException} if it could not be found.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching keyword match
	 * @throws NoSuchKeywordMatchException if a matching keyword match could not be found
	 */
	@Override
	public KeywordMatch findByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchKeywordMatchException {
		KeywordMatch keywordMatch = fetchByA_R(anonymousUserId, ruleInstanceId);

		if (keywordMatch == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("anonymousUserId=");
			msg.append(anonymousUserId);

			msg.append(", ruleInstanceId=");
			msg.append(ruleInstanceId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchKeywordMatchException(msg.toString());
		}

		return keywordMatch;
	}

	/**
	 * Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching keyword match, or <code>null</code> if a matching keyword match could not be found
	 */
	@Override
	public KeywordMatch fetchByA_R(long anonymousUserId, long ruleInstanceId) {
		return fetchByA_R(anonymousUserId, ruleInstanceId, true);
	}

	/**
	 * Returns the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching keyword match, or <code>null</code> if a matching keyword match could not be found
	 */
	@Override
	public KeywordMatch fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { anonymousUserId, ruleInstanceId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_A_R,
					finderArgs, this);
		}

		if (result instanceof KeywordMatch) {
			KeywordMatch keywordMatch = (KeywordMatch)result;

			if ((anonymousUserId != keywordMatch.getAnonymousUserId()) ||
					(ruleInstanceId != keywordMatch.getRuleInstanceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_KEYWORDMATCH_WHERE);

			query.append(_FINDER_COLUMN_A_R_ANONYMOUSUSERID_2);

			query.append(_FINDER_COLUMN_A_R_RULEINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

				qPos.add(ruleInstanceId);

				List<KeywordMatch> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, finderArgs,
						list);
				}
				else {
					KeywordMatch keywordMatch = list.get(0);

					result = keywordMatch;

					cacheResult(keywordMatch);

					if ((keywordMatch.getAnonymousUserId() != anonymousUserId) ||
							(keywordMatch.getRuleInstanceId() != ruleInstanceId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_A_R,
							finderArgs, keywordMatch);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (KeywordMatch)result;
		}
	}

	/**
	 * Removes the keyword match where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the keyword match that was removed
	 */
	@Override
	public KeywordMatch removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchKeywordMatchException {
		KeywordMatch keywordMatch = findByA_R(anonymousUserId, ruleInstanceId);

		return remove(keywordMatch);
	}

	/**
	 * Returns the number of keyword matchs where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the number of matching keyword matchs
	 */
	@Override
	public int countByA_R(long anonymousUserId, long ruleInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_R;

		Object[] finderArgs = new Object[] { anonymousUserId, ruleInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KEYWORDMATCH_WHERE);

			query.append(_FINDER_COLUMN_A_R_ANONYMOUSUSERID_2);

			query.append(_FINDER_COLUMN_A_R_RULEINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

				qPos.add(ruleInstanceId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_A_R_ANONYMOUSUSERID_2 = "keywordMatch.anonymousUserId = ? AND ";
	private static final String _FINDER_COLUMN_A_R_RULEINSTANCEID_2 = "keywordMatch.ruleInstanceId = ?";

	public KeywordMatchPersistenceImpl() {
		setModelClass(KeywordMatch.class);
	}

	/**
	 * Caches the keyword match in the entity cache if it is enabled.
	 *
	 * @param keywordMatch the keyword match
	 */
	@Override
	public void cacheResult(KeywordMatch keywordMatch) {
		entityCache.putResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchImpl.class, keywordMatch.getPrimaryKey(), keywordMatch);

		finderCache.putResult(FINDER_PATH_FETCH_BY_A_R,
			new Object[] {
				keywordMatch.getAnonymousUserId(),
				keywordMatch.getRuleInstanceId()
			}, keywordMatch);

		keywordMatch.resetOriginalValues();
	}

	/**
	 * Caches the keyword matchs in the entity cache if it is enabled.
	 *
	 * @param keywordMatchs the keyword matchs
	 */
	@Override
	public void cacheResult(List<KeywordMatch> keywordMatchs) {
		for (KeywordMatch keywordMatch : keywordMatchs) {
			if (entityCache.getResult(
						KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
						KeywordMatchImpl.class, keywordMatch.getPrimaryKey()) == null) {
				cacheResult(keywordMatch);
			}
			else {
				keywordMatch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all keyword matchs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KeywordMatchImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the keyword match.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(KeywordMatch keywordMatch) {
		entityCache.removeResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchImpl.class, keywordMatch.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((KeywordMatchModelImpl)keywordMatch);
	}

	@Override
	public void clearCache(List<KeywordMatch> keywordMatchs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (KeywordMatch keywordMatch : keywordMatchs) {
			entityCache.removeResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
				KeywordMatchImpl.class, keywordMatch.getPrimaryKey());

			clearUniqueFindersCache((KeywordMatchModelImpl)keywordMatch);
		}
	}

	protected void cacheUniqueFindersCache(
		KeywordMatchModelImpl keywordMatchModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					keywordMatchModelImpl.getAnonymousUserId(),
					keywordMatchModelImpl.getRuleInstanceId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_A_R, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, args,
				keywordMatchModelImpl);
		}
		else {
			if ((keywordMatchModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						keywordMatchModelImpl.getAnonymousUserId(),
						keywordMatchModelImpl.getRuleInstanceId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_A_R, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, args,
					keywordMatchModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		KeywordMatchModelImpl keywordMatchModelImpl) {
		Object[] args = new Object[] {
				keywordMatchModelImpl.getAnonymousUserId(),
				keywordMatchModelImpl.getRuleInstanceId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, args);

		if ((keywordMatchModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_R.getColumnBitmask()) != 0) {
			args = new Object[] {
					keywordMatchModelImpl.getOriginalAnonymousUserId(),
					keywordMatchModelImpl.getOriginalRuleInstanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, args);
		}
	}

	/**
	 * Creates a new keyword match with the primary key. Does not add the keyword match to the database.
	 *
	 * @param keywordMatchId the primary key for the new keyword match
	 * @return the new keyword match
	 */
	@Override
	public KeywordMatch create(long keywordMatchId) {
		KeywordMatch keywordMatch = new KeywordMatchImpl();

		keywordMatch.setNew(true);
		keywordMatch.setPrimaryKey(keywordMatchId);

		keywordMatch.setCompanyId(companyProvider.getCompanyId());

		return keywordMatch;
	}

	/**
	 * Removes the keyword match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param keywordMatchId the primary key of the keyword match
	 * @return the keyword match that was removed
	 * @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	 */
	@Override
	public KeywordMatch remove(long keywordMatchId)
		throws NoSuchKeywordMatchException {
		return remove((Serializable)keywordMatchId);
	}

	/**
	 * Removes the keyword match with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the keyword match
	 * @return the keyword match that was removed
	 * @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	 */
	@Override
	public KeywordMatch remove(Serializable primaryKey)
		throws NoSuchKeywordMatchException {
		Session session = null;

		try {
			session = openSession();

			KeywordMatch keywordMatch = (KeywordMatch)session.get(KeywordMatchImpl.class,
					primaryKey);

			if (keywordMatch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKeywordMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(keywordMatch);
		}
		catch (NoSuchKeywordMatchException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected KeywordMatch removeImpl(KeywordMatch keywordMatch) {
		keywordMatch = toUnwrappedModel(keywordMatch);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(keywordMatch)) {
				keywordMatch = (KeywordMatch)session.get(KeywordMatchImpl.class,
						keywordMatch.getPrimaryKeyObj());
			}

			if (keywordMatch != null) {
				session.delete(keywordMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (keywordMatch != null) {
			clearCache(keywordMatch);
		}

		return keywordMatch;
	}

	@Override
	public KeywordMatch updateImpl(KeywordMatch keywordMatch) {
		keywordMatch = toUnwrappedModel(keywordMatch);

		boolean isNew = keywordMatch.isNew();

		KeywordMatchModelImpl keywordMatchModelImpl = (KeywordMatchModelImpl)keywordMatch;

		Session session = null;

		try {
			session = openSession();

			if (keywordMatch.isNew()) {
				session.save(keywordMatch);

				keywordMatch.setNew(false);
			}
			else {
				keywordMatch = (KeywordMatch)session.merge(keywordMatch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !KeywordMatchModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
			KeywordMatchImpl.class, keywordMatch.getPrimaryKey(), keywordMatch,
			false);

		clearUniqueFindersCache(keywordMatchModelImpl);
		cacheUniqueFindersCache(keywordMatchModelImpl, isNew);

		keywordMatch.resetOriginalValues();

		return keywordMatch;
	}

	protected KeywordMatch toUnwrappedModel(KeywordMatch keywordMatch) {
		if (keywordMatch instanceof KeywordMatchImpl) {
			return keywordMatch;
		}

		KeywordMatchImpl keywordMatchImpl = new KeywordMatchImpl();

		keywordMatchImpl.setNew(keywordMatch.isNew());
		keywordMatchImpl.setPrimaryKey(keywordMatch.getPrimaryKey());

		keywordMatchImpl.setKeywordMatchId(keywordMatch.getKeywordMatchId());
		keywordMatchImpl.setCompanyId(keywordMatch.getCompanyId());
		keywordMatchImpl.setModifiedDate(keywordMatch.getModifiedDate());
		keywordMatchImpl.setAnonymousUserId(keywordMatch.getAnonymousUserId());
		keywordMatchImpl.setRuleInstanceId(keywordMatch.getRuleInstanceId());

		return keywordMatchImpl;
	}

	/**
	 * Returns the keyword match with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the keyword match
	 * @return the keyword match
	 * @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	 */
	@Override
	public KeywordMatch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKeywordMatchException {
		KeywordMatch keywordMatch = fetchByPrimaryKey(primaryKey);

		if (keywordMatch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKeywordMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return keywordMatch;
	}

	/**
	 * Returns the keyword match with the primary key or throws a {@link NoSuchKeywordMatchException} if it could not be found.
	 *
	 * @param keywordMatchId the primary key of the keyword match
	 * @return the keyword match
	 * @throws NoSuchKeywordMatchException if a keyword match with the primary key could not be found
	 */
	@Override
	public KeywordMatch findByPrimaryKey(long keywordMatchId)
		throws NoSuchKeywordMatchException {
		return findByPrimaryKey((Serializable)keywordMatchId);
	}

	/**
	 * Returns the keyword match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the keyword match
	 * @return the keyword match, or <code>null</code> if a keyword match with the primary key could not be found
	 */
	@Override
	public KeywordMatch fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
				KeywordMatchImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		KeywordMatch keywordMatch = (KeywordMatch)serializable;

		if (keywordMatch == null) {
			Session session = null;

			try {
				session = openSession();

				keywordMatch = (KeywordMatch)session.get(KeywordMatchImpl.class,
						primaryKey);

				if (keywordMatch != null) {
					cacheResult(keywordMatch);
				}
				else {
					entityCache.putResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
						KeywordMatchImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
					KeywordMatchImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return keywordMatch;
	}

	/**
	 * Returns the keyword match with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param keywordMatchId the primary key of the keyword match
	 * @return the keyword match, or <code>null</code> if a keyword match with the primary key could not be found
	 */
	@Override
	public KeywordMatch fetchByPrimaryKey(long keywordMatchId) {
		return fetchByPrimaryKey((Serializable)keywordMatchId);
	}

	@Override
	public Map<Serializable, KeywordMatch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, KeywordMatch> map = new HashMap<Serializable, KeywordMatch>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			KeywordMatch keywordMatch = fetchByPrimaryKey(primaryKey);

			if (keywordMatch != null) {
				map.put(primaryKey, keywordMatch);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
					KeywordMatchImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (KeywordMatch)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_KEYWORDMATCH_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (KeywordMatch keywordMatch : (List<KeywordMatch>)q.list()) {
				map.put(keywordMatch.getPrimaryKeyObj(), keywordMatch);

				cacheResult(keywordMatch);

				uncachedPrimaryKeys.remove(keywordMatch.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(KeywordMatchModelImpl.ENTITY_CACHE_ENABLED,
					KeywordMatchImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the keyword matchs.
	 *
	 * @return the keyword matchs
	 */
	@Override
	public List<KeywordMatch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<KeywordMatch> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<KeywordMatch> findAll(int start, int end,
		OrderByComparator<KeywordMatch> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<KeywordMatch> findAll(int start, int end,
		OrderByComparator<KeywordMatch> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<KeywordMatch> list = null;

		if (retrieveFromCache) {
			list = (List<KeywordMatch>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_KEYWORDMATCH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KEYWORDMATCH;

				if (pagination) {
					sql = sql.concat(KeywordMatchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<KeywordMatch>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<KeywordMatch>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the keyword matchs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (KeywordMatch keywordMatch : findAll()) {
			remove(keywordMatch);
		}
	}

	/**
	 * Returns the number of keyword matchs.
	 *
	 * @return the number of keyword matchs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KEYWORDMATCH);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return KeywordMatchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the keyword match persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(KeywordMatchImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_KEYWORDMATCH = "SELECT keywordMatch FROM KeywordMatch keywordMatch";
	private static final String _SQL_SELECT_KEYWORDMATCH_WHERE_PKS_IN = "SELECT keywordMatch FROM KeywordMatch keywordMatch WHERE keywordMatchId IN (";
	private static final String _SQL_SELECT_KEYWORDMATCH_WHERE = "SELECT keywordMatch FROM KeywordMatch keywordMatch WHERE ";
	private static final String _SQL_COUNT_KEYWORDMATCH = "SELECT COUNT(keywordMatch) FROM KeywordMatch keywordMatch";
	private static final String _SQL_COUNT_KEYWORDMATCH_WHERE = "SELECT COUNT(keywordMatch) FROM KeywordMatch keywordMatch WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "keywordMatch.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No KeywordMatch exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No KeywordMatch exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(KeywordMatchPersistenceImpl.class);
}