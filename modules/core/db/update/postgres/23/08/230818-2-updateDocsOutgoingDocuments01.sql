alter table DOCS_OUTGOING_DOCUMENTS add constraint FK_DOCS_OUTGOING_DOCUMENTS_ON_DOCUMENT foreign key (DOCUMENT_ID) references SYS_FILE(ID);
create index IDX_DOCS_OUTGOING_DOCUMENTS_ON_DOCUMENT on DOCS_OUTGOING_DOCUMENTS (DOCUMENT_ID);
