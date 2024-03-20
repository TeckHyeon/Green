SELECT      가져올 칼럼이름들
 FROM       테이블이름
 WHERE      조건
 ORDER BY   정렬기준 ASC;
 
-- 월급이 10000 이상 
SELECT      EMPLOYEE_ID 번호, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, SALARY
 FROM       EMPLOYEES
 WHERE      SALARY  >=  10000
 ORDER BY   SALARY DESC;

--  조건 : >, <, >=, <=, =, !=(<>) 
--         NOT, AND, OR
-- 부서번호가 60 인 직원정보 
SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID  =  60 ;  -- 5 명
 
-- 부서번호가 90 인 직원정보 (모두) 
SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID  =  90 ;   -- 3명  
 
-- 부서번호가 60, 90 인 직원정보  
 
SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID   =  60
 OR         DEPARTMENT_ID   =  90;    -- 8명
 
SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID   =  60
 OR         90;    -- ERROR  : 90 은 조건식이 아니거

SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID  IN ( 60, 90 );
 
SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID = 60
UNION 
SELECT      *
 FROM       EMPLOYEES
 WHERE      DEPARTMENT_ID = 90; 
  
 --------------------------------------
 --  || : 문자열 결합 연산자
 -- 1.월급이 15000 이상인 직원의 번호, 이름, 이메일, 월급을 월급순으로 출력
 SELECT      EMPLOYEE_ID                     "직원 번호", 
             FIRST_NAME || ' ' || LAST_NAME  이름, 
             EMAIL                           이메일, 
             SALARY                          월급
  FROM       EMPLOYEES  
  WHERE      SALARY      >=  15000
  ORDER BY   SALARY   DESC,  EMPLOYEE_ID ASC; 
 
 -- 2.월급이 10000~15000 인 직원의 사번, 이름, 월급, 부서번호
 SELECT       EMPLOYEE_ID                       "직원의 사번", 
              FIRST_NAME || ' ' || LAST_NAME    이름, 
              SALARY                            월급, 
              DEPARTMENT_ID                     부서번호
  FROM        EMPLOYEES          
  WHERE       10000 <= SALARY   
   AND                 SALARY  <= 15000           --     1000 <= SALARY <= 15000
  ORDER BY    DEPARTMENT_ID ASC,  SALARY DESC;  
  
 SELECT       EMPLOYEE_ID                       "직원의 사번", 
              FIRST_NAME || ' ' || LAST_NAME    이름, 
              SALARY                            월급, 
              DEPARTMENT_ID                     부서번호
  FROM        EMPLOYEES          
  WHERE       SALARY   BETWEEN 10000 AND 15000     
  ORDER BY    DEPARTMENT_ID ASC,  SALARY DESC;  
 
 -- 3.직업 ID 가 IT_PROG 인 직원 명단
 SELECT    EMPLOYEE_ID                     AS 사번,
           FIRST_NAME || ' ' || LAST_NAME     이름,
           EMAIL                              이메일, 
           JOB_ID                             직업ID
  FROM     EMPLOYEES 
  WHERE    JOB_ID = 'IT_PROG';
  
 -- 4. 직원이름이 GRANT 인 직원을 찾으세요 
 SELECT    EMPLOYEE_ID                     직원번호,
           FIRST_NAME || ' ' || LAST_NAME  이름,
           PHONE_NUMBER                    전화,
           DEPARTMENT_ID                   부서번호
  FROM     EMPLOYEES
  WHERE    UPPER(FIRST_NAME) = 'GRANT'    -- ALIAS 사용불가능 이름 = 'GRANT ' : 오류
   OR      UPPER(LAST_NAME)  = 'GRANT'   
 -- ORDER BY 이름 ASC;   -- ALIAS 사용가능
   ORDER BY FIRST_NAME || ' ' || LAST_NAME ASC;   -- ALIAS 사용가능
  
 -- 5. 사번, 월급, 10% 인상한 월급
 SELECT        EMPLOYEE_ID       사번, 
               SALARY            월급, 
               SALARY * 1.1      "10% 인상한 월급"
  FROM         EMPLOYEES  ;
  -- WHERE   
  ORDER BY 
 
 
 -- 6. 50 번 부서의 직원명단, 월급, 부서번호
 SELECT     EMPLOYEE_ID                      사번,
            FIRST_NAME || ' ' || LAST_NAME   직원명단, 
            SALARY                           월급, 
            DEPARTMENT_ID                    부서번호
  FROM      EMPLOYEES   
  WHERE     DEPARTMENT_ID  =  50
  ORDER BY  사번 ASC;
  
 -- 7.  20, 60, 80, 90번 부서의 직원명단, 월급, 부서번호
 SELECT      FIRST_NAME || ' ' || LAST_NAME   직원명단, 
             SALARY                           월급, 
             DEPARTMENT_ID                    부서번호  
  FROM       EMPLOYEES
  WHERE      DEPARTMENT_ID IN ( 20, 60, 80, 90  )
  ORDER BY   부서번호 ASC, EMPLOYEE_ID;
  
 -- 8. 보너스없는 직원명단
 SELECT      FIRST_NAME || ' ' || LAST_NAME   직원명단, 
             SALARY                           월급, 
             DEPARTMENT_ID                    부서번호  
  FROM       EMPLOYEES
  WHERE      COMMISSION_PCT  IS  NULL;

