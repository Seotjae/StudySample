use gdj42_csj;
-- 1. 데이터 삽입
-- INSERT INTO [테이블명]([컬럼이름],...) VALUES([해당 컬럼의 값],...);
desc employees;
insert into employees (emp_no, first_name, family_name, email, mobile, salary, depart_no, commission) 
	values(1111, '성재', '최', 'abc123@naver.com', '01012341234', 5000000, 'dev001', 90);
	
-- 특정 컬럼의 값만 넣을 수 있음
insert into employees (emp_no, first_name, family_name, email, mobile, salary) 
	values(112, '태근', '김', 'abc456@naver.com', '01056785678', 7000000);

insert into employees (emp_no, family_name, email, mobile, salary) 
	values(113, '김', 'abc789@naver.com', '01043214321', 10000000);

-- 데이터 조회
select*from employees;

-- 데이터 수정
-- UPDATE [테이블명] SET [컬럼명] = [변경할값] WHERE [조건];
update employees set family_name = '이' where emp_no = 1111;
-- depart_no 가 null 인 녀셕은 depart_no 를 dev_002 로 바꿔라
update employees set depart_no = 'dev_002' where depart_no is null;
-- commission 이 null 인 녀셕은 commission 을 10 으로 바꿔라
update employees set commission = 10 where commission is null;

-- 데이터 삭제
-- DELETE FROM [테이블명] WHERE [조건];
-- first_name 이 null 인 사람을 지워라
delete from employees where first_name is null;

-- UPSERT: 값이 없으면 INSERT 있으면 UPDATE -> 정상 동작하려면 키 설정이 되어 있어야 함
-- INSERT INTO [테이블명]([컬럼이름],...) VALUES([해당 컬럼의 값],...) ON DUPLICATE KEY UPDATE [컬럼명] = [변경할값];







