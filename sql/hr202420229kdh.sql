//부서명, 해당 부서의 팀장 이름
SELECT  D.DEPARTMENT_NAME 부서명,
        E.FIRST_NAME || ' ' || E.LAST_NAME 팀장이름
FROM    DEPARTMENTS D, EMPLOYEES E
WHERE   D.MANAGER_ID = E.EMPLOYEE_ID;

SELECT  D.DEPARTMENT_NAME 부서명,
        E.FIRST_NAME || ' ' || E.LAST_NAME 팀장이름
FROM    DEPARTMENTS D, EMPLOYEES E
WHERE   D.MANAGER_ID = E.EMPLOYEE_ID(+);

-- SELF JOIN - 자신의 TABLE을 JOIN의 대상으로
//직원번호, 직원이름, 상사번호,상사이름
SELECT  E1.FIRST_NAME || ' ' || E1.LAST_NAME 직원이름,
        E2.FIRST_NAME || ' ' || E2.LAST_NAME 상사이름
FROM    EMPLOYEES E1, EMPLOYEES E2
WHERE   E1.MANAGER_ID = E2.EMPLOYEE_ID
ORDER BY E2.EMPLOYEE_ID;

--계층형 쿼리 - 계층구조 hierarchy
--LEVEL : 계층형 쿼리의 레벨을 구하는 예약어
//직원번호, 직원명, 레벨, 부서명
SELECT  e.employee_id 직원번호,
        LPAD(' ', 3*LEVEL-3) || E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        LEVEL 레벨,
        d.department_name 부서명
FROM EMPLOYEES E, DEPARTMENTS D
WHERE e.department_id = d.department_id
Start with e.manager_id IS NULL
CONNECT by prior e.employee_id = e.manager_id;

--START WITH : 시작점
-- CONNECT BY PRIOR - 연결 조건
-- LEVEL : 계층형 구조에서만 사용하는 의사칼럼

-- 등가 조인 : EQUI JOIN - 조인의 조건이 = 인 것
-- 비등가 조인 : NON-EQUI JOIN - 조인의 조건이 = 아닌 것
// 직원등급 
//  월급                  등급
//  20000 초과             S
//  15001~20000            A0
//  10001~15001            B
//  5001~10000             C
//  3001~5000              D
//  0~3000                 E
// 직원번호 직원명 월급 등급

SELECT  E.employee_id 직원번호,
        E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        E.salary 월급,
        case    when E.salary > 20000 Then 'S'
                when E.salary <= 20000 AND E.salary >= 15001 Then 'A'
                when E.salary <= 15000 AND E.salary >= 10001 Then 'B'
                when E.salary <= 10000 AND E.salary >= 5001 Then 'C'
                when E.salary <= 5000 AND E.salary >= 3001 Then 'D'
                when E.salary <= 3000 AND E.salary >= 0 Then 'E'
                ELSE '측정불가'
        END 등급
FROM employees E;

CREATE TABLE SALGRADE
(
    GRADE VARCHAR2(1) PRIMARY KEY
    ,LOSAL NUMBER(10)
    ,HISAL NUMBER(10)
);
INSERT INTO SALGRADE VALUES ('S',20001,9999999999);
INSERT INTO SALGRADE VALUES ('A',15001,20000);
INSERT INTO SALGRADE VALUES ('B',10001,15000);
INSERT INTO SALGRADE VALUES ('C',5001,10000);
INSERT INTO SALGRADE VALUES ('D',3001,5000);
INSERT INTO SALGRADE VALUES ('E',0,3000);
COMMIT;

SELECT * FROM SALGRADE;

SELECT  E.employee_id 직원번호,
        E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        E.salary 월급,
        s.grade 등급
FROM employees E, salgrade s
WHERE e.salary between s.losal AND s.hisal
order by e.salary desc;

----------------
---- JOIN
SELECT  E.employee_id 직원번호,
        E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        E.salary 월급,
        s.grade 등급
FROM employees E
JOIN salgrade s ON e.salary between s.losal AND s.hisal
order by e.salary desc;

---- OUTER JOIN
SELECT  E.employee_id 직원번호,
        E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        E.salary 월급,
        s.grade 등급
FROM employees E
LEFT JOIN salgrade s ON e.salary between s.losal AND s.hisal
order by e.salary desc;

---- OUTER JOIN 문제있는 월급없는 직원은 미책정

SELECT  E.employee_id 직원번호,
        E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        nvl(to_char(e.salary),'미책정') 월급,
        nvl(s.grade,'미책정') 등급
        FROM employees E
