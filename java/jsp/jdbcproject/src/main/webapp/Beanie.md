|Product Name|Team|Price|Categories|Thumbnail Image URL|Description Image URL|
|-|-|-|-|-|-|
|뉴 젤리 미드 비니 LA다저스|LaDodgers|43000|Beanie|[뉴 젤리 미드 비니 LA다저스](./images/beanie/thumbnail/new_jelly_la.jpg)|[뉴 젤리 미드 비니 LA다저스](./images/beanie/description/new_jelly_la.jpg)|
|뉴 젤리 미드 비니 뉴욕양키스|NYKees|43000|Beanie|[뉴 젤리 미드 비니 뉴욕양키스](./images/beanie/thumbnail/new_jelly_ny.jpg)|[뉴 젤리 미드 비니 뉴욕양키스](./images/beanie/description/new_jelly_ny.jpg)
|뉴 젤리 미드 비니 클리블랜드 가디언스|Cleveland|43000|Beanie|[뉴 젤리 미드 비니 클리블랜드 가디언스](./images/beanie/thumbnail/new_jelly_cg.jpg)|[뉴 젤리 미드 비니 클리블랜드 가디언스](./images/beanie/description/new_jelly_cg.jpg)|
|바시티 컬시브 미드 비니 뉴욕양키스|NYKees|43000|Beanie|[바시티 컬시브 미드 비니 뉴욕양키스](./images/beanie/thumbnail/cursive_ny.jpg)|[바시티 컬시브 미드 비니 뉴욕양키스](./images/beanie/description/cursive_ny.jpg)|
|바시티 컬시브 미드 비니 보스턴 레드삭스|Boston|43000|Beanie|[바시티 컬시브 미드 비니 보스턴 레드삭스](./images/beanie/thumbnail/cursive_red_sox.jpg)|[바시티 컬시브 미드 비니 보스턴 레드삭스](./images/beanie/description/cursive_red_sox.jpg)|
|캔디 미드 비니 뉴욕양키스|NYKees|39000|Beanie|[캔디 미드 비니 뉴욕양키스](./images/beanie/thumbnail/candy_ny.jpg)|[캔디 미드 비니 뉴욕양키스](./images/beanie/description/candy_ny.jpg)|
|캔디 미드 비니 보스턴 레드삭스|Boston|39000|Beanie|[캔디 미드 비니 보스턴 레드삭스](./images/beanie/thumbnail/candy_red_sox.jpg)|[캔디 미드 비니 보스턴 레드삭스](./images/beanie/description/candy_red_sox.jpg)|
|크로셰 미야옹 비니 LA다저스|LaDodgers|39000|Beanie|[크로셰 미야옹 비니 LA다저스](./images/beanie/thumbnail/miyaong_la.jpg)|[크로셰 미야옹 비니 LA다저스](./images/beanie/description/miyaong_la.jpg)|
|크로셰 미야옹 비니 뉴욕양키스|NYKees|39000|Beanie|[크로셰 미야옹 비니 뉴욕양키스](./images/beanie/thumbnail/miyaong_ny.jpg)|[크로셰 미야옹 비니 뉴욕양키스](./images/beanie/description/miyaong_ny.jpg)|
|크로셰 미야옹 비니 보스턴 레드삭스|Boston|39000|Beanie|[크로셰 미야옹 비니 보스턴 레드삭스](./images/beanie/thumbnail/miyaong_red_sox.jpg)|[크로셰 미야옹 비니 보스턴 레드삭스](./images/beanie/description/miyaong_red_sox.jpg)|
```sql
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('LaDodgers', 'Beanie', '뉴 젤리 미드 비니 LA다저스', SYSDATE - 30, '/images/beanie/thumbnail/new_jelly_la.jpg', '/images/beanie/description/new_jelly_la.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '뉴 젤리 미드 비니 뉴욕양키스', SYSDATE - 30, '/images/beanie/thumbnail/new_jelly_ny.jpg', '/images/beanie/description/new_jelly_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Cleveland', 'Beanie', '뉴 젤리 미드 비니 클리블랜드 가디언스', SYSDATE - 30, '/images/beanie/thumbnail/new_jelly_cg.jpg', '/images/beanie/description/new_jelly_cg.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '바시티 컬시브 미드 비니 뉴욕양키스', SYSDATE - 30, '/images/beanie/thumbnail/cursive_ny.jpg', '/images/beanie/description/cursive_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Boston', 'Beanie', '바시티 컬시브 미드 비니 보스턴 레드삭스', SYSDATE - 30, '/images/beanie/thumbnail/cursive_red_sox.jpg', '/images/beanie/description/cursive_red_sox.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '캔디 미드 비니 뉴욕양키스', SYSDATE - 30, '/images/beanie/thumbnail/candy_ny.jpg', '/images/beanie/description/candy_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Boston', 'Beanie', '캔디 미드 비니 보스턴 레드삭스', SYSDATE - 30, '/images/beanie/thumbnail/candy_red_sox.jpg', '/images/beanie/description/candy_red_sox.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('LaDodgers', 'Beanie', '크로셰 미야옹 비니 LA다저스', SYSDATE - 30, '/images/beanie/thumbnail/miyaong_la.jpg', '/images/beanie/description/miyaong_la.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '크로셰 미야옹 비니 뉴욕양키스', SYSDATE - 30, '/images/beanie/thumbnail/miyaong_ny.jpg', '/images/beanie/description/miyaong_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Boston', 'Beanie', '크로셰 미야옹 비니 보스턴 레드삭스', SYSDATE - 30, '/images/beanie/thumbnail/miyaong_red_sox.jpg', '/images/beanie/description/miyaong_red_sox.jpg');
```
```sql
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Black', 'S', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Black', 'M', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Black', 'L', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Black', 'XL', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'White', 'S', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'White', 'M', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'White', 'L', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'White', 'XL', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Green', 'S', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Green', 'M', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Green', 'L', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Green', 'XL', 50, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Black', 'S', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Black', 'M', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Black', 'L', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Black', 'XL', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'White', 'S', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'White', 'M', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'White', 'L', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'White', 'XL', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Green', 'S', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Green', 'M', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Green', 'L', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Green', 'XL', 60, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Black', 'S', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Black', 'M', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Black', 'L', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Black', 'XL', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'White', 'S', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'White', 'M', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'White', 'L', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'White', 'XL', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Green', 'S', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Green', 'M', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Green', 'L', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Green', 'XL', 70, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Black', 'S', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Black', 'M', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Black', 'L', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Black', 'XL', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'White', 'S', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'White', 'M', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'White', 'L', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'White', 'XL', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Green', 'S', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Green', 'M', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Green', 'L', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'Green', 'XL', 80, 43000);


INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Black', 'S', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Black', 'M', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Black', 'L', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Black', 'XL', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'White', 'S', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'White', 'M', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'White', 'L', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'White', 'XL', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Green', 'S', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Green', 'M', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Green', 'L', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Green', 'XL', 90, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Black', 'S', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Black', 'M', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Black', 'L', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Black', 'XL', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'White', 'S', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'White', 'M', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'White', 'L', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'White', 'XL', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Green', 'S', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Green', 'M', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Green', 'L', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Green', 'XL', 100, 39000);
-- Insert for '캔디 미드 비니 보스턴 레드삭스'
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Black', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Black', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Black', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Black', 'XL', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'White', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'White', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'White', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'White', 'XL', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Green', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Green', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Green', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Green', 'XL', 120, 39000);
-- Insert for '크로셰 미야옹 비니 LA다저스'
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Black', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Black', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Black', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Black', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'White', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'White', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'White', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'White', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Green', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Green', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Green', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Green', 'XL', 130, 39000);
-- Insert for '크로셰 미야옹 비니 뉴욕양키스'
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Black', 'S', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Black', 'M', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Black', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Black', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'White', 'S', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'White', 'M', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'White', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'White', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Green', 'S', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Green', 'M', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Green', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Green', 'XL', 130, 39000);
-- Insert for '크로셰 미야옹 비니 보스턴 레드삭스' with color 'White' and different sizes
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Black', 'S', 140, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Black', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Black', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Black', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'White', 'S', 140, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'White', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'White', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'White', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Green', 'S', 140, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Green', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Green', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'Green', 'XL', 130, 39000);
```