<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 수정</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="icon" href="/img/favicon.png" />
</head>
<body>
	<main>
		<h2>유저 수정</h2>
		<form action="/users/update">
			<table>
				<tr>
					<td>유저 아이디</td>
					<td><input type="text" name="userid" value="${vo.userid}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>유저 이름</td>
					<td><input type="text" name="username" value="${vo.username}" /></td>
				</tr>
				<tr>
					<td>유저 비밀번호</td>
					<td><input type="password" name="passwd"/></td>
				</tr>
				<tr>
					<td>유저 이메일</td>
					<td><input type="text" name="email" value="${vo.email}"/></td>
				</tr>
				<tr>
					<td>UPOINT</td>
					<td><input type="text" name="upoint" value="${vo.upoint}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>가입일</td>
					<td><input type="text" name="indate" value="${vo.indate}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="수정" /><input
						type="button" value="취소" id="cancel_btn" /></td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			const goListEl = document.getElementById('cancel_btn');
			goListEl.addEventListener('click', function(e) {
				location.href = '/users/list';
			});
		</script>
	</main>
</body>
</html>