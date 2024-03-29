<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>config 내장 객체 예제</title>
</head>
<body>
<h1>config 내장 객체 예제</h1>
<hr>
<%
	Enumeration<?> enu = application.getInitParameterNames();
	while (enu.hasMoreElements()) {
		String initParamName = enu.nextElement().toString();
%>
<%=initParamName %> = <%=application.getInitParameter(initParamName) %><br>
<%
	}
%>
</body>
</html>