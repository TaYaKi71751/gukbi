# SQL Queries for SCOTT Schema

## 1. 사원들의 이름과 사번을 출력해보자.
```sql
SELECT e.ename, e.empno
FROM emp e;
```

## 2. job이 CLERK인 사원들의 이름과 부서명을 출력해 보자.
```sql
SELECT e.ename, d.dname
FROM emp e
JOIN dept d ON e.deptno = d.deptno
WHERE e.job = 'CLERK';
```

## 3. 연봉이 2600이상인 사원의 이름과 부서명을 출력해 보자.
```sql
SELECT e.ename, d.dname
FROM emp e
JOIN dept d ON e.deptno = d.deptno
WHERE e.sal >= 2600;
```

## 4. 사원 이름과 급여와 급여등급(호봉)을 출력해 보자.
```sql
SELECT e.ename, e.sal, s.grade
FROM emp e
JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal;
```

## 5. 사원의 봉급과 상사의 봉급을 출력해 보자.
```sql
SELECT e.sal      AS emp_sal,
       m.sal      AS mgr_sal
FROM emp e
LEFT JOIN emp m ON e.mgr = m.empno;
```

## 6. 사원번호와 관리자의 사원번호를 출력해보자. (관리자가 없어도 출력)
```sql
SELECT e.empno,
       m.empno   AS mgr_empno
FROM emp e
LEFT JOIN emp m ON e.mgr = m.empno;
```

## 7. 사원이름과 사원이 다니는 부서명을 출력해보자.  
#### 단, 사원이 존재하지 않는 부서는 부서명만 출력해 보자.
```sql
SELECT e.ename,
       d.dname
FROM dept d
LEFT JOIN emp e ON d.deptno = e.deptno;
```

## 8. 부서번호가 20인 사원의 사번, 부서번호, 부서위치를 출력해 보자.
```sql
SELECT e.empno, d.deptno, d.loc
FROM emp e
JOIN dept d ON e.deptno = d.deptno
WHERE d.deptno = 20;
```
