<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String userid = request.getParameter("userid");
String userpasswd = request.getParameter("passwd");
String uid = "";
if(userid != null) {
 uid = userid.trim().toUpperCase();	
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP입니다.</h2>
	<div><%=userid%>님이 로그인 되었습니다.</div>
	<div><%=uid%>님이 로그인 되었습니다.</div>
</body>
</html>