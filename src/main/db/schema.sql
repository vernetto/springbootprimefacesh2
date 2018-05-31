create table RULE (ID integer not null, RULE VARCHAR, primary key(id));

create table QUARANTINE (ID integer not null, GAV VARCHAR(255), REQUESTDATE TIMESTAMP,  primary key(id));
