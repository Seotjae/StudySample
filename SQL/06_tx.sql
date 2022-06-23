-- TRANSACTION을 이용해서 실수를 만회할 수 있음
SELECT @@autocommit; -- auto commit 여부 (1: true / 0: false)
-- auto commit 이 편리하긴 하지만 0으로 변경해 놓는 것을 추천
-- auto commit 끄는 방법
set autocommit = 0;
-- 이제 명령어 입력 후 commit을 실행해야 명령어가 확정됨

-- CREATE, ALTER, DROP 등의 명령어는 AUTO COMMIT 여부에 상관없이 확정

commit;
select * from employees; -- 현 상태 확인
delete from employees;
rollback;