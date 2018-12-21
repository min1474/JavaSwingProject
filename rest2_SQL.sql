create table member (
	num int auto_increment primary key,
	id varchar(30) not null,
	pw varchar(30) not null,
	name varchar(20) not null,
	tel varchar(30) not null,
	email varchar(30) not null
);

create table booking (
	num int auto_increment primary key,
	tablenum varchar(10) not null,
	id varchar(30) not null,
	name varchar(20) not null,
	tel varchar(30) not null,
	person varchar(10) not null,
	year varchar(10) not null,
	month varchar(10) not null,
	day varchar(10) not null,
	hour varchar(30) not null
);

create table review (
	num int auto_increment primary key,
	id varchar(30) not null,
	title varchar(100) not null,
	content varchar(300) not null,
	grade varchar(10) not null
);

create table adminmember (
	num int auto_increment primary key,
	id varchar(30) not null,
	pw varchar(30) not null,
	name varchar(20) not null,
	email varchar(30) not null,
	tel varchar(30) not null,
	code varchar(10) not null,
	admin varchar(20) not null
);
	
alter table booking add unique(tablenum, year, month, day, hour);


 member ������
insert into member(id, pw, name, tel, email) values('kim1111','1234','kim1','010-1234-1234','kim1111@naver.com');
insert into member(id, pw, name, tel, email) values('song1111','1234','song1','010-5678-5678','song1111@naver.com');
insert into member(id, pw, name, tel, email) values('park1111','1234','park1','010-4321-4321','park1111@naver.com');
insert into member(id, pw, name, tel, email) values('lee1111','1234','lee1','010-8765-8765','lee1111@naver.com');
insert into member(id, pw, name, tel, email) values('jung1111','1234','jung1','010-0123-0123','jung1111@naver.com');
insert into member(id, pw, name, tel, email) values('kim2222','1234','kim2','010-2345-2345','kim2222@naver.com');
insert into member(id, pw, name, tel, email) values('song2222','1234','song2','010-6543-6543','song2222@naver.com');
insert into member(id, pw, name, tel, email) values('park2222','1234','park2','010-9876-9876','park2222@naver.com');
insert into member(id, pw, name, tel, email) values('lee2222','1234','lee2','010-5913-5913','lee2222@daum.com');
insert into member(id, pw, name, tel, email) values('jung2222','1234','jung2','010-7439-7439','jung2222@daum.com');
insert into member(id, pw, name, tel, email) values('kim3333','1234','kim3','010-2398-2398','kim3333@naver.com');
insert into member(id, pw, name, tel, email) values('song3333','1234','song3','010-1298-1298','song3333@naver.com');
insert into member(id, pw, name, tel, email) values('park3333','1234','park3','010-3841-3841','park3333@naver.com');
insert into member(id, pw, name, tel, email) values('lee3333','1234','lee3','010-2984-2984','lee3333@daum.com');
insert into member(id, pw, name, tel, email) values('jung3333','1234','jung3','010-2847-2847','jung3333@daum.com');
insert into member(id, pw, name, tel, email) values('kim4444','1234','kim4','010-3275-3275','kim4444@naver.com');
insert into member(id, pw, name, tel, email) values('song4444','1234','song4','010-3247-3247','song4444@naver.com');
insert into member(id, pw, name, tel, email) values('park4444','1234','park4','010-1548-1548','park4444@naver.com');
insert into member(id, pw, name, tel, email) values('lee4444','1234','lee4','010-9854-9854','lee4444@daum.com');
insert into member(id, pw, name, tel, email) values('jung4444','1234','jung4','010-6575-6575','jung4444@daum.com');

insert into member(id, pw, name, tel, email) values('min1','1234','jagnmin1','010-6575-6575','jangmin1@naver.com');
insert into member(id, pw, name, tel, email) values('min2','1234','jagnmin2','010-6575-6575','jangmin2@naver.com');
insert into member(id, pw, name, tel, email) values('min3','1234','jagnmin3','010-6575-6575','jangmin3@naver.com');
insert into member(id, pw, name, tel, email) values('min4','1234','jagnmin4','010-6575-6575','jangmin4@naver.com');
insert into member(id, pw, name, tel, email) values('min5','1234','jagnmin5','010-6575-6575','jangmin5@naver.com');
insert into member(id, pw, name, tel, email) values('min6','1234','jagnmin6','010-6575-6575','jangmin6@naver.com');
insert into member(id, pw, name, tel, email) values('min7','1234','jagnmin7','010-6575-6575','jangmin7@naver.com');
insert into member(id, pw, name, tel, email) values('min8','1234','jagnmin8','010-6575-6575','jangmin8@naver.com');
insert into member(id, pw, name, tel, email) values('min9','1234','jagnmin9','010-6575-6575','jangmin9@naver.com');
insert into member(id, pw, name, tel, email) values('min10','1234','jagnmin10','010-6575-6575','jangmin10@naver.com');





 adminmember ������
