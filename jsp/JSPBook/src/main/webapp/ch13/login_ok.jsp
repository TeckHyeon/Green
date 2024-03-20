<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>로그인 성공 페이지</h3>
	<%
	String userId = session.getAttribute("userId").toString();
	String userName = session.getAttribute("userName").toString();
	%>
	
	<h4> <%= userName %>님 안녕하세요</h4>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>