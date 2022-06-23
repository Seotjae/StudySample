-- 서브쿼리: 쿼리 안에 쿼리를 뜻함
-- 쿼리로 추출된 내용을 가지고 재검색 하거나
-- 검색한 내용을 가상 컬럼으로 만들어 추가할 수 있음

-- 부서 테이블
create table dept(
	deptno varchar(10) primary key
	,deptname varchar(20)
	,loc varchar(10)
);

-- 직원 테이블
create table emp(
	ename varchar(20)
	,job varchar(20)
	,deptno varchar(10)
	,hiredate date
	,foreign key(deptno) references dept(deptno)
);
select * from dept;
insert into dept values(1, 'sales','NEWYORK');
insert into dept values(2, 'dev01','LA');
insert into dept values(3, 'personnel','NEWYORK');
insert into dept values(4, 'delivery','BOSTON');

select * from emp;
delete from emp where deptno ='4';
insert into emp values('kim', 'manager', 1, str_to_date('16/01/02','%y/%m/%d'));
insert into emp values('lee', 'staff', 1, str_to_date('15/01/02','%y/%m/%d'));
insert into emp values('han', 'staff', 1, str_to_date('16/03/02','%y/%m/%d'));
insert into emp values('kim', 'assistant', 2, str_to_date('15/09/22','%y/%m/%d'));
insert into emp values('ahn', 'staff', 2, str_to_date('15/11/02','%y/%m/%d'));
insert into emp values('hwang', 'manager', 2, str_to_date('15/08/12','%y/%m/%d'));
insert into emp values('cha', 'assistant', 2, str_to_date('12/03/02','%y/%m/%d'));
insert into emp values('hong', 'staff', 2, str_to_date('14/08/02','%y/%m/%d'));
insert into emp values('gang', 'staff', 2, str_to_date('16/01/02','%y/%m/%d'));
insert into emp values('nam', 'leader', 4, str_to_date('10/01/02','%y/%m/%d'));
update emp set deptno = '1' where hiredate = '2015-09-22';

select @@autocommit;

-- 문제1) han 의 근무 부서 이름은?
-- emp 테이블에서 han 의 부서 번호를 알아냄
select deptno from emp where ename = 'han';
-- 부서 번호를 가지고 해당 부서명을 알아냄
select deptname from dept where deptno = 1;
-- 해결책>
select deptname from dept where deptno = (select deptno from emp where ename = 'han');


-- 문제2) 부서 위치가 LA 또는 BOSTON 인 부서에 속한 사람들의 이름과 직책
select * from dept;
select * from emp;
-- 부서 위치가 LA 또는 BOSTON 인 부서 번호를 알아내서
select deptno from dept where loc = 'LA' or loc = 'BOSTON'; -- 2, 4
-- 부서번호로 해당 부서에 속한 이름과 직책을 알아냄
select ename, job from emp where deptno = 2 or deptno = 4;
-- 해결책>
select ename, job from emp where deptno in (select deptno from dept where loc = 'LA' or loc = 'BOSTON'); 
-- IN : 메인 쿼리와 비교 조건이 결과 중에 하나라도 일치하면 참 ('=' 비교만 가능, 크다 작다 불가능)
-- ALL: 메인 쿼리와 비교 조건이 모두 일치하면 참
-- EXIST: 메인 쿼리와 비교 조건이 결과 중에 하나라도 존재하면 참 ('=' 이외의 조건도 가능, 크다 작다 가능)


-- 문제3) sales 부서에 근무하는 사원의 모든 데이터 가져오기
select * from dept;
select * from emp;
-- sales 부서의 번호는?
select * from dept where deptname = 'sales'; -- 1
-- 번호를 통해 사원 정보를 얻음
select * from emp where deptno = 1;
-- 해결책>
select * from emp where deptno = (select deptno from dept where deptname = 'sales');


-- 문제4) 직책이 manager 인 사원들 (여러명일 경우 가장 빠른 직원 기준) 보다 입사일이 빠른 직원 데이터 가져오기
select * from emp where job = 'manager'; -- 2015-08-12
select min(hiredate) from emp where job = 'manager';
-- 2015-08-12 보다 입사일이 더 빠른 사람
select * from emp where hiredate < (select min(hiredate) from emp where job = 'manager') order by hiredate;


-- 5) 부서별로 직원이 몇명인지 데이터 가져오기
select count(*) from emp; -- count 안에는 null이 없는 컬럼을 지정해주는 것이 좋음 (기본키)

select * from dept;
select count(*) from emp where deptno = 2;
select count(*) from emp where deptno = 3;
select count(*) from emp where deptno = 4;
-- select count(*), (select loc from dept where deptno = 1), (select deptname from dept where deptno = 1) from emp where deptno = 1;

-- 상하관계 쿼리 (외부의 테이블에서 구해온 값을 내 테이블 안에 넣어서 표현하는 것) 
select deptname, loc, (select count(*) from emp where deptno = 1) as cnt from dept where deptno = 1;

-- 테이블 명은 별칭으로 줄여줄 수 있음, 이 때 as는 생략 가능, 별칭은 그 쿼리문 안에서만 적용
select deptname, loc, (select count(*) from emp where deptno = d.deptno) as cnt from dept d;



















