# select 의 where 절
```
문자의 비교는 사전순으로 먼저나온 문자가 작고, 나중에 나온 문자가 크다.
시간은 과거의 시간보다 현재의 시간이 크고 현재 시간보다 미래 시간이 크다.
sql 문법은 대소문자를 구분하지 않지만 테이블에 들어 있는 데이터는 데소문자를 구분한다.
a >= ‘a’ and a <= ‘b’ 'b' 를 제외한 'b'로 시작하는 문자열 banana는 검색되지 않는다.
```
```sql
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
```sql
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

```sql
--관리자가 없는 사원의 정보를 출력해보자.
select * from employees where manager_id=null; --동작하지 않음
select * from employees where manager_id is null; -- null인경우 선택
select * from employees where manager_id is not null; -- null이 아닌경우 선택
```
# and로 검색하기
```sql
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
```sql
--사원의 봉급을 50증가한 형태로 출력해 보자.
select salary,salary+50 from employees;
--사원의 현봉급보다 10%증가한 형태로 출력해 보자.
select salary,salary*1.1 from employees;
--사원의 현봉급보다 2배증가한 형태로 출력해 보자.
select salary, salary+salary, salary*2 from employees;
```
# 컬럼 별명 as
```sql
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
```sql
-- 사원의 성과 이름을 합쳐서 fullname이라는 컬럼명으로 출력해보자.
select first_name||last_Name as fullname from employees;
select first_name||' '||last_Name as fullname from employees;
```

