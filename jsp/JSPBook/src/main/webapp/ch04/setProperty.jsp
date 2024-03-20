<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action Tag</title>
</head>
<body>
	<jsp:useBean id="person" class="ch04.com.dao.Person" scope = "request" />
	<jsp:setProperty property="id" name="person" value = "20211119" />
	<jsp:setProperty property="name" name="person" value = "홍길동" />
	<p> 아이디 : <% out.println(person.getId()); %>
	<p> 이 름 : <% out.println(person.getName()); %>
</body>
</html>