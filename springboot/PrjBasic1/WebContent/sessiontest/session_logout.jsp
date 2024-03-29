<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    session.invalidate(); // 모든 session변수 초기화
    response.sendRedirect("NewFile.html");
%>