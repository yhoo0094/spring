<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user/user.jsp</title>
</head>
<body>
${user.id}<br>
${user.password}<br>
${user.name}<br>
${user.role}<br>
${user.profile}<br>
<a href="filedown?uFile=${user.profile}">파일다운로드</a><br>
<img alt="" src="images/${user.profile}" width="500px;" height="500px;"><br>
</body>
</html>