alter table DOCS_OUTGOING_DOCUMENTS rename column author to author__u00459 ;
alter table DOCS_OUTGOING_DOCUMENTS add column AUTHOR uuid ;
