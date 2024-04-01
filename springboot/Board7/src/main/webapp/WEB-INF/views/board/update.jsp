<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 수정</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="icon" href="/img/favicon.png" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/common.css" />
<style>
textarea {
	height: 250px;
	width: 100%;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/browser-scss@1.0.3/dist/browser-scss.min.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function() {

		const  goListEl  = document.getElementById('btn-list');
	     goListEl.addEventListener('click', function(e) {
	        location.href = '/board/list?menu_id=' + "${board.menu_id}";
	     })

		document.getElementById("btn-cancel").addEventListener("click",
				function() {
			   document.getElementById("title").value = "${board.title}";
		        document.getElementById("content").value = "${board.content}";
		        document.getElementById("writer").value = "${board.writer}";
				});
	});
</script>

</head>
<body>
	<main class="container mt-5">
		<div class="row">
			<div class="col-sm">
				<form action="/board/update">
					<div class="form-floating my-3">
						<input type="text" class="form-control" name="bno" id="bno" value="${board.bno}" readonly="readonly" /> <label for="bno">bno</label>
					</div>
					<div class="form-floating my-3">
						<input type="text" class="form-control" name="menu_id" id="menu_id" value="${board.menu_id}" readonly="readonly" /> <label for="menu_id">메뉴 아이디</label>
					</div>
					<div class="form-floating my-3">
						<input type="text" class="form-control" name="title" id="title" value="${board.title}" /> <label for="title">글 제목</label>
					</div>
					<div class="form-floating my-3">
						<textarea rows="20" class="form-control" id="content" name="content" placeholder="내용" style="height: 250px; width: 100%;">${board.content}</textarea>
						<label for="content">내용</label>
					</div>
					<div class="form-floating my-3">
						<input type="text" class="form-control" name="writer" id="writer" value="${board.writer}" /><label for="writer">작성자</label>
					</div>
					<div class="my-3 clearfix">
						<button type="button" id="btn-list" class="btn btn-secondary float-start">목록</button>
						<button type="reset" id="btn-reset" class="btn btn-warning float-end">리셋</button>
						<button type="submit" id="btn-submit" class="btn btn-primary float-end me-2">등록</button>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>