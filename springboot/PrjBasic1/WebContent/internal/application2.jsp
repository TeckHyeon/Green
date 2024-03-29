<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application 내장 객체의 로그와 속성 메서드</title>
</head>
<body>
<h1>application 내장 객체의 로그와 속성 메서드</h1>
<hr>
<%
    // session : 한브라우저내애 이동하는 모든 페이지 정보를 공유
    //           로그인, 장바구니, 권한 부여
    // application 영역은 모든 유저 공용
	application.setAttribute("name", "홍길동");
	application.log("로그 메시지 저장");
	application.log("name=홍길동");
	// log 접속기록
	// 실서버   : tomcat/ ../log/20190502.txt
	// 이클립스 : 콘솔 영역에 출력
%>
<%=application.getAttribute("name") %><br>
<%
    // 접속자 카운트
	if (application.getAttribute("count") == null) 
		application.setAttribute("count", 0);
	Integer counter = (Integer)application.getAttribute("count");
	int cnt = counter.intValue() + 1;
	application.setAttribute("count", cnt);
%>
카운터 : <%=application.getAttribute("count") %>
<hr>
</body>
</html>