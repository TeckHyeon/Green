<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="www.lug.or.kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page 내장 객체 예제</title>
</head>
<body>
<h1>page 내장 객체 예제</h1>
<%
	String pageinfo = this.getServletInfo();
%>
현재 페이지의 info값 : <%=pageinfo %>
</body>
</html>