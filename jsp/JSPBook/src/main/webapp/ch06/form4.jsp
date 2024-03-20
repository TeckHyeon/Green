<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Form Processing</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 mx-auto">
		<h3 class="text-center mt-5">회원 가입</h3>
			</div>
		</div>
		<form action="form_process3.jsp" name="member" method="post">
		<div class="mb-3 mt-3">
			<p>
				<label for="userId">아이디 : </label>
				<input type="text" class= "form-control" id="userid" name="id" placeholder="아이디를 입력해주세요">
		</div>
	
		<div class="mb-3 mt-3">			
			<p>
				비밀번호 : <input type="password" name="passwd">
		</div>>
			<p>
				이름 : <input type="text" name="name">
			<p>
				연락처 : <select name="phone1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="019">019</option>
				</select> 
						- <input type="text" maxlength="4" size="4" name="phone2"> 
						- <input type="text" maxlength="4" size="4" name="phone3">
			<p>
				성별 : 	<input type="radio" name="sex" value="남성" checked>남성 
						<input type="radio" name="sex" value="여성">여성
			<p>
				취미 : 독서<input type="checkbox" name="hobby" value ="독서" checked>
					   운동<input type="checkbox" name="hobby" value = "운동" >
					   영화<input type="checkbox" name="hobby" value ="영화" >
			<p>
					<textarea name="comment" rows="3" cols="30"
						placeholder="가입 인사를 입력해주세요.">
					</textarea>
					
			<p> <input type = "submit" value="가입하기">
				<input type = "reset" value="다시쓰기">
		</form>
	</div>
</body>
</html>