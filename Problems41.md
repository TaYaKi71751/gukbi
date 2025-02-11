문제1) 다음중 잘못된 부분을 찾아서 올바르게 변경해보자.
```
insert into human values ('홍길남,31,156.4,to-date(2001:02:03 00:00:00','YYYY:MM:DD HH24:MI:SS'));
```
```
insert into human values ('홍길남',31,156.4,to_date('2001:02:03 00:00:00','YYYY:MM:DD HH24:MI:SS'));
```
문제2) drop table human; 와 같은 sql 작업후 rollback; 가능한가?
```
rollback은 insert update delete 같은 데이터를 조작할때 사용 가능하다.
```
```
불가능 하다.
```
문제3) 다음 데이터를 저장할 수 있는 테이블을 만들고 CRUD 작업 가능한 sql를 만들어 보자. 테이블,컬럼명을 한글이 아닌 영어로 만들어 사용하자.
```
테이블명: 화학물질 재고 현황
```
|화학물질명|재고량(kg)|최소재고량(kg)|입고일자|
|---|---|---|---|
|아세트산|500|100|2023-03-15|
|수산화나트륨|300|50|2023-04-20|
|황산|200|80|2023-05-10|
|염화칼슘|400|120|2023-06-05|
|염산|600|200|2023-07-08|
```
create table chemical_quantity_status(
    name nvarchar2(100),
    quantity number(100),
    max_quantity number(100),
    income_date date
);
insert into chemical_quantity_status values ('아세트산',500,100,to_date('2023-03-15','YYYY-MM-DD'));
insert into chemical_quantity_status values ('수산화나트륨',300,50,to_date('2023-04-20','YYYY-MM-DD'));
insert into chemical_quantity_status values ('황산',200,80,to_date('2023-05-10','YYYY-MM-DD'));
insert into chemical_quantity_status values ('아세트산',400,120,to_date('2023-06-05','YYYY-MM-DD'));
insert into chemical_quantity_status values ('아세트산',600,200,to_date('2023-07-08','YYYY-MM-DD'));
```

