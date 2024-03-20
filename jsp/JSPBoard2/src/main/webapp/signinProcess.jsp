<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.bitc.dto.MemberDto" %>
<%@ page import="com.bitc.dto.MemberDao" %>


<jsp:useBean id="dao" class="com.bitc.dto.MemberDao"></jsp:useBean>
<jsp:useBean id="member" class="com.bitc.dto.MemberDto"></jsp:useBean>

<%
	/*
	1. 사용자가 입력한 내용 가져오기
	2. DB접속
	3. 사용자 정보 DB 등록
	*/
	
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	String userEmail = request.getParameter("userEmail");
// 	String userPhone1 = request.getParameter("userPhone1");
// 	String userPhone2 = request.getParameter("userPhone2");
// 	String userPhone3 = request.getParameter("userPhone3");
// 	String userPhone = userPhone1 + userPhone2 + userPhone3;
	String userPhone = request.getParameter("userPhone1") + request.getParameter("userPhone2") + request.getParameter("userPhone3");
	String userGender = request.getParameter("userGender");
	String userAddr = request.getParameter("userAddr");
	
// 	MemberDto member = new MemberDto(); 와 <jsp:useBean id="member" class="com.bitc.dto.MemberDto"></jsp:useBean> 한 것이 동일한 의미임
	member.setUserId(userId);
	member.setUserPw(userPw);
	member.setUserName(userName);
	member.setUserEmail(userEmail);
	member.setUserPhone(userPhone);
	member.setUserGender(userGender);
	member.setUserAddr(userAddr);
	
	int result = dao.insertMember(member);
	
	if (result > 0) {
		response.sendRedirect("login.jsp");
	}
	else {
		response.sendRedirect("signinError.jsp");
	}
%>













