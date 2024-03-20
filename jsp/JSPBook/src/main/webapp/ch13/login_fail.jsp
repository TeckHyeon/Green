<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="refresh"
	content="5; url=http://localhost:8080/JSPBook/ch13/login.jsp"> -->
<title>Insert title here</title>
<script>
	window.addEventListener("DOMCountentLoaded", function() {
		setTimeout(function() {
			window.location.href = "login.jsp";
		})
	})
</script>
</head>
<body>
	<h3>로그인 실패 페이지</h3>
	<p>아이디 및 비밀번호가 틀렸습니다.</p>
	<p>5초 후 login 페이지로 이동합니다.</p>
	<a href="login.jsp">로그인 페이지로 이동</a>
</body>
</html>