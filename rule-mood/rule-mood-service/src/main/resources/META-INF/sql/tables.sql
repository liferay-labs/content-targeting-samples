create table CT_Mood_Mood (
	moodId LONG not null primary key,
	companyId LONG,
	modifiedDate DATE null,
	anonymousUserId LONG,
	ruleInstanceId LONG,
	timeToLive LONG
);