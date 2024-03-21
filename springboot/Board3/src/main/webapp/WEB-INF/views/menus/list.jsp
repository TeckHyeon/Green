<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

/*
  tr:first-child > td {
     border-color : white;
  }
  */
tr:nth-child(2)>td {
	text-align: right;
}
</style>

</head>
<body>
	<main>
		<h2>메뉴 목록</h2>
		<div>
			<table>
				<tr>
					<td style="border-left-color: black;">Menu_seq</td>
					<td>Menu_id</td>
					<td>Menu_name</td>
					<td>삭제</td>
					<td style="border-right-color: black;">수정</td>
				</tr>
				<tr>
					<td colspan="5">[<a href="/Menus/WriteForm">메뉴등록</a>]&nbsp;&nbsp;&nbsp;[<a
						href="/Menus/WriteForm2">메뉴등록2</a>]

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
				document.addEventListener('click',
						function(e) {
							if (e.target
									&& e.target.classList
											.contains('delete_btn')) {
								e.preventDefault(); // 기본 동작 방지
								var menuSeq = e.target
										.getAttribute('data-menu-seq');
								if (confirm("정말 삭제하시겠습니까?")) {
									location.href = '/Menus/Delete?menu_seq='
											+ menuSeq;
								}
							}
						});
			</script>
		</div>
		<a href="/">home</a>
	</main>
</body>
</html>