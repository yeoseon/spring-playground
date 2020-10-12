drop table if exists account;
create table account (id bigint not null AUTO_INCREMENT PRIMARY KEY, password varchar(255), username varchar(255));