LEFT JOIN salgrade s ON e.salary between s.losal AND s.hisal
order by e.salary desc;

SELECT  E.employee_id 직원번호,
        E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,
        nvl(to_char(e.salary),'미책정') 월급,
        RANK() OVER (ORDER BY nvl(E.salary,0) desc) 랭크
        FROM employees E
order by 랭크;

-- 분석함수와 WINDOW 함수
-- 1. 10개만 출력
// 전체
SELECT employee_id, first_name, last_name, salary
from employees
order by salary desc nulls last;

// 10개만 출력
-- 1)
SELECT rownum,employee_id, first_name, last_name, salary
from employees
-- where rownum BETWEEN 1 and 10
order by salary desc nulls last;
-- 정렬이 되면 rownum 순서로 나오지 않으므로 사용이 어렵다;;
-- 2)
SELECT rownum, t.*
from (SELECT employee_id, first_name, last_name, salary
from employees
order by salary desc nulls last
) t
where rownum BETWEEN 1 and 10;

-- 3) ANSI 문법 : NEW
-- ROW_NUMBER() : 모든 RDB 사용가능
select *
from(
SELECT row_number() over(order by salary desc nulls last) RN,employee_id, first_name, last_name, salary
from employees) t
where rn between 1 and 10;
-- where rownum BETWEEN 1 and 10

-- MYSQL 페이징
-- SELECT * FROM TABLE1 LIMIT 1, 10; 페이징 속도가 빠름

-- 12C 부터 가능
SELECT *
FROM employees
ORDER BY employee_id
OFFSET 1 ROWS fetch next 10 rows only; -- 속도가 빠름

-------------
-- 석차 RANK(), DENSE_RANK()
//월급 1등부터 10등까지
SELECT  employee_id 직원번호,
        FIRST_NAME || ' ' || LAST_NAME 직원명,
        salary 월급,
        RANK() OVER(ORDER by salary desc nulls last) 순위
from employees;
--------------
-- ORACLE DATABASE 생성
-- 계정생성 -> 계정이 관리하는 TABLESPACE 안의 TABLE에 데이터가 저장된다.

-- 1) 테이블생성
-- 1. 테이블 복사 : hr
-- 대상 : 테이블 구조, 데이터 (제약조건 일부만 복사(not null))
create table EMP1
AS
SELECT * FROM EMPLOYEES;
-- 대상 : 테이블 구조, 데이터 (제약조건 일부만 복사(not null))
create table EMP2
AS
SELECT * FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (50, 80);
-- 구조만 복사, DATA 빼고
create table EMP3
AS
SELECT * FROM EMPLOYEES
WHERE 1=0;
-- 구조만 복사한후에
create table EMP4
AS
SELECT * FROM EMPLOYEES
WHERE 1=0;
--data만 추가하는 방법
INSERT INTO EMP4 SELECT*FROM employees;
commit;
--- 일부 칼럼만 복사해서 새로운 테이블 생성
CREATE TABLE EMP5 
AS
 SELECT EMPLOYEE_ID EMPID,
        FIRST_NAME || ' ' || LAST_NAME ENAME,
        SALARY                         SAL,
        SALARY * COMMISSION_PCT        COMM,
        MANAGER_ID                     MGR,
        DEPARTMENT_ID                   DEPTID
 FROM EMPLOYEES;
 ---SQLDEVELOPER 메뉴에서 TABLE 생성 수정 추가
 
 --- SQL SCRIPT로 테이블 생성
 
 --- 테이블 제거 - 구조와 DATA 제거됨 영구적으로
 DROP TABLE EMP1;
 DROP TABLE CASCADE; -- 관련된 db가 있어도 삭제 가능
 DROP TABLE EMPLOYEES; -- 삭제안됨 : 외래키에 설정된 DATA가 있을 떄 오류발생 후 삭제 안됨
 -- ORA-02449: 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다
 -- 02449. 00000 -  "unique/primary keys in table referenced by foreign keys"
 
 -- 구조(테이블) 변경
 -- 칼럼추가
    ALTER TABLE EMP5
        ADD( LOC VARCHAR2(6) ); -- 추가된 DATA NULL
 --칼럼제거
    ALTER TABLE EMP5 DROP COLUMN LOC;
 --테이블 이름 변경
    RENAME EMP4 TO NEWMP;
 --칼럼속성변경
    ALTER TABLE EMP5
    MODIFY (ENAME VARCHAR2(60));