----------------------------------------------------------------- 
 
-- 중요 데이터 추가(2 명)
   INSERT INTO EMPLOYEES
    VALUES ( 207, '길동', '홍', 'GDHONG', '010.1234.5678' ,
       SYSDATE, 'IT_PROG', NULL, NULL, NULL, NULL);
   INSERT INTO EMPLOYEES
    VALUES ( 208, '리나', '카', 'RINA', '010.5555.5678' ,
       SYSDATE, 'IT_PROG', NULL, NULL, NULL, NULL);
   COMMIT; 

  패턴 매칭 - 문자열 포함여부
    %  : 0 개의 글자수 이상
    _  : 1 개의 문자  
  LIKE   '010%'  - 010 으로 시작되는  startsWith
         '%010'  - 010 으로 끝나는    endsWith  
         '%010%' - 010 이 포함된      contains
  1. 전화번호가 44 로 시작되는 직원명단    
     --전화번호가 011 로 시작되는 직원명단    
  SELECT     E.EMPLOYEE_ID                   사번,
             FIRST_NAME || ' ' || LAST_NAME  이름,
             E.PHONE_NUMBER                  전화
   FROM      EMPLOYEES   E
   WHERE     E.PHONE_NUMBER  LIKE  '44%';
     
  
  2. 이름(FIRST_NAME)이  nette 로 끝나는 직원정보  
  SELECT     E.EMPLOYEE_ID                   사번,
             FIRST_NAME || ' ' || LAST_NAME  이름,
             E.PHONE_NUMBER                  전화
   FROM      EMPLOYEES   E
   WHERE     E.FIRST_NAME  LIKE  '%nette';
               
  3. 이메일에 MA 가 포함된 직원  
  
  SELECT     E.EMPLOYEE_ID                   사번,
             FIRST_NAME || ' ' || LAST_NAME  이름,
             E.PHONE_NUMBER                  전화,
             E.EMAIL                         이메일
   FROM      EMPLOYEES   E
   WHERE     E.EMAIL  LIKE  '%MA%';
    
  4. LAST_NAME 세번째,네번째 글자가 LL 인것을 찾아라   
  SELECT     E.EMPLOYEE_ID                   사번,
             FIRST_NAME || ' ' || LAST_NAME  이름,
             E.PHONE_NUMBER                  전화,
             E.EMAIL                         이메일
   FROM      EMPLOYEES   E
   WHERE     E.LAST_NAME  LIKE  '__ll%';
   -- WHERE     E.LAST_NAME  LIKE  '__LL%';
 
 -------
  --오늘날짜 : DUAL 은 출력을 위한 한칸의 공간
  SELECT  SYSDATE FROM DUAL;
  날짜표현식
    ANSI  2024-02-26  
    미국  02/26/24     월/일/년도
    영국  26/02/24     일/월/년도
      
  5. 입사년월이 17년 2월인 사원출력 -- 입사년월이 17년 2월인 사원출력
    SELECT   EMPLOYEE_ID                       사번,
             FIRST_NAME || ' ' || LAST_NAME    이름, 
             HIRE_DATE                         입사일
     FROM    EMPLOYEES
     WHERE   '17/02/01' <=  HIRE_DATE   
      AND                   HIRE_DATE <= '17/02/28';
      
    SELECT   EMPLOYEE_ID                       사번,
             FIRST_NAME || ' ' || LAST_NAME    이름, 
             HIRE_DATE                         입사일
     FROM    EMPLOYEES
     WHERE   HIRE_DATE  BETWEEN   '17/02/01' AND LAST_DAY('17/02/01');  
    
 6.  '17/02/07'   에 입사한 사람출력 -- '07/02/07'   에 입사한 사람출력 
 
   SELECT   EMPLOYEE_ID                       사번,
             FIRST_NAME || ' ' || LAST_NAME    이름, 
             HIRE_DATE                         입사일
     FROM    EMPLOYEES
     WHERE   HIRE_DATE = '17/02/07';
    

  오늘 '24/02/26'  입사한 사람 
    SELECT   EMPLOYEE_ID                       사번,
             FIRST_NAME || ' ' || LAST_NAME    이름, 
             HIRE_DATE                         입사일
     FROM    EMPLOYEES
    --  WHERE   HIRE_DATE = '24/02/26';  -- 출력안됨 : 시분초 문제  '24/02/26 00:00:00
      WHERE   HIRE_DATE = SYSDATE;      -- 출력안됨 : 시분초 문제
  
  --  ALTER SESSION SET 현재 SESSION 의 출력형태 변경
 SELECT SYSDATE FROM DUAL;      -- 24/02/26
 ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD HH24:MI:SS';
 SELECT SYSDATE FROM DUAL;      -- 2024-02-26 14:49:33 
 
  해결)      
   SELECT   EMPLOYEE_ID                       사번,
             FIRST_NAME || ' ' || LAST_NAME    이름, 
             HIRE_DATE                         입사일
     FROM    EMPLOYEES
     WHERE   HIRE_DATE  BETWEEN  '2024-02-27 00:00:00'
                        AND      '2024-02-27 23:59:59';  
      
   SELECT   EMPLOYEE_ID                       사번,
             FIRST_NAME || ' ' || LAST_NAME    이름, 
             HIRE_DATE                         입사일
     FROM    EMPLOYEES
     WHERE   TO_CHAR(HIRE_DATE, 'YYYY-MM-DD')  = '2024-02-27';  
 
  SELECT EMPLOYEE_ID, HIRE_DATE
   FROM  EMPLOYEES;
 
 --- ==================   
  연산자
  산술 : + , -, * , /
  
  SELECT  3 * 2, 7 / 2, 0 / 7, 7 / 0.0
   FROM   DUAL;
 
 문자결합 : || 
 
 비교 조건식 : >, <. >=, <=, =, !=  
 
 논리        : NOT, AND, OR
 
 범위        : BETWEEN
 여러개중선택 : IN ( ) 
 

 함수 : SINGLE ROW FUNCTION - 결과가 1:1
 
 SELECT FIRST_NAME FROM EMPLOYEES;  -- 109
 SELECT FIRST_NAME, UPPER(FIRST_NAME) FROM EMPLOYEES;  -- 109
 
 SELECT COUNT(FIRST_NAME) FROM EMPLOYEES;   -- 109즐 -> 1줄 : 집계함수
 
 
 수치 함수
 1) CEIL(), FLOOR()
   SELECT  CEIL(10.234), CEIL(-10.234)    FROM   DUAL;    -- 1 줄   
   SELECT  CEIL(10.234), CEIL(-10.234)    FROM   EMPLOYEES; -- 109

 2) ROUND(), TRUNC()  -- 반올림, 버림
     SELECT ROUND(10.154, 1), ROUND(10.154, 2), ROUND(10.154, 3)
      FROM DUAL;    -- 10.2	10.15	10.154
      
     --                  10원단위반올림      100원단위 반올림 
     SELECT ROUND(0, 3), ROUND(115.155, -1), ROUND(115.155, -2)
      FROM DUAL;     -- 0	120	100
      
    --                  10원단위절사      100원단위 절사    
    SELECT TRUNC(0, 3), TRUNC(115.155, -1), ROUND(115.155, -2)
      FROM DUAL;       -- 0	110	100
      
    POWER(3, 2) : 3의 2승
    SELECT POWER(3, 2), POWER(3, 3), POWER(3, 3.0001), power(4, 3/2)
      FROM DUAL;  
    
    SQRT(2)  : SQUARE ROOT  : 제곱근
    
    SELECT SQRT(2), SQRT(4) , SQRT(5)   
      FROM DUAL;
      
    SELECT  SQRT(-4) 
      FROM DUAL;   -- ORA-01428: '-4' 인수가 범위를 벗어났습니다
   
    SELECT  MOD(7,2) FROM DUAL;
   
   MOD(n2, n1)와 REMAINDER(n2, n1) : 나머지
   EXP(n), LN(n) 그리고 LOG(n2, n1)
   ------------------------------------------
   문자함수
   INITCAP(char)-첫글자 대문자, LOWER(char)-소문자, UPPER(char)-대문자
    SELECT INITCAP('never say goodbye'), INITCAP('never6say*good가bye')
      FROM DUAL;
  
   CONCAT(char1, char2), SUBSTR(char, pos, len), SUBSTRB(char, pos, len)          
    
    SELECT CONCAT('I Have', ' A Dream'), 'I Have' || ' A Dream'
      FROM DUAL;
  --               1234567         
    SELECT SUBSTR('ABCDEFG', 1, 4), SUBSTR('ABCDEFG', -1, 4)
 --                                              -1       : 음수쪽 (-1(뒤)에서부터 4개 추출)
      FROM DUAL;
   
   SELECT  SUBSTR('대한민국 KOREA', 1, 3), SUBSTRB('대한민국 KOREA', 1, 3)
    FROM   DUAL;
    
 --               1234567 8 9 0 12345678901     
   SELECT  INSTR('Hello 대한민국 KOREA love', 'l' ),
           INSTR('Hello 대한민국 KOREA love', 'l'
              , INSTR('Hello 대한민국 KOREA love', 'l' ) + 1 ),
           INSTR('Hello 대한민국 KOREA love', 'l',  3+1 )
    FROM   DUAL; 
   
    LTRIM(char, set), RTRIM(char, set) 
    -- DEFGABC	나다라	ABCDEFG	 가나다
  SELECT LTRIM('ABCDEFGABC', 'ABC'),
           LTRIM('가나다라', '가'),
           RTRIM('ABCDEFGABC', 'ABC'),
           RTRIM('가나다라', '라')
      FROM DUAL;  
      
   SELECT TRIM( '   ABCDE  1234567     ')    
     FROM DUAL;
    
    REPLACE('나는 너를 모르는데 너는 나를 알겠는가?', '나', '너')  
    SELECT REPLACE('나는 너를 모르는데 너는 나를 알겠는가?', '나', '너')
     FROM DUAL;   
     
     LENGTH(chr), LENGTHB(chr) 
       SELECT LENGTH('대한민국'),
           LENGTHB('대한민국')
      FROM DUAL;
      
   -------------------------------
   시간 
    기준시간  GMT   : 그린위치 천문대 시간 한국시간 +09:00 (과거)
              UTC   : univertial time  한국시간 +09:00 (현재)
   
   날짜 함수
   SYSDATE, SYSTIMESTAMP
    -- 2024-02-26 16:04:36	   24/02/26 16:04:36.543000000 +09:00
    SELECT SYSDATE, SYSTIMESTAMP FROM DUAL;
  
  날짜 계산 
     날짜 + n        : sysdate + 7 :  오늘부터 7일 후 (1주일 후)
     날짜2 - 날짜1   : to_date()('2024-12-25') - sysdate : 몇일 남았나?
     -- 날짜2 + 날짜1  : 모든 언어에서 에러 의미없다
     
   SELECT  SYSDATE-7, SYSDATE, SYSDATE+7 FROM DUAL;  
   SELECT TRUNC( TO_DATE('2024-12-25') - sysdate) FROM DUAL;
  
  ADD_MONTHS (date, integer)  - n 개월 후의 날짜
   SELECT ADD_MONTHS(SYSDATE, 1), ADD_MONTHS(SYSDATE, -1)
    FROM DUAL; 
    
   MONTHS_BETWEEN(date1, date2)
    SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 1)) mon1,
           MONTHS_BETWEEN(ADD_MONTHS(SYSDATE, 1), SYSDATE) mon2
      FROM DUAL;
      
    SELECT MONTHS_BETWEEN('2024-03-26', '2024-02-26' ),
           MONTHS_BETWEEN('2024-04-26', '2024-03-26' )
      FROM DUAL;  

  LAST_DAY(date)   
  SELECT LAST_DAY(SYSDATE)
      FROM DUAL;
      
 ROUND(date, format), TRUNC(date, format)
 SELECT SYSDATE, ROUND(SYSDATE, 'month'), TRUNC(SYSDATE, 'month')
      FROM DUAL;
 
 NEXT_DAY (date, char), -- 다가오는 금요일
    SELECT NEXT_DAY(SYSDATE, '월요일')
      FROM DUAL;

