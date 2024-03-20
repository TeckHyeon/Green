<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.bitc.dto.*"%>


<%
request.setCharacterEncoding("UTF-8");

String userId = request.getParameter("userId");
String title = request.getParameter("title");
String contents = request.getParameter("contents");

BoardDao dao = new BoardDao();
BoardDto board = new BoardDto();

board.setTitle(title);
board.setContents(contents);
board.setCreatorId(userId);

int result = dao.boardInsert(board);

response.sendRedirect("boardList.jsp");
	
%>