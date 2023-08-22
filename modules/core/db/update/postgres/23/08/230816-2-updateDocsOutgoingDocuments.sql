alter table DOCS_OUTGOING_DOCUMENTS rename column state to state__u92800 ;
alter table DOCS_OUTGOING_DOCUMENTS add column STATE varchar(255) ;
