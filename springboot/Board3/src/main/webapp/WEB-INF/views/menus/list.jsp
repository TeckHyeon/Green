<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
<%@ page import="com.board.domain.MenuVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="icon" href="/img/favicon.png" />
<script
	src="
https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js
"></script>
<style type="text/css">
td {
	padding: 10px;
	width: 150px;
	text-align: center;
}

tr:first-child {
	background-color: black;
	color: white;
	font-weight: bold;
	td
	{
	border-color
	:
	red;
}
}
</style>
</head>
<body>
	<h2>메뉴 목록</h2>
	<div>
		<table>

			<tr>
				<th>Menu_seq</th>
				<th>Menu_id</th>
				<th>Menu_name</th>
			</tr>


			<%
			Object obj = request.getAttribute("lists");
			List<MenuVo> menus;
			if (obj instanceof List<?>) {
				List<?> temp = (List<?>) obj;
				if (!temp.isEmpty() && temp.get(0) instanceof MenuVo) {
					menus = (List<MenuVo>) temp;
				} else {
					menus = Collections.emptyList(); // 비어 있는 리스트 할당
				}
			} else {
				menus = Collections.emptyList(); // 비어 있는 리스트 할당
			}

			for (MenuVo menu : menus) {
			%>
			<tr>
				<td><%=menu.getMenu_seq()%></td>
				<td><%=menu.getMenu_id()%></td>
				<td><%=menu.getMenu_name()%></td>
			</tr>
			<%
			}
			%>

		</table>
		<table>
			<tr>
				<td>Menu_seq</td>
				<td>Menu_id</td>
				<td>Menu_name</td>
				<td>삭제</td>
				<td>수정</td>
			</tr>
			<tr>
				<td colspan="5">[<a href="/Menus/WriteForm">메뉴등록</a>]
				</td>
			</tr>
			<c:forEach var="menu" items="${ lists }">
				<tr>
					<td>${ menu.menu_seq }</td>
					<td>${ menu.menu_id }</td>
					<td>${ menu.menu_name }</td>
					<td><a href="#" class="delete_btn"
						data-menu-seq="${menu.menu_seq}">삭제</a>
					<td><a href="/Menus/UpdateForm/${ menu.menu_seq }">수정</a>
				</tr>
			</c:forEach>
		</table>
		<script type="text/javascript">
			document.addEventListener('click', function(e) {
				if (e.target && e.target.classList.contains('delete_btn')) {
					e.preventDefault(); // 기본 동작 방지
					var menuSeq = e.target.getAttribute('data-menu-seq');
					if (confirm("정말 삭제하시겠습니까?")) {
						location.href = '/Menus/Delete/' + menuSeq;
					}
				}
			});
		</script>
	</div>
	<a href="/">home</a>
</body>
</html>