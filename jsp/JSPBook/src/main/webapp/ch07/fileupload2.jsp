<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form action = "fileupload02_process.jsp" method = "post" 
	enctype = "multipart/form-data" name="fileForm">
	
	<label for="name">이름1 : </label>
	<input type="text" id="name1" name="name1"><br>
	<label for="subject">제목1 : </label>
	<input type="text" id="subject1" name="subject1"><br>
	<label for="filename">파일1 : </label>
	<input type="file" id="filename1" name="filename1"><br>
	
	<label for="name">이름2 : </label>
	<input type="text" id="name2" name="name2"><br>
	<label for="subject">제목2 : </label>
	<input type="text" id="subject2" name="subject2"><br>
	<label for="filename">파일2 : </label>
	<input type="file" id="filename2" name="filename2"><br>
	
	<label for="name">이름3 : </label>
	<input type="text" id="name3" name="name3"><br>
	<label for="subject">제목3 : </label>
	<input type="text" id="subject3" name="subject3"><br>
	<label for="filename">파일3 : </label>
	<input type="file" id="filename3" name="filename3"><br>
	
	<button type="submit">파일 올리기</button>
	</form>
</body>
</html>