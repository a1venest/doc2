alter table DOCS_OUTGOING_DOCUMENTS rename column author to author__u19354 ;
alter table DOCS_OUTGOING_DOCUMENTS drop constraint FK_DOCS_OUTGOING_DOCUMENTS_ON_AUTHOR ;
drop index IDX_DOCS_OUTGOING_DOCUMENTS_ON_AUTHOR ;
