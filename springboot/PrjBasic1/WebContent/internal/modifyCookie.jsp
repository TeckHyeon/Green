<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>name 쿠키 값 변경</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (int i=0; i<cookies.length; i++) {
			if (cookies[i].getName().equals("name")) {
				sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
				String cValue = "JSP 프로그래밍 도서";
				byte[] b1 = cValue.getBytes();
				Cookie cookie = new Cookie("name", encoder.encode(b1));
				response.addCookie(cookie);
				out.println("name 쿠키 값 변경을 완료하였습니다.<br><br>");
				out.println("<a href='getCookie.jsp'>변경된 쿠키 값 확인</a>");
				break;
			} 
		}
	}
%>
</body>
</html>