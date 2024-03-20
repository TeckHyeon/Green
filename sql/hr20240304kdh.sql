//부서명, 해당부서장이름
-- INNER JOIN : 양쪽 다 NULL이 아닌 DATA 출력
SELECT DEPARTMENT_NAME 부서명, E.FIRST_NAME || ' ' || E.LAST_NAME 해당부서장이름
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.MANAGER_ID = E.EMPLOYEE_ID
ORDER BY D.DEPARTMENT_ID ASC;

SELECT DEPARTMENT_NAME 부서명, E.FIRST_NAME || ' ' || E.LAST_NAME 해당부서장이름
FROM DEPARTMENTS D
JOIN EMPLOYEES E
ON D.MANAGER_ID = E.EMPLOYEE_ID
ORDER BY D.DEPARTMENT_ID ASC;

-- 모든 부서를 대상으로 출력, 부서명, 부서장이름 (단, 부서장이 없으면 NULL)

SELECT DEPARTMENT_NAME 부서명, E.FIRST_NAME || ' ' || E.LAST_NAME 해당부서장이름
FROM DEPARTMENTS D
LEFT JOIN EMPLOYEES E
ON D.MANAGER_ID = E.EMPLOYEE_ID
ORDER BY D.DEPARTMENT_ID ASC;

--의미가 다르다
SELECT DEPARTMENT_NAME 부서명, E.FIRST_NAME || ' ' || E.LAST_NAME 해당부서장이름
FROM DEPARTMENTS D
FULL OUTER JOIN EMPLOYEES E
ON D.MANAGER_ID = E.EMPLOYEE_ID
ORDER BY D.DEPARTMENT_ID ASC;

//  성적처리 TABLE
--  업무
--  학생 : 학번, 이름,전화, 입학일
--  성적 : 학번, 국어, 영어, 수학, 총점, 평균, 학점, 석차 결과
--  과목은 변경될 수 있다

--  TABLE 생성
--  학생      : 학번(PK),   이름,   전화,  입학일
--  성적      : 일련번호(PK), 교과목,   점수,   학번(FK) 
-- 제약조건 CONSTRAINT
-- 잘못된 데이터 입력 방지
// 1. 주 식별자 설정
// PRIMARY KEY : NUT NULL + UNIQUE 기본 적용
//2.NOT NULL / NULL     : 필수입력, 컬럼레벨 제약조건
//3.UNIQUE              : 중복방지
//4.CHECK               : 범위지정 - DOMAIN 제약조건
//5.FOREIGN KEY         : 외래키

CREATE TABLE STUDENT (  STID NUMBER(6) PRIMARY KEY,
                        STNAME varchar2(30) NOT NULL,
                        PHONE varchar2(20) UNIQUE,
                        INDATE DATE DEFAULT SYSDATE
                        );

INSERT INTO STUDENT VALUES (1, '윈터', '010-1234-5678',SYSDATE);
INSERT INTO STUDENT VALUES (2, '제니', '011-1234-5678',SYSDATE);
INSERT INTO STUDENT VALUES (3, '비비', '012-1234-5678',SYSDATE);
INSERT INTO STUDENT VALUES (4, '사쿠라', '013-1234-5678',SYSDATE);
INSERT INTO STUDENT VALUES (5, '유진', '014-1234-5678',SYSDATE);
INSERT INTO STUDENT (STID, STNAME, PHONE, INDATE) VALUES(7,NULL, '015',SYSDATE);
INSERT INTO STUDENT (STID, STNAME, PHONE, INDATE) VALUES(8,'유나', '018',SYSDATE);

commit;
SELECT * FROM STUDENT;
DROP TABLE STUDENT;
DROP TABLE SCORES;
CREATE TABLE SCORES (SCID NUMBER(6) , --Primary key,
                    SUBJECT varchar2(30) NOT NULL,
                    SCORE NUMBER(3) CHECK (SCORE BETWEEN 0 AND 100),
                    STID NUMBER(6) NOT NULL,
                    CONSTRAINT STID_PK PRIMARY KEY(SCID, SUBJECT),
                    CONSTRAINT STID_FK FOREIGN KEY(STID) REFERENCES STUDENT (STID));
                    
