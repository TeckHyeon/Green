<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session 로그인 체크</title>
</head>
<body>
<%
	String mid = (String)session.getAttribute("ID");
	boolean login = (mid == null) ? false : true;
%>
<%
	if (login) {
%>
<%=mid %> 아이디로 로그인하였습니다.<br>
세션 ID : <%=session.getId() %>
<p><a href="session_logout.jsp">로그아웃</a>
<%
	} else {
%>
로그인을 하지 않았습니다.
<p><a href="session_loginform.jsp">로그인폼 바로가기</a>
<%
	}
%>
</body>
</html>