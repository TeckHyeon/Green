<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application 내장 객체 예제</title>
</head>
<body>
<h1>application 내장 객체 예제</h1>
<hr>
1. 서버 정보 : <%=application.getServerInfo() %><br>
2. 서블릿 API 메이저 버전 : <%=application.getMajorVersion() %><br>
3. 서블릿 API 마이너 버전 : <%=application.getMinorVersion() %><br>
4. 실제 경로 : <%=application.getRealPath("application.jsp") %>
</body>
</html>