<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "login_process.jsp" method = "post">
	<p><label for = "usedId">아이디 : </label>
	<input type = "text" name = "userId" id = "userId" placeholder="아이디를 입력해주세요.">
	</p>	
	<p>
	<label for = "userPw">비밀번호 : </label>
	<input type = "password" name = "userPw" id = "userPw" placeholder="비밀번호를 입력해주세요.">
	</p>
	<button type = "sumbit">로그인</button>
	</form>
</body>
</html>