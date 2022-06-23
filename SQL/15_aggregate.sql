-- 집계함수: 여러행 또는 테이블 전체 행으로부터 하나의 결과 값을 반환하는 함수

-- 우리는 이미 group by 할 때 사용해 봄
-- 일반적으로 많이 사용하는 함수
-- AVG(), COUNT(), MAX(), MIN(), SUM() 등

-- 1. COUNT() : 검색된 행의 수를 반환
select count(deptno) from dept; -- 해당 컬럼에 있는 데이터의 수

-- 2. MAX() : 해당 컬럼의 최대값을 반환
-- 숫자뿐 아니라 정렬 가능한 대상은 최대 값을 뽑아낼 수 있음
select * from employees;
select max(email) from employees;

-- 3. MIN() : 해당 컬럼의 최소값을 반환
-- 숫자뿐 아니라 정렬 가능한 대상은 최소 값을 뽑아낼 수 있음
select min(email) from employees;

-- 급여(salary)가 가장 적은 사람과 가장 많은 사람은 누구인가
-- union 사용
select family_name, first_name, salary from employees where salary = (select max(salary) from employees)
union all
select family_name, first_name, salary from employees where salary = (select min(salary) from employees);
-- or 조건 사용
select family_name, first_name, salary from employees 
	where salary = (select max(salary) from employees) or salary = (select min(salary) from employees);
-- in 조건 사용
select family_name, first_name, salary from employees 
	where salary in ((select max(salary) from employees),(select min(salary) from employees));
ㄴ

-- 4. AVG() : 해당 컬럼의 평균 값을 반환
select avg(salary) from employees;
-- dev002 부서의 사원 평균 급여
select * from employees;
select depart_no, avg(salary) from employees where depart_no = 'dev002'; -- 소수점이 거슬린다면 집계함수 아닌 숫자함수에서 찾아쓰면 됨


-- 5. SUM() : 해당 컬럼의 합계를 반환
select sum(salary) from employees;
select depart_no, SUM(salary) from employees where depart_no = 'dev002';




