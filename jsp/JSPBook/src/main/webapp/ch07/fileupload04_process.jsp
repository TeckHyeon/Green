
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@page import="org.apache.commons.fileupload.servlet.*"%>
<%@page import="org.apache.commons.fileupload.disk.*"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	String charSet = "UTF-8";

	String fileUploadPath = "C:\\java404\\upload";
	
	int limitUploadFileSize = 5 * 1024 * 1024;
	%>
	
	<%
	request.setCharacterEncoding(charSet);
	File uploadPath = new File(fileUploadPath); 
	DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	fileItemFactory.setRepository(uploadPath);
	fileItemFactory.setSizeThreshold(limitUploadFileSize);
	ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
	try {
		List<FileItem> items = fileUpload.parseRequest(request);
		
		for (FileItem item : items) {
			if (item.isFormField()) {
				String name = item.getFieldName();
				String value = item.getString(charSet);
				out.println(name + " = " + value + "<br>");
			}
			else {
				String fileFieldName = item.getFieldName();
				String fileName = item.getName();
				String contentType = item.getContentType();
				
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				long fileSize = item.getSize();
				
				File file = new File(fileUploadPath + "/" + fileName);
				item.write(file);
				
				out.println("------------------------<br>");
				out.println("요청 파라미터 이름 : " + fileFieldName + "<br>");
				out.println("저장 파일 이름 : " + fileName + "<br>");
				out.println("파일 콘텐츠 유형 : " + contentType + "<br>");
				out.println("파일 크기 : " + fileSize);
			}
		}
	}
	catch (Exception e) {
		e.printStackTrace();
		out.println("<h2>파일 업로드 중 오류가 발생했습니다.</h2>");
	}
	%>
</body>
</html>