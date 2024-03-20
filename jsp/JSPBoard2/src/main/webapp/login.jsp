<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String type = "로그인 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
	<jsp:param value="<%=type%>" name="type1"/>
	</jsp:include>

	<main class="container mt-5">
		<section class="row">
			<article class="col-sm-4 mx-auto">
				<form action="./loginCheck.jsp" method="post">
					<div class="my-3">
						<label for="user-id" class="form-label">ID : </label>
						<input type="text" class="form-control" id="user-id" name="userId" placeholder="ID를 입력해주세요">
					</div>
					<div class="my-3">
						<label for="user-pw" class="form-label">Password : </label>
						<input type="password" class="form-control" id="user-pw" name="userPw" placeholder="Password를 입력해주세요">
					</div>
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">로그인</button>
						<a href="signin.jsp" class="btn btn-secondary">회원 가입</a>
					</div>
				</form>
			</article>
		</section>
	</main>

	<%@ include file="footer.jsp" %>
</body>
</html>