------------------------------------------------------------ 
 변환 함수
 TO_CHAR (숫자 혹은 날짜, format)
 
 -- L : 해당국가의 화폐단위 : ￦123,456,789
   SELECT TO_CHAR(123456789, 'L999,999,999'),
          TO_CHAR(123456789, 'L0,000,999,999')
      FROM DUAL;
   SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
    FROM DUAL;   
    
   SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY'),
          TO_CHAR(SYSDATE, 'YYYY-MM-DD DY')
    FROM DUAL;     
    
 TO_NUMBER(expr, format)
 SELECT '123456' AS "12345678901234", TO_NUMBER('123456')
    FROM DUAL;
    
 TO_DATE(char, format), TO_TIMESTAMP(char, format)
   SELECT TO_DATE('20140101 13:44:50', 'YYYY-MM-DD HH24:MI:SS')
      FROM DUAL;
   
   day : 일요일 , dy : 일   
   SELECT TO_CHAR(TO_DATE('19931225'), 'YYYY-MM-DD DAY')
      FROM DUAL;   
      
   -- 문자열 '19931225'을 '1993년 12월 25일 토요일' 로 출력   
   SELECT   TO_CHAR(TO_DATE('19931225'), 'YYYY"년" MM"월" DD"일" DAY') 
     FROM   DUAL;
     
   SELECT   TO_CHAR(TO_DATE('19931225'), 'YYYY') || '년 '
          ||  TO_CHAR(TO_DATE('19931225'), 'MM')   || '월 '
          ||  TO_CHAR(TO_DATE('19931225'), 'DD')   ||  '일 '
          ||  TO_CHAR(TO_DATE('19931225'), 'DY')   || '요일'    
     FROM   DUAL;  
     
   -- 문자열 '19931225'을 '1993年 12月 25日 토曜日' 로 출력
   年月日時分秒 
   日月火水木金土
   
   
    SELECT   TO_CHAR(TO_DATE('19931225'), 'YYYY')  || '年 '  
          ||  TO_CHAR(TO_DATE('19931225'), 'MM')   || '月 '
          ||  TO_CHAR(TO_DATE('19931225'), 'DD')   || '日 '
          ||  TO_CHAR(TO_DATE('19931225'), 'DY')   || '曜日'    
     FROM   DUAL;  
      
   -- IF 처리 - 다중 IF 포함
   NVL(expr1, expr2), NVL2((expr1, expr2, expr3) => NULL VALUE
   NVL 함수는 expr1이 NULL일 때 expr2를 반환한다.
   참고) MSSQL : ISNULL(), MYSQL : IFNULL()
   
   NULL 은 계산에 포함되면 결과는 NULL 이다
   
   직원번호, 이름, 월급, 보너스(월급*COMMISSION_PCT), 연봉(월급*12 + 보너스)
   SELECT   E.EMPLOYEE_ID                                  직원번호, 
            E.FIRST_NAME || ' ' || E.LAST_NAME             이름,             
            E.SALARY                                       월급, 
            E.SALARY * E.COMMISSION_PCT                    보너스,
            E.SALARY + E.SALARY * E.COMMISSION_PCT  
            실수령,
            E.SALARY*12 + E.SALARY * E.COMMISSION_PCT      연봉
    FROM    EMPLOYEES   E;
    
   SELECT   E.EMPLOYEE_ID                                    직원번호, 
            E.FIRST_NAME || ' ' || E.LAST_NAME               이름,             
            E.SALARY                                         월급, 
            NVL(E.SALARY * E.COMMISSION_PCT, 0)              보너스,
            E.SALARY + NVL(E.SALARY * E.COMMISSION_PCT,0)    실수령,
            E.SALARY*12 + NVL(E.SALARY * E.COMMISSION_PCT,0) 연봉
    FROM    EMPLOYEES   E;
   
   부서번호가 있는 경우 부서번호 출력 
   부서번호가 없는 경우 '부서없음' 출력 
   
   SELECT   EMPLOYEE_ID, 
            DEPARTMENT_ID, 
            NVL( DEPARTMENT_ID , '부서없음')    -- NUMBER, VARCHAR2  : INVALID NUMBER       
    FROM    EMPLOYEES;
   NVL 은 두 변수의 TYPE 이 같아야한다
   
   해결)
   SELECT   EMPLOYEE_ID, 
            DEPARTMENT_ID, 
            NVL( TO_CHAR(DEPARTMENT_ID) , '부서없음')           
    FROM    EMPLOYEES;
   -- WHERE   DEPARTMENT_ID IS NULL;
  
   해결2)
   DECODE (expr, search1, result1, search2, result2, …, default) : IF 문
   DECODE는 expr과 search1을 비교해 두 값이 같으면 result1을, 
       같지 않으면 다시 search2와 비교해 값이 같으면 result2를 반환하고, 
       이런 식으로 계속 비교한 뒤 최종적으로 같은 값이 없으면 default 값을 반환한다. 
  
    IF( DEPARTMENT_ID IS  NULL)
       '부서없음'
    ELSE
       DEPARTMENT_ID
       
   SELECT   EMPLOYEE_ID, 
            DEPARTMENT_ID, 
            DECODE( DEPARTMENT_ID,  NULL, '부서없음', DEPARTMENT_ID )  부서번호           
    FROM    EMPLOYEES;   
  
   --=============
   부서번호 90	Executive 
            80	Sales
            50	Shipping
            60	IT ;
    
    직원번호, 이름, 부서명
    SELECT   EMPLOYEE_ID                           직원번호, 
             FIRST_NAME || ' ' || LAST_NAME        이름, 
             DECODE ( DEPARTMENT_ID, 90,   'Executive'
                                   , 80,   'Sales'
                                   , 50,   'Shipping'
                                   , 60,   'IT'
                                   , NULL, '몰라'
             )  AS 부서명                   
     FROM    EMPLOYEES;
     
     SELECT  TO_CHAR(TO_DATE('19931225'), 'YYYY"年" MM"月" DD"日" ')
            || DECODE( TO_CHAR(TO_DATE('19931225'), 'DY'), '일', '日'
            ,'월', '月'
            ,'화', '火'
            ,'수', '水'
            ,'목', '木'
            ,'금', '金'
            ,'토', '土')
            || '曜日' AS 날짜   
     FROM DUAL;    
     
            
            
    ---==============================
