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
DROP TABLE ADMINISTRATORS;
DROP TABLE MANAGERS;
DROP TABLE ORDERS;
DROP TABLE CUSTOMERS;
DROP TABLE PRODUCTS;
DROP TABLE COLORS;
DROP TABLE TEAMS;
-- Colors Table
CREATE TABLE COLORS (
    color_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,           -- Primary key
    color_code VARCHAR(10) UNIQUE          -- Color code (e.g., HEX, RGB)
);

-- Teams Table
CREATE TABLE TEAMS (
    team_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,            -- Primary key
    team_name VARCHAR(30) UNIQUE           -- Team name
);

-- Products Table
CREATE TABLE PRODUCTS (
    product_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,                     -- Primary key (you can add it as primary key or unique constraint)
    team_id NUMBER,                        -- Foreign key referencing TEAMS
    color_id NUMBER,                       -- Foreign key referencing COLORS
    name VARCHAR2(100),                    -- Product name
    price NUMBER,                          -- Price of the product
    thumbnail_image_path varchar(1000),
    description_image_path varchar(1000),
    description varchar(65534),
    FOREIGN KEY (team_id) REFERENCES TEAMS (team_id),   -- Foreign key to TEAMS
    FOREIGN KEY (color_id) REFERENCES COLORS (color_id) -- Foreign key to COLORS
);
-- Customers Table
CREATE TABLE CUSTOMERS (
    customer_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY ,
    name VARCHAR(50),
    email VARCHAR(100) UNIQUE,   -- Ensures email is unique across customers
    password VARCHAR(100) NOT NULL,  -- Ensures password is provided
    address VARCHAR(3000)
);
-- Orders Table
CREATE TABLE ORDERS (
    order_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,          -- Primary key for the orders table
    product_id NUMBER,                    -- Foreign key for product
    qty NUMBER,
    order_date DATE,                      -- Date and time when the order was placed
    end_date DATE,                        -- Date and time when the order was completed or ended
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
    manager_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,      -- Primary key for manager_id
    name VARCHAR(50),                   -- Manager's name
    email VARCHAR(100) UNIQUE NOT NULL, -- Unique and NOT NULL constraint for email
    password VARCHAR(100) NOT NULL      -- NOT NULL constraint for password (use hashed passwords in a real application)
);
-- Administrators Table
CREATE TABLE ADMINISTRATORS (
    admin_id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50),                  -- name length
    email VARCHAR(100) UNIQUE NOT NULL,-- email length
    password VARCHAR(100) NOT NULL     -- password length
);
```
## Insert Datas
```sql
INSERT INTO COLORS (color_code) 
VALUES ('#003087');  -- New York Yankees Blue
INSERT INTO COLORS (color_code) 
VALUES ('#FF5733');  -- Example: a random color for another product
INSERT INTO COLORS (color_code) 
VALUES ('#FF4500');  -- Los Angeles Dodgers Orange
INSERT INTO COLORS (color_code) 
VALUES ('#008000');  -- Boston Red Sox Green

INSERT INTO TEAMS (team_name) 
VALUES ('New York Yankees');
INSERT INTO TEAMS (team_name) 
VALUES ('Los Angeles Dodgers');
INSERT INTO TEAMS (team_name) 
VALUES ('Boston Red Sox');
INSERT INTO TEAMS (team_name) 
VALUES ('Chicago Cubs');

