<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<form action = "session01_process.jsp" method = "post">
	<p>
		<label for = "id">아이디 : </label>
		<input type="text" name="id" id="id">
	</p>
	<p>
		<label for = "passwd">비밀번호 : </label>
		<input type="text" name="passwd" id="passwd">
	</p>
	<button type="submit">전송</button>
	</form>
	<hr>
	<a href="session02.jsp"> 세션 상태 확인 페이지로 이동 </a>
</body>
</html>