<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 수정</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="icon" href="/img/favicon.png" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style>
input:not(input[type=submit]) {
	width: 100%;
}

input[type=submit] {
	width: 100px;
}

#goList {
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

input[readonly] {
	background: #EEE;
}
</style>
</head>
<body>
	<main>
		<h2>유저 상세 정보</h2>
		<table>
			<tr>
				<td>유저 아이디</td>
				<td>${vo.userid}</td>
			</tr>
			<tr>
				<td>유저 이름</td>
				<td>${vo.username}</td>
			</tr>
			<tr>
				<td>유저 이메일</td>
				<td>${vo.email}</td>
			</tr>
			<tr>
				<td>유저 등급</td>
				<td>${vo.upt}</td>
			</tr>
			<tr>
				<td>UPOINT</td>
				<td><c:choose>
						<c:when test="${ vo.upoint != 0 }">
							${vo['upoint']} 
						</c:when>
						<c:otherwise>
							<span style="color: red">없음</span>
						</c:otherwise>
					</c:choose></td>
			</tr>

			<tr>
				<td>가입일</td>
				<td>${vo.indate}</td>
			</tr>
			<tr>
				<td colspan="2"><a class="btn btn-primary"
					href="/users/signinform" role="button">회원가입</a> <a
					class="btn btn-primary"
					href="/users/updateform?userid=${ vo.userid }" role="button">회원수정</a>
					<a class="btn btn-primary"
					href="/users/delete?userid=${ vo.userid }" role="button">회원삭제</a> <a
					class="btn btn-primary" href="/users/list" role="button">회원목록</a> <a
					class="btn btn-primary" href="/" role="button">Home</a>
			</tr>
		</table>
	</main>
</body>
</html>