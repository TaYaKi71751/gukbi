# 함수
- 문자열의 인덱스는 1부터 시작한다.

|함수|내용|예제|
|-|-|-|
|abs|절대값 출력|select -10,abs(-10) from dual;<br>-10과 절대값 10이 출력 된다.|
|floor|소수점 아래를 버림|select floor(11.123) from dual;<br>소수점을 잘라낸 11출력|
|round|소수점 반올림|select round(11.123),round(11.129,2) from dual;<br>11과 소수점 3째자리에서 반올림한 11.13 출력|
|trunc|소수점 버림|select trunc(123.129),trunc(123.129,-1) from dual;<br>123과 1의 자리에서 버림한 120 출력|
|mod|나머지 구하는 함수|select mod(7,2),mod(5,3) from dual;<br>7을 2로 나눈 나머지 1과 5를 3으로 나눈 나머지 2가 출력된다.|
|lower|소문자|select lower(‘HELLO world’) from dual;<br>hello world|
|upper|대문자|select upper('HELLO world') from dual;<br>HELLO WORLD|
|initcap|시작부분만 대문자|select initcap('HELLO world') from dual;<br>Hello World|
|concat|문자열 합치기|select concat(‘he’,’llo’) from dual;<br>두컬럼의 문자열을 합칠수 있다. hello 출력|
|substr|부분문자열 추출|select substr('안녕 HELLO world',2,4) from dual;<br>실행결과 녕 HE 이출력된다. 문자열에서 2번째 인덱스부터 4개의 문자가 출력된다.|
|length|문자열 개수|select length('안녕 HELLO world') from dual;<br>14가 출력 된다.|
|trim|양쪽공백 삭제|select trim(' hello ') from dual;<br>'hello'|
|ltrim|왼쪽공백 삭제|select ltrim(' hello ') from dual;<br>'hello '|
|rtrim|오른쪽공백 삭제|select rtrim(' hello ') from dual;<br>' hello'|
|instr|특정 문자열의 위치를 찾음|select instr(upper('wo 안녕 HELLO world'),'WO',1,2) from dual;<br>실행결과 12<br>첫번째 매개변수 문자열에서 두번째 문자열을 찾음,<br>세번재 매개변수는 첫번째 문자열에서 찾을 때 시작할 위치,<br>네번재 매개변수 찾은 동일한 문자열의 위치 중 해당번째 문자열의 위치 인덱스를 리턴|
|months\_between|두날짜의 월차를 구함|select months\_between(sysdate,sysdate+60) from dual;<br>결과값 -2.03225...|
|add\_months|월을 더함|select add\_months(sysdate,2) from dual;<br>결과값은 오늘 날짜보다 2달 증가한 값이 출력|
|next\_day|다음 요일의 날짜를 구함|select next\_day(sysdate,7) from dual;<br>1은 일요일 2는 월요일 7은 토요일에 해당하는 다음 날짜를 출력한다.|
|last\_day|달의 마지막일을 구함|ct last\_day(sysdate) from dual;<br>해당월의 마지막 일이 출력된다.|
|to\_char|문자로 변환|select to\_char(sysdate, ‘YYYY/MM:dd HH24:MI:SS’) from dual;<br>select to\_char(560, ‘$999,999.99’),to\_char(560, ‘$000,000.00’) from dual;<br>$560.00, $000,560.00<br>select to\_char(50) from dual;<br>웹에서 오라클 숫자 format으로 검색해 보자.|
|to\_date|날짜형으로 변환|select to_date(‘1977:05:06 14:05:06’,‘YYYY:MM:DD HH24:MI:SS’) from dual;<br>시간 포맷에서 대소문자 구분을 안함|
|to_number|숫자형으로 변환|select to_number(‘1’) from dual;|

# 그룹함수
|연산자|의미|
|-|-|
|sum|검색된 총합을 반환<br>select sum(salary) from employees;<br>전체 사원의 급여합|
|avg|검색된 평균을 반환<br>select avg(salary) from employees;<br>전체 사원의 급여 평균|
|count|검색된 총 개수를 반환<br>select count(salary) from employees;<br>급여를 받는 전체 사원의 수|
|max|검색 결과중 가장 큰수 반환<br>select max(salary) from employees;<br>전체 사원중 급여를 가장 많이 받는 사원의 급여|
|min|검색 결과중 가장 작은수 반환<br>select min(salary) from employees;<br>전체 사원중 급여를 가장 적게 받는 사원의 급여|
```
-- 일반 컬럼과 함께 사용하면 출력할 데이터 개수가 달라져서 출력에 문제가 발생하여 사용할 수 없다.
select sum(salary),salary from employees; –- 동작하지 않음
-- 그룹함수는 null 때문에 문제가 발생 할 수 있으니 항상 머리속에 null을 생각하며 사용하자.
select count(*),count(commission_pct) from employees; 
-- 위 쿼리를 실행시켜 보면 다른 결과 107 35가 나오는데 null를 카운팅하지 않아서 그렇다.
select count(*),count(nvl(commission_pct,0)) from employees;
-- nvl(commission_pct,0)은 commission_pct컬럼의 값이 null일때 값이 0으로 바뀌어서 null도 셀 수 있게 되어 결과가 107 107이 된다.
select avg(commission_pct),avg(nvl(commission_pct,0)) from employees;
-- null 때문에 다른 결과가 나온다.
```
