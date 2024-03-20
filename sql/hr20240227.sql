-- SUBQUERY
 쿼리문안에 쿼리문이 들어간 경우 () 안에 표현
 
 
-- INLINE VIEW : FROM 문 뒤에 ( SELECT )
SELECT * 
  FROM
  ( SELECT  *
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID IN (50, 80, 60, 90) 
  ) T
  WHERE   SALARY >= 10000;
    
 --------------------------------
  08월 입사자의  사번, 이름, 입사일
  SELECT   EMPLOYEE_ID                                   사번, 
           FIRST_NAME || ' ' || LAST_NAME                이름, 
           TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"')  입사일
   FROM    EMPLOYEES  
   WHERE   TO_CHAR(HIRE_DATE, 'MM') = '08';
  
  08월 입사자의 인원수
  SELECT   COUNT(EMPLOYEE_ID)   인원수 
   FROM    EMPLOYEES  
   WHERE   TO_CHAR(HIRE_DATE, 'MM') = '02';
    
  입사후 일주일이내인 직원명단
  SELECT       EMPLOYEE_ID                         사번,
               FIRST_NAME || ' ' || LAST_NAME      이름, 
               TO_CHAR(HIRE_DATE, 'YYYY-MM-DD')    입사일 
   FROM        EMPLOYEES
   -- WHERE       HIRE_DATE  BETWEEN  SYSDATE - 7 AND SYSDATE;  
   WHERE       HIRE_DATE >= SYSDATE - 7;
     
