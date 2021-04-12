<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="url1" value="/sec03/url-result.jsp">
	<c:param name="id" value="lee"/>
	<c:param name="pwd" value="1234"/>
	<c:param name="name" value="이몽룡"/>
	<c:param name="email" value="lee@test.com"/>
</c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<a href="${url1 }">회원 정보 출력</a>
	</body>
</html>