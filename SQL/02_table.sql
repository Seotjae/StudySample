-- database는 테이블이 저장되는 공간
-- database 목록 보기
show databases;

-- create database [데이터베이스 이름]
create database gdj42_csj;
-- drop database [데이터베이스 이름]

-- 데이터베이스 사용
-- use [데이터베이스 이름]
use gdj42_csj;
-- 이 이후로 생성되는 table은 gdj42_csj에 저장
drop database gdj42_csj;
-- 데이터베이스 안에 테이블 만들기
-- 1. 테이블 생성
/* create table [테이블 명](
 * 	[컬럼명] [데이터타입] (사이즈)
 * 	,[컬럼명] [데이터타입] (사이즈)
 * 	...
 * );
 */
/*데이터 타입
1) 문자 타입 -> 검색 속도가 가장 빠름
고정형 CHAR (바이트 수)
가변형 VARCHAR (바이트 수) -> 가장 많이 사용
TEXT: 65,535 byte
LONGTEXT: 4,294,967,295 byte
2) 숫자 타입
INT, FLOAT, BIGINT, DOUBLE
3) 날짜 타입
DATE: 0000-00-00
DATETIME: 0000-00-00 00:00:00
TIMESTAMP: DATETIME과 같지만 time zone에 따라 시간이 변경
*/
-- 실습
use gdj42_csj;
create table testtable(
	username varchar(50)
	,age int(3)
	,mobile varchar(15)
	,reg_date date default current_date
);
-- 테이블 구조 확인
-- DESC [테이블 명]
desc testtable;
create table employees(
	emp_no int(3)
	,first_name varchar(30)
	,last_name varchar(10)
	,email varchar(60)
	,mobile varchar(15)
	,salary int(8)
	,reg_date date default current_date
);
desc employees;
-- 테이블 리스트 확인
show tables;

-- 2. 테이블 삭제
drop table testtable;

-- 3. 테이블 수정: ALTER
-- 1) 컬럼 이름 변경 -> ALTER TABLE [테이블 이름] RENAME COLUMN [변경 전 이름] TO [변경 후 이름]
ALTER TABLE employees RENAME COLUMN last_name TO family_name;

-- 2) 컬럼 추가 -> ALTER TABLE [테이블 이름] ADD ([컬럼명] [데이터 타입])
-- 컬럼명: depart_no, 데이터 타입: varchar, 사이즈: 10
ALTER TABLE employees ADD (depart_no varchar(10));
-- 컬럼명: commission, 데이터 타입: varchar, 사이즈: 10
ALTER TABLE employees ADD (commission varchar(10));
-- 컬럼명: etc, 데이터 타입: varchar, 사이즈: 100
ALTER TABLE employees ADD (etc varchar(100));

-- 3) 컬럼 속성 변경 -> ALTER TABLE [테이블 이름] MODIFY COLUMN [컬럼명] [데이터타입]
-- float(전체자리수, 그중소수점자리수 -> 000.00
ALTER TABLE employees MODIFY COLUMN commission float(5,2);

ALTER TABLE board MODIFY COLUMN board_cont varchar(10000);

-- 4) 컬럼 삭제 -> ALTER TABLE [테이블 이름] DROP COLUMN [컬럼명]
ALTER TABLE employees DROP COLUMN etc;







