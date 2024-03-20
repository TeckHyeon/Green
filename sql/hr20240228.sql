  직원이름, 부서번호, 부서명 
  
  SELECT    FIRST_NAME || ' ' || LAST_NAME   직원이름, 
       --     DEPARTMENT_ID                    부서번호, 
            CASE   DEPARTMENT_ID
              WHEN  10  THEN  'Administration'
              WHEN  20	THEN  'Marketing'
              WHEN  30	THEN  'Purchasing'
              WHEN  40	THEN  'Human Resources'
              WHEN  50	THEN  'Shipping'
              WHEN  60	THEN  'IT'
              WHEN  70	THEN  'Public Relations'
              WHEN  80	THEN  'Sales'
              WHEN  90	THEN  'Executive'
              WHEN  100	THEN  'Finance'
              WHEN  110	THEN  'Accounting'
            END                              부서명 
   FROM     EMPLOYEES;
   
 -------------------------------------------
 -------------------------------------------
 -------------------------------------------
 -- JOIN : 나누어져이쓴 표(테이블)에서 필요한 칼럼(열)만 뽑아서 원하는 DATA 를 만든다
 ---       두개이상의 테이블에 필요한 정보를 모아서 새로운 표 생성
 
직원이름, 부서명
 
 -- ORACLE OLD 표현법
 CARTISSAN PRODUCT 
 SELECT    EMPLOYEE_ID       직원번호,    
           DEPARTMENT_NAME   부서명
  FROM     EMPLOYEES, DEPARTMENTS ;    -- 2943 : 109*27
  -- 비교 조건이 없어서 모든 직원과 모든 부서를 전부 매칭시킴
  
 SELECT 109*27 FROM DUAL; 
 
 INNER JOIN  - 양쪽 다 존재하는 DATA
 --ORA-00918: 열의 정의가 애매합니다
 -- 00918. 00000 -  "column ambiguously defined"
 SELECT    EMPLOYEE_ID       직원번호,    
           DEPARTMENT_NAME   부서명
  FROM     EMPLOYEES, DEPARTMENTS 
  WHERE    DEPARTMENT_ID = DEPARTMENT_ID; 
 
 SELECT    EMPLOYEE_ID          직원번호,    
           DEPARTMENT_NAME      부서명
  FROM     EMPLOYEES,           DEPARTMENTS 
  WHERE    EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;   
     -- 106 개 (109명 -3명(DEPARTMENT_ID가 NULL)
     
 SELECT    E.EMPLOYEE_ID          직원번호,    
           D.DEPARTMENT_NAME      부서명
  FROM     EMPLOYEES  E,    DEPARTMENTS  D 
  WHERE    E.DEPARTMENT_ID = D.DEPARTMENT_ID;    -- 106명  
  
부서명, 부서직원이름
SELECT      D.DEPARTMENT_NAME                     부서명, 
            E.FIRST_NAME || ' ' || E.LAST_NAME    부서직원이름
 FROM       DEPARTMENTS  D , EMPLOYEES  E
 WHERE      D.DEPARTMENT_ID  = E.DEPARTMENT_ID  
 ORDER BY   D.DEPARTMENT_NAME ASC;   -- 106 명
 
 부서명, 부서직원이름
우리회사 부서수
 SELECT COUNT(*) FROM  DEPARTMENTS;   -- 27
우리회사 직원수
 SELECT COUNT(*) FROM  EMPLOYEES;   -- 109
직원이 근무하는 부서수
 SELECT COUNT(DISTINCT DEPARTMENT_ID) FROM  EMPLOYEES;   -- 11
 
 RIGHT OUTER JOIN - 출력기준은 직원 정보(직원은 오른쪽)
 
 모든직원정보 출력 : 109명 출력
   부서명 있으면 출력하고 없으면 NULL 로 표시
    NULL 표시되는 조건에 (+) 표기
 
 SELECT      D.DEPARTMENT_NAME                    부서명, 
             E.FIRST_NAME || ' ' || E.LAST_NAME   직원명         
  FROM       DEPARTMENTS  D, EMPLOYEES E 
  WHERE      D.DEPARTMENT_ID(+) =  E.DEPARTMENT_ID
  ORDER  BY  D.DEPARTMENT_NAME ASC;          -- 109 명
 
 LEFT OUTER JOIN  
 모든 부서정보를 출력 
   해당직원이 있으면 직원이름 출력 해당직원이 없으면 NULL
   
 SELECT      D.DEPARTMENT_NAME                    부서명, 
             E.FIRST_NAME || ' ' || E.LAST_NAME   직원명         
  FROM       DEPARTMENTS  D, EMPLOYEES E 
  WHERE      D.DEPARTMENT_ID =  E.DEPARTMENT_ID(+)
  ORDER  BY  D.DEPARTMENT_NAME ASC;          -- 122 명 (106 명 +  16개부서)
 
 -- 모든 직원과 모든 부서를 출력
 FULL OUTER JOIN : OLD 문법에는 해당명령이 없다
   WHERE D.DEPARTMENT_ID(+) =  E.DEPARTMENT_ID(+) : ERROR
 
 
 -- NEW 표현법
  CARTISSAN PRODUCT 
  CROSS JOIN - 조건 없는 JOIN : 실험실 LEVEL 조인 DATA 생성할때 사용
  SELECT   D.DEPARTMENT_NAME                     부서명,  
           E.FIRST_NAME || ' ' || E.LAST_NAME    직원명
   FROM    DEPARTMENTS  D  CROSS JOIN  EMPLOYEES E;  -- 2943
 
 
  INNER JOIN         ==   JOIN
  양쪽 다 존재
  SELECT   D.DEPARTMENT_NAME                     부서명,  
           E.FIRST_NAME || ' ' || E.LAST_NAME    직원명
   FROM    DEPARTMENTS  D  INNER JOIN  EMPLOYEES E  ON  D.DEPARTMENT_ID = E.DEPARTMENT_ID; -- 106
   
   SELECT   D.DEPARTMENT_NAME                     부서명,  
            E.FIRST_NAME || ' ' || E.LAST_NAME    직원명
   FROM     DEPARTMENTS  D  JOIN  EMPLOYEES E  ON  D.DEPARTMENT_ID = E.DEPARTMENT_ID; -- 106
      
  ---
  직원명 기준으로 부서명, 직원명 - 109 명
  RIGHT OUTER JOIN    ==  RIGHT JOIN
  SELECT      D.DEPARTMENT_NAME                   부서명, 
              E.FIRST_NAME || ' ' || E.LAST_NAME  직원명
   FROM       DEPARTMENTS  D  RIGHT OUTER  JOIN  EMPLOYEES E
     ON       D.DEPARTMENT_ID  =  E.DEPARTMENT_ID
   ORDER BY   부서명 ASC;   
  
  LEFT OUTER JOIN   ==  RIGHT JOIN 
 SELECT       D.DEPARTMENT_NAME                   부서명, 
              E.FIRST_NAME || ' ' || E.LAST_NAME  직원명
   FROM       EMPLOYEES E LEFT OUTER  JOIN  DEPARTMENTS  D
     ON       D.DEPARTMENT_ID  =  E.DEPARTMENT_ID
   ORDER BY   부서명 ASC; 
  
  부서명을 중심으로 
  SELECT      D.DEPARTMENT_NAME                   부서명, 
              E.FIRST_NAME || ' ' || E.LAST_NAME  직원명
   FROM       DEPARTMENTS  D  LEFT JOIN  EMPLOYEES E            
    ON        D.DEPARTMENT_ID   =  E.DEPARTMENT_ID;   -- 122
    
  SELECT      D.DEPARTMENT_NAME                   부서명, 
              E.FIRST_NAME || ' ' || E.LAST_NAME  직원명
   FROM       EMPLOYEES E  RIGHT JOIN       DEPARTMENTS  D       
    ON        D.DEPARTMENT_ID   =  E.DEPARTMENT_ID;   -- 122
   
  FULL OUTER JOIN    ==  FULL  JOIN
  
  SELECT      D.DEPARTMENT_NAME                   부서명, 
              E.FIRST_NAME || ' ' || E.LAST_NAME  직원명
   FROM       EMPLOYEES E     FULL JOIN       DEPARTMENTS  D       
    ON        D.DEPARTMENT_ID   =  E.DEPARTMENT_ID;   -- 125 (109 + 27 - 11) 
  
  ----------------------

부서명, 부서위치   - OUTER JOIN 의미 없다
  1)
  SELECT   D.DEPARTMENT_NAME,
           STREET_ADDRESS || ' ' || CITY || ' ' || STATE_PROVINCE  || ' ' || COUNTRY_ID           
   FROM    DEPARTMENTS  D,  LOCATIONS  L  
   WHERE   D.LOCATION_ID  =  L.LOCATION_ID;
  
  2) 
  SELECT   D.DEPARTMENT_NAME,
           STREET_ADDRESS || ' ' || CITY || ' ' || STATE_PROVINCE  || ' ' || COUNTRY_ID           
   FROM    DEPARTMENTS  D  JOIN  LOCATIONS  L  
    ON   D.LOCATION_ID  =  L.LOCATION_ID;  

