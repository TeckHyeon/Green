SELECT
    *
FROM
    (
        SELECT
            *
        FROM
            employees
        WHERE
            department_id IN ( 50, 80, 60, 90 )
    ) t
WHERE
    salary >= 10000;

SELECT
    employee_id                               사번,
    first_name
    || ' '
    || last_name                              이름,
    to_char(hire_date, 'YYYY"년"-MM"월"-DD"일"') 입사일
FROM
    employees
WHERE
    to_char(hire_date, 'MM') = '08';


-- 08월 입사자의 인원수
SELECT
    to_char(hire_date, 'MM')
    || '월'  입사달,
    COUNT(*)
    || ' 명' AS 직원수
FROM
    employees
WHERE
    to_char(hire_date, 'MM') = '08'
GROUP BY
    to_char(hire_date, 'MM')
ORDER BY
    to_char(hire_date, 'MM');

--  입사후 일주일이내인 직원명단
SELECT
    employee_id   번호,
    first_name
    || ' '
    || last_name  이름,
    salary        월급,
    department_id 부서번호,
    hire_date     입사일
FROM
    employees

-- where hire_date between sysdate -7 and sysdate;
WHERE
    hire_date >= sysdate - 7;

--  입사일 기준 년도별 인원수
SELECT
    to_char(hire_date, 'YYYY')
    || '년'  입사연도,
    COUNT(*)
    || ' 명' AS 직원수
FROM
    employees
GROUP BY
    to_char(hire_date, 'YYYY')
ORDER BY
    to_char(hire_date, 'YYYY');

--  입사일기준 월별 인원수, 2017년 기준 
SELECT
    to_char(hire_date, 'MM')
    || '월'  입사월,
    COUNT(*)
    || ' 명' AS 직원수
FROM
    employees
WHERE
    to_char(hire_date, 'YYYY') = '2017'
GROUP BY
    to_char(hire_date, 'MM')
ORDER BY
    to_char(hire_date, 'MM');

--  직원수, 직원월급합, 직원월급평균
SELECT
    COUNT(*),
    COUNT(salary),
    SUM(salary),
    round(AVG(salary),
          3),
    round(SUM(salary) / COUNT(employee_id),
          3),
    round(SUM(salary) / COUNT(salary),
          3)
FROM
    employees;

SELECT
    department_id      부서번호,
    COUNT(employee_id) 인원수,
    SUM(salary)        월급합,
    round(AVG(salary),
          3)           월급평균
FROM
    employees
WHERE
    department_id IN ( 60, 50, 90 )
GROUP BY
    department_id;

--부서별 월급 평균
SELECT
    department_id 부서번호,
    round(AVG(salary),
          3)      월급평균
FROM
    employees
GROUP BY
    department_id
ORDER BY
    department_id NULLS LAST;

SELECT
    department_id      부서번호,
    COUNT(employee_id) 인원수,
    SUM(salary)        월급합
FROM
    employees
GROUP BY
    department_id
ORDER BY
    department_id;

SELECT
    department_id      부서번호,
    COUNT(employee_id) 인원수,
    SUM(salary)        월급합
FROM
    employees
GROUP BY
    department_id
HAVING
    COUNT(employee_id) >= 5
ORDER BY
    department_id;

select department_id, department_name
from departments
where department_id in (
SELECT
    department_id      부서번호
FROM
    employees
GROUP BY
    department_id
HAVING
    SUM(salary) >= 20000);


SELECT
    department_id      부서번호,
    COUNT(employee_id) 인원수,
    SUM(salary)        월급합
FROM
    employees
GROUP BY
    department_id
HAVING
    SUM(salary) >= 20000
ORDER BY
    월급합;

SELECT
    job_id        직업번호,
    COUNT(job_id) 인원수
FROM
    employees
GROUP BY
    job_id;

SELECT
    COUNT(DISTINCT job_id) 직업수
FROM
    employees;


-- 부서별 최대 월급이 14000 이상인 부서의 부서번호와 최대월급
--  부서별 모우고 같은부서는 직업별 인원수, 월급평균 
SELECT
    department_id      부서번호,
    COUNT(employee_id) 인원수,
    MAX(salary)
FROM
    employees
GROUP BY
    department_id
HAVING
    MAX(salary) >= 14000;

SELECT
    COUNT(job_id) 인원수,
    round(AVG(salary),
          3)      월급평균
FROM
    employees
GROUP BY
    department_id;

SELECT
    e.employee_id     사번,
    e.first_name
    || ' '
    || e.last_name    이름,
    e.hire_date       입사일,
    d.department_name 부서명
FROM
    employees   e,
    departments d
WHERE
    ( e.department_id = d.department_id )
    AND d.department_name = 'IT';