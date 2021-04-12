<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>if문</title>
	</head>
	<body>
		<c:set var="id" value="hong" scope = "page"/>
		<c:set var="pwd" value="1234" scope = "page"/>
		<c:set var="name" value="${'홍길동'}" scope = "page"/><!-- EL 사용해도 됨 -->
		<c:set var="age" value="${22} " scope = "page"/>
		<c:set var="height" value="177" scope = "page"/>
		
		<c:if test ="${true }">
			<h3>항상 참입니다.</h3>
		</c:if>
		
		<c:if test ="${(id=='hong') && (name=='홍길동') }">
			<h3>아이디는 ${id }이고, 이름은 ${name }입니다.</h3>
		</c:if>
		
		<c:if test ="${height>160}">
			<h3> ${name }의 키는  160보다 큽니다.</h3>
		</c:if>
	</body>
</html>