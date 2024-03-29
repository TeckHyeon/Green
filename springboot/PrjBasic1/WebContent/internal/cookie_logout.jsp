<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myjsp.util.CookieUtil"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie 로그아웃</title>
</head>
<body>
<%
	response.addCookie(
		// 쿠키 유효 시간을 0으로 지정하여 쿠키를 삭제한다.
		CookieUtil.createCookie("LOGIN", "", "/", 0)
	);
	response.addCookie(
		// 쿠키 유효 시간을 0으로 지정하여 쿠키를 삭제한다.
		CookieUtil.createCookie("ID", "", "/", 0)
	);
%>
로그아웃 하였습니다.
<p><a href="cookie_loginform.jsp">로그인폼 바로가기</a>
</body>
</html>