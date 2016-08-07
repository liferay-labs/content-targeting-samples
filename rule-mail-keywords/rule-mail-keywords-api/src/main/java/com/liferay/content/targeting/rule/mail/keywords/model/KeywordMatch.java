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

package com.liferay.content.targeting.rule.mail.keywords.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the KeywordMatch service. Represents a row in the &quot;CT_MK_KeywordMatch&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see KeywordMatchModel
 * @see com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchImpl
 * @see com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchImpl")
@ProviderType
public interface KeywordMatch extends KeywordMatchModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.content.targeting.rule.mail.keywords.model.impl.KeywordMatchImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<KeywordMatch, Long> KEYWORD_MATCH_ID_ACCESSOR = new Accessor<KeywordMatch, Long>() {
			@Override
			public Long get(KeywordMatch keywordMatch) {
				return keywordMatch.getKeywordMatchId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<KeywordMatch> getTypeClass() {
				return KeywordMatch.class;
			}
		};
}