----  
  직원명, 부서명, 부서위치     
  1)  
  SELECT    E.EMPLOYEE_ID                             직원번호,
            E.FIRST_NAME   || ' ' ||  E.LAST_NAME     직원명,
            D.DEPARTMENT_NAME                         부서명,
            L.STREET_ADDRESS                          부서위치
   FROM     EMPLOYEES  E,  DEPARTMENTS  D,  LOCATIONS L    
   WHERE    E.DEPARTMENT_ID   =  D.DEPARTMENT_ID
    AND     D.LOCATION_ID     =  L.LOCATION_ID;
  
  2)
   SELECT    E.EMPLOYEE_ID                             직원번호,
            E.FIRST_NAME   || ' ' ||  E.LAST_NAME     직원명,
            D.DEPARTMENT_NAME                         부서명,
            L.STREET_ADDRESS                          부서위치
   FROM     EMPLOYEES  E 
              INNER JOIN  DEPARTMENTS  D  ON  E.DEPARTMENT_ID = D.DEPARTMENT_ID
              INNER JOIN  LOCATIONS L     ON  D.LOCATION_ID   = L.LOCATION_ID;
 
 ----
  직원명, 부서위치 (단 IT 부서를)    
  1)
    SELECT   E.FIRST_NAME  ||  ' ' ||  E.LAST_NAME    직원명, 
             L.STREET_ADDRESS                         부서위치
     FROM    EMPLOYEES   E, DEPARTMENTS D,  LOCATIONS L
     WHERE   E.DEPARTMENT_ID   =  D.DEPARTMENT_ID
      AND    D.LOCATION_ID     =  L.LOCATION_ID
      AND    D.DEPARTMENT_NAME = 'IT';
  
  2)
   SELECT   E.FIRST_NAME  ||  ' ' ||  E.LAST_NAME    직원명, 
             L.STREET_ADDRESS                         부서위치
     FROM    EMPLOYEES   E
               JOIN  DEPARTMENTS D  ON  E.DEPARTMENT_ID   =  D.DEPARTMENT_ID
               JOIN  LOCATIONS L    ON   D.LOCATION_ID     =  L.LOCATION_ID
     WHERE   D.DEPARTMENT_NAME = 'IT';
   
  ---
  부서명별 월급평균 
  1)
     SELECT      D.DEPARTMENT_NAME          부서명,
                 ROUND(AVG(E.SALARY), 3)    월급평균
      FROM       DEPARTMENTS D,  EMPLOYEES E
      WHERE      D.DEPARTMENT_ID  = E.DEPARTMENT_ID
      GROUP BY   D.DEPARTMENT_NAME
      ORDER BY   D.DEPARTMENT_NAME ASC;
  
  2) INNER JOIN
     SELECT      D.DEPARTMENT_NAME          부서명,
                 ROUND(AVG(E.SALARY), 3)    월급평균
      FROM       DEPARTMENTS D
                 JOIN    EMPLOYEES E  ON  D.DEPARTMENT_ID  = E.DEPARTMENT_ID
      GROUP BY   D.DEPARTMENT_NAME
      ORDER BY   D.DEPARTMENT_NAME ASC;
  
  3) OUTER JOIN
      SELECT     D.DEPARTMENT_NAME          부서명,
                 ROUND(AVG(E.SALARY), 3)    월급평균
      FROM       DEPARTMENTS D,  EMPLOYEES E
      WHERE      D.DEPARTMENT_ID  = E.DEPARTMENT_ID(+)
      GROUP BY   D.DEPARTMENT_NAME
      ORDER BY   ROUND(AVG(E.SALARY), 3) DESC  NULLS LAST;
  
  4)
      SELECT     D.DEPARTMENT_NAME          부서명,
                 ROUND(AVG(E.SALARY), 3)    월급평균
      FROM       DEPARTMENTS D
                 LEFT   JOIN   EMPLOYEES E  ON  D.DEPARTMENT_ID  = E.DEPARTMENT_ID
      GROUP BY   D.DEPARTMENT_NAME
      ORDER BY   ROUND(AVG(E.SALARY), 3) DESC  NULLS LAST;
  
  -------  
  직원명, 담당업무, 담당업무 히스토리
  0) 
    SELECT   * FROM JOB_HISTORY;
    
               직원번호      직원명       담당업무   업무시작일   업무종료일
  EMPLOYEES    EMPLOYEE_ID   FIRST_NAME                                       -- 현재근무
  JOB_HISTORY  EMPLOYEE_ID                           START_DATE   END_DATE    -- 업무이력
  JOBS                                    JOB_TITLE 
    
  1) 현재근무직원 중심(eMPLOYEES)
             직원번호        직원명       담당업무     업무시작일   업무종료일   
    SELECT   E.EMPLOYEE_ID, E.FIRST_NAME, J.JOB_TITLE, E.HIRE_DATE, '근무중'
     FROM    EMPLOYEES  E, JOBS J  
     WHERE   E.JOB_ID   =  J.JOB_ID;
     
  2) 업무이력 중심( JOB_HISTORY   )
             직원번호       직원명        담당업무      업무시작일     업무종료일
    SELECT   E.EMPLOYEE_ID, E.FIRST_NAME, J.JOB_TITLE,  JH.START_DATE, JH.END_DATE        
     FROM    EMPLOYEES  E, JOB_HISTORY JH, JOBS  J
     WHERE   E.EMPLOYEE_ID   =  JH.EMPLOYEE_ID
      AND    JH.JOB_ID       =  J.JOB_ID;
     
   1) UNION 2) 모든 직원의 업무이력
    SELECT   E.EMPLOYEE_ID, E.FIRST_NAME, J.JOB_TITLE, E.HIRE_DATE, SYSDATE
     FROM    EMPLOYEES  E, JOBS J  
     WHERE   E.JOB_ID   =  J.JOB_ID
    UNION
    SELECT   E.EMPLOYEE_ID, E.FIRST_NAME, J.JOB_TITLE,  JH.START_DATE, JH.END_DATE        
     FROM    EMPLOYEES  E, JOB_HISTORY JH, JOBS  J
     WHERE   E.EMPLOYEE_ID   =  JH.EMPLOYEE_ID
      AND    JH.JOB_ID       =  J.JOB_ID;
    
   1) UNION 2)  결과 정렬
   SELECT   * 
   FROM
   (
    SELECT   E.EMPLOYEE_ID                        EMPID,
             E.FIRST_NAME || ' ' || E.LAST_NAME   EMPNAME , 
             J.JOB_TITLE                          JOBTITLE, 
             E.HIRE_DATE                          STARTDATE, 
             SYSDATE                               ENDDATE
     FROM    EMPLOYEES  E, JOBS J  
     WHERE   E.JOB_ID   =  J.JOB_ID
    UNION
    SELECT   E.EMPLOYEE_ID                         EMPID,                    
             E.FIRST_NAME  || ' ' || E.LAST_NAME   EMPNAME,
             J.JOB_TITLE                           JOBTITLE,
             JH.START_DATE                         STARTDATE,
             JH.END_DATE                           ENDDATE
     FROM    EMPLOYEES  E, JOB_HISTORY JH, JOBS  J
     WHERE   E.EMPLOYEE_ID   =  JH.EMPLOYEE_ID
      AND    JH.JOB_ID       =  J.JOB_ID
   )  T
   ORDER BY  T.EMPID ASC, T.STARTDATE ASC;
    
    -- INLINE VIEW 
   SELECT   *
   FROM
   (
    SELECT   E.EMPLOYEE_ID, E.FIRST_NAME || ' ' || E.LAST_NAME, J.JOB_TITLE, E.HIRE_DATE, SYSDATE
     FROM    EMPLOYEES  E
       JOIN   JOBS J  ON   E.JOB_ID   =  J.JOB_ID
    UNION
    SELECT   E.EMPLOYEE_ID, E.FIRST_NAME  || ' ' || E.LAST_NAME, J.JOB_TITLE, JH.START_DATE, JH.END_DATE
     FROM    EMPLOYEES  E
        JOIN   JOB_HISTORY JH  ON  E.EMPLOYEE_ID   =  JH.EMPLOYEE_ID
        JOIN   JOBS  J         ON  JH.JOB_ID       =  J.JOB_ID     
   )  T
   ORDER BY  1 ASC, 4 ASC;
   
