alter table DOC_SUBDIVISIONS add constraint FK_DOC_SUBDIVISIONS_ON_LEAD_DIVISION foreign key (LEAD_DIVISION_ID) references DOC_SUBDIVISIONS(ID);
create index IDX_DOC_SUBDIVISIONS_ON_LEAD_DIVISION on DOC_SUBDIVISIONS (LEAD_DIVISION_ID);