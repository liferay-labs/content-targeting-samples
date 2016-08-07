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

package com.liferay.content.targeting.rule.mood.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.content.targeting.rule.mood.exception.NoSuchMoodException;
import com.liferay.content.targeting.rule.mood.model.Mood;
import com.liferay.content.targeting.rule.mood.model.impl.MoodImpl;
import com.liferay.content.targeting.rule.mood.model.impl.MoodModelImpl;
import com.liferay.content.targeting.rule.mood.service.persistence.MoodPersistence;

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
 * The persistence implementation for the mood service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MoodPersistence
 * @see com.liferay.content.targeting.rule.mood.service.persistence.MoodUtil
 * @generated
 */
@ProviderType
public class MoodPersistenceImpl extends BasePersistenceImpl<Mood>
	implements MoodPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MoodUtil} to access the mood persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MoodImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANONYMOUSUSERID =
		new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnonymousUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANONYMOUSUSERID =
		new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnonymousUserId",
			new String[] { Long.class.getName() },
			MoodModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANONYMOUSUSERID = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAnonymousUserId", new String[] { Long.class.getName() });

	/**
	 * Returns all the moods where anonymousUserId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @return the matching moods
	 */
	@Override
	public List<Mood> findByAnonymousUserId(long anonymousUserId) {
		return findByAnonymousUserId(anonymousUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Mood> findByAnonymousUserId(long anonymousUserId, int start,
		int end) {
		return findByAnonymousUserId(anonymousUserId, start, end, null);
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
	@Override
	public List<Mood> findByAnonymousUserId(long anonymousUserId, int start,
		int end, OrderByComparator<Mood> orderByComparator) {
		return findByAnonymousUserId(anonymousUserId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Mood> findByAnonymousUserId(long anonymousUserId, int start,
		int end, OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANONYMOUSUSERID;
			finderArgs = new Object[] { anonymousUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANONYMOUSUSERID;
			finderArgs = new Object[] {
					anonymousUserId,
					
					start, end, orderByComparator
				};
		}

		List<Mood> list = null;

		if (retrieveFromCache) {
			list = (List<Mood>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Mood mood : list) {
					if ((anonymousUserId != mood.getAnonymousUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOOD_WHERE);

			query.append(_FINDER_COLUMN_ANONYMOUSUSERID_ANONYMOUSUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MoodModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

				if (!pagination) {
					list = (List<Mood>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Mood>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first mood in the ordered set where anonymousUserId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mood
	 * @throws NoSuchMoodException if a matching mood could not be found
	 */
	@Override
	public Mood findByAnonymousUserId_First(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator) throws NoSuchMoodException {
		Mood mood = fetchByAnonymousUserId_First(anonymousUserId,
				orderByComparator);

		if (mood != null) {
			return mood;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anonymousUserId=");
		msg.append(anonymousUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMoodException(msg.toString());
	}

	/**
	 * Returns the first mood in the ordered set where anonymousUserId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mood, or <code>null</code> if a matching mood could not be found
	 */
	@Override
	public Mood fetchByAnonymousUserId_First(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator) {
		List<Mood> list = findByAnonymousUserId(anonymousUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mood in the ordered set where anonymousUserId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mood
	 * @throws NoSuchMoodException if a matching mood could not be found
	 */
	@Override
	public Mood findByAnonymousUserId_Last(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator) throws NoSuchMoodException {
		Mood mood = fetchByAnonymousUserId_Last(anonymousUserId,
				orderByComparator);

		if (mood != null) {
			return mood;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("anonymousUserId=");
		msg.append(anonymousUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMoodException(msg.toString());
	}

	/**
	 * Returns the last mood in the ordered set where anonymousUserId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mood, or <code>null</code> if a matching mood could not be found
	 */
	@Override
	public Mood fetchByAnonymousUserId_Last(long anonymousUserId,
		OrderByComparator<Mood> orderByComparator) {
		int count = countByAnonymousUserId(anonymousUserId);

		if (count == 0) {
			return null;
		}

		List<Mood> list = findByAnonymousUserId(anonymousUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Mood[] findByAnonymousUserId_PrevAndNext(long moodId,
		long anonymousUserId, OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException {
		Mood mood = findByPrimaryKey(moodId);

		Session session = null;

		try {
			session = openSession();

			Mood[] array = new MoodImpl[3];

			array[0] = getByAnonymousUserId_PrevAndNext(session, mood,
					anonymousUserId, orderByComparator, true);

			array[1] = mood;

			array[2] = getByAnonymousUserId_PrevAndNext(session, mood,
					anonymousUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Mood getByAnonymousUserId_PrevAndNext(Session session, Mood mood,
		long anonymousUserId, OrderByComparator<Mood> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOOD_WHERE);

		query.append(_FINDER_COLUMN_ANONYMOUSUSERID_ANONYMOUSUSERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MoodModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(anonymousUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(mood);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Mood> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moods where anonymousUserId = &#63; from the database.
	 *
	 * @param anonymousUserId the anonymous user ID
	 */
	@Override
	public void removeByAnonymousUserId(long anonymousUserId) {
		for (Mood mood : findByAnonymousUserId(anonymousUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(mood);
		}
	}

	/**
	 * Returns the number of moods where anonymousUserId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @return the number of matching moods
	 */
	@Override
	public int countByAnonymousUserId(long anonymousUserId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANONYMOUSUSERID;

		Object[] finderArgs = new Object[] { anonymousUserId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOOD_WHERE);

			query.append(_FINDER_COLUMN_ANONYMOUSUSERID_ANONYMOUSUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(anonymousUserId);

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

	private static final String _FINDER_COLUMN_ANONYMOUSUSERID_ANONYMOUSUSERID_2 =
		"mood.anonymousUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RULEINSTANCEID =
		new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleInstanceId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEINSTANCEID =
		new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleInstanceId",
			new String[] { Long.class.getName() },
			MoodModelImpl.RULEINSTANCEID_COLUMN_BITMASK |
			MoodModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RULEINSTANCEID = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleInstanceId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the moods where ruleInstanceId = &#63;.
	 *
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching moods
	 */
	@Override
	public List<Mood> findByRuleInstanceId(long ruleInstanceId) {
		return findByRuleInstanceId(ruleInstanceId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Mood> findByRuleInstanceId(long ruleInstanceId, int start,
		int end) {
		return findByRuleInstanceId(ruleInstanceId, start, end, null);
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
	@Override
	public List<Mood> findByRuleInstanceId(long ruleInstanceId, int start,
		int end, OrderByComparator<Mood> orderByComparator) {
		return findByRuleInstanceId(ruleInstanceId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Mood> findByRuleInstanceId(long ruleInstanceId, int start,
		int end, OrderByComparator<Mood> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEINSTANCEID;
			finderArgs = new Object[] { ruleInstanceId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RULEINSTANCEID;
			finderArgs = new Object[] {
					ruleInstanceId,
					
					start, end, orderByComparator
				};
		}

		List<Mood> list = null;

		if (retrieveFromCache) {
			list = (List<Mood>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Mood mood : list) {
					if ((ruleInstanceId != mood.getRuleInstanceId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MOOD_WHERE);

			query.append(_FINDER_COLUMN_RULEINSTANCEID_RULEINSTANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MoodModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleInstanceId);

				if (!pagination) {
					list = (List<Mood>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Mood>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first mood in the ordered set where ruleInstanceId = &#63;.
	 *
	 * @param ruleInstanceId the rule instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mood
	 * @throws NoSuchMoodException if a matching mood could not be found
	 */
	@Override
	public Mood findByRuleInstanceId_First(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator) throws NoSuchMoodException {
		Mood mood = fetchByRuleInstanceId_First(ruleInstanceId,
				orderByComparator);

		if (mood != null) {
			return mood;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleInstanceId=");
		msg.append(ruleInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMoodException(msg.toString());
	}

	/**
	 * Returns the first mood in the ordered set where ruleInstanceId = &#63;.
	 *
	 * @param ruleInstanceId the rule instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching mood, or <code>null</code> if a matching mood could not be found
	 */
	@Override
	public Mood fetchByRuleInstanceId_First(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator) {
		List<Mood> list = findByRuleInstanceId(ruleInstanceId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last mood in the ordered set where ruleInstanceId = &#63;.
	 *
	 * @param ruleInstanceId the rule instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mood
	 * @throws NoSuchMoodException if a matching mood could not be found
	 */
	@Override
	public Mood findByRuleInstanceId_Last(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator) throws NoSuchMoodException {
		Mood mood = fetchByRuleInstanceId_Last(ruleInstanceId, orderByComparator);

		if (mood != null) {
			return mood;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleInstanceId=");
		msg.append(ruleInstanceId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMoodException(msg.toString());
	}

	/**
	 * Returns the last mood in the ordered set where ruleInstanceId = &#63;.
	 *
	 * @param ruleInstanceId the rule instance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching mood, or <code>null</code> if a matching mood could not be found
	 */
	@Override
	public Mood fetchByRuleInstanceId_Last(long ruleInstanceId,
		OrderByComparator<Mood> orderByComparator) {
		int count = countByRuleInstanceId(ruleInstanceId);

		if (count == 0) {
			return null;
		}

		List<Mood> list = findByRuleInstanceId(ruleInstanceId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Mood[] findByRuleInstanceId_PrevAndNext(long moodId,
		long ruleInstanceId, OrderByComparator<Mood> orderByComparator)
		throws NoSuchMoodException {
		Mood mood = findByPrimaryKey(moodId);

		Session session = null;

		try {
			session = openSession();

			Mood[] array = new MoodImpl[3];

			array[0] = getByRuleInstanceId_PrevAndNext(session, mood,
					ruleInstanceId, orderByComparator, true);

			array[1] = mood;

			array[2] = getByRuleInstanceId_PrevAndNext(session, mood,
					ruleInstanceId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Mood getByRuleInstanceId_PrevAndNext(Session session, Mood mood,
		long ruleInstanceId, OrderByComparator<Mood> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MOOD_WHERE);

		query.append(_FINDER_COLUMN_RULEINSTANCEID_RULEINSTANCEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MoodModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleInstanceId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(mood);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Mood> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the moods where ruleInstanceId = &#63; from the database.
	 *
	 * @param ruleInstanceId the rule instance ID
	 */
	@Override
	public void removeByRuleInstanceId(long ruleInstanceId) {
		for (Mood mood : findByRuleInstanceId(ruleInstanceId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(mood);
		}
	}

	/**
	 * Returns the number of moods where ruleInstanceId = &#63;.
	 *
	 * @param ruleInstanceId the rule instance ID
	 * @return the number of matching moods
	 */
	@Override
	public int countByRuleInstanceId(long ruleInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RULEINSTANCEID;

		Object[] finderArgs = new Object[] { ruleInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MOOD_WHERE);

			query.append(_FINDER_COLUMN_RULEINSTANCEID_RULEINSTANCEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_RULEINSTANCEID_RULEINSTANCEID_2 = "mood.ruleInstanceId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_R = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, MoodImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			MoodModelImpl.ANONYMOUSUSERID_COLUMN_BITMASK |
			MoodModelImpl.RULEINSTANCEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_R = new FinderPath(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or throws a {@link NoSuchMoodException} if it could not be found.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching mood
	 * @throws NoSuchMoodException if a matching mood could not be found
	 */
	@Override
	public Mood findByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchMoodException {
		Mood mood = fetchByA_R(anonymousUserId, ruleInstanceId);

		if (mood == null) {
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

			throw new NoSuchMoodException(msg.toString());
		}

		return mood;
	}

	/**
	 * Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the matching mood, or <code>null</code> if a matching mood could not be found
	 */
	@Override
	public Mood fetchByA_R(long anonymousUserId, long ruleInstanceId) {
		return fetchByA_R(anonymousUserId, ruleInstanceId, true);
	}

	/**
	 * Returns the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching mood, or <code>null</code> if a matching mood could not be found
	 */
	@Override
	public Mood fetchByA_R(long anonymousUserId, long ruleInstanceId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { anonymousUserId, ruleInstanceId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_A_R,
					finderArgs, this);
		}

		if (result instanceof Mood) {
			Mood mood = (Mood)result;

			if ((anonymousUserId != mood.getAnonymousUserId()) ||
					(ruleInstanceId != mood.getRuleInstanceId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MOOD_WHERE);

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

				List<Mood> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, finderArgs,
						list);
				}
				else {
					Mood mood = list.get(0);

					result = mood;

					cacheResult(mood);

					if ((mood.getAnonymousUserId() != anonymousUserId) ||
							(mood.getRuleInstanceId() != ruleInstanceId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_A_R,
							finderArgs, mood);
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
			return (Mood)result;
		}
	}

	/**
	 * Removes the mood where anonymousUserId = &#63; and ruleInstanceId = &#63; from the database.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the mood that was removed
	 */
	@Override
	public Mood removeByA_R(long anonymousUserId, long ruleInstanceId)
		throws NoSuchMoodException {
		Mood mood = findByA_R(anonymousUserId, ruleInstanceId);

		return remove(mood);
	}

	/**
	 * Returns the number of moods where anonymousUserId = &#63; and ruleInstanceId = &#63;.
	 *
	 * @param anonymousUserId the anonymous user ID
	 * @param ruleInstanceId the rule instance ID
	 * @return the number of matching moods
	 */
	@Override
	public int countByA_R(long anonymousUserId, long ruleInstanceId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_R;

		Object[] finderArgs = new Object[] { anonymousUserId, ruleInstanceId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MOOD_WHERE);

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

	private static final String _FINDER_COLUMN_A_R_ANONYMOUSUSERID_2 = "mood.anonymousUserId = ? AND ";
	private static final String _FINDER_COLUMN_A_R_RULEINSTANCEID_2 = "mood.ruleInstanceId = ?";

	public MoodPersistenceImpl() {
		setModelClass(Mood.class);
	}

	/**
	 * Caches the mood in the entity cache if it is enabled.
	 *
	 * @param mood the mood
	 */
	@Override
	public void cacheResult(Mood mood) {
		entityCache.putResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodImpl.class, mood.getPrimaryKey(), mood);

		finderCache.putResult(FINDER_PATH_FETCH_BY_A_R,
			new Object[] { mood.getAnonymousUserId(), mood.getRuleInstanceId() },
			mood);

		mood.resetOriginalValues();
	}

	/**
	 * Caches the moods in the entity cache if it is enabled.
	 *
	 * @param moods the moods
	 */
	@Override
	public void cacheResult(List<Mood> moods) {
		for (Mood mood : moods) {
			if (entityCache.getResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
						MoodImpl.class, mood.getPrimaryKey()) == null) {
				cacheResult(mood);
			}
			else {
				mood.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all moods.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MoodImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the mood.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Mood mood) {
		entityCache.removeResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodImpl.class, mood.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MoodModelImpl)mood);
	}

	@Override
	public void clearCache(List<Mood> moods) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Mood mood : moods) {
			entityCache.removeResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
				MoodImpl.class, mood.getPrimaryKey());

			clearUniqueFindersCache((MoodModelImpl)mood);
		}
	}

	protected void cacheUniqueFindersCache(MoodModelImpl moodModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					moodModelImpl.getAnonymousUserId(),
					moodModelImpl.getRuleInstanceId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_A_R, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, args, moodModelImpl);
		}
		else {
			if ((moodModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moodModelImpl.getAnonymousUserId(),
						moodModelImpl.getRuleInstanceId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_A_R, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_A_R, args,
					moodModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(MoodModelImpl moodModelImpl) {
		Object[] args = new Object[] {
				moodModelImpl.getAnonymousUserId(),
				moodModelImpl.getRuleInstanceId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, args);

		if ((moodModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_R.getColumnBitmask()) != 0) {
			args = new Object[] {
					moodModelImpl.getOriginalAnonymousUserId(),
					moodModelImpl.getOriginalRuleInstanceId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_A_R, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_A_R, args);
		}
	}

	/**
	 * Creates a new mood with the primary key. Does not add the mood to the database.
	 *
	 * @param moodId the primary key for the new mood
	 * @return the new mood
	 */
	@Override
	public Mood create(long moodId) {
		Mood mood = new MoodImpl();

		mood.setNew(true);
		mood.setPrimaryKey(moodId);

		mood.setCompanyId(companyProvider.getCompanyId());

		return mood;
	}

	/**
	 * Removes the mood with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param moodId the primary key of the mood
	 * @return the mood that was removed
	 * @throws NoSuchMoodException if a mood with the primary key could not be found
	 */
	@Override
	public Mood remove(long moodId) throws NoSuchMoodException {
		return remove((Serializable)moodId);
	}

	/**
	 * Removes the mood with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the mood
	 * @return the mood that was removed
	 * @throws NoSuchMoodException if a mood with the primary key could not be found
	 */
	@Override
	public Mood remove(Serializable primaryKey) throws NoSuchMoodException {
		Session session = null;

		try {
			session = openSession();

			Mood mood = (Mood)session.get(MoodImpl.class, primaryKey);

			if (mood == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMoodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(mood);
		}
		catch (NoSuchMoodException nsee) {
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
	protected Mood removeImpl(Mood mood) {
		mood = toUnwrappedModel(mood);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mood)) {
				mood = (Mood)session.get(MoodImpl.class, mood.getPrimaryKeyObj());
			}

			if (mood != null) {
				session.delete(mood);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (mood != null) {
			clearCache(mood);
		}

		return mood;
	}

	@Override
	public Mood updateImpl(Mood mood) {
		mood = toUnwrappedModel(mood);

		boolean isNew = mood.isNew();

		MoodModelImpl moodModelImpl = (MoodModelImpl)mood;

		Session session = null;

		try {
			session = openSession();

			if (mood.isNew()) {
				session.save(mood);

				mood.setNew(false);
			}
			else {
				mood = (Mood)session.merge(mood);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MoodModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((moodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANONYMOUSUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moodModelImpl.getOriginalAnonymousUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANONYMOUSUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANONYMOUSUSERID,
					args);

				args = new Object[] { moodModelImpl.getAnonymousUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANONYMOUSUSERID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANONYMOUSUSERID,
					args);
			}

			if ((moodModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEINSTANCEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						moodModelImpl.getOriginalRuleInstanceId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RULEINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEINSTANCEID,
					args);

				args = new Object[] { moodModelImpl.getRuleInstanceId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RULEINSTANCEID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEINSTANCEID,
					args);
			}
		}

		entityCache.putResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
			MoodImpl.class, mood.getPrimaryKey(), mood, false);

		clearUniqueFindersCache(moodModelImpl);
		cacheUniqueFindersCache(moodModelImpl, isNew);

		mood.resetOriginalValues();

		return mood;
	}

	protected Mood toUnwrappedModel(Mood mood) {
		if (mood instanceof MoodImpl) {
			return mood;
		}

		MoodImpl moodImpl = new MoodImpl();

		moodImpl.setNew(mood.isNew());
		moodImpl.setPrimaryKey(mood.getPrimaryKey());

		moodImpl.setMoodId(mood.getMoodId());
		moodImpl.setCompanyId(mood.getCompanyId());
		moodImpl.setModifiedDate(mood.getModifiedDate());
		moodImpl.setAnonymousUserId(mood.getAnonymousUserId());
		moodImpl.setRuleInstanceId(mood.getRuleInstanceId());
		moodImpl.setTimeToLive(mood.getTimeToLive());

		return moodImpl;
	}

	/**
	 * Returns the mood with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the mood
	 * @return the mood
	 * @throws NoSuchMoodException if a mood with the primary key could not be found
	 */
	@Override
	public Mood findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMoodException {
		Mood mood = fetchByPrimaryKey(primaryKey);

		if (mood == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMoodException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return mood;
	}

	/**
	 * Returns the mood with the primary key or throws a {@link NoSuchMoodException} if it could not be found.
	 *
	 * @param moodId the primary key of the mood
	 * @return the mood
	 * @throws NoSuchMoodException if a mood with the primary key could not be found
	 */
	@Override
	public Mood findByPrimaryKey(long moodId) throws NoSuchMoodException {
		return findByPrimaryKey((Serializable)moodId);
	}

	/**
	 * Returns the mood with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the mood
	 * @return the mood, or <code>null</code> if a mood with the primary key could not be found
	 */
	@Override
	public Mood fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
				MoodImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Mood mood = (Mood)serializable;

		if (mood == null) {
			Session session = null;

			try {
				session = openSession();

				mood = (Mood)session.get(MoodImpl.class, primaryKey);

				if (mood != null) {
					cacheResult(mood);
				}
				else {
					entityCache.putResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
						MoodImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
					MoodImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return mood;
	}

	/**
	 * Returns the mood with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param moodId the primary key of the mood
	 * @return the mood, or <code>null</code> if a mood with the primary key could not be found
	 */
	@Override
	public Mood fetchByPrimaryKey(long moodId) {
		return fetchByPrimaryKey((Serializable)moodId);
	}

	@Override
	public Map<Serializable, Mood> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Mood> map = new HashMap<Serializable, Mood>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Mood mood = fetchByPrimaryKey(primaryKey);

			if (mood != null) {
				map.put(primaryKey, mood);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
					MoodImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Mood)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MOOD_WHERE_PKS_IN);

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

			for (Mood mood : (List<Mood>)q.list()) {
				map.put(mood.getPrimaryKeyObj(), mood);

				cacheResult(mood);

				uncachedPrimaryKeys.remove(mood.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MoodModelImpl.ENTITY_CACHE_ENABLED,
					MoodImpl.class, primaryKey, nullModel);
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
	 * Returns all the moods.
	 *
	 * @return the moods
	 */
	@Override
	public List<Mood> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Mood> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Mood> findAll(int start, int end,
		OrderByComparator<Mood> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Mood> findAll(int start, int end,
		OrderByComparator<Mood> orderByComparator, boolean retrieveFromCache) {
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

		List<Mood> list = null;

		if (retrieveFromCache) {
			list = (List<Mood>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MOOD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MOOD;

				if (pagination) {
					sql = sql.concat(MoodModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Mood>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Mood>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the moods from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Mood mood : findAll()) {
			remove(mood);
		}
	}

	/**
	 * Returns the number of moods.
	 *
	 * @return the number of moods
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MOOD);

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
		return MoodModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the mood persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MoodImpl.class.getName());
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
	private static final String _SQL_SELECT_MOOD = "SELECT mood FROM Mood mood";
	private static final String _SQL_SELECT_MOOD_WHERE_PKS_IN = "SELECT mood FROM Mood mood WHERE moodId IN (";
	private static final String _SQL_SELECT_MOOD_WHERE = "SELECT mood FROM Mood mood WHERE ";
	private static final String _SQL_COUNT_MOOD = "SELECT COUNT(mood) FROM Mood mood";
	private static final String _SQL_COUNT_MOOD_WHERE = "SELECT COUNT(mood) FROM Mood mood WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "mood.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Mood exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Mood exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MoodPersistenceImpl.class);
}