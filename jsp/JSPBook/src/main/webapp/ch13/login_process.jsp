<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		String id = "test1";
		String pw = "test1234";
	%>
	<%
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		if (id.equals(userId) && pw.equals(userPw)) {
			session.setAttribute("userId", userId);
			session.setAttribute("userName", "홍길동");
			session.setAttribute("userPw", userPw);
			response.sendRedirect("login_ok.jsp");
		} else {
			response.sendRedirect("login_fail.jsp");
		}
	%>
</body>
</html>