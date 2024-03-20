
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@page import="org.apache.commons.fileupload.servlet.*"%>
<%@page import="org.apache.commons.fileupload.disk.*"%>

<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
	// jsp의 선언부, 클래스의 멤버 변수로 선언됨
	String charSet = "UTF-8";
	
	String fileUploadPath = "C:\\java404\\upload";

	int limitUploadFileSize = 5 * 1024 * 1024;
	%>
	
	<%		
	request.setCharacterEncoding(charSet);
	
	// 파일 저장 폴더를 가지고 File 클래스 타입의 객체를 생성
	// DiskFileItemFactory 클래스에서 파일 저장 폴더를 설정하는 메서드인 setRepository()의 매개변수가 	File 클래스 타입의 객체를 사용함
	
	File uploadPath = new File(fileUploadPath); 
	
	// DiskFileItemFactory : 업로드된 파일을 저장할 저장소와 관련된 클래스로 FileItem 객체를 생성함
	// getDefaultCharset() : 기본값을 지정된 문자셋을 출력
	// getRepository() : 기본값으로 지정된 파일 저장 폴더를 출력
	// getSizeThreshold() : 기본값으로 지정된 최대 파일 크기를 출력
	// setDefaultCharset(String 문자셋) : 사용할 문자셋을 설정
	// setRepository(FIle 파일 저장경로) : 사용할 파일 저장 경로를 설정
	// setSizeThreshold(int 파일 크기) :  사용할 파일의 최대 크기를 설정
	
	DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	fileItemFactory.setRepository(uploadPath);
	//fileItemFactory.setRepository(new File(저장경로));
	fileItemFactory.setSizeThreshold(limitUploadFileSize);
	
	//  DiskFileUpload 클래스는 현재 사용이 중단 됨, ServletFileUpload를 사용하여 파일 업로드를 	구현해야 함
	
	//  ServletFileUpload : 업로드된 파일 처리를 위한 높은 수준의 API, HTTP 요청에 대한 	httpServletReqeust 객체로부터 multipart/form-data 형식을 입력받아 다루기 쉽게 변환해 주는 역할을 	하는 클래스
	
	//  getItemIterator(HttpServletReqeust request) : FileItemIterator 타입으로 데이터를 반환
	
	//  isMultipartContent(HttpServletReqeust request) : 요청 중 다중 부분 컨텐츠가 존재 하는지 		여부를 반환
	
	//  parseParameterMap(HttpServletReqeust request) : Map<String, List<FileItem>> 타입으로 		데이터를 반환
	
	//  parseRequest(HttpServletReqeust request) : List<FileItem> 타입으로 데이터를 반환

	ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
	
	try {
		List<FileItem> items = fileUpload.parseRequest(request);
		
		for (FileItem item : items) {
			// input type = "file"인지 아닌지 확인하는 메서드
			// 일반 데이터는 true, file이면 false
			if (item.isFormField()) {
				String title = item.getString(charSet);
				out.println("<h3>" + title + "</h3>");
			}
			else {
				// 업로드 된 파일의 경로를 포함하여 파일 이름을 가져옴
				String fileName = item.getName();
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				
				File file = new File(fileUploadPath + "/" + fileName);
				item.write(file);
				out.println("파일 이름 : " + fileName + "<br>");
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