<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String title = request.getParameter("title");
	String contents = request.getParameter("contents");
	String userId = request.getParameter("userId");
	String contentPw = request.getParameter("contentPw");

	if (contentPw == null || contentPw.isEmpty()) {
		contentPw = "1234";
	}

	try {
		String sql = "INSERT INTO t_board (title, contents, creator_id, passwd, created_date) values (?,?,?,?, NOW()) ";

		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, contents);
		pstmt.setString(3, userId);
		pstmt.setString(4, contentPw);

		int count = pstmt.executeUpdate();

		if (count < 1) {

		} else {

		}

	} catch (SQLException ex) {

	} finally {
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}

		response.sendRedirect("boardList.jsp");
	}
	%>
</body>
</html>