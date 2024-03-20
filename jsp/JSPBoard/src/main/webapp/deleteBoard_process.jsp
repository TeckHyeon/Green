<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>

<%
request.setCharacterEncoding("utf-8");

int idx = Integer.parseInt(request.getParameter("idx"));
String passwd = request.getParameter("contentPw");

String sql = "UPDATE t_board set deleted_yn = 'Y' WHERE idx = ? AND passwd = ? ";
try {
	pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, passwd);

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
}
response.sendRedirect("boardList.jsp");
%>