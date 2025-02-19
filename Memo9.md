```
-- department_id,location_id,department_name,city 를 출력 해보자
select departments.department_id,departments.location_id,departments.department_name,locations.city 
from departments,locations 
where departments.location_id = locations.location_id;
```
```
-- group by
select * from employees;
select * from employees where salary is null;
select avg(salary) from employees;
select avg(salary) from employees;
select * from employees order by department_id;

select department_id,round(avg(salary)) from employees group by department_id order by department_id;

-- 매니저가 같은 사원들의 총 급여, 매니저가 관리하는 사원 수
select manager_id,sum(salary),count(employee_id) from employees group by manager_id;
```
```
-- 급여가 3000 이상의 사원 중에서 job_id가 같은 사원의 급여 총합이 20000 이상인
-- job_id와 급여의 총합을 job_id 알파벳 순으로 출력
select job_id,sum(salary),count(salary) 
from employees 
where salary >= 3000 
group by job_id 
having sum(salary) >= 20000
order by job_id asc;
```
```
-- self join
select * from employees;
select employee_id,first_name,manager_id from employees 사원 order by employee_id;
select employee_id,first_name from employees 관리자 order by employee_id;

select 사원.employee_id,사원.first_name,관리자.employee_id,관리자.first_name
from employees 사원,employees 관리자 
where 사원.manager_id=관리자.employee_id 
order by 관리자.employee_id;
```
4. outer join
```
outer join(외부 조인)
두 테이블을 이퀴 조인할때 선택된 두 컬럼에 일치하는 값이 들어 있지 않다면 이퀴 조인 결과 매칭되는 데이터가 없으므로 출력 되지 않는다. 
만약 한쪽 테이블에만 있는 데이터를 사라지지 않고 출력을 원한다면 없는쪽 테이블 컬럼의 데이터에 null를 넣어 출력해야 하는데 이렇게 이퀴조인시 일치하는 데이터가 없을때 
한쪽 컬럼에 null를 넣어 출력하는 방법을 외부 조인이라고 한다
```
```
select count(*) from employees;
-- 107

select count(*) from employees,departments
where employees.department_id = departments.department_id;
-- 106
```
```
-- outer join

-- left outer join
-- 178번 부서가 없는 사원도 부서에 null을 채워서 출력
select * from employees,departments
where employees.department_id = departments.department_id(+);
select count(*) from employees,departments
where employees.department_id = departments.department_id(+);
-- 107

select distinct departments.department_id from employees,departments
where employees.department_id = departments.department_id(+); -- 11

select * from departments; -- 27

-- right outer join
select count(*) from employees,departments
where employees.department_id(+) = departments.department_id; -- 122 (27-11=16개 부서가 사원이 없음)
-- 122 = 106 + 16
```
```
-- outer join

-- ansi 표준
-- full outer join
select count(*) from employees full outer join departments
on employees.department_id = departments.department_id; -- 123

-- left outer join
select count(*) from employees left outer join departments
on employees.department_id = departments.department_id;

-- right outer join
select count(*) from employees right outer join departments
on employees.department_id = departments.department_id;
```
