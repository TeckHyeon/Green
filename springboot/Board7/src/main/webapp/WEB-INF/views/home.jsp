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
<style>
</style>
</head>
<body>
	<main>
		<h2>Home</h2>
		<div>
			<a href="/Menus/WriteForm">새 메뉴 추가</a>
		</div>
		<div>
			<a href="/Menus/WriteForm2">새 메뉴 추가2</a>
		</div>
		<div>
			<a href="/Menus/List">메뉴 목록</a>
		</div>
		<hr />
		<div>
			<a href="/users/list">사용자 목록</a>
		</div>
		<div>
			<a href="/users/signinform">사용자 추가</a>
		</div>
		<div>&nbsp;</div>
		<div>
			<a href="/board/list?menu_id=MENU01">게시물 목록</a>
		</div>
		<div>
			<a href="/board/writeForm?menu_id=MENU01">게시물 등록</a>
		</div>
		<div>&nbsp;</div>
		<div>
			<a href="/boardPaging/list?menu_id=MENU01">게시물 목록(페이징)</a>
		</div>
		<div>
			<a href="/boardPaging/writeForm?menu_id=MENU01">게시물 등록(페이징)</a>
		</div>
		<div>&nbsp;</div>

		<div>
			${login.username }님 환영합니다<br> 당신의 가입일은 ${login.indate } 입니다.
		</div>
		<c:choose>
			<c:when test="${not empty login.username}">
				<div>
					<a href="/logout">로그아웃</a>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<a href="/loginform">로그인</a>
				</div>
			</c:otherwise>
		</c:choose>

	</main>
</body>
</html>


