-- 1. 참조 제약 조건
-- FOREING KEY (외래키) : 외부의 다른 키를 가져와서 사용하는 것
-- 이때 다른 테이블의 기본키를 가져오는데 기본키의 주인이 부모가 됨

-- 부모 테이블 생성
create table parentTable(
	userid varchar(30) primary key
	,userName varchar(20)
	,userPhone varchar(20)
	,userAddr varchar(100)
);

-- 1) 만들면서 설정
create table childTable(
	orderId int(8)
	,userId varchar(30)
	,productName varchar(20)
	,price int(8)
	,qty int(5)
	-- ,constraint fk_child foreign key (userId) references parentTable(userId)
);

-- 2) 만든 후 설정 (이 방법도 자주 쓰임)
-- ALTER TABLE [테이블명] ADD CONSTRAINT [외래키명] FOREIGN KEY(컬럼명) REFERENCES 부모테이블(가져올컬럼)
alter table childTable add constraint fk_child foreign key(userId) references parentTable(userId);

-- 부모의 기본키를 자식의 기본키로 사용하였는가? (YES: 식별 관계(1대1) / NO: 비식별 관계(1대다수))
-- 일반적으론 비식별 관계 -> 1 대 다수
-- 식별 관계는 1 대 1 관계, 설정시 신중해야 함, 설정할 일이 거의 없음
create table idenTable(
	userid varchar(30) primary key
	,foreign key(userId) references parentTable(userId)
);


-- 2. 연계 참조 무결성 제약 조건
-- 무결성: 논리적인 결함이 없음
-- 참조: 외래키 관계
-- 부모가 사라지면 연계적으로 자식도 사라져야 함, 왜? 이게 외래키 관계에서 논리적으로 맞음
create table supplier(
	supplier_id int(5) primary key
	, supplier_name varchar(50) not null
	,phone varchar(12)
);

-- ON DELETE CASCADE 가 없으면 자식이 있는 경우 부모를 지우려고 하면 지워지지 않음
-- 지워지지 않는 것이 연계 참조 무결성 제약 조건 임
-- ON DELETE CASCADE 가 있으면 부모를 지우면 자식도 같이 지워짐
create table products(
	product_id int(5) primary key
	,supplier_id int(5)
	,price int(8)
	,foreign key(supplier_id) references supplier(supplier_id) on delete cascade
);


-- 데이터 넣기 (부모)
insert into supplier (supplier_id, supplier_name, phone) values (1, '김철수', '02-123-1234');
insert into supplier (supplier_id, supplier_name, phone) values (2, '홍길동', '032-568-0078');
insert into supplier (supplier_id, supplier_name, phone) values (3, '박영수', '042-323-3234');
select * from supplier;

-- 데이터 넣기 (자식)
insert into products (product_id, supplier_id, price) values (1111, 1, 6000);
insert into products (product_id, supplier_id, price) values (1112, 2, 8000);
insert into products (product_id, supplier_id, price) values (1113, 3, 7000);
insert into products (product_id, supplier_id, price) values (1114, 1, 10000);
select * from products;

-- 김철수를 지우세요! 무언가 하나를 지정해서 할 때는 기본키를 사용
-- 원래 이 경우 부모가 지워질 경우 자식이 남기 때문에 지워지지 않음
delete from supplier where supplier_id = 1;
-- ON DELETE CASCADE 가 없으면 부모에 해당하는 자식을 먼저 지우고 부모를 지워주면 됨

-- 부모테이블을 지우면?
-- 현재까지는 mariaDB 에서 부모테이블을 먼저 삭제할 수 없음 (oracle에선 가능)
drop table supplier; -- Cannot delete or update a parent row: a foreign key constraint fails


-- 3. 유니크 (UNIQUE) 제약 조건 -> 중복을 허용하지 않음
-- PK = UNIQUE + NOT NULL
-- UNIQUE 는 한 테이블에 여러 개 가능
-- 후보키
-- ALTER TABLE [테이블명] ADD CONSTRAINT [키이름] UNIQUE ([적용할컬럼]);
alter table childtable add constraint child_uq unique(productName);
desc childtable;


-- 4. 체크 제약 조건 (거의 안씀) -> 조건에 맞지 않으면 입력할 수 없음
-- 제약 조건 추가시 조건을 걸어둠
-- ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건이름] CHECK ([적용할컬럼][조건]);
-- products 입력 시 price 를 5000원 과 10000원 사이만 받겠다
alter table products add constraint pr_chk check(price between 5000 and 10000);
select * from products;
insert into products values (1114, 2, 9000); -- 컬럼명이 생략되려면 모든 컬럼에 값이 입력되어야 함 
insert into products values (1115, 2, 19000); -- 10000원 보다 높기 때문에 체크제약 조건에 의해서 입력되지 않음


