create table CT_MK_KeywordMatch (
	keywordMatchId LONG not null primary key,
	companyId LONG,
	modifiedDate DATE null,
	anonymousUserId LONG,
	ruleInstanceId LONG
);