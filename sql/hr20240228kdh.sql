-- JOIN : 나누어져있는 테이블에서 필요한 칼럼(열)만 몰아서 원하는 DATA를 만든다
--------  두개이상의 테이블에 필요한 정보를 모아서 새로운 테이블 생성
-- OLD 표현법
SELECT
    "A1"."DEPARTMENT_NAME" "부서명",
    "A2"."FIRST_NAME"
    || ' '
    || "A2"."LAST_NAME"    "부서직원이름",
    "A2"."DEPARTMENT_ID"   "부서번호"
FROM
    "HR"."EMPLOYEES"   "A2",
    "HR"."DEPARTMENTS" "A1"
WHERE
    "A2"."DEPARTMENT_ID" = "A1"."DEPARTMENT_ID"
ORDER BY
    "A1"."DEPARTMENT_NAME";
    -- 우리회사 부서수
SELECT
    COUNT(*)
FROM
    departments; -- 27
 -- 우리회사 직원수
SELECT
    COUNT(*)
FROM
    employees; -- 109
-- 직원이 근무하는 부서수
SELECT COUNT(DISTINCT DEPARTMENT_ID) FROM EMPLOYEES; -- 11

// RIGHT OUTER JOIN - 출력기준은 직원 정보 (직원은 오른쪽)

-- 모든 직원정보 출력
-- 부서명 있으면 출력하고 없으면 NULL로 표시
SELECT D.DEPARTMENT_NAME 부서명,
    "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME"
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID(+) = E.DEPARTMENT_ID
ORDER BY D.DEPARTMENT_NAME ASC;
-- 해당 직원이 있으면 직원 이름 출력 해당 직원이 없으면 NULL
SELECT D.DEPARTMENT_NAME 부서명,
    "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID(+)
ORDER BY D.DEPARTMENT_NAME ASC; -- 122명 (106명 + 직원이 없는 16개부서)

-- FULL OUTER JOIN : OLD 문법에는 해당명령이 없다
-- WHERE D>DEPARTMENT_ID(+) = E.DEPARTMENT_ID(+) : ERROR

-- NEW 표현법
-- cartesian product
-- CROSS JOIN - 조건 없는 JOIN : 실험실 LEVEL 조인 DATA 생성할 때 사용
SELECT D.DEPARTMENT_NAME 부서명,
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM DEPARTMENTS D CROSS JOIN EMPLOYEES E;

--INNER JOIN == JOIN
SELECT D.DEPARTMENT_NAME 부서명,
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM DEPARTMENTS D INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;

--LEFET OUTER JOIN == LEFT JOIN
// 직원명 기준으로 부서명, 직원명
SELECT 
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명,
D.DEPARTMENT_NAME 부서명
FROM EMPLOYEES E LEFT JOIN DEPARTMENTS D ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;
//똑같다
SELECT D.DEPARTMENT_NAME 부서명,
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM DEPARTMENTS D RIGHT JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;

--RIGHT OUTER JOIN == RIGHT JOIN
//부서명 기준으로
SELECT D.DEPARTMENT_NAME 부서명,
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM EMPLOYEES E RIGHT JOIN DEPARTMENTS D ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;

SELECT D.DEPARTMENT_NAME 부서명,
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM DEPARTMENTS D LEFT JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;

--FULL OUTER JOIN == FULL JOIN
SELECT D.DEPARTMENT_NAME 부서명,
      "E"."FIRST_NAME"
    || ' '
    || "E"."LAST_NAME" 직원명
FROM DEPARTMENTS D FULL JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;

--  부서명, 부서위치      
SELECT  D.DEPARTMENT_NAME 부서명,
        L.CITY
        || ' '
        || L.STREET_ADDRESS 
        || ' '
        || l.state_province 부서위치
FROM DEPARTMENTS D INNER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID;
--  직원명, 부서명, 부서위치     
SELECT  E.FIRST_NAME
        || ' '
        || E.LAST_NAME 직원이름,
        D.DEPARTMENT_NAME 부서명,
        L.CITY
        || ' '
        || L.STREET_ADDRESS 부서위치