------------------------------
-- ~별 인원수
  집계함수  COUNT(), SUM(), AVG(), MIN(), MAX()
  그룹핑    GROUP BY
  
  -- 직원수, 월급합, 월급평균
  -- 109	691416	6461.831775700934579439252336448598130841
  SELECT    COUNT(*), COUNT(SALARY), 
            SUM(SALARY), 
            ROUND(AVG(SALARY), 3),
            ROUND( SUM(SALARY) / COUNT(EMPLOYEE_ID), 3) ,
            ROUND( SUM(SALARY) / COUNT(SALARY), 3)
   FROM     EMPLOYEES ;
 
  -- 부서 60번 부서 인원수, 월급합, 월급평균
  SELECT    COUNT(EMPLOYEE_ID), SUM(SALARY), ROUND(AVG(SALARY), 3)
   FROM     EMPLOYEES
   WHERE    DEPARTMENT_ID = 50;
   
   -- 부서별 60, 50, 90 의  인원수, 월급합, 월급평균
   -- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
   --    00937. 00000 -  "not a single-group group function"
   SELECT       DEPARTMENT_ID             부서번호,
                COUNT(EMPLOYEE_ID)        인원수, 
                SUM(SALARY)               월급합, 
                ROUND(AVG(SALARY), 3)     월급평균 
    FROM        EMPLOYEES
    WHERE       DEPARTMENT_ID  IN ( 60, 50, 90  ) ; -- ERROR
   
   -- 정상적으로 출력 
   SELECT       DEPARTMENT_ID             부서번호,
                COUNT(EMPLOYEE_ID)        인원수, 
                SUM(SALARY)               월급합, 
                ROUND(AVG(SALARY), 3)     월급평균 
    FROM        EMPLOYEES
    WHERE       DEPARTMENT_ID  IN ( 60, 50, 90  )
    GROUP BY    DEPARTMENT_ID ;    -- 부서별
  
  입사일 기준 년도별 인원수
  SELECT      TO_CHAR( HIRE_DATE,  'YYYY' )   입사연도,
              COUNT( EMPLOYEE_ID )            인원수
   FROM       EMPLOYEES  
   GROUP BY   TO_CHAR( HIRE_DATE,  'YYYY' )
   ORDER BY   TO_CHAR( HIRE_DATE,  'YYYY' );
    
  입사일기준 월별 인원수, 2017년 기준 
  SELECT       TO_CHAR( HIRE_DATE, 'MM' )    월, 
               COUNT( EMPLOYEE_ID )          인원수
   FROM        EMPLOYEES
    -- WHERE       TO_CHAR( HIRE_DATE, 'YYYY' )  = '2017'  
   GROUP BY    TO_CHAR( HIRE_DATE, 'MM' )
    HAVING       TO_CHAR( HIRE_DATE, 'YYYY' )  = '2017'  
   ORDER BY    TO_CHAR( HIRE_DATE, 'MM' );
  
  입사일에 해당되는 달의 첫번째 날짜와 마지막 날짜를 출력 
  SELECT   EMPLOYEE_ID                          사번, 
           FIRST_NAME ||  ' ' || LAST_NAME      이름, 
           HIRE_DATE                            입사일, 
           TRUNC(HIRE_DATE, 'MONTH')            입사월첫날, 
           LAST_DAY( HIRE_DATE )                입사월마지막날
   FROM    EMPLOYEES;
  
  현재 시간이 오전인지 오후인지를 출력
  SELECT  SYSDATE,
          TO_CHAR( SYSDATE, 'AM' ),
          TO_CHAR( SYSDATE, 'HH12:MI:SS AM' )
   FROM   DUAL;
  
  부서별 월급 평균
  SELECT      DEPARTMENT_ID                          부서번호, 
              ROUND(AVG(SALARY),   3)                월급평균,
              TO_CHAR(AVG(SALARY), 'L999,990.000')   월급평균
   FROM       EMPLOYEES
   GROUP BY   DEPARTMENT_ID
   ORDER BY   DEPARTMENT_ID  NULLS LAST;   -- NULLS FIRST
        
  부서별 20, 50, 60, 80 만  월급 평균    
   SELECT      DEPARTMENT_ID                          부서번호, 
              ROUND(AVG(SALARY),   3)                월급평균,
              TO_CHAR(AVG(SALARY), 'L999,990.000')   월급평균
   FROM       EMPLOYEES
   WHERE      DEPARTMENT_ID  IN  ( 20, 50, 60, 80  )
   GROUP BY   DEPARTMENT_ID
   ORDER BY   DEPARTMENT_ID  NULLS LAST;   -- NULLS FIRST
    
  부서별 인원수, 월급합  
  SELECT      DEPARTMENT_ID           부서번호, 
              COUNT(EMPLOYEE_ID)      인원수, 
              SUM(SALARY)             월급합  
   FROM       EMPLOYEES
   GROUP BY   DEPARTMENT_ID
   ORDER BY   DEPARTMENT_ID;
     
  부서별 사원수  
  SELECT      DEPARTMENT_ID           부서번호, 
              COUNT(EMPLOYEE_ID)      인원수 
   FROM       EMPLOYEES
   GROUP BY   DEPARTMENT_ID
   ORDER BY   DEPARTMENT_ID;
  
  
  부서별 사원수가 5명 이상인 부서번호 
  -- ORA-00934: 그룹 함수는 허가되지 않습니다
   --  00934. 00000 -  "group function is not allowed here"
  SELECT      DEPARTMENT_ID           부서번호, 
              COUNT(EMPLOYEE_ID)      인원수 
   FROM       EMPLOYEES
   WHERE      COUNT(EMPLOYEE_ID) >= 5    -- WHERE 안에 그룹함수 사용 불가
   GROUP BY   DEPARTMENT_ID
   ORDER BY   DEPARTMENT_ID;  -- ERROR
   
    
  SELECT      DEPARTMENT_ID           부서번호, 
              COUNT(EMPLOYEE_ID)      인원수 
   FROM       EMPLOYEES   
   GROUP BY   DEPARTMENT_ID
     HAVING   COUNT(EMPLOYEE_ID) >= 5    -- 그룹을 만들때 사용하는 조건(일반조건,그룹함수 다가능)
   ORDER BY   DEPARTMENT_ID;
  
  부서별 월급총계가 20000 이상인 부서
  SELECT       DEPARTMENT_ID      부서번호
            -, SUM(SALARY)        월급총계
   FROM        EMPLOYEES  
   GROUP  BY   DEPARTMENT_ID
    HAVING      SUM(SALARY)   >= 20000
   ORDER  BY   DEPARTMENT_ID ;

 1) 부서별 월급총계가 20000 이상인 부서번호  
  SELECT      DEPARTMENT_ID    부서번호
   FROM       EMPLOYEES
   GROUP  BY  DEPARTMENT_ID 
    HAVING     SUM(SALARY) >= 20000;
    -- 90, 60, 100,30, 50 , 80, 110
  
  2)   90, 60, 100,30, 50 , 80, 110 부서의 부서번호, 부서이름
  SELECT   DEPARTMENT_ID, DEPARTMENT_NAME
   FROM    DEPARTMENTS
   WHERE   DEPARTMENT_ID IN ( 90, 60, 100,30, 50 , 80, 110 );
    
  1) +  2)  부서별 월급총계가 20000 이상인 부서번호, 부서이름
  SUBQUERY  : 안쪽 쿼리에 ORDER BY 사용불가
  SELECT   DEPARTMENT_ID, DEPARTMENT_NAME
   FROM    DEPARTMENTS
   WHERE   DEPARTMENT_ID IN ( 
      SELECT      DEPARTMENT_ID    부서번호
       FROM       EMPLOYEES
       GROUP  BY  DEPARTMENT_ID 
       HAVING     SUM(SALARY) >= 20000  
   );
  
   
  JOB_ID 별 인원수 
  SELECT      JOB_ID,  COUNT(EMPLOYEE_ID)
   FROM       EMPLOYEES
   GROUP BY   JOB_ID;
   
  직업의 수 : JOB_ID 의 수
  
  -- JOBS   에 있는 JOB_ID 갯수 - 19 
  SELECT  COUNT(JOB_ID)
   FROM   JOBS;
   
  -- EMPLOYEES  에 있는 JOB_ID 갯수 - 109
  SELECT   COUNT(JOB_ID)
   FROM    EMPLOYEES;
   
   -- 직원의 JOB_ID  중복을 제거한 갯수 : EMPLOYEES  에 있는 JOB_ID 갯수 - 109
   SELECT   COUNT( DISTINCT JOB_ID  )
    FROM    EMPLOYEES;                  -- 19
    
  부서별 최대월급이 14000 이상인 부서의 부서번호와 최대월급
  SELECT       DEPARTMENT_ID    부서번호, 
               MAX(SALARY)      최대월급
   FROM        EMPLOYEES 
   --WHERE
   GROUP BY    DEPARTMENT_ID
    HAVING     MAX(SALARY)  >= 14000
   ORDER BY    DEPARTMENT_ID ;
  
  
  부서별 모우고 같은부서는 직업별 인원수, 월급평균 
  SELECT      DEPARTMENT_ID, JOB_ID, COUNT(EMPLOYEE_ID),  ROUND(AVG(SALARY), 3)
   FROM       EMPLOYEES           
   GROUP BY   DEPARTMENT_ID, JOB_ID
