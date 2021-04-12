<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		c:url 이동 페이지입니다. <br>
		아이디 : ${param.id }<br>
		비밀번호 : ${param.pwd }<br>
		이름 : ${param.name }<br>
		이메일 : ${param.email }<br>
		
	</body>
</html>