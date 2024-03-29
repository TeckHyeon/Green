<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session 로그아웃</title>
</head>
<body>
<%
	session.invalidate();
%>
로그아웃 하였습니다.
<p><a href="session_loginform.jsp">로그인폼 바로가기</a>
</body>
</html>