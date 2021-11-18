drop database if exists eShop;
create database if not exists eShop;

use eShop;
SET NAMES 'utf8';

create table users(
id INT PRIMARY KEY auto_increment, 
username varchar(100),
email varchar(100) unique, 
address varchar(100), 
password varchar(100),
status varchar(30) default("active"));


create table products_tea(
id INT PRIMARY KEY auto_increment, 
name varchar(100), 
description text, 
price varchar(100), 
category varchar(100), 
image varchar(250), 
created varchar(30));



create table products_dish(
id INT PRIMARY KEY auto_increment, 
name varchar(100), 
description text(200), 
price varchar(100), 
category varchar(100), 
image varchar(250), 
created varchar(30));
		
        
create table orders(
id int auto_increment primary key,
userId int not null ,
productId int not null,
status varchar(30) default("registered"));    

alter table orders add foreign key (id) references products_dish(id);
alter table orders add foreign key (id) references users(id);