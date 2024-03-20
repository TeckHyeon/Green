<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="delete02_process.jsp" method = "post">
		
		<label for = "id">아이디 : </label>
		<input type = "text" id = "id" name = "id"><br><br>
		<label for = "password">비밀번호 : </label>
		<input type = "password" id = "passwd" name = "passwd"><br><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>