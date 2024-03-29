<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includetagheader.jsp</title>
</head>
<body>
include 액션 태그의 header 페이지입니다.<p>
<h2>
이름 = "<%=request.getParameter("name") %>"<br>
국가  = "<%=request.getParameter("nation") %>"
</h2>
</body>
</html>