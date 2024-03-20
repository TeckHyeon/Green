<%@page import="db.MemberVo"%>
<%@page import="db.DBHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String mid = request.getParameter("mid");

//데이터 조회 : mid 로 
DBHandler db = new DBHandler();
MemberVo vo = db.getMember(Integer.parseInt(mid));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<main>
		<h2>회원 상세 정보</h2>
		<table>
			<tr>
				<td>번호</td>
				<td><%=vo.getMid()%></td>
			</tr>
			<tr>

				<td>이름</td>
				<td><%=vo.getName()%></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><%=vo.getPhone()%></td>
			</tr>
			<tr>

				<td>가입일</td>
				<td><%=vo.getIndate()%></td>
			</tr>
			<tr>
			<td colspan="2">
			<a href="delete.jsp?mid=<%=vo.getMid()%>">[삭제]</a>
			<a href="updateform.jsp?mid=<%=vo.getMid()%>">[수정]</a>
			<a href="list.jsp">[목록]</a>
			</td>
			</tr>
		</table>
	</main>
</body>
</html>