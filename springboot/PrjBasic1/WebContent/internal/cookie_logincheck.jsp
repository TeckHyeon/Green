<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myjsp.util.CookieUtil"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie 로그인 체크</title>
</head>
<body>
<%
    // 모든 쿠키 가져오기 
	CookieUtil cookie = new CookieUtil(request);
	boolean login = cookie.exists("LOGIN") &&
		cookie.getValue("LOGIN").equals("SUCCESS");
%>
<%
	if (login) {
		String mid = cookie.getValue("ID");
%>
<%=mid %> 아이디로 로그인하였습니다.<br>
<p><a href="cookie_logout.jsp">로그아웃</a>
<%
	} else {
%>
로그인을 하지 않았습니다.
<p><a href="cookie_loginform.jsp">로그인폼 바로가기</a>
<%
	}
%>
</body>
</html>