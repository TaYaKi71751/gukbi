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
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('LaDodgers', 'Beanie', '뉴 젤리 미드 비니 LA다저스', SYSDATE - 30, 'new_jelly_la.jpg', 'new_jelly_la.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '뉴 젤리 미드 비니 뉴욕양키스', SYSDATE - 30, 'new_jelly_ny.jpg', 'new_jelly_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Cleveland', 'Beanie', '뉴 젤리 미드 비니 클리블랜드 가디언스', SYSDATE - 30, 'new_jelly_cg.jpg', 'new_jelly_cg.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '바시티 컬시브 미드 비니 뉴욕양키스', SYSDATE - 30, 'cursive_ny.jpg', 'cursive_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Boston', 'Beanie', '바시티 컬시브 미드 비니 보스턴 레드삭스', SYSDATE - 30, 'cursive_red_sox.jpg', 'cursive_red_sox.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '캔디 미드 비니 뉴욕양키스', SYSDATE - 30, 'candy_ny.jpg', 'candy_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Boston', 'Beanie', '캔디 미드 비니 보스턴 레드삭스', SYSDATE - 30, 'candy_red_sox.jpg', 'candy_red_sox.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('LaDodgers', 'Beanie', '크로셰 미야옹 비니 LA다저스', SYSDATE - 30, 'miyaong_la.jpg', 'miyaong_la.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('NYKees', 'Beanie', '크로셰 미야옹 비니 뉴욕양키스', SYSDATE - 30, 'miyaong_ny.jpg', 'miyaong_ny.jpg');
INSERT INTO PRODUCTS (tm_id, ca_id, pr_name, pr_regdate, pr_thum_img, pr_detail_img) VALUES ('Boston', 'Beanie', '크로셰 미야옹 비니 보스턴 레드삭스', SYSDATE - 30, 'miyaong_red_sox.jpg', 'miyaong_red_sox.jpg');
```
```sql
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'BLK', 'S', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'BLK', 'M', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'BLK', 'L', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'BLK', 'XL', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'WT', 'S', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'WT', 'M', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'WT', 'L', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'WT', 'XL', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'GN', 'S', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'GN', 'M', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'GN', 'L', 50, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'GN', 'XL', 50, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'BLK', 'S', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'BLK', 'M', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'BLK', 'L', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'BLK', 'XL', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'WT', 'S', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'WT', 'M', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'WT', 'L', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'WT', 'XL', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'GN', 'S', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'GN', 'M', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'GN', 'L', 60, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'GN', 'XL', 60, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'BLK', 'S', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'BLK', 'M', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'BLK', 'L', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'BLK', 'XL', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'WT', 'S', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'WT', 'M', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'WT', 'L', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'WT', 'XL', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'GN', 'S', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'GN', 'M', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'GN', 'L', 70, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'GN', 'XL', 70, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'BLK', 'S', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'BLK', 'M', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'BLK', 'L', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'BLK', 'XL', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'WT', 'S', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'WT', 'M', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'WT', 'L', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'WT', 'XL', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'GN', 'S', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'GN', 'M', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'GN', 'L', 80, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'GN', 'XL', 80, 43000);


INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'BLK', 'S', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'BLK', 'M', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'BLK', 'L', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'BLK', 'XL', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'WT', 'S', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'WT', 'M', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'WT', 'L', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'WT', 'XL', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'GN', 'S', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'GN', 'M', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'GN', 'L', 90, 43000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'GN', 'XL', 90, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'BLK', 'S', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'BLK', 'M', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'BLK', 'L', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'BLK', 'XL', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'WT', 'S', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'WT', 'M', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'WT', 'L', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'WT', 'XL', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'GN', 'S', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'GN', 'M', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'GN', 'L', 100, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES
( (SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'GN', 'XL', 100, 39000);
-- Insert for '캔디 미드 비니 보스턴 레드삭스'
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'BLK', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'BLK', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'BLK', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'BLK', 'XL', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'WT', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'WT', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'WT', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'WT', 'XL', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'GN', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'GN', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'GN', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'GN', 'XL', 120, 39000);
-- Insert for '크로셰 미야옹 비니 LA다저스'
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'BLK', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'BLK', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'BLK', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'BLK', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'WT', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'WT', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'WT', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'WT', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'GN', 'S', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'GN', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'GN', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'GN', 'XL', 130, 39000);
-- Insert for '크로셰 미야옹 비니 뉴욕양키스'
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'BLK', 'S', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'BLK', 'M', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'BLK', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'BLK', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'WT', 'S', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'WT', 'M', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'WT', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'WT', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'GN', 'S', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'GN', 'M', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'GN', 'L', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'GN', 'XL', 130, 39000);
-- Insert for '크로셰 미야옹 비니 보스턴 레드삭스' with color 'WT' and different sizes
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'BLK', 'S', 140, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'BLK', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'BLK', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'BLK', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'WT', 'S', 140, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'WT', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'WT', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'WT', 'XL', 130, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'GN', 'S', 140, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'GN', 'M', 120, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'GN', 'L', 110, 39000);
INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) 
VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'GN', 'XL', 130, 39000);
```