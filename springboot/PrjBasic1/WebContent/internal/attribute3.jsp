<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>속성값의 자동 타입 변환</title>
</head>
<body>
<%
	pageContext.setAttribute("price", 100);
	Integer val = (Integer)pageContext.getAttribute("price");
	int value = val + 1000;
%>
val = <%=val %><br>
value = val + 1000 = <%=value %>
</body>
</html>