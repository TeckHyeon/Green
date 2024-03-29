<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includetag.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8"); // 캐릭터셋 설정
	String name = "JSP 기초"; // 사용되지 않는 변수
%>
<jsp:include page="includetagheader.jsp" flush="true" />
<hr>
include 액션 태그의 body 페이지입니다.
</body>
</html>