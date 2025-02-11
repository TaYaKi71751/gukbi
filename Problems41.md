문제1) 다음중 잘못된 부분을 찾아서 올바르게 변경해보자.
```
insert into human values ('홍길남,31,156.4,to-date(2001:02:03 00:00:00','YYYY:MM:DD HH24:MI:SS'));
```
```
insert into human values ('홍길남',31,156.4,to_date('2001:02:03 00:00:00','YYYY:MM:DD HH24:MI:SS'));
```
