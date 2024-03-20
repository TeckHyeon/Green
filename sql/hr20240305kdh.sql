SELECT * FROM STUDENT;

INSERT INTO STUDENT (STID, STNAME, PHONE) VALUES (9, '지민', '019');
commit;

-- 번호자동증가
-- SEQUENCE 객체 사용

CREATE SEQUENCE SEQ_STID;
commit;

    CREATE SEQUENCE SEQ_STID
    INCREMENT BY 1
    START WITH 10
    MINVALUE 1
    MAXVALUE 999999
    NOCYCLE;


SELECT SEQ_STID.NEXTVAL FROM DUAL;
SELECT SEQ_STID.CURRVAL FROM DUAL;
select nvl(max(stid),0)+1 from student;


INSERT INTO STUDENT (STID, STNAME, PHONE) VALUES ((select nvl(max(stid),0)+1 from student), '민니', '019-2');
commit;

------------------------------------------------------------         
 인덱스 - INDEX : 정렬된 찾아보기를 이용하여 조회하므로 검색 속도를 올리는 방법
 PRIMARY KEY 나 UNIQUE OPTION 은 기본적으로 인덱스를 자동 생성한다
 인덱스는 WHERE 문에 주로 사용하는 칼럼에 생성하는 것이 좋다
  조건문 =  로 사용해라. 계산식이 포함되면 인덱스가 작동안한다
 JOIN 조건에도 인덱스를 생성하는 것이 검색속도 향상에 도움이된다
 단, INSERT, DELETE 같은 것이 많이 발생하면 INDEX 사용시 속도가 더 느려진다
 
 계산된 열자체를 인덱스롤 생성
 CREATE  INDEX  IDX_ENAME  
    ON EMPLOYEES ( FIRST_NAME || ' ' || LAST_NAME )
 
 TEST 계정으로 로그인하여 
   POST 테이블에 INDEX 로 조회테스트
   
 SELECT COUNT(*) FROM POST;

SELECT MAX(ZIPCODE) FROM POST; -- 799-823

SET TIMING ON
  SELECT  * FROM  POST  WHERE  ZIPCODE = '799-823';
  INDEX 가 없을 때 경과 시간: 00:00:00.451
  
INDEX 생성 후 
CREATE INDEX  INDEX명 ON 테이블명 (칼럼1, 칼럼2, ..)

CREATE INDEX  IDX_ZIPCODE  ON POST (ZIPCODE);

ZIPCODE 인덱스 생성후 다시검색
SET TIMING ON
  SELECT  * FROM  POST  WHERE  ZIPCODE = '799-823';

스크립트 출력창 확인
경과 시간: 00:00:00.344

------------------------------------------------
SELECT * FROM EMP_DETAILS_VIEW;

//사번, 이름, 이메일, 업무ID, 업무명, 부서번호, 부서명
 CREATE OR REPLACE VIEW VIEW_EMP_DEPT_JOBS
AS
    SELECT E.EMPLOYEE_ID 사번, E.FIRST_NAME || ' '  || E.LAST_NAME  이름,  E.EMAIL 이메일, J.JOB_ID 업무ID, J.JOB_TITLE 업무명, D.DEPARTMENT_ID 부서번호, D.DEPARTMENT_NAME 부서명
    FROM EMPLOYEES E 
    LEFT JOIN DEPARTMENTS D ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
    JOIN JOBS J ON E.JOB_ID = J.JOB_ID
    ORDER BY E.EMPLOYEE_ID;
select 사번, 이름, 이메일 from VIEW_EMP_DEPT_JOBS;

--ORACLE 11G에서는 권한 CREATE VIEW 권한이 RESOURCE에 포함되어 있지 않다.

//GRANT CONEECT, RESOUCE, CREATE VIEW TO HR;

------------------------------------------------------
-- 프로시저(PROCEDURE)와 함수(FUNCTION)

--  ORACLE 의 부프로그램(SUBPROGRAM) :프로그램의 조각
--  ORALCE 의 명령(PL/SQL 문)을 이용해서 프로그래밍을 사용하는 기법
--  PL-SQL : PROCEDURAL  LANGUAGE : 오라클
--  T-SQL  : TRANSACTION SQL      : MS-SQL
--
--  1. FUNCTION   -- 함수
--      - 결과값 반드시 한개만 돌려준다(RETURN)
--  2. PROCEDURE  -- 프로시저(SUBROUTINE)
--      - 결과가 없거나 여러개일때 

-- 107번 직원의 이름과 월급 조회

SELECT FIRST_NAME || ' ' || LAST_NAME 직원이름, SALARY 월급
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 107;

