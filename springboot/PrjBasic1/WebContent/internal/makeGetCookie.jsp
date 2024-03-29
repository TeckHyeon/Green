<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie 생성과 cookie 값 얻어오기</title>
</head>
<body>
<%
	sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	String cValue1 = "자바";
	byte[] b1 = cValue1.getBytes();
	Cookie cookie1 = new Cookie("id", encoder.encode(b1));
	cookie1.setDomain(".lug.or.kr");
	cookie1.setMaxAge(60 * 60);
	cookie1.setPath("/");
	response.addCookie(cookie1);

	String cValue2 = "jsp";
	byte[] b2 = cValue2.getBytes();
	Cookie cookie2 = new Cookie("id", encoder.encode(b2));
	cookie2.setDomain("www.lug.or.kr");
	cookie2.setMaxAge(60 * 30);
	cookie2.setPath("/jsp");
	response.addCookie(cookie2);

	String cValue3 = "tomcat";
	byte[] b3 = cValue3.getBytes();
	Cookie cookie3 = new Cookie("id", encoder.encode(b3));
	cookie3.setDomain("book.lug.or.kr");
	cookie3.setMaxAge(60 * 30);
	response.addCookie(cookie3);
%>
<b>클라이언트 웹 브라우저가 가지고 있는 id 속성의 쿠키 값은?</b>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length > 0) {
		for (int i=0; i<cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
				byte[] bb = decoder.decodeBuffer(cookies[i].getValue());
				String cValue = new String(bb);
%>
<hr>
쿠키의 이름 : <%=cookies[i].getName() %><br>
id 속성의 쿠키 값 : <%=cValue %>
<%
			}
		}
	}
%>
<hr>
</body>
</html>