<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<link rel="icon" href="/img/favicon.png" />
<style>
input:not(input[type=submit]) {
	width: 100%;
}

input[type=submit] {
	width: 100px;
}

#list_btn {
	width: 80px;
}

td {
	padding: 10px;
	width: 700px;
	text-align: center;
}

td:nth-of-type(1) {
	width: 200px;
}

td:not([colspan]):first-child {
	background: black;
	color: white;
	font-weight: bold;
}
</style>
</head>

<body>
	<main>
		<h2>유저 등록</h2>
		<form action="/users/signin" method="POST">
			<table>
				<tr>
					<td>유저 아이디</td>
					<td><input type="text" name="userid" /></td>
				</tr>
				<tr>
					<td>유저 비밀번호</td>
					<td><input type="password" name="passwd" /></td>
				</tr>
				<tr>
					<td>유저 이름</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>유저 이메일</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>유저 포인트</td>
					<td><input type="text" name="upoint" /></td>
				</tr>
				<tr>
					<td>가입날짜</td>
					<td><input type="text" name="indate" value="${now}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="추가" /><input
						type="button" value="목록" id="list_btn" /></td>
				</tr>
			</table>
		</form>
	</main>
	<script type="text/javascript">
		const goListEl = document.getElementById('list_btn');
		goListEl.addEventListener('click', function(e) {
			location.href = '/users/list';
		});
	</script>
</body>

</html>