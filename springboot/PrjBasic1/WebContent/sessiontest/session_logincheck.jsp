<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String  msg         = "";
    String  session_id  = "";
    String id = (String) session.getAttribute("id");
    if(id != null ) {    	
    	session_id = session.getId();
    	msg += id +  "님 환영합니다<br>";
    	msg += "로그인된 session id" + session_id + "<br>";
    	msg += "<a href='session_logout.jsp'>로그인아웃</a>";
    } else {
    	msg += "로그인되지 않았습니다";
    	msg += "<a href='NewFile.html'>로그인하러 가기</a>";
    }
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>로그인 채크</h1>
  <%=msg%>
</body>
</html>