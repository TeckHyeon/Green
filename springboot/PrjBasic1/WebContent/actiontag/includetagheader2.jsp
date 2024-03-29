<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includetagheader2.jsp</title>
</head>
<body>
include 액션 태그의 header 페이지입니다.<p>
<h2>
웹 프로그래밍 언어 = "<%=request.getParameter("language") %>"
tag                = "<%=request.getParameter("tag") %>"
</h2>
</body>
</html>