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
-- 기존 테이블 삭제 (기존 데이터베이스 구조 초기화)
DROP TABLE ORDER_DETAILS;
DROP TABLE USERS;
DROP TABLE ORDERS;
DROP TABLE PRODUCT_STOCKS;
DROP TABLE PRODUCT_DETAILS;
DROP TABLE PRODUCTS;
DROP TABLE TEAMS;
DROP TABLE SIZES;
DROP TABLE COLORS;
DROP TABLE PAYMENTS;

-- 결제 방식 테이블
CREATE TABLE PAYMENTS (
    pay_id VARCHAR(2000) PRIMARY KEY, -- 결제 방식 ID (예: 카드, 카카오페이 등)
    pay_name VARCHAR(2000) NOT NULL -- 결제 방식 이름
);

-- 팀 테이블 (예: 스포츠 팀, 브랜드 등)
CREATE TABLE TEAMS (
    tm_id VARCHAR(2000) PRIMARY KEY, -- 팀 ID (고유 식별자)
    tm_name VARCHAR2(2000) NOT NULL -- 팀 이름
);

-- 사이즈 테이블 (의류 및 액세서리의 사이즈 정보)
CREATE TABLE SIZES (
    sz_id VARCHAR(2000) PRIMARY KEY, -- 사이즈 ID (예: S, M, L 등)
    sz_name VARCHAR2(2000) NOT NULL -- 사이즈 이름
);

-- 색상 테이블 (제품의 색상 정보 저장)
CREATE TABLE COLORS (
    cl_id VARCHAR(2000) PRIMARY KEY, -- 색상 ID (고유 식별자)
    cl_name VARCHAR2(100) NOT NULL -- 색상 이름
);

-- 제품 테이블 (제품의 기본 정보 저장)
CREATE TABLE PRODUCTS (
    pr_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 제품 ID
    tm_id VARCHAR(2000) NOT NULL, -- 팀 ID (외래 키 참조)
    ca_id VARCHAR(20) NOT NULL CHECK (ca_id IN ('BallCap', 'Hat', 'Season', 'Beanie')), -- 제품 카테고리 ID (제한된 값만 허용)
    pr_name VARCHAR2(1000) NOT NULL, -- 제품 이름
    pr_regdate DATE NOT NULL, -- 제품 등록 날짜
    pr_thum_img VARCHAR(2000) NOT NULL, -- 제품 썸네일 이미지
    pr_detail_img VARCHAR(2000) NOT NULL, -- 제품 상세 이미지
    FOREIGN KEY (tm_id) REFERENCES TEAMS (tm_id) -- TEAMS 테이블의 tm_id 참조
);

-- 제품 재고 테이블 (각 제품의 재고 및 가격 정보 저장)
CREATE TABLE PRODUCT_STOCKS (
    pr_st_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 재고 ID
    pr_id NUMBER NOT NULL, -- 제품 ID (외래 키 참조)
    cl_id VARCHAR(2000) NOT NULL, -- 색상 ID (외래 키 참조)
    sz_id VARCHAR(3) NOT NULL CHECK (sz_id IN ('XS', 'S', 'M', 'L', 'XL', 'XXL')), -- 제품 사이즈 (제한된 값만 허용)
    quantity NUMBER NOT NULL, -- 재고 수량
    price NUMBER NOT NULL, -- 가격
    FOREIGN KEY (pr_id) REFERENCES PRODUCTS (pr_id), -- 제품 참조
    FOREIGN KEY (cl_id) REFERENCES COLORS (cl_id) -- 색상 참조
);

-- 주문 테이블 (사용자의 주문 정보 저장)
CREATE TABLE ORDERS (
    order_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 주문 ID
    user_id NUMBER NOT NULL, -- 사용자 ID (외래 키 참조)
    order_date DATE NOT NULL, -- 주문 날짜
    total_price NUMBER NOT NULL, -- 총 주문 금액
    pay_id VARCHAR2(10) NOT NULL CHECK (pay_id IN ('card', 'kakao', 'naverpay')), -- 결제 방식 (제한된 값만 허용)
    shipping_address VARCHAR(2000) NOT NULL, -- 배송 주소
    shipping_date DATE NOT NULL, -- 배송 예정일
    FOREIGN KEY (user_id) REFERENCES USERS (user_id) -- USERS 테이블의 user_id 참조
);

-- 사용자 테이블 (회원 정보 저장)
CREATE TABLE USERS (
    user_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 사용자 ID
    grade VARCHAR2(10) NOT NULL CHECK (grade IN ('admin', 'customer')), -- 사용자 등급 (관리자 또는 고객)
    name VARCHAR(2000) NOT NULL, -- 사용자 이름
    id VARCHAR(2000) NOT NULL, -- 로그인 ID
    pw VARCHAR(2000) NOT NULL, -- 비밀번호
    address VARCHAR(2000) NOT NULL, -- 주소
    hp VARCHAR(2000) NOT NULL, -- 휴대폰 번호
    email VARCHAR(2000) NOT NULL, -- 이메일
    regdate DATE NOT NULL -- 가입 날짜
);

-- 주문 상세 정보 테이블 (각 주문의 개별 품목 정보 저장)
CREATE TABLE ORDER_DETAILS (
    order_detail_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 주문 상세 ID
    order_id NUMBER NOT NULL, -- 주문 ID (외래 키 참조)
    user_id NUMBER NOT NULL, -- 사용자 ID (외래 키 참조)
    pr_st_id NUMBER NOT NULL, -- 제품 재고 ID (외래 키 참조)
    order_quantity NUMBER NOT NULL, -- 주문 수량
    order_price NUMBER NOT NULL, -- 주문 가격
    FOREIGN KEY (order_id) REFERENCES ORDERS (order_id), -- 주문 참조
    FOREIGN KEY (user_id) REFERENCES USERS (user_id), -- 사용자 참조
    FOREIGN KEY (pr_st_id) REFERENCES PRODUCT_STOCKS (pr_st_id) -- 제품 재고 참조
);
```
