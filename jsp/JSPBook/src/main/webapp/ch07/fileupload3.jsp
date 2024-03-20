<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form action = "fileupload03_process.jsp" method = "post" 
	enctype = "multipart/form-data" name="fileForm">
	
	<label for="filename">파일 : </label>
	<input type="file" id="filename" name="filename"><br>
	<button type="submit">파일 올리기</button>
	</form>
</body>
</html>