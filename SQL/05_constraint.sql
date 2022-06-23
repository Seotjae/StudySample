use gdj42_csj;

-- 제약조건: 데이터를 넣을 때 특정한 조건을 만족해야 입력을 받는 것

-- 1. 기본키 제약 좋건 (Primary key -> PK)
-- 중복을 허용하지 않음 + null 도 허용하지 않음
-- 테이블 당 1개만 가능 (테이블 종속적)
-- 일반적으로 기본키는 열쇠 그림으로 나타냄

-- 키본키 생성 방법1 (테이블 생성 하면서 넣기) *** 굉장히 자주 사용
create table pktest(
 firstcol int(3) primary key
 ,secondcol varchar(4)
);

insert into pktest (firstcol, secondcol) values (111, 'test');
select * from pktest;

insert into pktest (firstcol, secondcol) values (111, 'test'); -- 중복 허용하지 않음
insert into pktest ( secondcol) values ('test'); -- null 도 허용하지 않음

-- 키본키 생성 방법2 (테이블에 나중에 추가하기)
-- 키 추가 전에 데이터에 중복과 null이 있는지 확인 필요
select * from employees;
-- ALTER TABLE [테이블명] ADD PRIMARY KEY ([지정할컬럼]);
 alter table employees add primary key (emp_no);

-- 제약 조건 확인
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'employees';

-- UPSERT: 값이 없으면 INSERT 있으면 UPDATE -> 정상 동작하려면 키 설정이 되어 있어야 함
-- INSERT INTO [테이블명]([컬럼이름],...) VALUES([해당 컬럼의 값],...) ON DUPLICATE KEY UPDATE [컬럼명] = [변경할값];
insert into employees (emp_no, first_name, family_name, email, mobile, salary)
	values(112, '태근', '김', 'email@naver.com', '01012341234', '5000000')
	on duplicate key update first_name='태곤', family_name='박';

-- 키는 몇개 컬럼으로 구성되나?
-- 기본키는 한개의 컬럼으로 구성이 어려울 경우 여러개의 컬럼을 조합해서 씀 (최대 16개)
-- 이를 복합키라고 함
create table pkTwoTest (
	first_col int(5)
	,second_col varchar(10)
	,third_col date
	,primary key (first_col, second_col)
);

-- alter table pkTwoTest add primary key (first_col, second_col);
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'pkTwoTest';



-- 2. NOT NULL 제약 조건 (NULL을 허용하지 않음)
-- 테이블 속성으로 취급 받음 
create table pkTwoTest (
	first_col int(5)
	,second_col varchar(10)
	,third_col date not null
	,primary key (first_col, second_col)
);

-- ALTER TABLE [테이블명] MODIFY [컬럼명] [데이터타입] NOT NULL;
alter table pktwotest modify third_col date not null;
-- NOT NULL 은 속성으로 인식되기 때문에 제약조건에서는 찾을 수 없음 -> DESC 를 통해서 속성 확인 가능
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'pkTwoTest';
desc pktwotest ;


-- 키 삭제
-- ALTER TABLE [테이블명] DROP PRIMARY KEY ;
ALTER TABLE pktwotest DROP PRIMARY key;








