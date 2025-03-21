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
INSERT INTO COLORS (color_id, color_code) 
VALUES (1, '#FF5733');

INSERT INTO COLORS (color_id, color_code) 
VALUES (2, '#33FF57');

INSERT INTO COLORS (color_id, color_code) 
VALUES (3, '#5733FF');


INSERT INTO TEAMS (team_id, team_name)
VALUES (1, 'Team A');

INSERT INTO TEAMS (team_id, team_name)
VALUES (2, 'Team B');

INSERT INTO TEAMS (team_id, team_name)
VALUES (3, 'Team C');


INSERT INTO PRODUCTS (product_id, team_id, color_id, name, price)
VALUES (1, 1, 1, 'Product 1', 99.99);

INSERT INTO PRODUCTS (product_id, team_id, color_id, name, price)
VALUES (2, 2, 2, 'Product 2', 149.99);

INSERT INTO PRODUCTS (product_id, team_id, color_id, name, price)
VALUES (3, 3, 3, 'Product 3', 199.99);


INSERT INTO CUSTOMERS (customer_id, email, password, name, address)
VALUES (1, 'customer1@example.com', 'password123', 'John Doe', '1234 Elm Street, Springfield, IL');

INSERT INTO CUSTOMERS (customer_id, email, password, name, address)
VALUES (2, 'customer2@example.com', 'password456', 'Jane Smith', '5678 Oak Avenue, Madison, WI');


INSERT INTO MANAGERS (manager_id, name, email, password)
VALUES (1, 'Alice Brown', 'alice.brown@example.com', 'admin123');

INSERT INTO MANAGERS (manager_id, name, email, password)
VALUES (2, 'Bob White', 'bob.white@example.com', 'admin456');


INSERT INTO ORDERS (order_id, product_id, team_id, color_id, address, status)
VALUES (1, 1, 1, 1, '1234 Elm Street, Springfield, IL', 'pending');

INSERT INTO ORDERS (order_id, product_id, team_id, color_id, address, status)
VALUES (2, 2, 2, 2, '5678 Oak Avenue, Madison, WI', 'shipped');


INSERT INTO ADMINISTRATOR (admin_id, name, email, password)
VALUES (1, 'Charlie Green', 'charlie.green@example.com', 'admin123');

INSERT INTO ADMINISTRATOR (admin_id, name, email, password)
VALUES (2, 'Diana Blue', 'diana.blue@example.com', 'admin456');
```
