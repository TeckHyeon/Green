<%@page import="db.MemberVo"%>
<%@page import="db.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String mid = request.getParameter("mid");
DBHandler db = new DBHandler();
db.delete(Integer.parseInt(mid)); //db 에서 삭제
response.sendRedirect("list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<h2>삭제 되었습니다.</h2>
</body>
</html>