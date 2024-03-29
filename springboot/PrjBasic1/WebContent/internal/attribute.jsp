<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Attribute 예제</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String value = request.getParameter("value");

	if (name != null && value != null) {
		application.setAttribute(name, value);
	}
%>
<%
	if (name != null && value != null) {
%>
<%=name %> = <%=value %>
<%
	} else {
%>
application 내장 객체의 속성을 설정하지 않음.
<%
	}
%>
</body>
</html>