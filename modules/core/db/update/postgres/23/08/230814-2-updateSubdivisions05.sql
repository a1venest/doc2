alter table DOC_SUBDIVISIONS rename column subdivisions_id to subdivisions_id__u33211 ;
alter table DOC_SUBDIVISIONS drop constraint FK_DOC_SUBDIVISIONS_ON_SUBDIVISIONS ;
drop index IDX_DOC_SUBDIVISIONS_ON_SUBDIVISIONS ;
alter table DOC_SUBDIVISIONS add column LEAD_DIVISION_ID uuid ;
