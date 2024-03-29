<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예외 에러 발생!</title>
</head>
<body>
<h1>Exception Error!</h1>
아래와 같은 예외가 발생하였습니다.<br>
<%=exception.getMessage() %><br>
<%=pageContext.getErrorData().getThrowable().toString() %>
</body>
</html>