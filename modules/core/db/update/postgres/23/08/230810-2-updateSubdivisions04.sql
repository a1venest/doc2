alter table DOC_SUBDIVISIONS rename column division_head_id to division_head_id__u32379 ;
alter table DOC_SUBDIVISIONS drop constraint FK_DOC_SUBDIVISIONS_ON_DIVISION_HEAD ;
drop index IDX_DOC_SUBDIVISIONS_ON_DIVISION_HEAD ;
alter table DOC_SUBDIVISIONS add column DIVISION_HEAD_ID uuid ;