--   ORDER BY   DEPARTMENT_ID,  ROUND(AVG(SALARY), 3) DESC;
   ORDER BY  1,  4 DESC;
     
  IT부서 직원 출력(난이도 상)       
  1) DEPARTMENTS 에서 IT 부서의 부서번호
     SELECT    DEPARTMENT_ID
      FROM     DEPARTMENTS
      WHERE    UPPER(DEPARTMENT_NAME)  = 'IT';  -- 60
      
  2)  60 번 부서의 직원 명단 EMPLOYEES
     SELECT    EMPLOYEE_ID                     사번,
               FIRST_NAME || ' ' || LAST_NAME  이름,
               DEPARTMENT_ID
      FROM     EMPLOYEES
      WHERE    DEPARTMENT_ID = 60;
  
  1) + 2) SUB QUERY
     SELECT    EMPLOYEE_ID                     사번,
               FIRST_NAME || ' ' || LAST_NAME  이름,
               DEPARTMENT_ID
      FROM     EMPLOYEES
      WHERE    DEPARTMENT_ID = (
         SELECT    DEPARTMENT_ID
          FROM     DEPARTMENTS
          WHERE    UPPER(DEPARTMENT_NAME)  = 'IT'
      );
  
  'IT' 부서의 평균월급보다 많은 월급을 받는 사람명단
   1) 'IT' 부서번호 : 60
     SELECT   DEPARTMENT_ID
      FROM    DEPARTMENTS
      WHERE   UPPER(DEPARTMENT_NAME) = 'IT';
      
   2) ( 60 ) 부서의 평균월급 : 5760
     SELECT   AVG(SALARY)
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID = 60;
     
   3)  (5760) 보다 많은 월급받는 사람의 정보
     SELECT   EMPLOYEE_ID, SALARY, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   SALARY >= 5760;
  
   
   1) + 2) + 3) 
     SELECT   EMPLOYEE_ID, SALARY, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   SALARY >= (
         SELECT   AVG(SALARY)
          FROM    EMPLOYEES
          WHERE   DEPARTMENT_ID = (
              SELECT   DEPARTMENT_ID
               FROM    DEPARTMENTS
               WHERE   UPPER(DEPARTMENT_NAME) = 'IT'
          )      
      ) 
      AND   DEPARTMENT_ID = 50
      ;
  
  'IT' 부서와 'Shipping' 부서 직원명단 출력
  1) 'IT' 부서의 번호       : 60 
      SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME = 'IT'
  
  2) 'Shipping' 부서의 번호 : 50
     SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME = 'Shipping'
       
  1) + 2)
      SELECT   DEPARTMENT_ID
       FROM    DEPARTMENTS
       WHERE   DEPARTMENT_NAME = 'IT'
        OR     DEPARTMENT_NAME = 'Shipping'
  
  3)  직원명단
     SELECT   EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID = 60
       OR     DEPARTMENT_ID = 50;
       
     SELECT   EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID IN ( 60, 50 );
 
  결과 1 )
     SELECT   EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID IN ( 
        SELECT   DEPARTMENT_ID
         FROM    DEPARTMENTS
         WHERE   DEPARTMENT_NAME = 'IT'
          OR     DEPARTMENT_NAME = 'Shipping' 
     );
     
   결과 2 )
     SELECT   EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID IN ( 
        SELECT   DEPARTMENT_ID
         FROM    DEPARTMENTS
         WHERE   DEPARTMENT_NAME IN (  'IT', 'Shipping' )
     );  
     
     
    결과3) 
     SELECT   EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID = (
          SELECT   DEPARTMENT_ID
           FROM    DEPARTMENTS
           WHERE   DEPARTMENT_NAME = 'IT'
      )
      OR     DEPARTMENT_ID = (
        SELECT   DEPARTMENT_ID
         FROM    DEPARTMENTS
         WHERE   DEPARTMENT_NAME = 'IT'         
     );
     
   결과 4)  
   SELECT   EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME, DEPARTMENT_ID
      FROM    EMPLOYEES
      WHERE   DEPARTMENT_ID IN ( 
        (
          SELECT   DEPARTMENT_ID
           FROM    DEPARTMENTS
           WHERE   DEPARTMENT_NAME = 'IT'
         ),
       (
        SELECT   DEPARTMENT_ID
         FROM    DEPARTMENTS
         WHERE   DEPARTMENT_NAME = 'IT'         
       )  
     );
  
  
  1) + 2) + 3)
  
  
   직원이름, 부서번호, 부서명 - CASE WHEN
  
  
  
  
  
  
  
     