[pdf](./pdf/table_ERD.pdf)

[JavaProjects](./java/customhobby)
```sql
drop table customer;
drop table hobby;
CREATE TABLE CUSTOMER (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER(3),  -- 나이 추가
    height NUMBER(5,2),
    birthday DATE
);

CREATE TABLE HOBBY (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,  -- 하비 ID (기본키)
    customer_id NUMBER ,  --(FK) 별도의 고유 식별자 추가
    hobby VARCHAR2(255)
);
-- CUSTOMER 테이블에 샘플 데이터 삽입 (id 제외)
INSERT INTO CUSTOMER (name, age, height, birthday) VALUES ('김철수', 30, 175.5, TO_DATE('1994-05-12', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER (name, age, height, birthday) VALUES ('이영희', 25, 162.3, TO_DATE('1999-08-24', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER (name, age, height, birthday) VALUES ('박민수', 40, 180.0, TO_DATE('1984-12-01', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER (name, age, height, birthday) VALUES ('최지현', 35, 168.7, TO_DATE('1989-07-15', 'YYYY-MM-DD'));
INSERT INTO CUSTOMER (name, age, height, birthday) VALUES ('정하나', 28, 155.2, TO_DATE('1996-03-21', 'YYYY-MM-DD'));

-- HOBBY 테이블에 샘플 데이터 삽입 (id 제외)
INSERT INTO HOBBY (customer_id, hobby) VALUES (1, '축구');
INSERT INTO HOBBY (customer_id, hobby) VALUES (1, '독서');
INSERT INTO HOBBY (customer_id, hobby) VALUES (2, '요가');
INSERT INTO HOBBY (customer_id, hobby) VALUES (3, '등산');
INSERT INTO HOBBY (customer_id, hobby) VALUES (3, '바둑');
INSERT INTO HOBBY (customer_id, hobby) VALUES (4, '수영');
INSERT INTO HOBBY (customer_id, hobby) VALUES (5, '영화 감상');
INSERT INTO HOBBY (customer_id, hobby) VALUES (5, '베이킹');

```

```sql
select customer.*,hobby.hobby from customer,hobby where customer.id = hobby.customer_id(+);
```

```java
// DBConn 쉽게 데이터베이스를 사용할 수 있는 클래스
// DBConn.statementQuery(String sql)    select                 resultSet
// DBConn.statementUpdate(String sql)   insert,update,delete   변경된 개수
```
```java
// HobbyDao Hobby 테이블 CRUD작업 하는 클래스
```
```sql
-- 마지막 customer의 id
select max(id) as max_id from customer;
```
