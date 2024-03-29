<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%
    String    pnum1   = request.getParameter("num1");
    String    pnum2   = request.getParameter("num2");
	int       num1    = Integer.valueOf(pnum1);   
	int       num2    = Integer.valueOf(pnum2);
	
	int       result1 = num1 + num2; 
	int       result2 = num1 - num2; 
	int       result3 = num1 * num2; 
	int       result4 = num1 / num2;	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h2>넌어온 값</h2>
   <div>num1:<%=num1 %></div>
   <div>num2:<%=num2 %></div>
   <div>num1+num2:<%=result1 %></div>
   <div>num1-num2:<%=result2 %></div>
   <div>num1*num2:<%=result3 %></div>
   <div>num1/num2:<%=result4 %></div>
</body>
</html>