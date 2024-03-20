<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


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
	request.setCharacterEncoding("UTF-8");
	String type = "회원가입 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
	<jsp:param value="<%=type%>" name="type1"/>
	</jsp:include>

	<main class="container">
		<section class="row">
			<article class="col-sm-4 mx-auto">
				<form action="signinProcess.jsp" method="post">
					<div class="my-3">
						<label for="user-id" class="form-label">ID : </label>
						<input type="text" class="form-control" id="user-id" name="userId" placeholder="사용할 ID를 입력하세요">
					</div>
					<div class="my-3">
						<label for="user-pw" class="form-label">Password : </label>
						<input type="password" class="form-control" id="user-pw" name="userPw" placeholder="사용할 Password를 입력하세요">
					</div>
					<div class="my-3">
						<label for="user-name" class="form-label">Name : </label>
						<input type="text" class="form-control" id="user-name" name="userName" placeholder="이름을 입력하세요">
					</div>
					<div class="my-3">
						<label for="user-email" class="form-label">Email : </label>
						<input type="email" class="form-control" id="user-email" name="userEmail" placeholder="Email을 입력하세요">
					</div>
					<div class="my-3">
						<label for="user-phone" class="form-label">Phone : </label>
						<div class="row" id="user-phone">
							<div class="col-sm-4">
								<select class="form-select" name="userPhone1">
									<option value="02">02</option>
									<option value="051">051</option>
									<option value="010">010</option>
								</select>
							</div>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="userPhone2">
							</div>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="userPhone3">
							</div>
						</div>
					</div>
					<div class="my-3">
						<label for="user-gender" class="form-label">Gender : </label>
						<div id="user-gender">
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" id="user-gender-m" name="userGender" value="M" checked>
								<label for="user-gender-m" class="form-check-label">남성</label>
							</div>
							<div class="form-check form-check-inline">
								<input type="radio" class="form-check-input" id="user-gender-f" name="userGender" value="F">
								<label for="user-gender-f" class="form-check-label">여성</label>
							</div>
						</div>
					</div>
					<div class="my-3">
						<label for="user-addr" class="form-label">Address : </label>
						<textarea class="form-control" id="user-addr" name="userAddr" rows="3"></textarea>
					</div>
					
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-primary">확인</button>
						<button type="reset" class="btn btn-secondary" id="btnCancel">취소</button>
					</div>
				</form>
			</article>
		</section>
	</main>
	
	<%@ include file="footer.jsp" %>
</body>
</html>













