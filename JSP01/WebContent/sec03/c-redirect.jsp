<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:redirect</title>
	</head>
	<body>
		<c:redirect url="/sec03/redirect-result.jsp">
			<c:param name="id" value="lee"/>
			<c:param name="pwd" value="1234"/>
			<c:param name="name" value="이몽룡"/>
			<c:param name="email" value="lee@test.com"/>
		</c:redirect>
		
	</body>
</html>