<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script>
	window.addEventListener("DOMContentLoaded", function() {
		var btnCancel = document.querySelector("#btnCancel");
		btnCancel.addEventListener("click", function() {
			history.back();
		});
	});
</script>
</head>
<body>

	<%
	String userId = (String) session.getAttribute("userId");

	if (userId == null) {
		response.sendRedirect("authFail.jsp");
	}
	%>

	<%
	request.setCharacterEncoding("UTF-8");
	String type = "게시글 등록 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
		<jsp:param value="<%=type%>" name="type1" />
	</jsp:include>

	<main class="container mt-4">
		<section class="row">
			<article class="col-sm">
				<form action="boardInsert.jsp" method="post">
					<div class="my-3">
						<label for="title" class="form-label">제목 : </label> <input
							type="text" class="form-control" id="title" name="title"
							placeholder="제목을 입력하세요">
					</div>
					<div class="my-3">
						<label for="content" class="form-label">내용 : </label>
						<textarea rows="5" cols="30" class="form-control" id="contents"
							name="contents"></textarea>
					</div>
					<div>
						<input type="hidden" id="userId" name="userId" value="<%= userId %>">
					</div>
					<div class="d-flex justify-content-end">
						<button type="submit" class="btn btn-primary me-2">등록</button>
						<button type="reset" class="btn btn-secondary " id="btnCancel">취소</button>
					</div>
				</form>
			</article>
		</section>
	</main>

	<%@ include file="footer.jsp"%>
</body>
</html>