-- Stored preocedure 스토어드 프로시저
CREATE OR REPLACE PROCEDURE  GetEmpSal( IN_EMPID  IN  number  ) 
IS
  V_NAME    VARCHAR2(46);
  V_SAL     NUMBER(8, 2);
  BEGIN
     SELECT   FIRST_NAME || ' ' || LAST_NAME, SALARY
      INTO    V_NAME, V_SAL
      FROM    EMPLOYEES  
      WHERE   EMPLOYEE_ID = IN_EMPID;
      DBMS_OUTPUT.PUT_LINE( '이름 : ' || V_NAME  );
      DBMS_OUTPUT.PUT_LINE( '월급 : ' || V_SAL  );
  END;
/
commit;
set serveroutput on;
call getempsal(207);

--사번입력, 이름, 전화, 이메일 출력 프로시저
CREATE OR REPLACE PROCEDURE  GetEmpInfo( IN_EMPID  IN  number  ) 
IS
  V_NAME    VARCHAR2(46);
  V_PHONE   VARCHAR2(20);
  V_EMAIL   VARCHAR2(25);
  BEGIN
     SELECT   FIRST_NAME || ' ' || LAST_NAME, PHONE_NUMBER, EMAIL
      INTO    V_NAME, V_PHONE, V_EMAIL
      FROM    EMPLOYEES  
      WHERE   EMPLOYEE_ID = IN_EMPID;
      DBMS_OUTPUT.PUT_LINE( '이름 : ' || V_NAME  );
      DBMS_OUTPUT.PUT_LINE( '전화번호 : ' || V_PHONE  );
      DBMS_OUTPUT.PUT_LINE( '이메일 : ' || V_EMAIL  );
  END;
/

-- 부서번호, 해당부서의 최고월급자의 이름, 월급 출력
CREATE OR REPLACE PROCEDURE  GetMaxSal( IN_DEPID  IN  number  ) 
IS
  V_DEPID    NUMBER(4, 0);
  V_NAME   VARCHAR2(20);
  V_SAL   NUMBER(8, 2);
  BEGIN
  SELECT MAX(SALARY)
  INTO V_SAL
  FROM EMPLOYEES
  WHERE DEPARTMENT_ID = IN_DEPID;
  
  SELECT   FIRST_NAME
      INTO    V_NAME
      FROM    EMPLOYEES 
      WHERE   DEPARTMENT_ID = IN_DEPID
      AND SALARY = V_SAL;
      
      DBMS_OUTPUT.PUT_LINE( '부서번호 : ' || IN_DEPID  );
      DBMS_OUTPUT.PUT_LINE( '이름 : ' || V_NAME  );
      DBMS_OUTPUT.PUT_LINE( '월급 : ' || V_SAL  );
  END;
/
call GetEmpInfo(107);
call GetMaxSal(60);

90 번 부서번호 입력, 직원들 출력

SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 90;

 SELECT MAX(SALARY)
  INTO V_SAL
  FROM EMPLOYEES
  WHERE DEPARTMENT_ID = IN_DEPID;
  
  SELECT   FIRST_NAME
   INTO    V_NAME
   FROM    EMPLOYEES 
   WHERE   DEPARTMENT_ID = IN_DEPID
   AND SALARY = V_SAL;
--익명블럭
DECLARE
  V_SAL   NUMBER(8, 2);
  IN_DEPID NUMBER(4, 0) := 100;
  V_NAME   VARCHAR2(20);
BEGIN
 SELECT MAX(SALARY)
  INTO V_SAL
  FROM EMPLOYEES
  WHERE DEPARTMENT_ID = IN_DEPID;
SELECT   FIRST_NAME
      INTO    V_NAME
      FROM    EMPLOYEES 
      WHERE   DEPARTMENT_ID = IN_DEPID
      AND SALARY = V_SAL;
      
      DBMS_OUTPUT.PUT_LINE( '부서번호 : ' || IN_DEPID  );
      DBMS_OUTPUT.PUT_LINE( '이름 : ' || V_NAME  );
      DBMS_OUTPUT.PUT_LINE( '월급 : ' || V_SAL  );
END;
/

SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 90;


// INTO 사용시 아래 예제처럼 결과가 여러줄 일때는 오류가 발생한다.

CREATE OR REPLACE PROCEDURE GETEMPLIST( IN_DEPTID NUMBER)
AS
VEID NUMBER(8,2);
VENAME VARCHAR2(4000);
VLNAME VARCHAR(4000);
VPHONE VARCHAR2(4000);
BEGIN
SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER
INTO VEID, VENAME, VLNAME, VPHONE
FROM EMPLOYEES
WHERE DEPARTMENT_ID = IN_DEPTID;
END;
/
EXEC GETEMPLIST(90);

// 해결책) 커서 사용 cursor
CREATE OR REPLACE PROCEDURE GETEMPLIST( IN_DEPTID IN NUMBER,
                                        O_CUR OUT SYS_REFCURSOR)
AS
    BEGIN
    OPEN O_CUR FOR
    SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER
    FROM EMPLOYEES
    WHERE DEPARTMENT_ID = IN_DEPTID;
    END;
/

var o_cur REFCURSOR;
exec GETEMPLIST( 60, :O_CUR );
PRINT O_CUR;