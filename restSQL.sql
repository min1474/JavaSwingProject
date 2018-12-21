create table member (
	num int auto_increment primary key,
	id varchar(20),
	pw varchar(20),
	name varchar(20),
	tel varchar(20),
	email varchar(30)
);

create table booking (
	num int auto_increment primary key,
	day varchar(20),
	hour varchar(20),
	name varchar(20),
	tel varchar(20),
	tablenum varchar(30)
);

create table review (
	num int auto_increment primary key,
	title varchar(50),
	name varchar(20),
	content varchar(300),
	grade varchar(5)
);

insert into member(id, pw, name, tel, email) values('aaa','aaa','aaa','aaa','aaa');
insert into member(id, pw, name, tel, email) values('bbb','bbb','bbb','bbb','bbb');
insert into member(id, pw, name, tel, email) values('ccc','ccc','ccc','ccc','ccc');
insert into member(id, pw, name, tel, email) values('ddd','ddd','ddd','ddd','ddd');
insert into member(id, pw, name, tel, email) values('eee','eee','eee','eee','eee');
insert into member(id, pw, name, tel, email) values('fff','fff','fff','fff','fff');
insert into member(id, pw, name, tel, email) values('ggg','ggg','ggg','ggg','ggg');
insert into member(id, pw, name, tel, email) values('hhh','hhh','hhh','hhh','hhh');
insert into member(id, pw, name, tel, email) values('iii','iii','iii','iii','iii');
insert into member(id, pw, name, tel, email) values('jjj','jjj','jjj','jjj','jjj');
insert into member(id, pw, name, tel, email) values('kkk','kkk','kkk','kkk','kkk');













