<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myjsp.util.CookieUtil"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자바 클래스를 이용한 쿠키 생성</title>
</head>
<body>
<%
    // 쿠키 생성(추가)
	response.addCookie(CookieUtil.createCookie("book", 
			"JSP 웹 프로그래밍 입문"));
    // 모든 쿠키 정보를 가져온다
	CookieUtil cookie = new CookieUtil(request);	
	String str = "해당 쿠키가 존재하지 않습니다.";
	if (cookie.exists("book")) {
		str = cookie.getValue("book");
	}
%>
<%=str %>
</body>
</html>