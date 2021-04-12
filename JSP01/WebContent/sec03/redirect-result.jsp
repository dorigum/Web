<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>redirect 결과 출력</title>
	</head>
	<body>
		c:redirect 이동 페이지입니다. <br>
		아이디 : ${param.id }<br>
		비밀번호 : ${param.pwd }<br>
		이름 : ${param.name }<br>
		이메일 : ${param.email }<br>
	</body>
</html>