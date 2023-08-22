alter table SEC_USER add constraint FK_SEC_USER_ON_PHOTO foreign key (PHOTO_ID) references SYS_FILE(ID);
create index IDX_SEC_USER_ON_PHOTO on SEC_USER (PHOTO_ID);
