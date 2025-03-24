# SQL
## User Creation
### Windows
```powershell
sqlplus "/as sysdba"
```
### MacOS
```shell
sqlplus system/password@//localhost:1521
```
### Create User
```sql
--  c## 없이 접속하기 위한 설정
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;
-- 신규계정 생성
CREATE USER JDBCPROJ IDENTIFIED BY 1234;
-- 권한부여
GRANT CONNECT, RESOURCE, DBA TO JDBCPROJ;
-- 테이블 데이터 권한부여
GRANT UNLIMITED TABLESPACE TO JDBCPROJ;
-- 접속확인
conn JDBCPROJ/1234;
```
## ERD
![erd](./images/image73.png)
## Create Table
```sql
DROP TABLE ORDER_DETAILS;
DROP TABLE SHOPPINGCARTS;
DROP TABLE USERS;
DROP TABLE ORDERS;
DROP TABLE PRODUCT_STOCKS;
DROP TABLE USER_GRADES;
DROP TABLE PRODUCT_DETAILS;
DROP TABLE PRODUCTS;
DROP TABLE CATEGORIES;
DROP TABLE TEAMS;
DROP TABLE SIZES;
DROP TABLE COLORS;
DROP TABLE PAYMENTS;

-- 카테고리 테이블
CREATE TABLE CATEGORIES (
    cg_id VARCHAR(2000) PRIMARY KEY, -- 자동 증가 ID
    cg_name VARCHAR2(100) NOT NULL -- 카테고리 이름
);

-- 팀 테이블
CREATE TABLE TEAMS (
    tm_id VARCHAR(2000) PRIMARY KEY, -- 자동 증가 ID
    tm_name VARCHAR2(100) NOT NULL -- 팀 이름
);

-- 사이즈 테이블
CREATE TABLE SIZES (
    sz_id VARCHAR(2000) PRIMARY KEY, -- 자동 증가 ID
    sz_name VARCHAR2(100) NOT NULL -- 사이즈 이름
);

-- 색상 테이블
CREATE TABLE COLORS (
    cl_id VARCHAR(2000) PRIMARY KEY, -- 자동 증가 ID
    cl_name VARCHAR2(100) NOT NULL -- 색상 이름
);

-- 제품 테이블
CREATE TABLE PRODUCTS (
    pr_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    cg_id VARCHAR(2000) NOT NULL, -- 카테고리 ID (외래 키)
    tm_id VARCHAR(2000) NOT NULL, -- 팀 ID (외래 키)
    pr_name VARCHAR2(1000) NOT NULL, -- 제품 이름
    pr_regdate DATE NOT NULL, -- 제품 등록 날짜
    FOREIGN KEY (cg_id) REFERENCES CATEGORIES (cg_id),
    FOREIGN KEY (tm_id) REFERENCES TEAMS (tm_id)
);

-- 제품 재고 테이블
CREATE TABLE PRODUCT_STOCKS (
    pr_st_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    pr_id NUMBER NOT NULL, -- 제품 ID (외래 키)
    cl_id VARCHAR(2000) NOT NULL, -- 색상 ID (외래 키)
    sz_id VARCHAR(2000) NOT NULL, -- 사이즈 ID (외래 키)
    quantity NUMBER NOT NULL, -- 재고 수량
    price NUMBER NOT NULL, -- 가격
    FOREIGN KEY (pr_id) REFERENCES PRODUCTS (pr_id),
    FOREIGN KEY (cl_id) REFERENCES COLORS (cl_id),
    FOREIGN KEY (sz_id) REFERENCES SIZES (sz_id)
);

-- 제품 상세 정보 테이블
CREATE TABLE PRODUCT_DETAILS (
    pr_de_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    pr_id NUMBER NOT NULL, -- 제품 ID (외래 키)
    subject VARCHAR2(2000) NOT NULL, -- 제품 설명
    product_img VARCHAR2(2000) NOT NULL, -- 제품 이미지 URL
    product_detail_img VARCHAR2(2000) NOT NULL, -- 상세 이미지 URL
    FOREIGN KEY (pr_id) REFERENCES PRODUCTS (pr_id)
);

CREATE TABLE USER_GRADES (
    grade VARCHAR(2000) PRIMARY KEY,
    name VARCHAR(2000) NOT NULL
);
CREATE TABLE PAYMENTS (
    pay_id VARCHAR(2000) PRIMARY KEY,
    pay_name VARCHAR(2000) NOT NULL
);
CREATE TABLE ORDERS (
    order_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_date DATE NOT NULL,
    total_price NUMBER NOT NULL,
    pay_id VARCHAR(2000) NOT NULL,
    shipping_address VARCHAR(2000) NOT NULL,
    shipping_date DATE NOT NULL,
    FOREIGN KEY (pay_id) REFERENCES PAYMENTS (pay_id)
);
CREATE TABLE USERS (
    user_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    grade VARCHAR(2000) NOT NULL,
    name VARCHAR(2000) NOT NULL,
    id VARCHAR(2000) NOT NULL,
    pw VARCHAR(2000) NOT NULL,
    address VARCHAR(2000) NOT NULL,
    email VARCHAR(2000) NOT NULL,
    hp VARCHAR(2000) NOT NULL,
    regdate DATE NOT NULL,
    FOREIGN KEY (grade) REFERENCES USER_GRADES (grade)
);
CREATE TABLE SHOPPINGCARTS (
    cart_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id NUMBER NOT NULL,
    pr_st_id NUMBER NOT NULL,
    order_quantity NUMBER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES USERS (user_id),
    FOREIGN KEY (pr_st_id) REFERENCES PRODUCT_STOCKS (pr_st_id)
);
CREATE TABLE ORDER_DETAILS (
    order_detail_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_id NUMBER NOT NULL,
    user_id NUMBER NOT NULL,
    cart_id NUMBER NOT NULL,
    pr_st_id NUMBER NOT NULL,
    order_quantity NUMBER NOT NULL,
    order_price NUMBER NOT NULL,
    FOREIGN KEY (order_id) REFERENCES ORDERS (order_id),
    FOREIGN KEY (user_id) REFERENCES USERS (user_id),
    FOREIGN KEY (cart_id) REFERENCES SHOPPINGCARTS,
    FOREIGN KEY (pr_st_id) REFERENCES PRODUCT_STOCKS (pr_st_id)
);
```
