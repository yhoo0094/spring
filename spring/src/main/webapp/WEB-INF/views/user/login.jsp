<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>login</h3>
	<form action="login" method="post">
		<input name="id" placeholder="id"><br> <input
			name="password" placeholder="password">
		<button>로그인</button>
	</form>
	<form action="">
		<input><input>
		<button>로그인</button>
		<a href="${kakao_url}">카카오로그인</a> <a href="#">네이버로그인</a>
	</form>
</body>
</html>