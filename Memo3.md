https://stackoverflow.com/questions/67395995/how-to-install-oracle-database-express-on-mac-m1

https://boisv.medium.com/oracle-database-express-edition-how-to-install-on-macos-538f6404fefb

- 인코딩
```
export NLS_LANG=AMERICAN_AMERICA.AL32UTF8
```
- 설치
```
brew uninstall --cask docker
brew install colima
brew install docker
brew install qemu
```
- 실행
```
docker volume rm oracle-volume
docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle -v oracle-volume:/opt/oracle/oradata gvenzl/oracle-xe
sqlplus system/oracle@//localhost:1521
```

```
conn sys as sysdba;
create user c##human identified by human;
grant connect,resource,dba to c##human;
```

```
sqlplus c##human/human@//localhost:1521
conn c##human/human@//localhost:1521
```
|속성|설명|
|---|---|
|nchar(n)|고정길이 문자 n개, <br>ID나 PASSWORD등에 사용|
|nvarchar2(n)|가변길이 문자 n개, <br>최대 2000까지 가능,<br> 게시판 글 등에 사용,|
|number|+-38자리 정수와 실수|
|number(n)|n자리 정수|
|number(m,n)|총 m 자리인데 소수점이 n자리인 실수|
|date|날짜와 시간을 저장('YYYYMMDDHH24MISS')<br>현재시간:sysdate|

```
'1977:05:06 14:05:06'은 입력 날짜 문자이고
형식 문자열 'YYYY:MM:DD HH24:MI:SS'은 입력 문자열의 예상 형식이다.
예상 형식에 맞춰서 입력 날짜 문자를 기술해서 원하는 시간 데이터를 얻을 수 있다.
```
```
to_date('1977:05:06 14:05:06', 'YYYY:MM:DD HH24:MI:SS');
```
- 현재시간을 출력
```
select sysdate from dual;
```
- 현재시간을 형식에 맞게 문자열로 출력
```
select to_char(sysdate, 'YYYY:MM:DD HH24:MI:SS') from dual;
```

- 모든 테이블 출력
```
select * from tab;
```
- 한줄 당 출력 할 글자 수
```
set linesize 100
```
- column 설정
```
column tname format A30;
column tabtype format a10;
column clusterid format a10;
```
- 테이블 만들기
```
create table human(
    name nvarchar2(30),
    age number(3),
    height number(4,1),
    birthday date
);
```
- insert 하기
```
insert into human(name,age,height,birthday) values ('홍길동', 30, 152.1, to_date('2000:02:03 00:00:00', 'YYYY:MM:DD HH24:MI:SS'));
```
- 일부 column 만 선택하기
```
select age,height from human;
```
- 변경사항 적용하기
```
commit; -- 변경된 사항을 적용하고 저장한다.
```
- update
```
update human set age=100; -- human 테이블의 모든 데이터가 100으로 변경됨
update human set age=11,height=156.2; -- 처럼 콤마로 넣을 데이터를 기술 할 수 있다.
```
- rollback
```
rollback; -- 마지막 commit; 상태로 복원한다.
-- commit 한 후에는 commit 된 이전 상태로 복원 할 수 없다고 볼 수 있다.
```
- where
```
update human set age=10 where age>=30; -- age가 30보다 크거나 같은 곳을 update 한다.
```
- delete
```
delete from human;
delete human;
delete from human where name='홍길동'; -- name이 홍길동 인 row를 삭제한다.
```
- drop
```
drop table human; -- human 테이블을 삭제한다.
```
- null
```
insert into human values ('', null,0,NULL);
```
- `'` 문자를 insert 할 때는 `'` 문자를 두번 입력한다.
