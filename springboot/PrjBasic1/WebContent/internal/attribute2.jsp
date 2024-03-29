<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>attribute 속성값 출력</title>
</head>
<body>
<h1>attribute 속성값 출력</h1>
<hr>
<%
	Enumeration<?> enu = application.getAttributeNames();
	while (enu.hasMoreElements()) {
		String name = enu.nextElement().toString();
		Object value = application.getAttribute(name);
%>
application 속성값 : <%=name %> = <%=value %><br>
<%
	}
%>
</body>
</html>