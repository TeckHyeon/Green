<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="myjsp.util.CookieUtil"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookie 로그인 처리</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	// 입력한 id와 pass가 동일하고 id가 공백이 아니면 쿠키 생성
	if (id.equals(pass) && !id.equals("")) {
		response.addCookie( // 로그인 상태 판단을 위해 사용
			CookieUtil.createCookie("LOGIN", "SUCCESS", "/", -1)
		);
		response.addCookie( // 로그인한 아이디 저장
			CookieUtil.createCookie("ID", id, "/", -1)
		);
%>
로그인에 성공하였습니다.<br>
<%
	} else { // 로그인 실패할 경우 자바 스크립트 새창을 띄운다.
%>
<script>
alert("로그인 실패입니다.");
history.go(-1);
</script>
<%
	}
%>
<p><a href="cookie_logincheck.jsp">로그인 체크해보기</a>
</body>
</html>