# and or not 논리 연산자
```sql
where a > 0 and b > 0 and c > 0  -- 과 같이 기술 한다면 3가지 조건이 모두 참일 때만 해당 데이터가 출력이 된다. 나이가 50이면서 남자인 데이터 두 조건다 만족해야 데이터를 출력하고 싶을때 and를 사용 한다. 
age=50 and gender= ‘man’
where a > 0 or b > 0 or c > 0 -- 와 같이 기술 한다면 3가지 조건중 하나라도 참이 있으면 해당 데이터가 출력이 된다.
-- 나이가 50이거나 남자인 데이터 두 조건 중 하나만 만족하면 해당 데이터가 출력된다. 
age=50 or gender= ‘man’
where a!=0, where not a=0
-- a컬럼의 값이 0이 아닌 경우에 데이터가 출력 된다.
```
# between 연산자
```sql
--연봉이 8000보다 같거나 많고 10000보다 같거나 작은 사원 정보를 출력해 보자.
select * from employees where salary between 8000 and 10000;
select * from employees where salary >= 8000 and salary<=10000;
```
```sql
--연봉이 7000 미만 이거나 10000초과인 사원 정보를 출력해 보자.
select * from emp where sal not between 7000 and 10000;
select * from employees where salary < 7000 or salary>10000;
```
```sql
--사원의 이름이 E~G로 시작하는 사원정보를 출력해 보자.
select * from employees where first_name between 'E' and 'H' and first_name != 'H';
select * from employees where first_name >= 'E' and first_name < 'H' ;
```
```sql
-- 사원의 입사일이 2004년 5월 20일 ~ 2007년 10월 9일 이전 까지의 사원 정보를 출력해 보자.
select * from employees where hiredate between '2004-05-20' and '2007-10-10';
```
# null 연산과 null값 변경 함수
```
null값을 가지고 연산을 하면 결과값은 null이 되어 생각과 다른 결과가 나오는 경우가 있다. 
null값을 다른 값으로 변경해서 원하는 결과가 나올 수 있도록 할 수 있는데 이때 사용하는 함수로 nvl, nvl2, decode가 있다. 
컬럼을 사용할 위치에 해당 메소드를 사용하여 null값을 처리할 수 있다.
nvl(컬럼명,0) 컬럼명이 null일때 0를 출력 한다.
nvl2(컬럼명, ‘notNull’, ‘null’) 컬럼이 null이 아니면 ‘notNull’이 null이면 ‘null’이 출력 된다.
decode(컬럼명,null,0,컬럼명) 컬럼명이 가지고 있는 값이 null이면 0 아니면 컬럼명이 가지고 있는 값이 출력된다.
```
```sql
select commission_pct + 1 from employees;
select nvl(commission_pct,0) + 1 from employees;
select nvl2(commission_pct,'notNull','null') from employees;
select nvl2(commission_pct,commission_pct,0) up_commission from employees;
select nvl2(commission_pct,commission_pct,0) as up_commission from employees;
select decode(commission_pct,null,0,commission_pct) + 1 from employees;
```
# decode와 case 문법
```sql
-- decode(컬럼명, 값1,변경값1, 값2,변경값2…, ‘나머지경우변경값’);
-- decode 다음에 오는 컬럼의 값이 값1이면 해당 컬럼의 값은 값1으로 변경되고 값2이면 값2로 변경되고 매핑되는 값이 없을 때에는 나머지 겨우 변경값이 출력 된다.
-- 다음 예제는 job_id 컬럼의 값이 'IT_PROG'이면 'Developer'로, 'SA_REP'이면 'Sales Representative'로, 그 외의 값이면 'Other Job'으로 변환됩니다.
SELECT employee_id, job_id, DECODE(
job_id,
'IT_PROG', 'Developer',
'SA_REP', 'Sales Representative',
'Other Job'
) AS job_title FROM employees;
```
```sql
-- 사원의 커미션이 0.1이하면 하 0.2이하면 중 0.2초과면 상,null이면 'null이다' 그 밖의 경우에는 '선택받지 못한데이터' 을 출력해보자.
-- case에서 end 까지가 하나의 컬럼이 되고, 컬럼명이 길어서 as로 별명을 사용하였다.
select first_name,commission_pct,
case
when commission_pct <=0.1 then '하'
when commission_pct <=0.2 then '중'
when commission_pct > 0.2 then '상'
when commission_pct is null then 'null이다'
else '선택받지 못한데이터'
end as PCT
from employees;
```
# in 연산자
```sql
-- 다음은 employees 테이블에서 job_id가 'IT_PROG', 'SA_REP', 'HR_REP' 중 하나인 행을 선택하는 쿼리입니다:
SELECT *
FROM employees
WHERE job_id IN ('IT_PROG', 'SA_REP', 'HR_REP');
```
# like 연산자
```sql
-- "employees" 테이블에서 이름이 "John"으로 시작하는 모든 직원을 검색하려면 다음과 같이 작성할 수 있습니다:
SELECT * FROM employees WHERE employee_name LIKE 'John%';
-- "employees" 테이블에서 성이 "Smith"이고 이름이 5글자인 모든 직원을 찾으려면 다음과 같이 작성할 수 있습니다:
SELECT * FROM employees WHERE employee_name LIKE 'Smith____';
```
```
‘hi’ 해당 컬럼 문자열이 hi인 데이터만 검색
‘hi%’ hi로 시작하는 모든 문자열
‘%hi’ hi로 끝나는 모든 문자열
‘%hi%’ hi가 들어간 모든 문자열
‘%%’ 모든 문자열
‘_ _’ 글자수가 2개인 모든 문자열
‘_hi’ 3글자인데 hi로 끝나는 모든 문자열
‘hi_’ 3글자인데 hi로 시작하는 모든 문자열
‘_hi_’ 4문자이고 두번째위치에 hi가 들어간 모든 문자열
‘_ _%’ 두글자 이상의 모든 데이터
```
# 와일드카드 문자의 사용 예시
```
%: 0개 이상의 문자를 나타냅니다.
_: 정확히 한 개의 문자를 나타냅니다.
```
# order by
```sql
-- first_name 순서대로 출력
select * from employees order by first_name;
-- job_id 순서대로 출력
select * from employees order by job_id; -- asc 생략
select * from employees order by job_id asc; -- 오름차순
select * from employees order by job_id desc; -- 내림차순
select * from employees order by job_id desc,salary asc; -- job_id 우선 정렬, job_id가 같은경우 내에서 salary로 정렬
```
