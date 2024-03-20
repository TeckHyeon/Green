<%@page import="org.apache.jasper.runtime.JspRuntimeLibrary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- DB 사용 -->
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp"%>
<%!
	ResultSet rs = null;
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 만들기</title>

<!-- 부트스트랩5 적용 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<style>
.jumbotron {
	background-color: lightgray;
}
</style>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8");
	String type = "게시판 목록 페이지";%>
	<jsp:include page="header.jsp" flush = "false">
	<jsp:param value="<%=type%>" name="type1"/>
	</jsp:include>
	
	<main class="container">
		<table class="table table-striped table-hover text-center mt-5">
			<colgroup>
				<col width="10%" />
				<col width="50%" />
				<col width="15%" />
				<col width="20%" />
				<col width="5%" />
			</colgroup>
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>등록일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<%
				String sql = "SELECT idx, title, creator_id, created_date, hit_cnt FROM t_board WHERE deleted_yn = 'N'";

				try {
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						int idx = rs.getInt("idx");
						String title = rs.getString("title");
						String creatorId = rs.getString("creator_id");
						String createdDate = rs.getString("created_date");
						int hitcnt = rs.getInt("hit_cnt");

						String item = "<tr>";
						item += "<td>" + idx + "</td>";
						item += "<td><a href = 'selectBoard.jsp?num=" + idx + "'>" + title + "</a></td>";
						item += "<td>" + creatorId + "</td>";
						item += "<td>" + createdDate + "</td>";
						item += "<td>" + hitcnt + "</td>";
						item += "</tr>";

						out.println(item);
					}
				} catch (SQLException ex) {
					
				} finally {
					if (rs != null) {
						rs.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				}
				%>
			</tbody>
		</table>
		<div class="d-flex justify-content-end">
			<a href="insertBoard.jsp" class="btn btn-primary">글쓰기</a>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>