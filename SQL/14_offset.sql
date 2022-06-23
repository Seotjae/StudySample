select * from employees;
-- 5개만 보여주기
select * from employees where emp_no < 121;

-- 특정 갯수 씩 가져오려면? 가상 컬럼(실제하지 않는 컬럼)을 이용
-- 가상 컬럼은 이름이 없어서 where 조건에 넣기 어려움 그래서 별도의 구문을 사용
-- 1. LIMIT: 특정한 갯수만 불러오기 (처음부터~)
select * from employees limit 5;

-- 그럼 다음 5개는?
-- 2. LIMIT 시작지점, 몇개 가져올지
select * from employees limit 5,5; -- 시작점을 0번부터 계산

-- 다음 5개
select * from employees limit 10,5;

-- 3. OFFSET
select * from employees limit 5 offset 0; -- 처음부터 5개
select * from employees limit 5 offset 5; -- 5번부터 5개


