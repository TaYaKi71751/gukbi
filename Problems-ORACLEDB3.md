# SQL Queries with Subqueries

## 1. JAMES 사원의 부서이름을 출력해보자.

```sql
SELECT D.DNAME
FROM DEPT D
WHERE D.DEPTNO = (
    SELECT E.DEPTNO
    FROM EMP E
    WHERE E.ENAME = 'JAMES'
);
```

## 2. 평균 급여보다 많이 받는 사원의 이름과 급여를 이름과 급여순으로 내림차순 정렬 하시오.

```sql
SELECT E.ENAME, E.SAL
FROM EMP E
WHERE E.SAL > (
    SELECT AVG(SAL)
    FROM EMP
)
ORDER BY E.ENAME DESC, E.SAL DESC;
```

## 3. 10번 부서의 최대 급여와 같은 급여를 받는 사원번호와 이름 출력

```sql
SELECT E.EMPNO, E.ENAME
FROM EMP E
WHERE E.SAL = (
    SELECT MAX(SAL)
    FROM EMP
    WHERE DEPTNO = 10
);
```

## 4. 20번 부서의 최대 급여보다 많이 받는 사원 번호와 이름을 출력해 보자.

```sql
SELECT E.EMPNO, E.ENAME
FROM EMP E
WHERE E.SAL > (
    SELECT MAX(SAL)
    FROM EMP
    WHERE DEPTNO = 20
);
```

## 5. BLAKE를 상사로 가질 사원정보를 출력하시오.

```sql
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL
FROM EMP E
WHERE E.MGR = (
    SELECT E2.EMPNO
    FROM EMP E2
    WHERE E2.ENAME = 'BLAKE'
);
```

## 6. 부하직원이 있는 사원 정보를 출력하시오.

```sql
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL
FROM EMP E
WHERE E.EMPNO IN (
    SELECT DISTINCT MGR
    FROM EMP
    WHERE MGR IS NOT NULL
);
```

## 7. 부하직원이 없는 사원 정보를 출력하시오.

```sql
SELECT E.EMPNO, E.ENAME, E.JOB, E.SAL
FROM EMP E
WHERE E.EMPNO NOT IN (
    SELECT DISTINCT MGR
    FROM EMP
    WHERE MGR IS NOT NULL
);
```