FROM DEPARTMENTS D 
INNER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID;
--  직원명, 부서위치 (단 IT 부서를)
SELECT  E.FIRST_NAME
        || ' '
        || E.LAST_NAME 직원이름,
        D.DEPARTMENT_NAME 부서명,
        L.CITY
        || ' '
        || L.STREET_ADDRESS 부서위치
FROM DEPARTMENTS D 
INNER JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
INNER JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
WHERE D.DEPARTMENT_NAME = 'IT';
--  부서명별 월급평균
SELECT  D.DEPARTMENT_NAME 부서명,
        ROUND(AVG(E.salary), 3) 월급평균
FROM DEPARTMENTS D 
LEFT JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID 
group by D.DEPARTMENT_ID, D.DEPARTMENT_NAME
ORDER BY d.department_name asc;
--  직원명, 담당업무, 담당업무 히스토리
SELECT EMPLOYEE_ID ,
START_DATE ,
END_DATE ,
JOB_ID ,
DEPARTMENT_ID  FROM job_history;

SELECT  E.employee_id 직원번호,
        E.FIRST_NAME
        || ' '
        || E.LAST_NAME 직원이름,
        j.JOB_TITLE 담당업무,
        h.start_date 업무시작날짜,
        h.end_date 업무종료날짜
FROM EMPLOYEES E
INNER JOIN JOBS J ON e.job_id = j.job_id
INNER JOIN JOB_HISTORY H ON j.job_id = h.job_id
order by e.employee_id;


SELECT 직원번호 ,
직원이름 ,
담당업무 ,
업무시작날짜 ,
업무종료날짜  
FROM(
        SELECT  E.employee_id 직원번호,
                E.FIRST_NAME
                || ' '
                || E.LAST_NAME 직원이름,
                j.JOB_TITLE 담당업무,
                h.start_date 업무시작날짜,
                h.end_date 업무종료날짜
        FROM EMPLOYEES E
        INNER JOIN JOBS J ON e.job_id = j.job_id
        INNER JOIN JOB_HISTORY H ON e.employee_id = h.employee_id
        UNION
        SELECT  E.employee_id 직원번호,
                E.FIRST_NAME
                || ' '
                || E.LAST_NAME 직원이름,
                j.JOB_TITLE 담당업무,
                h.start_date 업무시작날짜,
                h.end_date 업무종료날짜
        FROM JOB_HISTORY H
        INNER JOIN JOBS J ON h.job_id = j.job_id
        INNER JOIN Employees e ON e.employee_id = h.employee_id) T
ORDER BY T.직원번호;

--  JOB_HISTORY 에  2건 이상 등록된 직원번호, 잡의 갯수 통계 
SELECT employee_id, count(job_id)
FROM JOB_HISTORY
GROUP BY employee_id
HAVING COUNT(job_id)>=2;
--  JOB_HISTORY 에  2건 이상 등록된 직원번호, 직원이름, 잡의 갯수 통계 
SELECT h.employee_id, e.first_name, COUNT(H.JOB_ID)
FROM JOB_HISTORY H INNER JOIN employees E ON H.employee_id = E.employee_id
GROUP BY H.employee_id, e.first_name
HAVING COUNT(H.employee_id)>=2;

SELECT T.직원번호, e.first_name || e.last_name, t.잡의갯수
FROM
( 
    SELECT JH.employee_id 직원번호, COUNT(JH.JOB_ID) 잡의갯수
    FROM job_history JH
    GROUP BY jh.employee_id
    HAVING COUNT(JH.JOB_ID) >=2
    ORDER BY jh.employee_id
    ) T, EMPLOYEES E
    WHERE T.직원번호 = e.employee_id;

--  직원명, 부서명, 회사주소, 국가, REGION
SELECT  E.FIRST_NAME
        || ' '
        || E.LAST_NAME 직원명,
        D.DEPARTMENT_NAME 부서명,
        L.CITY
        || ' '
        || L.STREET_ADDRESS 회사주소,
        C.COUNTRY_NAME 국가,
        r.region_name REGION
FROM DEPARTMENTS D 
right JOIN EMPLOYEES E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID
LEFT JOIN LOCATIONS L ON D.LOCATION_ID = L.LOCATION_ID
LEFT JOIN COUNTRIES C ON c.country_id = l.country_id
LEFT JOIN regions R ON r.region_id = c.region_id;