------  
  JOB_HISTORY 에  2건 이상 등록된 직원번호, 잡의 갯수 통계 
  
  SELECT      JH.EMPLOYEE_ID  직원번호, COUNT( JH.JOB_ID )  잡의갯수
   FROM       JOB_HISTORY   JH
   GROUP BY   JH.EMPLOYEE_ID
    HAVING    COUNT( JH.JOB_ID ) >= 2
   ORDER BY   JH.EMPLOYEE_ID;
  
 --   
  JOB_HISTORY 에  2건 이상 등록된 직원번호, 직원이름, 잡의 갯수 통계 
 1) 
  SELECT      JH.EMPLOYEE_ID                      직원번호, 
              E.FIRST_NAME || ' ' || E.LAST_NAME  직원이름, 
              COUNT( JH.JOB_ID )                  잡의갯수
   FROM       JOB_HISTORY   JH, EMPLOYEES  E
   WHERE      JH.EMPLOYEE_ID = E.EMPLOYEE_ID
   GROUP BY   JH.EMPLOYEE_ID, E.FIRST_NAME || ' ' || E.LAST_NAME
    HAVING    COUNT( JH.JOB_ID ) >= 2
   ORDER BY   JH.EMPLOYEE_ID;
 
 2)
  SELECT T.직원번호, E.FIRST_NAME || E.LAST_NAME, T.잡의갯수 
   FROM
   (
      SELECT      JH.EMPLOYEE_ID  직원번호, COUNT( JH.JOB_ID )  잡의갯수
       FROM       JOB_HISTORY   JH
       GROUP BY   JH.EMPLOYEE_ID
        HAVING    COUNT( JH.JOB_ID ) >= 2
       ORDER BY   JH.EMPLOYEE_ID
   ) T
   , EMPLOYEES E
   WHERE  T.직원번호 = E.EMPLOYEE_ID;
   
