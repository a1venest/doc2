alter table DOCS_OUTGOING_DOCUMENTS add constraint FK_DOCS_OUTGOING_DOCUMENTS_ON_EXECUTOR foreign key (EXECUTOR_ID) references DOC_EMPLOYEES(ID);
create index IDX_DOCS_OUTGOING_DOCUMENTS_ON_EXECUTOR on DOCS_OUTGOING_DOCUMENTS (EXECUTOR_ID);