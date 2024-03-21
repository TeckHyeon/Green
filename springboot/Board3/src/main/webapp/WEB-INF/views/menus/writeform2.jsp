<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="/css/common.css" />
		<link rel="icon" href="/img/favicon.png" />
		<style>
			input:not(input[type=submit], [type=button]) {
				width: 100%;
			}

			input[type=submit],
			[type=button] {
				width: 100px;
			}

			td {
				padding: 10px;
				width: 700px;
				text-align: center;
			}

			td:nth-of-type(1) {
				width: 200px;
			}

			td:not([colspan]):first-child {
				background-color: black;
				color: white;
				font-weight: bold;
			}
		</style>
	</head>

	<body>
		<main>
			<h2>메뉴 등록</h2>
			<form action="/Menus/Write2" method="GET">
				<table>
					<tr>
						<td>메뉴 이름</td>
						<td><input type="text" name="menu_name" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="추가" /><input type="button" value="목록" id="list_btn" /></td>
					</tr>
				</table>
			</form>
		</main>
		<script type="text/javascript">
			const goListEl = document.getElementById('list_btn');
			goListEl.addEventListener('click', function (e) {
				location.href = '/Menus/List';
			});
		</script>
	</body>

	</html>