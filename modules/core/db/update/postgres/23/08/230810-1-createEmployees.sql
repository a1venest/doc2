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
    SUBDIVISION_ID uuid,
    PHOTO_ID uuid,
    --
    primary key (ID)
);