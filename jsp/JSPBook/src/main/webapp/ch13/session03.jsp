<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<%
	String name;
	String value;

	Enumeration<String> en = session.getAttributeNames();
	int i = 0;

	while (en.hasMoreElements()) {
		i++;
		name = en.nextElement().toString();
		value = session.getAttribute(name).toString();
		out.println("설정된 세션의 속성 이름 [ " + 1 + " ] : " + name + "<br>");
		out.println("설정된 세션의 속성 값 [ " + 1 + " ] : " + value + "<br>");

	}
	%>
</body>
</html>