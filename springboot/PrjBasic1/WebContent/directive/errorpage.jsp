<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="/directive/error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예외 에러 발생 페이지</title>
</head>
<body>
<%
	int a = 10;
	int b = 0;
%>
a와 b의 사칙 연산<br>
a + b = <%=a + b %><br>
a - b = <%=a - b %><br>
a * b = <%=a * b %><br>
a / b = <%=a / b %><!-- 0으로 나누지 못하므로 예외 에러 발생 -->
</body>
</html>