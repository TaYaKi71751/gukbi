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
DROP TABLE PRODUCT_STOCKS;
DROP TABLE PRODUCT_DETAILS;
DROP TABLE PRODUCTS;
DROP TABLE CATEGORIES;
DROP TABLE TEAMS;
DROP TABLE SIZES;
DROP TABLE COLORS;

-- 카테고리 테이블
CREATE TABLE CATEGORIES (
    ca_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    ca_name VARCHAR2(100) NOT NULL -- 카테고리 이름
);

-- 팀 테이블
CREATE TABLE TEAMS (
    te_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    te_name VARCHAR2(100) NOT NULL -- 팀 이름
);

-- 사이즈 테이블
CREATE TABLE SIZES (
    si_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    si_name VARCHAR2(100) NOT NULL -- 사이즈 이름
);

-- 색상 테이블
CREATE TABLE COLORS (
    co_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    co_name VARCHAR2(100) NOT NULL -- 색상 이름
);

-- 제품 테이블
CREATE TABLE PRODUCTS (
    pr_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    ca_id NUMBER NOT NULL, -- 카테고리 ID (외래 키)
    te_id NUMBER NOT NULL, -- 팀 ID (외래 키)
    pr_name VARCHAR2(1000), -- 제품 이름
    pr_regdate DATE, -- 제품 등록 날짜
    FOREIGN KEY (ca_id) REFERENCES CATEGORIES (ca_id),
    FOREIGN KEY (te_id) REFERENCES TEAMS (te_id)
);

-- 제품 재고 테이블
CREATE TABLE PRODUCT_STOCKS (
    pr_st_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- 자동 증가 ID
    pr_id NUMBER NOT NULL, -- 제품 ID (외래 키)
    co_id NUMBER NOT NULL, -- 색상 ID (외래 키)
    si_id NUMBER NOT NULL, -- 사이즈 ID (외래 키)
    quantity NUMBER NOT NULL, -- 재고 수량
    price NUMBER NOT NULL, -- 가격
    FOREIGN KEY (pr_id) REFERENCES PRODUCTS (pr_id),
    FOREIGN KEY (co_id) REFERENCES COLORS (co_id),
    FOREIGN KEY (si_id) REFERENCES SIZES (si_id)
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

```
## Insert Datas
```sql
INSERT INTO CATEGORIES (ca_name) VALUES ('모자');
INSERT INTO CATEGORIES (ca_name) VALUES ('의류');
INSERT INTO CATEGORIES (ca_name) VALUES ('액세서리');

INSERT INTO TEAMS (te_name) VALUES ('뉴욕 양키스');
INSERT INTO TEAMS (te_name) VALUES ('LA 다저스');
INSERT INTO TEAMS (te_name) VALUES ('보스턴 레드삭스');
INSERT INTO TEAMS (te_name) VALUES ('시카고 컵스');
INSERT INTO TEAMS (te_name) VALUES ('샌프란시스코 자이언츠');

INSERT INTO COLORS (co_name) VALUES ('블랙');
INSERT INTO COLORS (co_name) VALUES ('네이비');
INSERT INTO COLORS (co_name) VALUES ('화이트');
INSERT INTO COLORS (co_name) VALUES ('레드');
INSERT INTO COLORS (co_name) VALUES ('블루');

INSERT INTO SIZES (si_name) VALUES ('S');
INSERT INTO SIZES (si_name) VALUES ('M');
INSERT INTO SIZES (si_name) VALUES ('L');
INSERT INTO SIZES (si_name) VALUES ('XL');

INSERT INTO PRODUCTS (ca_id, te_id, pr_name, pr_regdate)
VALUES ((SELECT ca_id FROM CATEGORIES WHERE ca_name = '모자'),
        (SELECT te_id FROM TEAMS WHERE te_name = '뉴욕 양키스'),
        '뉴욕 양키스 59FIFTY 기본 로고 모자',
        SYSDATE);

SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴욕 양키스 59FIFTY 기본 로고 모자';

INSERT INTO PRODUCT_STOCKS (pr_id, co_id, si_id, quantity, price)
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴욕 양키스 59FIFTY 기본 로고 모자'),
        (SELECT co_id FROM COLORS WHERE co_name = '네이비'),
        (SELECT si_id FROM SIZES WHERE si_name = 'M'),
        50, 45000);
INSERT INTO PRODUCT_STOCKS (pr_id, co_id, si_id, quantity, price)
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴욕 양키스 59FIFTY 기본 로고 모자'),
        (SELECT co_id FROM COLORS WHERE co_name = '블랙'),
        (SELECT si_id FROM SIZES WHERE si_name = 'L'),
        30, 45000);

INSERT INTO PRODUCT_DETAILS (pr_id, subject, product_img, product_detail_img)
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴욕 양키스 59FIFTY 기본 로고 모자'),
        '뉴욕 양키스 59FIFTY 기본 로고 모자는 MLB 정품으로 클래식한 디자인과 완벽한 핏을 제공합니다.',
        'https://example.com/images/ny_yankees_cap.jpg',
        'https://example.com/images/ny_yankees_cap_detail.jpg');

INSERT INTO PRODUCTS (ca_id, te_id, pr_name, pr_regdate)
VALUES ((SELECT ca_id FROM CATEGORIES WHERE ca_name = '의류'),
        (SELECT te_id FROM TEAMS WHERE te_name = 'LA 다저스'),
        'LA 다저스 클래식 로고 티셔츠',
        SYSDATE);

INSERT INTO PRODUCT_STOCKS (pr_id, co_id, si_id, quantity, price)
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = 'LA 다저스 클래식 로고 티셔츠'),
        (SELECT co_id FROM COLORS WHERE co_name = '블루'),
        (SELECT si_id FROM SIZES WHERE si_name = 'M'),
        40, 35000);

INSERT INTO PRODUCT_DETAILS (pr_id, subject, product_img, product_detail_img)
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = 'LA 다저스 클래식 로고 티셔츠'),
        'LA 다저스를 상징하는 클래식한 로고 티셔츠입니다. 편안한 착용감을 제공합니다.',
        'https://example.com/images/la_dodgers_tshirt.jpg',
        'https://example.com/images/la_dodgers_tshirt_detail.jpg');

```
## JOIN
```sql
SELECT 
P.pr_id, 
P.pr_name, 
CA.ca_name, 
T.te_name, 
C.co_name, 
S.si_name, 
PS.price, 
PS.quantity
FROM 
PRODUCT_STOCKS PS,
PRODUCTS P,
CATEGORIES CA,
TEAMS T,
PRODUCT_DETAILS PD,
COLORS C,
SIZES S
WHERE PS.pr_id = P.pr_id
and CA.ca_id = P.ca_id
and P.te_id = T.te_id
and PD.pr_id = P.pr_id
and PS.co_id = C.co_id
and PS.si_id = S.si_id;
```
