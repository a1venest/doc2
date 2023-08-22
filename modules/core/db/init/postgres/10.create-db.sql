-- begin DOC_DOCUMENT_TYPE
create table DOC_DOCUMENT_TYPE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end DOC_DOCUMENT_TYPE

-- begin DOC_SUBDIVISIONS
create table DOC_SUBDIVISIONS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255),
    NAME varchar(255) not null,
    DIVISION_HEAD_ID uuid,
    LEAD_DIVISION_ID uuid,
    OUTGOING_DOCUMENTS_ID uuid,
    --
    primary key (ID)
)^
-- end DOC_SUBDIVISIONS
-- begin DOCS_OUTGOING_DOCUMENTS
create table DOCS_OUTGOING_DOCUMENTS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOC_TYPE_ID uuid not null,
    DOCUMENT_ID uuid,
    INITIATOR_ID uuid,
    EXECUTOR_ID uuid,
    DIVISIONHEAD_ID uuid,
    REG_NUMBER varchar(255),
    REG_DATA date,
    WHOM varchar(255),
    THEME varchar(255),
    ADDRESSEE varchar(255),
    SIGNATORY uuid,
    NOTE varchar(255),
    NAME varchar(255),
    AUTHOR varchar(255),
    DATE_OF_CREATION date,
    DATE_OF_CHANGE date,
    STATE varchar(255),
    ACCEPTANCE_REQUIRED boolean,
    --
    primary key (ID)
)^
-- end DOCS_OUTGOING_DOCUMENTS
-- begin DOC_EMPLOYEES
create table DOC_EMPLOYEES (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255),
    USER_ID uuid,
    PHONE varchar(255),
    PHOTO_ID uuid,
    --
    primary key (ID)
)^
-- end DOC_EMPLOYEES
