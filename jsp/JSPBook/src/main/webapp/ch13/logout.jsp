<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="5; url=http://localhost:8080/JSPBook/ch13/login.jsp">
<title>Insert title here</title>
</head>
<body>
	<h3>로그 아웃 페이지</h3>
	<p>로그아웃 되었습니다.</p>
	<%
	session.removeAttribute("userId");
	session.removeAttribute("userName");
	session.invalidate();
	%>
		<a href="login.jsp">로그인 페이지로 이동</a>
	<p>5초 후 login 페이지로 이동합니다.</p>
</body>
</html>