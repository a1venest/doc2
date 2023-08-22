alter table DOCS_OUTGOING_DOCUMENTS rename column executor_id to executor_id__u42892 ;
alter table DOCS_OUTGOING_DOCUMENTS rename column signatory to signatory__u67933 ;
alter table DOCS_OUTGOING_DOCUMENTS add column ACCEPTANCE_REQUIRED boolean ;
alter table DOCS_OUTGOING_DOCUMENTS add column INITIATOR_ID uuid ;
alter table DOCS_OUTGOING_DOCUMENTS add column SIGNATORY uuid ;
alter table DOCS_OUTGOING_DOCUMENTS add column EXECUTOR_ID uuid ;
