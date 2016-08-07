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

package com.liferay.content.targeting.rule.user.journey.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.user.journey.exception.NoSuchUserJourneyException;
import com.liferay.content.targeting.rule.user.journey.model.UserJourney;
import com.liferay.content.targeting.rule.user.journey.model.impl.UserJourneyImpl;
import com.liferay.content.targeting.rule.user.journey.model.impl.UserJourneyModelImpl;
import com.liferay.content.targeting.rule.user.journey.service.persistence.UserJourneyPersistence;

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
 * The persistence implementation for the user journey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserJourneyPersistence
 * @see com.liferay.content.targeting.rule.user.journey.service.persistence.UserJourneyUtil
 * @generated
 */
@ProviderType
public class UserJourneyPersistenceImpl extends BasePersistenceImpl<UserJourney>
	implements UserJourneyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UserJourneyUtil} to access the user journey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UserJourneyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyModelImpl.FINDER_CACHE_ENABLED, UserJourneyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyModelImpl.FINDER_CACHE_ENABLED, UserJourneyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_A_R = new FinderPath(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyModelImpl.FINDER_CACHE_ENABLED, UserJourneyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			UserJourneyModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK |
			UserJourneyModelImpl.RULEINSTANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_R = new FinderPath(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchUserJourneyException} if it could not be found.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching user journey
	 * @throws NoSuchUserJourneyException if a matching user journey could not be found
	 */
	@Override
	public UserJourney findByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchUserJourneyException {
		UserJourney userJourney = fetchByA_R(anonymousUserId, ruleInstanceId);

		if (userJourney == null) {
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

			throw new NoSuchUserJourneyException(msg.toString());
		}

		return userJourney;
	}

	/**
	 * Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching user journey, or <code>null</code> if a matching user journey could not be found
	 */
	@Override
	public UserJourney fetchByA_R(long anonymousUserId, long ruleInstanceId) {
		return fetchByA_R(anonymousUserId, ruleInstanceId, true);
	}

	/**
	 * Returns the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching user journey, or <code>null</code> if a matching user journey could not be found
	 */
	@Override
	public UserJourney fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { anonymousUserId, ruleInstanceId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_A_R,
					finderArgs, this);
		}

		if (result instanceof UserJourney) {
			UserJourney userJourney = (UserJourney)result;

			if ((anonymousUserId != userJourney.getAnonymousUserId()) ||
					(ruleInstanceId != userJourney.getRuleInstanceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERJOURNEY_WHERE);

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

				List<UserJourney> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, finderArgs,
						list);
				}
				else {
					UserJourney userJourney = list.get(0);

					result = userJourney;

					cacheResult(userJourney);

					if ((userJourney.getAnonymousUserId() != anonymousUserId) ||
							(userJourney.getRuleInstanceId() != ruleInstanceId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_A_R,
							finderArgs, userJourney);
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
			return (UserJourney)result;
		}
	}

	/**
	 * Removes the user journey where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the user journey that was removed
	 */
	@Override
	public UserJourney removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchUserJourneyException {
		UserJourney userJourney = findByA_R(anonymousUserId, ruleInstanceId);

		return remove(userJourney);
	}

	/**
	 * Returns the number of user journeies where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the number of matching user journeies
	 */
	@Override
	public int countByA_R(long anonymousUserId, long ruleInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_R;

		Object[] finderArgs = new Object[] { anonymousUserId, ruleInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERJOURNEY_WHERE);

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

	private static final String _FINDER_COLUMN_A_R_ANONYMOUSUSERID_2 = "userJourney.anonymousUserId = ? AND ";
	private static final String _FINDER_COLUMN_A_R_RULEINSTANCEID_2 = "userJourney.ruleInstanceId = ?";

	public UserJourneyPersistenceImpl() {
		setModelClass(UserJourney.class);
	}

	/**
	 * Caches the user journey in the entity cache if it is enabled.
	 *
	 * @param userJourney the user journey
	 */
	@Override
	public void cacheResult(UserJourney userJourney) {
		entityCache.putResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyImpl.class, userJourney.getPrimaryKey(), userJourney);

		finderCache.putResult(FINDER_PATH_FETCH_BY_A_R,
			new Object[] {
				userJourney.getAnonymousUserId(),
				userJourney.getRuleInstanceId()
			}, userJourney);

		userJourney.resetOriginalValues();
	}

	/**
	 * Caches the user journeies in the entity cache if it is enabled.
	 *
	 * @param userJourneies the user journeies
	 */
	@Override
	public void cacheResult(List<UserJourney> userJourneies) {
		for (UserJourney userJourney : userJourneies) {
			if (entityCache.getResult(
						UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
						UserJourneyImpl.class, userJourney.getPrimaryKey()) == null) {
				cacheResult(userJourney);
			}
			else {
				userJourney.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user journeies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserJourneyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user journey.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserJourney userJourney) {
		entityCache.removeResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyImpl.class, userJourney.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserJourneyModelImpl)userJourney);
	}

	@Override
	public void clearCache(List<UserJourney> userJourneies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserJourney userJourney : userJourneies) {
			entityCache.removeResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
				UserJourneyImpl.class, userJourney.getPrimaryKey());

			clearUniqueFindersCache((UserJourneyModelImpl)userJourney);
		}
	}

	protected void cacheUniqueFindersCache(
		UserJourneyModelImpl userJourneyModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					userJourneyModelImpl.getAnonymousUserId(),
					userJourneyModelImpl.getRuleInstanceId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_A_R, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, args,
				userJourneyModelImpl);
		}
		else {
			if ((userJourneyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						userJourneyModelImpl.getAnonymousUserId(),
						userJourneyModelImpl.getRuleInstanceId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_A_R, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, args,
					userJourneyModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		UserJourneyModelImpl userJourneyModelImpl) {
		Object[] args = new Object[] {
				userJourneyModelImpl.getAnonymousUserId(),
				userJourneyModelImpl.getRuleInstanceId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, args);

		if ((userJourneyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_R.getColumnBitmask()) != 0) {
			args = new Object[] {
					userJourneyModelImpl.getOriginalAnonymousUserId(),
					userJourneyModelImpl.getOriginalRuleInstanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, args);
		}
	}

	/**
	 * Creates a new user journey with the primary key. Does not add the user journey to the database.
	 *
	 * @param userJourneyId the primary key for the new user journey
	 * @return the new user journey
	 */
	@Override
	public UserJourney create(long userJourneyId) {
		UserJourney userJourney = new UserJourneyImpl();

		userJourney.setNew(true);
		userJourney.setPrimaryKey(userJourneyId);

		userJourney.setCompanyId(companyProvider.getCompanyId());

		return userJourney;
	}

	/**
	 * Removes the user journey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userJourneyId the primary key of the user journey
	 * @return the user journey that was removed
	 * @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	 */
	@Override
	public UserJourney remove(long userJourneyId)
		throws NoSuchUserJourneyException {
		return remove((Serializable)userJourneyId);
	}

	/**
	 * Removes the user journey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user journey
	 * @return the user journey that was removed
	 * @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	 */
	@Override
	public UserJourney remove(Serializable primaryKey)
		throws NoSuchUserJourneyException {
		Session session = null;

		try {
			session = openSession();

			UserJourney userJourney = (UserJourney)session.get(UserJourneyImpl.class,
					primaryKey);

			if (userJourney == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserJourneyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(userJourney);
		}
		catch (NoSuchUserJourneyException nsee) {
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
	protected UserJourney removeImpl(UserJourney userJourney) {
		userJourney = toUnwrappedModel(userJourney);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userJourney)) {
				userJourney = (UserJourney)session.get(UserJourneyImpl.class,
						userJourney.getPrimaryKeyObj());
			}

			if (userJourney != null) {
				session.delete(userJourney);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userJourney != null) {
			clearCache(userJourney);
		}

		return userJourney;
	}

	@Override
	public UserJourney updateImpl(UserJourney userJourney) {
		userJourney = toUnwrappedModel(userJourney);

		boolean isNew = userJourney.isNew();

		UserJourneyModelImpl userJourneyModelImpl = (UserJourneyModelImpl)userJourney;

		Session session = null;

		try {
			session = openSession();

			if (userJourney.isNew()) {
				session.save(userJourney);

				userJourney.setNew(false);
			}
			else {
				userJourney = (UserJourney)session.merge(userJourney);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UserJourneyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
			UserJourneyImpl.class, userJourney.getPrimaryKey(), userJourney,
			false);

		clearUniqueFindersCache(userJourneyModelImpl);
		cacheUniqueFindersCache(userJourneyModelImpl, isNew);

		userJourney.resetOriginalValues();

		return userJourney;
	}

	protected UserJourney toUnwrappedModel(UserJourney userJourney) {
		if (userJourney instanceof UserJourneyImpl) {
			return userJourney;
		}

		UserJourneyImpl userJourneyImpl = new UserJourneyImpl();

		userJourneyImpl.setNew(userJourney.isNew());
		userJourneyImpl.setPrimaryKey(userJourney.getPrimaryKey());

		userJourneyImpl.setUserJourneyId(userJourney.getUserJourneyId());
		userJourneyImpl.setCompanyId(userJourney.getCompanyId());
		userJourneyImpl.setModifiedDate(userJourney.getModifiedDate());
		userJourneyImpl.setAnonymousUserId(userJourney.getAnonymousUserId());
		userJourneyImpl.setRuleInstanceId(userJourney.getRuleInstanceId());
		userJourneyImpl.setCurrentPlid(userJourney.getCurrentPlid());
		userJourneyImpl.setFinished(userJourney.isFinished());

		return userJourneyImpl;
	}

	/**
	 * Returns the user journey with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the user journey
	 * @return the user journey
	 * @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	 */
	@Override
	public UserJourney findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserJourneyException {
		UserJourney userJourney = fetchByPrimaryKey(primaryKey);

		if (userJourney == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserJourneyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return userJourney;
	}

	/**
	 * Returns the user journey with the primary key or throws a {@link NoSuchUserJourneyException} if it could not be found.
	 *
	 * @param userJourneyId the primary key of the user journey
	 * @return the user journey
	 * @throws NoSuchUserJourneyException if a user journey with the primary key could not be found
	 */
	@Override
	public UserJourney findByPrimaryKey(long userJourneyId)
		throws NoSuchUserJourneyException {
		return findByPrimaryKey((Serializable)userJourneyId);
	}

	/**
	 * Returns the user journey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user journey
	 * @return the user journey, or <code>null</code> if a user journey with the primary key could not be found
	 */
	@Override
	public UserJourney fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
				UserJourneyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		UserJourney userJourney = (UserJourney)serializable;

		if (userJourney == null) {
			Session session = null;

			try {
				session = openSession();

				userJourney = (UserJourney)session.get(UserJourneyImpl.class,
						primaryKey);

				if (userJourney != null) {
					cacheResult(userJourney);
				}
				else {
					entityCache.putResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
						UserJourneyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
					UserJourneyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return userJourney;
	}

	/**
	 * Returns the user journey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userJourneyId the primary key of the user journey
	 * @return the user journey, or <code>null</code> if a user journey with the primary key could not be found
	 */
	@Override
	public UserJourney fetchByPrimaryKey(long userJourneyId) {
		return fetchByPrimaryKey((Serializable)userJourneyId);
	}

	@Override
	public Map<Serializable, UserJourney> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, UserJourney> map = new HashMap<Serializable, UserJourney>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			UserJourney userJourney = fetchByPrimaryKey(primaryKey);

			if (userJourney != null) {
				map.put(primaryKey, userJourney);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
					UserJourneyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (UserJourney)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_USERJOURNEY_WHERE_PKS_IN);

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

			for (UserJourney userJourney : (List<UserJourney>)q.list()) {
				map.put(userJourney.getPrimaryKeyObj(), userJourney);

				cacheResult(userJourney);

				uncachedPrimaryKeys.remove(userJourney.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(UserJourneyModelImpl.ENTITY_CACHE_ENABLED,
					UserJourneyImpl.class, primaryKey, nullModel);
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
	 * Returns all the user journeies.
	 *
	 * @return the user journeies
	 */
	@Override
	public List<UserJourney> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserJourney> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserJourney> findAll(int start, int end,
		OrderByComparator<UserJourney> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserJourney> findAll(int start, int end,
		OrderByComparator<UserJourney> orderByComparator,
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

		List<UserJourney> list = null;

		if (retrieveFromCache) {
			list = (List<UserJourney>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERJOURNEY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERJOURNEY;

				if (pagination) {
					sql = sql.concat(UserJourneyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserJourney>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserJourney>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the user journeies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserJourney userJourney : findAll()) {
			remove(userJourney);
		}
	}

	/**
	 * Returns the number of user journeies.
	 *
	 * @return the number of user journeies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERJOURNEY);

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
		return UserJourneyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user journey persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(UserJourneyImpl.class.getName());
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
	private static final String _SQL_SELECT_USERJOURNEY = "SELECT userJourney FROM UserJourney userJourney";
	private static final String _SQL_SELECT_USERJOURNEY_WHERE_PKS_IN = "SELECT userJourney FROM UserJourney userJourney WHERE userJourneyId IN (";
	private static final String _SQL_SELECT_USERJOURNEY_WHERE = "SELECT userJourney FROM UserJourney userJourney WHERE ";
	private static final String _SQL_COUNT_USERJOURNEY = "SELECT COUNT(userJourney) FROM UserJourney userJourney";
	private static final String _SQL_COUNT_USERJOURNEY_WHERE = "SELECT COUNT(userJourney) FROM UserJourney userJourney WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "userJourney.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserJourney exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserJourney exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(UserJourneyPersistenceImpl.class);
}