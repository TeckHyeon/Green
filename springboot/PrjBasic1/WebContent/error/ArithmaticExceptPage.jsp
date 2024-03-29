<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"  %>
<%
    // 현재 Error 상태를 변경
   // response.setStatus(200);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>web.xml을 이용한 에러처리</h2>
  <p>
    값이 잘못되었습니다<br>
    상세 에러 메세지 : <%=exception.getMessage() %>
    <a href="input.html">다시 계산하기</a>
  </p>
</body>
</html>