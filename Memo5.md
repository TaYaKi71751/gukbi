# select 의 where 절
```
문자의 비교는 사전순으로 먼저나온 문자가 작고, 나중에 나온 문자가 크다.
시간은 과거의 시간보다 현재의 시간이 크고 현재 시간보다 미래 시간이 크다.
sql 문법은 대소문자를 구분하지 않지만 테이블에 들어 있는 데이터는 데소문자를 구분한다.
a >= ‘a’ and a <= ‘b’ 'b' 를 제외한 'b'로 시작하는 문자열 banana는 검색되지 않는다.
```
```
select country_name from countries where country_name <= 'I';

COUNTRY_NAME
----------------------------------------
Argentina
Australia
Belgium
Brazil
Canada
China
Germany
Denmark
Egypt
France
```
```
select country_name from countries where country_name <= 'India';

COUNTRY_NAME
----------------------------------------
Argentina
Australia
Belgium
Brazil
Canada
China
Germany
Denmark
Egypt
France
India
```
|속성|설명|
|-|-|
|=, !=, <>|=은 같을때 나머지는 다를 때 참(true)이다.|
|>, >= ,< ,<=|왼쪽이 클때, 왼쪽이 크거나 작을때, 오른쪽이 클때,<br>오른쪽이 크거나 같을때 true이다.|

# null 검색하기
```
특정 컬럼에 null이 들어 있는 데이터를 찾을때 = 연산자를 사용해서 찾을 수 없다.
특정 컬럼에 null이 들어 있는 데이터를 찾고 싶다면 'where 컬럼명 is null'
null이 아닌 데이터를 찾고 싶다면 'where 컬럼명 is not null'를 사용하면 된다.
```

```
--관리자가 없는 사원의 정보를 출력해보자.
select * from employees where manager_id=null; --동작하지 않음
select * from employees where manager_id is null; -- null인경우 선택
select * from employees where manager_id is not null; -- null이 아닌경우 선택
```
# and로 검색하기
```
select * from employees where commission_pct is not null and salary >= 10000;
select * from employees whee commission_pct is not null and salary >= 10000 and manager_id is not null;
```
# 컬럼 연산
```
컬럼을 연산자로 연산하여 새로운 결과를 얻어낼 수 있다. 
컬럼+컬럼,
컬럼+숫자,
숫자+숫자
```
```
--사원의 봉급을 50증가한 형태로 출력해 보자.
select salary,salary+50 from employees;
--사원의 현봉급보다 10%증가한 형태로 출력해 보자.
select salary,salary*1.1 from employees;
--사원의 현봉급보다 2배증가한 형태로 출력해 보자.
select salary, salary+salary, salary*2 from employees;
```
# 컬럼 별명 as
```
--사원의 봉급을 50증가한 형태로 컬럼명을 upgradeSalary로 출력해 보자.
select salary,salary+50 as upgradeSalary from employees;
    SALARY UPGRADESALARY
---------- -------------
      2900	    2950
      2500	    2550
      4000	    4050
      3900	    3950
      3200	    3250
      2800	    2850
      3100	    3150
      3000	    3050
```
# Concatenation(||)를 이용한 컬럼 합치기
```
Concatenation(||)를 사용하여 컬럼에 결과물을 결합하여 하나의 컬럼을 만들 수 있다.
`select 컬럼명 || ‘과’|| 컬럼명 as 합친칼럼명 from 테이블`
```
```
-- 사원의 성과 이름을 합쳐서 fullname이라는 컬럼명으로 출력해보자.
select first_name||last_Name as fullname from employees;
select first_name||' '||last_Name as fullname from employees;
```
