<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String userid = request.getParameter("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>B.jsp 입니다</h2><%=userid %>
	<hr />
	<input type="button" value="뒤로" onclick="javascript:history.back()" />
</body>
</html>