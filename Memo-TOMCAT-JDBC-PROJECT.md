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
## Create Table
```sql
-- Colors Table
CREATE TABLE COLORS (
    color_id NUMBER PRIMARY KEY,           -- Primary key
    color_code VARCHAR(10) UNIQUE          -- Color code (e.g., HEX, RGB)
);

-- Teams Table
CREATE TABLE TEAMS (
    team_id NUMBER PRIMARY KEY,            -- Primary key
    team_name VARCHAR(30) UNIQUE           -- Team name
);

-- Products Table
CREATE TABLE PRODUCTS (
    product_id NUMBER,                     -- Primary key (you can add it as primary key or unique constraint)
    team_id NUMBER,                        -- Foreign key referencing TEAMS
    color_id NUMBER,                       -- Foreign key referencing COLORS
    name VARCHAR2(100),                    -- Product name
    price NUMBER,                          -- Price of the product
    FOREIGN KEY (team_id) REFERENCES TEAMS (team_id),   -- Foreign key to TEAMS
    FOREIGN KEY (color_id) REFERENCES COLORS (color_id) -- Foreign key to COLORS
);
-- Customers Table
CREATE TABLE CUSTOMERS (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100) UNIQUE,   -- Ensures email is unique across customers
    password VARCHAR(100) NOT NULL,  -- Ensures password is provided
    address VARCHAR(3000)
);
-- Orders Table
CREATE TABLE ORDERS (
    order_id NUMBER PRIMARY KEY,          -- Primary key for the orders table
    product_id NUMBER,                    -- Foreign key for product
    qty NUMBER,
    order_date TIMESTAMP,   -- Date and time when the order was placed
    end_date TIMESTAMP      -- Date and time when the order was completed or ended
    team_id NUMBER,                       -- Foreign key for team
    color_id NUMBER,                      -- Foreign key for color
    address VARCHAR(3000),                -- Customer's address for the order
    status VARCHAR(10),                   -- Status of the order (e.g., 'pending', 'shipped')
    
    FOREIGN KEY (product_id) REFERENCES PRODUCTS (product_id),  -- Linking to PRODUCTS table
    FOREIGN KEY (team_id) REFERENCES TEAMS (team_id),           -- Linking to TEAMS table
    FOREIGN KEY (color_id) REFERENCES COLORS (color_id)         -- Linking to COLORS table
);
-- Managers Table
CREATE TABLE MANAGERS (
    manager_id NUMBER PRIMARY KEY,      -- Primary key for manager_id
    name VARCHAR(50),                   -- Manager's name
    email VARCHAR(100) UNIQUE NOT NULL, -- Unique and NOT NULL constraint for email
    password VARCHAR(100) NOT NULL      -- NOT NULL constraint for password (use hashed passwords in a real application)
);
-- Administrators Table
CREATE TABLE ADMINISTRATORS (
    admin_id NUMBER PRIMARY KEY,
    name VARCHAR(50),                  -- name length
    email VARCHAR(100) UNIQUE NOT NULL,-- email length
    password VARCHAR(100) NOT NULL     -- password length
);
```
## Insert Datas
```sql
```
