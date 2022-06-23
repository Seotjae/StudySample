-- INDEX
-- 검색 속도를 향상
-- 잦은 삽입/삭제/수정 이 일어날 경우 불리함
-- 기본키와 유니크키가 걸려있는 경우는 이미 인덱스가 생성되어 있는 상태

-- 1. 고유 인덱스 (UNIQUE)
-- 중복되지 않은 데이터를 인덱스로 지정
-- 기본키와 유니크키가 설정되었을 때 생성되는 인덱스
-- CREATE UNIQUE INDEX [인덱스명] ON [테이블명]([컬럼])
create unique index emp_ename_idx on emp(ename); 
-- ename은 중복이 있는 데이터이기 때문에 유니크 인덱스 생성이 불가

-- 2. 비고유 인덱스 (NON-UNIQUE)
-- 일반 인덱스 (중복 허용)
-- CREATE INDEX [인덱스명] ON [테이블명]([컬럼])
create index emp_ename_idx on emp(ename); 

-- 3. 결합 인덱스 (COMBINATION)
-- 여러 컬럼을 조합하여 인덱스 생성 (16개 까지 가능)
-- 조합 데이터가 절대 중복이 날것 같지 않다면 UNIQUE INDEX 로 생성 가능
create index emp_combi_idx on emp(ename, job, deptno); 


-- 4. 인덱스 데이터 사전 (인덱스 목록 보기)
show index from DEPT;
show index from EMP;


-- 5. 인덱스 삭제
-- ALTER TABLE [테이블명] DROP INDEX [인덱스명];
ALTER TABLE emp DROP INDEX emp_ename_idx;
ALTER TABLE emp DROP INDEX emp_combi_idx;




