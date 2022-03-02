drop table if exists person CASCADE;
create table person (
id integer AUTO_INCREMENT,
age integer not null, 
favefood varchar(255), 
name varchar(255), 
primary key (id)
);