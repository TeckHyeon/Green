<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>exception error page</title>
</head>
<body>
<h1>exception error page</h1>
<hr>
<%
	String errorMsg = exception.getMessage();
	String exceptionMsg = exception.toString();
%>
에러 메시지 : <%=errorMsg %><br>
예외 클래스명과 에러 메시지 : <%=exceptionMsg %>
</body>
</html>