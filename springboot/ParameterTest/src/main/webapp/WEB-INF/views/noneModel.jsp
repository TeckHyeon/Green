<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>넘어온 data(model)</h2>
${a} == model.getAttribute("a")
${vo.a} == vo.getA()
<p>a : ${a} (model.getAttribute("a"))</p>
<p>b : ${b} (model.getAttribute("b"))</p>
<br>
<p>a : ${vo.getA()} (vo.getA())</p>
<p>b : ${vo.getB()} (vo.getB())</p>
<br>
<p>a : ${param.a} (param.a)</p>
<p>b : ${param.b} (param.b)</p>
<br>
<p>a : ${vo.a} (@ModelAttribute, attrName.getA())</p>
<p>b : ${vo.b} (@ModelAttribute, attrName.getB())</p>
<p><a href="/">HOME</a>
</body>
</html>