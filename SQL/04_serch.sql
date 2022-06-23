-- 데이터 조회
-- 1) 특정 컬럼 조회
-- SELECT [조회할컬럼] FROM [테이블명];
select * from employees; -- * 은 all을 의미
select family_name, first_name, salary from employees; -- 컬럼의 순서는 바꿔도 상관없음


-- 2) 산술표현
-- 숫자로 된 컬럼은 계산이 가능
select first_name, family_name, salary/10000 from employees; -- 컬럼 이름도 바뀜
-- 연봉 -> as를 통해 컬럼에 별칭을 줄 수 있음
select first_name , family_name, salary*12 as 연봉 from employees; -- 테이블을 먼저 지정해야 자동완성에 컬럼 표시됨


-- 3) 문자열 합치기
select concat(family_name, first_name) as name, salary*12 from employees;
-- 컬럼 이름을 연봉으로 바꾸고 만원 단위로 만들자
select concat(family_name, first_name) as name, concat(salary*12/10000, '만원') as 연봉 from employees;


-- 4) 특정 조건의 데이터 조회하기
-- SELECT [COLUMN] FROM [TABLE] WHERE [CONDITION];
-- family_name 이 김 인 사람의 모든 컬럼을 가져와라
select * from employees where family_name = '김';
-- salary 가 3000000 보다 큰 사람의 모든 정보 가져오기
select  * from employees where  salary > 3000000;

-- 4-1) AND 조건 
-- salary 가 100만원 이상 300만원 미만
select * from employees where salary >= 1000000 and salary < 3000000;

-- 4-2) OR 조건 
-- family_name 이 김 이거나 salary 가 200만원 이상인 사람의 성과, 이름, 급여
select family_name, first_name, salary from employees where family_name = '김' or salary >= 2000000;

-- 쿼리문 내에 부등호 (>, <, =)를 특수 문자로 인식해서 오류가 나는 경우가 있음
-- 이 경우 숫자를 사용하는 (계산 가능한) AND 조건에는 BETWEEN AND를 사용 할 수 있음
-- 4-3) BETWEEN AND
-- salary가 50만원 보다 크거나 같고, 400만원 보다 작거나 같은 사람의 성과 이름 구하기 -> and 조건으로 이용
select family_name, first_name from employees where salary >= 500000 and salary <= 4000000;
-- between and 사용
select family_name, first_name from employees where salary between 500000 and 4000000;


-- 5) 중복 제거
select * from employees where salary = 2000000;
-- SELECT DISTINCT [출력할컬럼] FROM [대상테이블];
-- 아래는 salary 가 2000000 인 사람들 중 성이 중복괴는 사람들을 제거하고 보여줌 (제일 위만 남겨둠)
select distinct family_name from employees where salary = 2000000;
-- DISTINCT 뒤에 여러개의 컬럼이 붙으면 생각한 만큼의 효과가 나오지 않음
-- 그래서 일반적으로 DISTINCT 뒤에는 하나의 컬럼만 붙임
select distinct family_name, first_name from employees;


-- 6)IN
-- 성이 김 또는 이 또는 박 인 사람들의 정보
-- 조건마다 사용하는 컬럼이 다를 경우 유리
select * from employees where family_name = '김' or family_name = '이' or family_name = '박';
-- family_name이 이 괄호 안에 (IN) 뭐라도 하나가 있다면 가져와라, 쿼리문 길이가 짧아지고 속도도 우월
select * from employees where family_name in ('김', '이', '박');


-- 7) IS NULL / IS NOT NULL
-- commission 이 null 인 것을 불러와라
select * from employees where commission is null;
-- commission 이 null 이 아닌 것을 불러와라
select * from employees where commission is not null;


-- 8) LIKE
-- 일부 내용이 비슷한 것을 찾아줌
-- WHERE [컬럼명] LIKE '%[검색어]%';
-- ze 로 시작하는 이메일을 가지고 있는 사람 찾기
select * from employees where email like 'ze%';
-- com 으로 끝나는 이메일을 가지고 있는 사람 찾기
select * from employees where email like '%com';
-- se 를 포함하는 이메일을 가지고 있는 사람 찾기
select * from employees where email like '%se%';
-- s와 e를 포함하는 이메일을 가지고 있는 사람 찾기
select * from employees where email like '%s%e%';


-- 9) ORDER BY
-- 특정 컬럼을 기준으로 정렬
-- ASC ▲(오름차순) | DESC ▼(내림차순) 
-- SELECT * FROM [테이블명] ORDER BY [컬럼이름] [ASC | DESC];
-- salary 가 높은 사람 순으로 정렬
select * from employees order by salary desc;
-- 성을 가나다 순으로 정렬
select * from employees order by family_name asc;
select * from employees order by family_name; -- asc 는 생략이 가능함
-- 연봉을 기준으로 정렬 (성, 이름, 연봉)
select family_name , first_name, salary*12 as annsal from employees order by annsal desc;
-- 다중 정렬 (있다는 것만 알아두기)
select * from employees order by first_name, salary desc;
-- ORDER BY 는 WHERE 조건 앞에 올까? 뒤에 올까?
-- 조건을 걸어서 데이터 수를 줄인 다음 정렬하는 것이 효과적이므로 뒤에 붙음
-- 문법적으로도 뒤에 붙어야함
select * from employees where salary > 2000000 order by family_name;


-- 10) GROUP BY
-- 데이터를 그룹화 해서 가져오는 것
-- 통계에서 자주 사용
-- SELECT [컬럼명] FROM [테이블명] GROUP BY [그룹화할컬럼];
-- 부서별 급여 합산
select depart_no, sum (salary) as total from employees group by depart_no order by total desc;

-- 부서별 인센티브 평균
-- salary 는 부서별로 압축되지 않는 값이므로 들어가면 안됨
-- 다른 DB 에서는 에러가 날 수 있음
select depart_no, salary, avg(commission) from employees group by depart_no;
-- 해결 방법: salary 를 빼던지 압축할 수 있는 다른 연산들을 해줌 (sum, avg 등)
select depart_no, avg(salary), avg(commission) from employees group by depart_no;

-- 11) HAVING
-- GROUP BY 한 값에 조건을 줄 때
-- 부서별 급여 합산 -> 합산액이 1000만원 이상인 팀은?
select depart_no, sum (salary) as total from employees group by depart_no;

-- HAVING 절에 별칭을 쓸 수 있으나 몇몇 디비에서는 사용할 수 없음 -> 가급적 HAVING 에 별칭 쓰지 말기 (중요)
select depart_no, sum (salary) as total from employees group by depart_no having sum(salary) > 10000000;

-- 부서별 급여 합산이 1000만원 이상인 부서를 금액이 높은 순으로
select depart_no, sum(salary) from employees group by depart_no having sum(salary) > 10000000 order by  sum(salary) desc;






































