<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="dbconn.jsp"%>
	<%
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		String sql = "SELECT * FROM member ";
		stmt = conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		while (rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("passwd");
			String name = rs.getString("name");
			
			out.println("아이디 : " + id + "<br>비밀번호 : " + password + "<br>이름 : " + name);
			out.println("<br>-------------------------------<br>");
		}
	}
	catch (SQLException ex) {
		out.println("데이터 베이스 조회 시 오류가 발생했습니다.");
		out.println("SQLException : " + ex.getMessage());
	} finally {
		if (rs != null)
			rs.close();
		if (stmt != null) 
			stmt.close();
		
		if (conn != null)
			conn.close();
		
	}
	%>

</body>
</html>