insert into adminmember(id, pw, name, email, tel, code, admin) values('root1','root','admin1','admin1111@naver.com','010-1111-1111', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root2','root','admin2','admin2222@daum.com','010-2222-2222', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root3','root','admin3','admin3333@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root4','root','admin4','admin4444@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root5','root','admin5','admin5555@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root6','root','admin6','admin6666@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root7','root','admin7','admin7777@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root8','root','admin8','admin8888@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root9','root','admin9','admin9999@daum.com','010-3333-3333', 'A1B1C1', 'administator');
insert into adminmember(id, pw, name, email, tel, code, admin) values('root10','root','admin10','admin1010@daum.com','010-3333-3333', 'A1B1C1', 'administator');




 booking ������

insert into booking values(null, '1', 'kim1111', 'kim1', '010-1234-1234', '2', '2018', '12', '25', '18:00 (Dinner)');
insert into booking values(null, '2', 'park2222', 'park2', '010-9876-9876', '4', '2018', '12', '25', '18:00 (Dinner)');
insert into booking values(null, '3', 'song1111', 'song1', '010-5678-5678', '4', '2018', '12', '25', '18:00 (Dinner)');

insert into booking values(null, '3', 'kim1111', 'kim1', '010-1234-1234', '4', '2018', '11', '11', '08:00 (AM)');
insert into booking values(null, '3', 'song4444', 'song4', '010-3247-3247', '3', '2018', '11', '11', '12:00 (Lunch)');
insert into booking values(null, '3', 'jung3333', 'jung3', '010-2847-2847', '5', '2018', '11', '11', '18:00 (Dinner)');

insert into booking values(null, '1', 'lee1111', 'lee1', '010-8765-8765', '4', '2018', '12', '31', '12:00 (Lunch)');
insert into booking values(null, '2', 'lee1111', 'lee1', '010-8765-8765', '4', '2018', '12', '31', '12:00 (Lunch)');
insert into booking values(null, '3', 'lee1111', 'lee1', '010-8765-8765', '3', '2018', '12', '31', '12:00 (Lunch)');


insert into booking values(null, '1', 'park4444', 'park4', '010-1548-1548', '5', '2018', '12', '1', '08:00 (AM)');
insert into booking values(null, '1', 'park4444', 'park4', '010-1548-1548', '5', '2018', '12', '1', '12:00 (Lunch)');
insert into booking values(null, '1', 'park4444', 'park4', '010-1548-1548', '5', '2018', '12', '1', '18:00 (Dinner)');

insert into booking values(null, '2', '', 'anomy', '010-7777-7777', '5', '2018', '12', '1', '18:00 (Dinner)');



 review ������
insert into review values(null, 'kim1111', 'kim1 test1', 'nice', '5');
insert into review values(null, 'park2222', 'park2 test1', 'good', '4');
insert into review values(null, 'lee1111', 'lee1 test1', 'awesome', '4');
insert into review values(null, 'lee2222', 'lee2 test1', 'good', '3');
insert into review values(null, 'lee1111', 'lee1 test2', 'bad', '1');

insert into review values(null, 'min1', 'min1 test', 'food is good', '5');
insert into review values(null, 'min2', 'min2 test', 'food is good', '4');
insert into review values(null, 'min3', 'min3 test', 'food is good', '3');
insert into review values(null, 'min4', 'min4 test', 'food is good', '2');
insert into review values(null, 'min5', 'min5 test', 'food is good', '1');
insert into review values(null, 'min6', 'min6 test', 'food is good', '2');
insert into review values(null, 'min7', 'min7 test', 'food is good', '3');
insert into review values(null, 'min8', 'min8 test', 'food is good', '2');
insert into review values(null, 'min9', 'min9 test', 'food is good', '1');
insert into review values(null, 'min10', 'min10 test', 'food is good', '5');

insert into review values(null, 'min1', 'min1 test2', 'food is not good', '2');
insert into review values(null, 'min2', 'min2 test2', 'food is not good', '2');
insert into review values(null, 'min3', 'min3 test2', 'food is not good', '2');
insert into review values(null, 'min4', 'min4 test2', 'food is not good', '3');
insert into review values(null, 'min5', 'min5 test2', 'food is not good', '3');
insert into review values(null, 'min6', 'min6 test2', 'food is not good', '4');
insert into review values(null, 'min7', 'min7 test2', 'food is not good', '2');
insert into review values(null, 'min8', 'min8 test2', 'food is not good', '1');
insert into review values(null, 'min9', 'min9 test2', 'food is not good', '2');








