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


INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 LA다저스'), 'Black', 'XS', 50, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 뉴욕양키스'), 'Black', 'S', 60, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '뉴 젤리 미드 비니 클리블랜드 가디언스'), 'Red', 'M', 70, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 뉴욕양키스'), 'White', 'L', 80, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '바시티 컬시브 미드 비니 보스턴 레드삭스'), 'Green', 'M', 90, 43000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 뉴욕양키스'), 'Blue', 'S', 100, 39000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '캔디 미드 비니 보스턴 레드삭스'), 'Black', 'L', 110, 39000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 LA다저스'), 'Brown', 'XL', 120, 39000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 뉴욕양키스'), 'Green', 'XS', 130, 39000);

INSERT INTO PRODUCT_STOCKS (pr_id, cl_id, sz_id, quantity, price) VALUES ((SELECT pr_id FROM PRODUCTS WHERE pr_name = '크로셰 미야옹 비니 보스턴 레드삭스'), 'White', 'S', 140, 39000);
```