<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%
     request.setCharacterEncoding("utf-8");
     String  id   = request.getParameter("id");
     String  pass = request.getParameter("pass");
     
     if(id.equals("sky") && pass.equals("1234") ) {
    	 session.setAttribute("id", id);
    	 out.print("<h2 style='color:blue'>로그인성공했습니다</h2>");
     } else {
    	 session.removeAttribute("id");
    	 out.print("<h2 style='color:red'>로그인실패했습니다</h2>");    	 
    	 out.print("<a href='javascript:history.back()'>뒤로가기</h2>");
     }     
 %>   
<a href="session_logincheck.jsp">로그인확인하기</a>