show databases; -- database : 데이터의 집합소

/*1. 유저 생성*/
-- CREATE USER [유저이름]@[접근가능한 host] IDENTIFIED BY [비밀번호];

-- web_user 는 외부에서는 접속 불가하며... 비밀번호는 pass 다.
CREATE USER 'web_user'@'localhost' IDENTIFIED BY 'pass';

-- web_user 는 어디서든 접속 가능 하며... 비밀번호는 pass 다.
CREATE USER 'web_user'@'%' IDENTIFIED BY 'pass';
CREATE USER 'csj'@'%' IDENTIFIED BY 'pass';

-- web_user 는 192.168. 으로 시작하는 IP 대역에서는 접속 가능 하며... 비밀번호는 pass 다.
CREATE USER 'web_user'@'192.168.%' IDENTIFIED BY 'pass';

-- dba_user 는 192.168.3. 으로 시작하는 IP 에서 접속 가능 하며 비밀번호는 1234 이다.
CREATE USER 'dba_user'@'192.168.3.%' IDENTIFIED BY '1234';

-- user002 는 192.168.0.111 에서 접속 가능하며 비밀번호는 1234 이다.
CREATE USER 'user002'@'192.168.0.111' IDENTIFIED BY '1234';

-- 생성된 user 확인
SELECT * FROM mysql.user;


/*2. 권한 부여 및 회수*/
-- 권한 부여
-- GRANT [권한] ON [데이터베이스.테이블] TO [사용자]
/* 줄 수 있는 권한(자주 사용하는 것 위주)
 * ALL PRIVILEGES : GRANT OPTION 을 제외한 모든 권한
 * SELECT : 읽기권한 - 특정명령어에 대한 권한도 줄 수 있다.(UPDATE, INSERT, DELETE, CREATE, DROP 등...)
 * GRANT OPTION : 권한 부여(내가 갖은 권한 이상은 줄 수 없다.)
 * */

-- web_user 는 모든 IP 로 접속 가능하고, grant 를 제외한 모든 권한을 가지고 있으며, 모든 데이터베이스, 모든 테이블을 접근 할 수 있다.
GRANT ALL PRIVILEGES ON *.* TO 'web_user'@'%';
GRANT ALL PRIVILEGES ON *.* TO 'csj'@'%';

-- dba_user 는 SELECT 권한을 주고, mysql 데이터 베이스의 모든 테이블 접근을 허용한다.
GRANT SELECT ON mysql.* TO 'dba_user'; -- 접근할수 없는 데이터베이스에 권한을 줘서 에러가 난다.

-- user002 는 SELECT,UPDATE, INSERT,DELETE 권한을 주고, 모든 데이터베이스와 테이블에 접근이 가능 하다.
GRANT SELECT, UPDATE, INSERT, DELETE ON *.* TO 'user002'@'192.168.0.111';

-- 권한 확정(GRANT 로 권한을 준 경우는 사용하지 않아도 된다.)
FLUSH PRIVILEGES;

-- 유저 확인으로 권한 여부를 알 수 있다.
SELECT * FROM mysql.user;

-- 권한 회수
-- REVOKE [권한] ON [데이터베이스,테이블] FROM [사용자]
REVOKE INSERT, DELETE ON *.* FROM 'user002'@'192.168.0.111';


-- 유저의 비밀번호 변경
-- SET PASSWORD FOR [사용자] = PASSWORD([패스워드]);
SET PASSWORD FOR 'user002'@'192.168.0.111' = PASSWORD('pass');
SET PASSWORD FOR 'csj'@'%' = PASSWORD('6232');
-- 유저 삭제
-- drop user [유저이름]
drop user 'user002'@'192.168.0.111';
drop user 'dba_user'@'192.168.3.%';
drop user 'csj'@'%';