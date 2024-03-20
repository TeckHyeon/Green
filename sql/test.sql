member
id         정수(6)     번호자동증가  기본키
userid     문자(30)    필수입력
username   문자(30)    필수입력
userpass   문자(30)    필수입력
email      문자(320)
regdate    날짜시간    기본값  현재

DROP TABLE MEMBER;

CREATE  TABLE   MEMBER (
     ID          INT            AUTO_INCREMENT  PRIMARY KEY
   , USERID      VARCHAR(30)    NOT NULL
   , USERNAME    VARCHAR(30)    NOT NULL
   , USERPASS    VARCHAR(30)    NOT NULL
   , EMAIL       VARCHAR(320)
   , REGDATE     DATETIME       DEFAULT  NOW()
);
INSERT INTO MEMbER (USERID, USERNAME, USERPASS, EMAIL)
VALUES              ('USERID', 'USERNAME', 'USERPASS', 'EMAIL');
select * from member;

update member
set USERID = 'admin'
    , USERPASS = '1234'
    , USERNAME = '관리자'
    , EMAIL = 'admin@blue.com'
WHERE ID = 1;
    
    
SELECT ID, USERID, USERNAME, USERPASS, EMAIL FROM MEMBER WHERE ID = 1;    
SELECT ID, USERID, USERNAME, USERPASS, EMAIL  FROM  MEMBER  WHERE ID  = 1;