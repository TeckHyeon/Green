<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>session 로그인 처리</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	if (id.equals(pass) && !id.equals("")) {
		session.setAttribute("ID", id);
%>
로그인에 성공하였습니다.<br>
세션 ID : <%=session.getId() %>
<%
	} else { // 로그인 실패할 경우 자바 스크립트 새창을 띄운다.
%>
<script>
alert("로그인 실패입니다.");
history.go(-1);
</script>
<%
	}
%>
<p><a href="session_logincheck.jsp">로그인 체크해보기</a>
</body>
</html>