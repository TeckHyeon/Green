<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String uid = request.getParameter("userid");
String pwd = request.getParameter("passwd");
%>
<h2>로그인 정보</h2>
<div>아이디:<%out.print(uid); %></div>
<div>암호:<%out.print(pwd); %></div>