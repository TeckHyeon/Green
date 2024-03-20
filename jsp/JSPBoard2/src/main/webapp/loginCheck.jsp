<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.bitc.dto.MemberDto" %>
<%@ page import="com.bitc.dto.MemberDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	
	/*
	5. DB에서 가져온 정보를 세션에 저장하기
	*/
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	MemberDao dao = new MemberDao();
	
	int count = dao.idPwCheck(userId, userPw);
	
	if (count > 0) {
// 		사용자 정보 불러오기
		MemberDto member = dao.getUserInfo(userId);
		
// 		세션 저장
		session.setAttribute("userId", member.getUserId());
		session.setAttribute("userName", member.getUserName());
		session.setAttribute("userEmail", member.getUserEmail());
		
		response.sendRedirect("boardList.jsp");
	}
	else {
		response.sendRedirect("loginFail.jsp");
	}
	%>
</body>
</html>