-- Insert New York Yankees product
INSERT INTO PRODUCTS (team_id, color_id, name, price, thumbnail_image_path, description_image_path, description)
VALUES (1, 1, 'New York Yankees Cap', 25.00, '/images/yankees_cap.jpg', '/images/yankees_cap_desc.jpg', 'A stylish cap featuring the New York Yankees logo.');
-- Insert Los Angeles Dodgers product
INSERT INTO PRODUCTS (team_id, color_id, name, price, thumbnail_image_path, description_image_path, description)
VALUES (2, 3, 'Los Angeles Dodgers T-shirt', 20.00, '/images/dodgers_tshirt.jpg', '/images/dodgers_tshirt_desc.jpg', 'A comfortable Dodgers T-shirt.');
-- Insert Boston Red Sox product
INSERT INTO PRODUCTS (team_id, color_id, name, price, thumbnail_image_path, description_image_path, description)
VALUES (3, 4, 'Boston Red Sox Hoodie', 45.00, '/images/redsox_hoodie.jpg', '/images/redsox_hoodie_desc.jpg', 'A warm hoodie for Red Sox fans.');
-- Insert Chicago Cubs product
INSERT INTO PRODUCTS (team_id, color_id, name, price, thumbnail_image_path, description_image_path, description)
VALUES (4, 2, 'Chicago Cubs Mug', 15.00, '/images/cubs_mug.jpg', '/images/cubs_mug_desc.jpg', 'A ceramic mug for Chicago Cubs fans.');

INSERT INTO CUSTOMERS (name, email, password, address)
VALUES ('Alice Johnson', 'alice.johnson@example.com', 'hashed_password_1', '123 Maple St, New York, NY');
INSERT INTO CUSTOMERS (name, email, password, address)
VALUES ('Bob Smith', 'bob.smith@example.com', 'hashed_password_2', '456 Oak St, Los Angeles, CA');
INSERT INTO CUSTOMERS (name, email, password, address)
VALUES ('Charlie Brown', 'charlie.brown@example.com', 'hashed_password_3', '789 Pine St, Boston, MA');
INSERT INTO CUSTOMERS (name, email, password, address)
VALUES ('David Lee', 'david.lee@example.com', 'hashed_password_4', '101 Birch St, Chicago, IL');

-- Order for New York Yankees Cap
INSERT INTO ORDERS (product_id, qty, order_date, end_date, team_id, color_id, address, status)
VALUES (1, 2, TO_DATE('2025-03-21', 'YYYY-MM-DD'), TO_DATE('2025-03-23', 'YYYY-MM-DD'), 1, 1, '123 Maple St, New York, NY', 'shipped');
-- Order for Los Angeles Dodgers T-shirt
INSERT INTO ORDERS (product_id, qty, order_date, end_date, team_id, color_id, address, status)
VALUES (2, 1, TO_DATE('2025-03-21', 'YYYY-MM-DD'), TO_DATE('2025-03-22', 'YYYY-MM-DD'), 2, 3, '456 Oak St, Los Angeles, CA', 'pending');
-- Order for Boston Red Sox Hoodie
INSERT INTO ORDERS (product_id, qty, order_date, end_date, team_id, color_id, address, status)
VALUES (3, 3, TO_DATE('2025-03-20', 'YYYY-MM-DD'), TO_DATE('2025-03-22', 'YYYY-MM-DD'), 3, 4, '789 Pine St, Boston, MA', 'shipped');
-- Order for Chicago Cubs Mug
INSERT INTO ORDERS (product_id, qty, order_date, end_date, team_id, color_id, address, status)
VALUES (4, 5, TO_DATE('2025-03-19', 'YYYY-MM-DD'), TO_DATE('2025-03-21', 'YYYY-MM-DD'), 4, 2, '101 Birch St, Chicago, IL', 'shipped');

INSERT INTO MANAGERS (name, email, password)
VALUES ('David Lee', 'david.lee@company.com', 'hashed_password_1');
INSERT INTO MANAGERS (name, email, password)
VALUES ('Sarah Brown', 'sarah.brown@company.com', 'hashed_password_2');

INSERT INTO ADMINISTRATORS (name, email, password)
VALUES ('George Black', 'george.black@admin.com', 'hashed_password_1');
INSERT INTO ADMINISTRATORS (name, email, password)
VALUES ('Emily White', 'emily.white@admin.com', 'hashed_password_2');
```
