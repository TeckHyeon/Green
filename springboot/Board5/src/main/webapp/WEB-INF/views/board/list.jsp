<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/png" href="/img/favicon.png" />
<link rel="stylesheet" href="/css/common.css" />
<script
	src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script>
<style>
table {
width: 1000px;}
#board {

td {
	padding: 10px;
	width: 150px;
	text-align: center;
}

tr:first-child {
	background-color: black;
	color: white;
	font-weight: bold;
	/* SCSS 문법에 적용 
     https://www.jsdelivr.com/package/npm/browser-scss
      */
	td
	{
	border-color
	:
	white;
}

}
tr:nth-child(2)>td {
	text-align: right;
}

td:nth-of-type(1) {
	width: 80px;
}

td:nth-of-type(2) {
	width: 400px;
}

td:nth-of-type(3) {
	width: 120px;
}

td:nth-of-type(4) {
	width: 180px;
}

td:nth-of-type(5) {
	width: 80px;
}

td:first-child>td {
	text-align: center;
}
}

</style>

</head>
<body>
	<main>
		<%@include file="/WEB-INF/include/menus.jsp" %>
		<%-- <c:import url="/WEB-INF/include/menus.jsp" ></c:import> --%>
		<h2>글목록</h2>
		<table id="board">
			<tr>
				<td>번호</td>
				<td>글제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<tr>
				<td colspan="7">[<a href="/board/writeForm?menu_id=${ boardVo.menu_id }">글쓰기</a>]
				</td>
			</tr>

			<c:forEach var="boardVo" items="${ boardList }">
				<tr>
					<td>${ boardVo.bno    }</td>
					<td><a href="/board/view?bno=${ boardVo.bno }">${ boardVo.title    }</td>
					<td>${ boardVo.writer    }</td>
					<td>${ boardVo.regdate    }</td>
					<td>${ boardVo.hit    }</td>
				</tr>
			</c:forEach>

		</table>

	</main>
</body>
</html>








