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
DROP TABLE CATEGORIES;
DROP TABLE TEAMS;
DROP TABLE SIZES;
DROP TABLE COLORS;
DROP TABLE PRODUCTS;
DROP TABLE PRODUCT_STOCK;
DROP TABLE PRODUCTS_DETAILS;
-- 카테고리 테이블: 제품의 카테고리를 저장
CREATE TABLE CATEGORIES (
    ca_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 카테고리 ID (자동 증가)
    ca_name VARCHAR(100) NOT NULL -- 카테고리 이름 (최대 100자)
);

-- 팀 테이블: 제품이 속한 팀을 저장
CREATE TABLE TEAMS (
    te_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 팀 ID (자동 증가)
    te_name VARCHAR(100) NOT NULL -- 팀 이름 (최대 100자)
);

-- 사이즈 테이블: 제품의 사이즈 정보를 저장
CREATE TABLE SIZES (
    si_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 사이즈 ID (자동 증가)
    si_name VARCHAR(100) NOT NULL -- 사이즈 이름 (최대 100자)
);

-- 색상 테이블: 제품의 색상 정보를 저장
CREATE TABLE COLORS (
    co_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 색상 ID (자동 증가)
    co_name VARCHAR(100) NOT NULL -- 색상 이름 (최대 100자)
);

-- 제품 테이블: 제품 정보를 저장
CREATE TABLE PRODUCTS (
    pr_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 제품 ID (자동 증가)
    ca_id NUMBER NOT NULL, -- 카테고리 ID (외래 키)
    te_id NUMBER NOT NULL, -- 팀 ID (외래 키)
    pr_name VARCHAR(1000), -- 제품 이름 (최대 1000자)
    pr_regdate DATE, -- 제품 등록 날짜
    FOREIGN KEY (ca_id) REFERENCES CATEGORIES (ca_id), -- 카테고리 참조
    FOREIGN KEY (te_id) REFERENCES TEAMS (te_id) -- 팀 참조
);

-- 제품 재고 테이블: 제품의 색상 및 사이즈별 재고 정보를 저장
CREATE TABLE PRODUCT_STOCKS (
    pr_st_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 재고 ID (자동 증가)
    pr_id NUMBER NOT NULL, -- 제품 ID (외래 키)
    co_id NUMBER NOT NULL, -- 색상 ID (외래 키)
    si_id NUMBER NOT NULL, -- 사이즈 ID (외래 키)
    quantity NUMBER NOT NULL, -- 재고 수량
    price NUMBER NOT NULL, -- 가격
    FOREIGN KEY (pr_id) REFERENCES PRODUCTS (pr_id), -- 제품 참조
    FOREIGN KEY (co_id) REFERENCES COLORS (co_id), -- 색상 참조
    FOREIGN KEY (si_id) REFERENCES SIZES (si_id) -- 사이즈 참조
);

-- 제품 상세 정보 테이블: 제품의 상세 이미지 및 설명을 저장
CREATE TABLE PRODUCT_DETAILS (
    pr_de_id NUMBER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 상세 정보 ID (자동 증가)
    pr_id NUMBER NOT NULL, -- 제품 ID (외래 키)
    subject VARCHAR(2000) NOT NULL, -- 제품 설명 (최대 2000자)
    product_img VARCHAR(2000) NOT NULL, -- 제품 이미지 URL (최대 2000자)
    product_detail_img VARCHAR(2000) NOT NULL, -- 상세 이미지 URL (최대 2000자)
    FOREIGN KEY (pr_id) REFERENCES PRODUCTS (pr_id) -- 제품 참조
);
```