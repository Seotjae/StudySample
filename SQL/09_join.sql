-- JOIN
-- 두 개 이상의 테이블을 연결해서 데이터를 검색하는 방식
-- 두 개 테이블을 SELECT 문장 안에서 JOIN 하려면 적어도 하나의 공통된 컬럼이 두 테이블에 존재해야 함
-- 그래서 일반적으로 PK 및 FK 값을 이용 -> 부모자식 관계가 아니여도 공통된 컬럼이 있다면 사용 가능

-- JOIN 방식
-- CROSS JOIN, EQUI JOIN**
-- NON EQUI JOIN -> 거의 사용 안함
-- SELF JOIN, OUTER JOIN**

-- 0. CROSS JOIN
-- CROSS JOIN 은 카다시안 곱을 수행 -> 과부하 때문에 서버에서 연산을 하지않음
-- emp(10) * dept(4) = 총 40개의 데이터를 보여줌

-- FROM [tableA] CROSS JOIN [tableB];
select e.ename, d.deptname from dept d cross join emp e;
-- cross join 은 생략이 가능
select e.ename, d.deptname from dept d, emp e;

-- cross join은 너무 많은 데이터를 보여줌, 의미있는 데이터를 뽑기 어려움
-- 그래서 조건을 주게 된다 -> EQUI JOIN, OUTER JOIN

-- 1. EQUI JOIN (등가 조인)
-- 가장 일반적인 조인, EQUAL(=)을 이용
-- 1) 등가 조인
select d.deptno, e.ename, d.deptname from dept d cross join emp e where d.deptno = e.deptno;

insert into dept(deptno, deptname, loc) values (5, 'dev02', 'FLORIDA');
-- 양 테이블 모두에 존재하지 않으면 보여주지 않음, 한쪽에만 있는 내용을 확인할 수 없음

-- 2) 내부 조인 (INNER JOIN)
-- WHERE 대신 USING()
-- 괄호 안에 공통된 컬럼을 지정, 이 안에는 꼭 컬럼이 아닌 서브쿼리도 사용 가능
select deptno, e.ename, d.deptname from dept d inner join emp e using (deptno);
-- WHERE 대신 ON
select d.deptno, e.ename, d.deptname from dept d inner join emp e on d.deptno = e.deptno;

-- 3) NATURAL JOIN
-- 자연스럽게 조인? 공통되는 컬럼만 존재한다면 ON 이나 WHERE 없이 조인이 가능
-- 공통된 컬럼에 대해서는 단축명을 지정하지 않아도 됨
select d.deptno, e.ename, d.deptname from dept d natural join emp e;


-- 2. 자기 조인 (SELF JOIN)
-- 기본적으로 등가 조인과 같지만 하나의 테이블로 조인하는 것이 차이
select a.ename as emp_name, b.ename as manager_name from emp a, emp b where a.ename = b.ename;


-- 3. 외부 조인 (OUTER JOIN)
-- 등가 조인은 양 테이블 모두에 값이 있어야만 출력해 줌
-- 하지만 한쪽 테이블에만 존재하는 값을 보고싶을 경우 외부 조인 사용
select * from emp;
select * from dept;

-- 부모에게 없는 값을 자식이 사용하려고 하면 에러 발생
insert into emp (ename, job, deptno, hiredate) values ('wang', 'assistant', 6 , str_to_date('14-06-02', '%Y-%m-%d'));
-- 부모자식 관계를 끊으면 해결
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'emp';
alter table emp drop constraint emp_ibfk_1;

-- 등가 조인의 경우 wang 도 안보이고, deptno 3,5 도 안보임
select e.deptno , e.ename , d.deptname from emp e, dept d where e.deptno = d.deptno;
-- 기준이 되는 테이블을 지목
-- FROM [tableA] [LEFT][RIGHT][FULL] OUTER JOIN [tableB] ON 조건;
-- LEFT OUTER JOIN: 왼쪽 테이블을 기준으로 더 있는 값을 보여줌
-- RIGHT OUTER JOIN: 오른쪽 테이블을 기준으로 더 있는 값을 보여줌
-- FULL OUTER JOIN: 어느 한쪽에 데이터가 없다 하더라도 다 보여줌, MariaDB 에서는 사용 못함

-- 1) LEFT OUTER JOIN
-- 왼쪽 emp(1,2,4,6) 기준으로 오른쪽 값이 없다 하더라도 보여줘라
select e.deptno, d.deptno, e.ename , d.deptname 
	from emp e left outer join dept d 
	on e.deptno = d.deptno;

-- 2) RIGHT OUTER JOIN
-- 오른쪽 dept(1,2,4,6) 기준으로 왼쪽 값이 없다 하더라도 보여줘라
select e.deptno, d.deptno, e.ename, d.deptname 
	from emp e right outer join dept d 
	on e.deptno = d.deptno;

-- 3) FULL OUTER JOIN
-- MariaDB 에서 지원하지 않음
-- 그래서 대신 UNION을 사용