----  
  직원명, 부서명, 회사주소, 국가, REGION
  
  SELECT  E.FIRST_NAME || ' ' || E.LAST_NAME    직원명, 
          D.DEPARTMENT_NAME                     부서명, 
          L.STREET_ADDRESS                      회사주소, 
          C.COUNTRY_NAME                        국가, 
          REGION_NAME                           본부
   FROM   EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
   WHERE  E.DEPARTMENT_ID  =  D.DEPARTMENT_ID
    AND   D.LOCATION_ID    =  L.LOCATION_ID
    AND   L.COUNTRY_ID     =  C.COUNTRY_ID
    AND   C.REGION_ID      =  R.REGION_ID;     -- 106
    
  SELECT  E.FIRST_NAME || ' ' || E.LAST_NAME    직원명, 
          D.DEPARTMENT_NAME                     부서명, 
          L.STREET_ADDRESS                      회사주소, 
          C.COUNTRY_NAME                        국가, 
          REGION_NAME                           본부
   FROM   EMPLOYEES E, DEPARTMENTS D, LOCATIONS L, COUNTRIES C, REGIONS R
   WHERE  E.DEPARTMENT_ID  =  D.DEPARTMENT_ID(+)
    AND   D.LOCATION_ID    =  L.LOCATION_ID(+)
    AND   L.COUNTRY_ID     =  C.COUNTRY_ID(+)
    AND   C.REGION_ID      =  R.REGION_ID(+);     -- 109  
    
    
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  