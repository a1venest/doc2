alter table DOC_SUBDIVISIONS rename column lead_division_id to lead_division_id__u15899 ;
alter table DOC_SUBDIVISIONS drop constraint FK_DOC_SUBDIVISIONS_ON_LEAD_DIVISION ;
drop index IDX_DOC_SUBDIVISIONS_ON_LEAD_DIVISION ;
