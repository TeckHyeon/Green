<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
double v1 = Double.parseDouble(request.getParameter("v1"));
double v2 = Double.parseDouble(request.getParameter("v2"));
String op = request.getParameter("op");
double result = 0.0;
switch (op) {
case "-선택-":
	break;
case "+":
	result = v1 + v2;
	break;
case "-":
	result = v1 - v2;
	break;
case "*":
	result = v1 * v2;
	break;
case "/":
	result = v1 / v2;
	break;

default:
	result = 0.0;
	break;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과</h2>
	<div>
		<%=result%>
	</div>
</body>
</html>