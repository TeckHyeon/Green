<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<style type="text/css">
			#div1 {
				/* color: blue; */
				background-color: yellow;
			}
		</style>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h2>Hello 하이</h2>
		<div style="color: cyan">현재 시간 출력</div>
		<div id="div1" style="color: blue;"></div>
		<script>
			let today = new Date();
			let now = today.toLocaleString()
			alert(now);
			// 필요한 element를 찾는다.
			let div1 = window.document.getElementById('div1');
			div1.innerHTML = now;
			div1.style.color = 'red';
			//div1.style.background-Color = 'darkbrown';
			div1.style['backgroundColor'] = 'green';
			console.log(div1);
			console.dir(div1);
		</script>
	</body>

	</html>