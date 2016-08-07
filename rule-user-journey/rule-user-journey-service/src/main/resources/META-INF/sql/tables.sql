create table CT_UJ_UserJourney (
	userJourneyId LONG not null primary key,
	companyId LONG,
	modifiedDate DATE null,
	anonymousUserId LONG,
	ruleInstanceId LONG,
	currentPlid LONG,
	finished BOOLEAN
);