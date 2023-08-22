alter table SEC_USER add constraint FK_SEC_USER_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_SEC_USER_ON_USER on SEC_USER (USER_ID);
