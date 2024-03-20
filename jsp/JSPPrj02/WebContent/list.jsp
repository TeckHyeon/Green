<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import='db.DBHandler'%>
<%@ page import='db.MemberVo'%>
<%@ page import="java.util.*"%>
<%
// 변수 선언

DBHandler db = new DBHandler();
ArrayList<MemberVo> voList = db.selectList();

String html = "";

String fmt = "";

fmt += "<tr><td>%d</td>";
fmt += "<td><a href='view.jsp?mid=%d'>%s</a></td>";
fmt += "<td>%s</td>";
fmt += "<td>%s</td>";
fmt += "</tr>";
for (int i = 0; i < voList.size(); i++) {
	MemberVo vo = voList.get(i);
	html += String.format(fmt, vo.getMid(), vo.getMid(),vo.getName(), vo.getPhone(), vo.getIndate());
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/table.css" />

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>

		<h2>회원목록조회</h2>
		<table>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>전화</td>
				<td>가입일</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: right"><a href="memreg.html">[회원
						가입]</a></td>
			</tr>
			<%=html%>
		</table>
		<table>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>전화</td>
				<td>가입일</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align: right"><a href="memreg.html">[회원
						가입]</a></td>
			</tr>
			<%
			for (int i = 0; i < voList.size(); i++) {
				out.println("<tr>");
				out.println("<td>" + voList.get(i).getMid() + "</td>");
				out.println("<td>" + voList.get(i).getName() + "</td>");
				out.println("<td>" + voList.get(i).getPhone() + "</td>");
				out.println("<td>" + voList.get(i).getIndate() + "</td>");
				out.println("</tr>");
			}
			%>
		</table>
	</main>
</body>
</html>