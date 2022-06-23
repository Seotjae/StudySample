-- 다수의 테이블에 대해 집합 연산을 할 수 있음
-- 차집합, 교집합, 합집합 등이 있음
-- [쿼리1] [UNION/UNION ALL/INTERSECT/NOT IN] [쿼리2]

-- 1. UNION (중복을 제거한 합집합)
-- 두개의 테이블에 있는 데이터를 중복 제거하여 가져옴 (성능이 좋지 않음)
-- 동일한 컬럼이 하나 있어야 한다
select deptno from emp 
union 
select deptno from dept;

-- UNION 을 이용해서 FULL OUTER JOIN 효과를 낼 수 있다?
-- LEFT JOIN + RIGHT JOIN = FULL JOIN
select e.deptno, e.ename, d.deptname from emp e left outer join dept d on e.deptno = d.deptno
union
select d.deptno, e.ename, d.deptname from emp e right outer join dept d on e.deptno = d.deptno;


-- 2. UNION ALL (중복을 제거하지 않은 합집합)
select deptno from emp e 
union all
select deptno from dept d;


-- 3. INTERSECT (교집합)
-- A 와 B 에 있는 공통된 데이터를 가져옴, 중복되는 데이터만 가져옴
select deptno from emp e 
intersect
select deptno from dept d;


-- 4. 차집합 (MINUS / NOT IN)
select distinct deptno from emp e; -- 1,2,4,6
select deptno from dept d; -- 1,2,3,4,5
-- emp 에서 dept 빼기 : 6
select deptno from emp where deptno not in (select deptno from dept);
-- dept에서 emp 빼기 : 3,5
select deptno from dept where deptno not in (select deptno from emp);


-- union 효과 내기
-- union all 로 데이터를 가져와서 어떤식으로 중복을 제거할 것인가?
select deptno from emp 
union 
select deptno from dept;

select deptno from emp
union all
select deptno from dept;

select deptno from emp;
select deptno from dept;
select deptno from emp where deptno not in (select deptno from dept);
select deptno from dept where deptno not in (select deptno from emp);



-- 
select deptno from emp where deptno not in (select deptno from dept)
union all
select deptno from dept;

select distinct deptno from emp;

select distinct deptno from emp
union all
select deptno from dept where deptno not in (select deptno from emp);

select distinct s.deptno from (select deptno from emp union all select deptno from dept) s;