INSERT  INTO  SCORES VALUES( 1, '국어', 100, 1);
INSERT  INTO  SCORES VALUES( 2, '영어', 100, 1);
INSERT  INTO  SCORES VALUES( 3, '수학', 100, 1);
INSERT  INTO  SCORES VALUES( 4, '국어', 100, 2);
INSERT  INTO  SCORES VALUES( 5, '수학',  80, 2);
INSERT  INTO  SCORES VALUES( 6, '국어',  70, 4);
INSERT  INTO  SCORES VALUES( 7, '영어',  80, 4);
INSERT  INTO  SCORES VALUES( 8, '수학',  85, 4);
INSERT  INTO  SCORES VALUES( 9, '국어',  999, 5); -- 입력안됨, CHECK 제약조건 위배
INSERT  INTO  SCORES VALUES( 10, '영어',  100, 6); -- 입력 안됨
commit;
select * from scores;

//5.제약조건 추가/수정/삭제
   ALTER TABLE  EMP2
    ADD CONSTRAINT  EMP2_PK  PRIMARY KEY ( EMPLOYEE_ID  );
    
   ALTER TABLE  EMP2
    MODIFY   (PHONE_NUMBER CONSTRAINT PHONE_NN  NOT NULL );
    
   ALTER TABLE  EMP2
    ADD CONSTRAINT  EMP2_UK  UNIQUE ( EMAIL  ); 
    
   ALTER TABLE  EMP2
    DROP CONSTRAINT  EMP2_UK;

-------------------------------------------
// 데이터추가

--조회

--학번, 이름, 점수(국어)
SELECT ST.STID 학번,ST.STNAME 이름, SC.SCORE 점수
FROM  STUDENT ST, SCORES SC
WHERE ST.STID = SC.STID AND SC.SUBJECT = '국어';
--학번, 이름, 총점,평균
SELECT ST.STID 학번, ST.STNAME 이름, SUM(SC.SCORE) 총점, round(AVG(SC.SCORE),1) 평균
FROM SCORES SC, STUDENT ST 
WHERE ST.STID = SC.STID
group by ST.STID, ST.STNAME;
--모든학생 학번, 이름, 총점, 평균
SELECT ST.STID 학번, ST.STNAME 이름, SUM(SC.SCORE) 총점, round(AVG(SC.SCORE),1) 평균
FROM SCORES SC, STUDENT ST 
WHERE ST.STID = SC.STID(+)
group by ST.STID, ST.STNAME;
-- 학번, 이름, 국어, 영어, 수학, 총점, 평균
SELECT SC.STID 학번, ST.STNAME 이름, SUM(DECODE(SC.SUBJECT, '국어', SC.SCORE)) 국어, SUM(DECODE(SC.SUBJECT, '영어', SC.SCORE)) 영어, SUM(DECODE(SC.SUBJECT, '수학', SC.SCORE)) 수학, SUM(SC.SCORE) 총점, round(AVG(SC.SCORE),3) 평균
FROM SCORES SC, STUDENT ST
WHERE ST.STID = SC.STID
group by SC.STID, ST.STNAME;

-- 학번, 이름, 국어, 영어, 수학, 총점, 평균, 등급, 석차
SELECT SC.STID 학번, ST.STNAME 이름, SUM(DECODE(SC.SUBJECT, '국어', SC.SCORE)) 국어, SUM(DECODE(SC.SUBJECT, '영어', SC.SCORE)) 영어, SUM(DECODE(SC.SUBJECT, '수학', SC.SCORE)) 수학, SUM(SC.SCORE) 총점, round(AVG(SC.SCORE),3) 평균
FROM SCORES SC
JOIN STUDENT ST
ON ST.STID = SC.STID
group by SC.STID, ST.STNAME;

