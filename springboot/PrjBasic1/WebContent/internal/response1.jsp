<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>response.sendRedirect()</title>
</head>
<body>
<%
	// url을 response2.jsp로 리다이렉트한다.
	response.sendRedirect("response2.jsp");
%>
</body>
</html>