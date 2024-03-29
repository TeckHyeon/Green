<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>include 지시자 사용</title>
</head>
<body>
top : <%@ include file="top.jsp" %>
<hr>include.jsp의 본문 내용입니다.<hr>
bottom : <%@ include file="bottom.jsp" %>
</body>
</html>