<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>


<script>
window.addEventListener("DOMContentLoaded", function() {
	setTimeout(function() {
		location.href = "boardList.jsp";
	}, 3000);
});
</script>
</head>
<body>
<%
session.removeAttribute("userId");
session.removeAttribute("userName");
session.removeAttribute("userEmail");

session.invalidate();
%>
	<%
	request.setCharacterEncoding("UTF-8");
	String type = "로그아웃 페이지";
	%>
	<jsp:include page="header.jsp" flush="false">
	<jsp:param value="<%=type%>" name="type1"/>
	</jsp:include>
	
	<main class = "container mt-4">
		<section class = "text-center">
			<p class = "lead">로그아웃되었습니다.</p>
			<p class = "lead">잠시 후 게시판 목록 페이지로 이동합니다.</p>
		</section>
	</main>

	<%@ include file="footer.jsp" %>

</body>
</html>