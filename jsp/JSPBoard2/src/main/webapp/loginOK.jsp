<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 OK 페이지</h1>
	<p><%= session.getAttribute("userName").toString() %> 님 반갑습니다.</p>
</body>
</html>