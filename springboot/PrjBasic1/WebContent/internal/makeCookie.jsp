<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie 생성</title>
</head>
<body>
[cookie 생성 시작]<hr>
<%
	sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	String cValue = "한빛nara";
	byte[] b1 = cValue.getBytes();
	Cookie cookie = new Cookie("name", encoder.encode(b1));
	response.addCookie(cookie);
%>
<%
	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	byte[] b2 = decoder.decodeBuffer(cookie.getValue());
	String cValue2 = new String(b2);
%>
[cookie 생성 완료]<hr>
[생성한 cookie 정보 보기]<hr>
쿠키 이름 : <%=cookie.getName() %><br>
쿠키 값 : <%=cValue2 %>
</body>
</html>