SELECT   EMPLOYEE_ID                           사번, 
         FIRST_NAME || ' ' || LAST_NAME        이름, 
         salary                                월급,
    CASE WHEN salary >= 15000 THEN 'VIP'
         WHEN salary >= 10000 THEN 'MASTER'
         WHEN salary >= 7000  THEN 'SENOIR'
         WHEN salary >= 4000  THEN 'JUNIOR'
         ELSE '병아리'
    END AS 사원등급              
FROM        EMPLOYEES
ORDER BY    salary DESC;

     SELECT  TO_CHAR(TO_DATE('19931225'), 'YYYY"年" MM"月" DD"日" ')
            || CASE TO_CHAR(TO_DATE('19931225'), 'DY')
                WHEN '일' THEN '日'
                WHEN '월' THEN '月'
                WHEN '화' THEN '火'
                WHEN '수' THEN '水'
                WHEN '목' THEN '木'
                WHEN '금' THEN '金'
                WHEN '토' THEN '土'
                END
            || '曜日' 
            AS 날짜   
     FROM DUAL;   


     월급  >= 15000 : 'VIP'
           >= 10000 : 'MASTER'
           >=  7000 : 'SENOIR'
           >=  4000 : 'JUNIOR'
           ELSE     : '병아리'
                 
-- 08월 입사자의 인원수
Select TO_CHAR(HIRE_DATE, 'MM')||'월' 입사달, COUNT(*)||' 명' AS 직원수 
from employees
WHERE TO_CHAR(HIRE_DATE, 'MM') = '08'
GROUP BY TO_CHAR(HIRE_DATE, 'MM')
ORDER BY TO_CHAR(HIRE_DATE, 'MM');
--  입사후 일주일이내인 직원명단
 SELECT       EMPLOYEE_ID                       번호, 
              FIRST_NAME || ' ' || LAST_NAME    이름, 
              SALARY                            월급, 
              DEPARTMENT_ID                     부서번호,
              Hire_date                          입사일
from employees
where extract(day from hire_date) = extract(day from add_days(sysdate,-7));
--  입사일 기준 년도별 인원수
--  입사일기준 월별 인원수, 2017년 기준 
--  입사일에 해당되는 달의 첫번째 날짜와 마지막 날짜를 출력 
--  
--  현재 시간이 오전인지 오후인지를 출력
--  
--  직원이름, 부서번호, 부서명
--  
--  직원수, 직원월급합, 직원월급평균
--
--  부서별 월급 평균
--      
--  부서별 20, 50, 60, 80만  월급 평균   
--  부서별 인원수, 월급합  
--  부서별 사원수  
--  부서별 사원수가 5명 이상인 부서명단 
--  부서별 월급 총계가 20000 이상인 부서
--  JOB_ID 별 인원수 
--  직업의 수 : JOB_ID 의 수
--  
--  부서별 최대 월급이 14000 이상인 부서의 부서번호와 최대월급
--  부서별 모우고 같은부서는 직업별 인원수, 월급평균 
--   
--  IT부서 직원 출력(난이도 상)     
 
 
 
 
 
 
 
 
 
 
 