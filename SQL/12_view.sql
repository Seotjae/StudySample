-- VIEW
-- 뷰는 여러 테이블의 데이터를 모아서 만든 가상 테이블
-- 복잡한 조인이나 서브쿼리를 사용해서 뷰를 만들어두면 나중에 일반 테이블처럼 조회하여 사용할 수 있음
-- 뷰는 자신만의 인덱스를 가질 수 없음, 가상 테이블이기 때문

-- 1. VIEW 생성 문법
-- CREATE [OR REPLACE] VIEW [VIEW명] AS [VIEW를 생성할 쿼리];
-- OR REPLACE: 기본 뷰를 수정할 때 사용
create view name_query as 
	select e.ename, d.deptname from emp e, dept d where e.deptno = d.deptno;


-- 기존 사원별 배정팀을 알고싶을 경우 쿼리
select e.ename, d.deptname from emp e, dept d where e.deptno = d.deptno;
-- 이걸 뷰로 만들어 두면..
-- 2. 뷰 사용법 (일반 테이블처럼 조회)
select * from name_query;


-- 3. 뷰에서의 데이터 수정
-- 원래 뷰에서는 데이터 수정을 허용하지 않았음, 이제는 허용하는 추세
update name_query set ename = 'oh' where ename = 'kim';
-- 뷰에서 데이터를 변경하면 원본 데이터도 수정됨
select * from emp;


-- 4. 뷰 수정
-- alter로 수정할 수 있지만
-- create on replace를 사용하면 뷰가 없을 경우 create 해 줌
create or replace view name_query as
	select e.ename, d.deptname, d.loc from emp e, dept d where e.deptno = d.deptno;

select * from name_query;


-- 5. WITH CHECK OPTION: 뷰를 생성하는 조건식에 해당하는 값은 UPDATE 할 수 없도록 막는 옵션
create view check_option as 
	select ename,job,deptno from emp where deptno = 1 with check option;

select * from check_option;

-- 다른 컬럼은 변경이 가능함
update check_option set job = 'manager' where ename = 'lee';
-- 뷰를 구성하는 조거이 되는 deptno 는 수정을 할 수 없음 (WITH CHECK OPTION 을 걸어놔서)
update check_option set deptno = 2 where ename = 'lee';

-- 뷰는 보안성이 좋다
-- 1) 이 데이터가 어느 테이블에서 왔는지 알기 힘듬
-- 2) 보여주고 싶은것만 보여줄 수 있음
-- 보안은 취하는 이득이 들이는 노력보다 적게 만드는 것

-- 6. 뷰의 정보 확인
show full tables where table_type = 'view'; -- 생성된 뷰 확인
show create view name_query; -- 해당 뷰의 생성 쿼리를 알 수 있음

-- 7. 뷰 삭제
drop view check_option;
drop view name_query;




