CREATE TABLE SCGRADE (  GRADE VARCHAR2(2) PRIMARY KEY,
                        MINSCORE NUMBER(10, 3) NOT NULL,
                        MAXSCORE NUMBER(10, 3) NOT NULL
                        );
 INSERT INTO SCGRADE VALUES('A',90,100);
 INSERT INTO SCGRADE VALUES('B',80,89.999);
 INSERT INTO SCGRADE VALUES('C',70,79.999);
 INSERT INTO SCGRADE VALUES('D',60,69.999);
 INSERT INTO SCGRADE VALUES('F', 0,59.999);
 COMMIT;
 drop table scgrade;
 SELECT T.학번, T.이름, T.국어, T.영어, T.수학, T.총점, T.평균, SG.GRADE, RANK() OVER ( ORDER BY  평균 DESC NULLS LAST )   석차
 FROM ( SELECT SC.STID 학번, ST.STNAME 이름, SUM(DECODE(SC.SUBJECT, '국어', SC.SCORE)) 국어, SUM(DECODE(SC.SUBJECT, '영어', SC.SCORE)) 영어, SUM(DECODE(SC.SUBJECT, '수학', SC.SCORE)) 수학, SUM(SC.SCORE) 총점, round(AVG(SC.SCORE),3) 평균
FROM SCORES SC
JOIN STUDENT ST
ON ST.STID = SC.STID
group by SC.STID, ST.STNAME) T
JOIN SCGRADE SG
ON T.평균 BETWEEN SG.MINSCORE AND SG.MAXSCORE;


-------------------------
-- ORACLE 11G 사용 PIVOT 방식
-- 학번, 이름, 국어, 영어, 수학, 총점, 평균, 학점
// 1)학번, 이름, 국어, 영어, 수학
SELECT * FROM
(
    SELECT STID,SUBJECT,SCORE
    FROM SCORES
)
PIVOT
(   SUM(SCORE)
    FOR SUBJECT
    IN('국어' AS 국어, '영어' AS 영어, '수학' AS 수학)
);
// 2)학번, 이름, 국어, 영어, 수학, 총점, 평균, 학점, 석차
SELECT  T.STID 학번,
        ST.STNAME 이름,
        T.국어 국어, 
        T.영어 영어,
        T.수학 수학,
        (nvl(T.국어,0) + nvl(T.영어,0) + nvl(T.수학,0)) 총점,
        round((nvl(T.국어,0) + nvl(T.영어,0) + nvl(T.수학,0))/3,3) 평균,
        SG.GRADE 학점,
        RANK() OVER ( ORDER BY  round((nvl(T.국어,0) + nvl(T.영어,0) + nvl(T.수학,0))/3,3) DESC NULLS LAST )   석차
FROM(
SELECT  * FROM
   (
      SELECT   STID,  SUBJECT,  SCORE
       FROM    SCORES   
   )
   PIVOT
   (
      SUM( SCORE ) 
       FOR SUBJECT
        IN('국어' AS 국어, '영어' AS 영어, '수학' AS 수학 )
   )) T, STUDENT ST, SCGRADE SG
   WHERE T.STID = ST.STID
   AND round((nvl(T.국어,0) + nvl(T.영어,0) + nvl(T.수학,0))/3,3) BETWEEN SG.MINSCORE AND SG.MAXSCORE;

숙제)
 EMPLOYEES 
 월별입사 인원수 : PIVOT

SELECT * FROM
(
  SELECT EXTRACT(YEAR FROM hire_date ) HY
       , EXTRACT(MONTH FROM hire_date ) HM
  FROM EMPLOYEES
)
PIVOT(COUNT(HM) FOR HM IN(1,2,3,4,5,6,7,8,9,10,11,12))
ORDER BY HY;

연도    1월  2월 3월    ...  11월 12월
2007년   3    2   0            7    8
2008년

CREATE TABLE POST
(
ZIPCODE VARCHAR2(7) NOT NULL
,SIDO VARCHAR2(6) 
,GUGUN VARCHAR2(34) 
,DONG VARCHAR2(100) 
,BUNJI VARCHAR2(34)
,SEQ NUMBER(5) PRIMARY KEY
);

SELECT COUNT(*) FROM POST;
SELECT COUNT(ZIPCODE) FROM POST;
SELECT COUNT(DISTINCT ZIPCODE) FROM POST;

SELECT *
FROM POST
WHERE DONG LIKE '부전2%';

update POST
SET BUNJI = '없음'
WHERE BUNJI IS NULL;

ROLLBACK;

DELETE FROM POST
WHERE DONG = '부전2동';

INSERT INTO post (
    zipcode,
    sido,
    gugun,
    dong,
    bunji,
    seq
) VALUES (
    '000-000', '천국', '천국구', '천국동', '천국로', 0
);
commit;