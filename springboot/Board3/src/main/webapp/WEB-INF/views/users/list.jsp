<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="icon" href="/img/favicon.png" />
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
		<h2>Users List</h2>
		<h2>메뉴 목록</h2>
		<div>
			<table>
				<tr>
					<td style="border-left-color: black;">아이디</td>
					<td>이름</td>
					<td>이메일</td>
					<td>회원등급</td>
					<td>가입일</td>
					<td style="border-right-color: black;">수정</td>
				</tr>
				<tr>
					<td colspan="5">[<a href="/Users/signinForm">사용자등록</a>]&nbsp;&nbsp;&nbsp;[<a
						href="/Users/signinForm2">사용자등록2</a>]

					</td>
				</tr>
				<c:forEach var="user" items="${ lists }">
					<tr>
						<td>${ user.userid }</td>
						<td>${ user.username }</td>
						<td>${ user.email }</td>
						<td>${ user.upoint }</td>
						<td>${ user.indate }</td>
						<td><a href="#" class="delete_btn"
							data-userid="${user.userid}">삭제</a>
						<td><a href="/Users/UpdateForm/${ user.userid }">수정</a>
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
								var userid = e.target
										.getAttribute('data-userid');
								if (confirm("정말 삭제하시겠습니까?")) {
									location.href = '/Users/Delete?userid='
											+ userid;
								}
							}
						});
			</script>
		</div>
	</main>
</body>
</html>





