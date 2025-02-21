[pdf](./pdf/table_ERD.pdf)

[JavaProjects](./java/customhobby)
```sql
CREATE TABLE CUSTOMER (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER(3),  -- 나이 추가
    height NUMBER(5,2),
    birthday DATE
);

CREATE TABLE HOBBY (
    id NUMBER PRIMARY KEY,  -- 하비 ID (기본키)
    custom_id NUMBER ,  --(FK) 별도의 고유 식별자 추가
    hobby VARCHAR2(255)
);
```

3개의 테이블
```sql
-- 고객 테이블

CREATE TABLE CUSTOMER (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER(3),
    height NUMBER(5,2),
    birthday DATE
);

-- 취미 테이블

CREATE TABLE HOBBY (
    id NUMBER PRIMARY KEY,
    hobby VARCHAR2(255) UNIQUE
);

-- 고객과 취미의 관계를 저장하는 테이블 (N:M 관계)

CREATE TABLE CUSTOMER_HOBBY (
    customer_id NUMBER,
    hobby_id NUMBER,
    PRIMARY KEY (customer_id, hobby_id),
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id) ON DELETE CASCADE,
    CONSTRAINT fk_hobby FOREIGN KEY (hobby_id) REFERENCES HOBBY(id) ON DELETE CASCADE
);
```
소스 db
```sql
-- 취미 테이블 (HobbyDto)
drop table hobby;
CREATE TABLE Hobby (
id number,
hobby VARCHAR(255)
);
-- 고객 테이블 (CustomerDto)
drop table customer;
CREATE TABLE Customer (
id number,
name VARCHAR(255),
height number,
birthday DATE
);
```
```sql
-- Hobby 테이블 데이터 삽입
INSERT INTO Hobby (id, hobby) VALUES (1, 'Reading');
INSERT INTO Hobby (id, hobby) VALUES (2, 'Swimming');
INSERT INTO Hobby (id, hobby) VALUES (3, 'Cycling');
INSERT INTO Hobby (id, hobby) VALUES (4, 'Gaming');
INSERT INTO Hobby (id, hobby) VALUES (5, 'Traveling');

-- Customer 테이블 데이터 삽입
INSERT INTO Customer (id, name, height, birthday) VALUES (1, 'Alice', 165.5, TO_DATE('1995-06-15', 'YYYY-MM-DD'));
INSERT INTO Customer (id, name, height, birthday) VALUES (2, 'Bob', 178.2, TO_DATE('1988-09-23', 'YYYY-MM-DD'));
INSERT INTO Customer (id, name, height, birthday) VALUES (3, 'Charlie', 172.0, TO_DATE('1992-11-11', 'YYYY-MM-DD'));
INSERT INTO Customer (id, name, height, birthday) VALUES (4, 'David', 180.7, TO_DATE('2000-03-05', 'YYYY-MM-DD'));
INSERT INTO Customer (id, name, height, birthday) VALUES (5, 'Emma', 158.3, TO_DATE('1998-07-20', 'YYYY-MM-DD'));
commit;
```
```
select customer.*,hobby.hobby from customer,hobby where customer.id = hobby.id(+);
```
