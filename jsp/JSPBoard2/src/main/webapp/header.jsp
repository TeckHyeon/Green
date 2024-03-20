<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String userId = (String) session.getAttribute("userId");
String userName = (String) session.getAttribute("userName");
String userEmail = (String) session.getAttribute("userEmail");
%>
<header class="container-fluid px-0">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark px-3">
		<a href="#" class="navbar-brand">JSP Board</a>

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-targer="#mynavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="mynavbar">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a href="#" class="nav-link active">메뉴
						1</a></li>
				<li class="nav-item"><a href="#" class="nav-link">메뉴 2</a></li>
				<li class="nav-item"><a href="#" class="nav-link">메뉴 3</a></li>
			</ul>

			<div class="d-flex">
				<%
				if (userId == null || userName == null) {
					out.println("<a href='login.jsp' class='btn btn-outline-primary'>로그인</a>");
				} else {
					out.println("<span class='navbar-text mb-0 me-3'>" + userName + " 님 반값습니다</span>");
					out.println("<a href='logout.jsp' class='btn btn-outline-info'>로그아웃</a>");
				}
				%>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="mt-4 p-5 bg-secondary rounded bg-opacity-50">
			<h1 class="text-center"><%=request.getParameter("type1")%></h1>
		</div>
	</div>
</header>