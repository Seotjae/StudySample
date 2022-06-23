 -- AUTO_INCREMENT
 -- 자동 증가하는 속성
 -- 데이터가 들어갈 때마다 무조건 1씩 증가하므로 중복이 생길 수 없음
 -- 기본키를 마땅히 지정하기 힘들면 auto_increment 를 활용
 
 -- 1. 테이블 생성 시 함께 생성 (가장 일반적인 방법)
 create table auto_inc(
 	no int(10) auto_increment primary key
 	,name varchar(10) not null
 );
-- auto_increment 로 만든 컬럼은 데이터 입력 시 자동으로 입력 됨
insert into auto_inc (name) values ('kim');
insert into auto_inc (name) values ('lee');
insert into auto_inc (name) values ('park');
select * from auto_inc;

 -- 2. 테이블 생성 후 추가
create table test(
	no int(10)
	,name varchar(10) not null
);
-- auto_increment 가 설정되지 않았으면 데이터를 수동으로 넣어야함
insert into test(no,name) values(1,'a');

select * from test;

-- auto_increment 는 속성으로 간주됨 (키 설정이 선행되어야 함)
alter table test modify no int(10) primary key auto_increment;
insert into test(name) values('b');
insert into test(name) values('c');
insert into test(name) values('d');

-- 자동속성 값을 초기화
alter table test auto_increment = 100;
insert into test(name) values('bb');
insert into test(name) values('cc');
insert into test(name) values('dd');
