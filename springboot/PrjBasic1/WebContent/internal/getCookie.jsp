<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie 검사와 cookie 값 가져오기</title>
</head>
<body>
<%
	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (int i=0; i<cookies.length; i++) {
			if (cookies[i].getName().equals("name")) {
				byte[] b2 = decoder.decodeBuffer(cookies[i].getValue());
				String cValue2 = new String(b2);
%>
클라이언트 웹 브라우저가 가지고 있는 name 속성의 쿠키 값은?<hr>
쿠키의 이름 : <%=cookies[i].getName() %><br>
name 속성의 쿠키 값 : <%=cValue2 %>
<%
			}
		}
	}
%>
</body>
</html>