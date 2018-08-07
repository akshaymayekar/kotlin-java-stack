CREATE DATABASE IF NOT EXISTS kotlin_java_stack;
use kotlin_java_stack;
create table users(id int primary key AUTO_INCREMENT, name varchar(25), password varchar(25), active bit(1));
insert into users(name, password, active) values("admin", "password", 1);
insert into users(name, password, active) values("akshay", "password1", 1);
insert into users(name, password, active) values("sam", "password2", 0);