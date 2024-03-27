<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 수정</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="icon" href="/img/favicon.png" />
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet"  href="/css/common.css" />
<style>
textarea {
	height: 250px;
	width: 100%;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script>
</head>
<body>
	<main>
		<h2>글 수정</h2>


		<form action="/board/update">
			<div class="row my-3" style="width: 24em">
				<label for="bno" class="col-sm-8 col-form-label">bno</label>
				<div class="col-sm-9">
					<input type="text" name="bno" id="bno" value="${board.bno}" readonly="readonly" />
				</div>
			</div>
			<div class="row my-3" style="width: 24em">
				<label for="menu_id" class="col-8 col-form-label">메뉴 아이디</label>
				<div class="col-sm-9">
					<input type="text" name="menu_id" id="menu_id" value="${board.menu_id}" readonly="readonly" />
				</div>
			</div>
			<div class="row my-3" style="width: 24em">
				<label for="title" class="col-8 col-form-label">글제목</label>
				<div class="col-sm-9">
					<input type="text" name="title" id="title" value="${board.title}" />
				</div>
			</div>
			<div class="row my-3" style="width: 24em">
				<label for="content" class="col-8 col-form-label">글 내용</label>
				<div class="col-sm-9">
					<textarea name="content" id="content" >${board.title}</textarea>
				</div>
			</div>
			<div class="row my-3" style="width: 24em">
				<label for="writer" class="col-8 col-form-label">작성자</label>
				<div class="col-sm-9">
					<input type="text" name="writer" id="writer" value="${board.writer}" />
				</div>
			</div>
			<div class="row my-4" style="width: 24em">
				<div class="col-8"></div>
				<input type="submit" value="수정" /><input type="button" value="취소" id="cancel_btn" />
			</div>
		</form>











		<script>
			const goListEl = document.getElementById('goList');
			goListEl.addEventListener('click', function(e) {
				location.href = '/board/list?menu_id=${menu_id}';
			})
		</script>
	</main>
</body>
</html>