<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   table, td { border:1px solid black;
       border-collapse:collapse;
   }
   table {  width:80%;
       margin:20px auto;
   }   
   td      { text-align:center;   }
   #top     { height: 120px; }
   #bottom  { height: 120px; }
   #left    { height: 400px; width:20%; }
   #content { height: 400px; }
   
   ul,li { margin:0; padding:0;}
   ul { list-style:none; }
   li { height:32px;background-color:#333;  }
   a  { text-decoration: none; color:lime; }
   a:hover  { text-decoration: none; color:red; background-color:white; }
   #topmenu li {  width:60px; float:left; }
 </style>
</head>
<body>
  <table>
    <tr>
      <td colspan="2" id="top">
      <jsp:include page="top.jsp" flush="false" />
      </td>
    </tr>
    <tr>
      <td id="left">left</td>
      <td id="content">content</td>
    </tr>
    <tr>
      <td colspan="2" id="bottom">
      <jsp:include page="bottom.jsp" flush="false" />
      </td>
    </tr>
    
  </table>
</body>
</html>