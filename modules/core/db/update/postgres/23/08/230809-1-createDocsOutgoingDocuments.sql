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
    REG_NUMBER varchar(255),
    REG_DATA date,
    WHOM varchar(255),
    THEME varchar(255),
    ADDRESSEE varchar(255),
    EXECUTOR varchar(255),
    SIGNATORY varchar(255),
    NOTE varchar(255),
    NAME varchar(255),
    AUTOR varchar(255),
    DATE_OF_CREATION date,
    DATE_OF_CHANGE date,
    STATE varchar(255),
    --
    primary key (ID)
);