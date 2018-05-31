drop table quarantine if exists
drop table rule if exists
drop sequence if exists hibernate_sequence

create sequence hibernate_sequence start with 1 increment by 1
 
   
create table quarantine (
       id bigint not null,
        gav varchar(255),
        requestdate timestamp,
        primary key (id)
)
 
    
create table rule (
       id bigint not null,
        rule varchar(255),
        primary key (id)
)
    