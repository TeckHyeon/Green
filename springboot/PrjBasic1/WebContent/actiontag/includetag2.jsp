<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includetag2.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- include action 에 파라미터 추가 전송 -->
<jsp:include page="includetagheader2.jsp?tag=123">     
	<jsp:param name="language" value="PHP" />	
</jsp:include>
<hr>
<b>
request parameter : <%=request.getParameter("language") %>
</b><br>
include 액션 태그의 body 페이지입니다.
</body>
</html>