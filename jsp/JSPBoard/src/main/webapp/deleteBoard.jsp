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
<style>
.jumbotron {
	background-color: lightgray;
}
</style>
<script>
	window.addEventListener("DOMContentLoaded", function() {
		var btnCancel = document.querySelector("#btn-cancel");
		btnCancel.addEventListener("click", function() {
			history.back();
		});
	});
</script>
</head>
<body>
<%
		request.setCharacterEncoding("utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
%>
	<% request.setCharacterEncoding("UTF-8");
	String type = "게시판 삭제 페이지";%>
	<jsp:include page="header.jsp" flush = "false">
	<jsp:param value="<%=type%>" name="type1"/>
	</jsp:include>
	
	<main class = "container">
		<form class = "mt-5" action = "deleteBoard_process.jsp" method = "post">
			<div class="my-3">
				<label for = "idx">삭제할 글 번호 : </label>
				<input type = "text" class="form-control" id="idx" name="idx" readonly value="<%=num%>">
			</div>
			<div class="my-3">
				<label for = "contentPw">삭제 비밀번호 : </label>
				<input type = "password" class="form-control" id="contentPw" name="contentPw" placeholder = "글을 삭제하려면 비밀번호를 입력하세요">
			</div>
			
			<div class="d-flex justify-content-between">
				<div>
					<a href = "boardList.jsp" class = "btn btn-secondary">목록</a>
				</div>
				<div>
					<button type = "submit" class = "btn btn-danger">삭제</button>
					<button type = "button" class = "btn btn-warning" id ="btn-cancel">취소</button>
				</div>
			</div>
			
		</form>
	</main>
	
	<%@ include file="footer.jsp" %>
</body>
</html>