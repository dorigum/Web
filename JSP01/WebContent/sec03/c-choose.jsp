<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<c:set var="id" value="hong" scope = "page"/>
<c:set var="pwd" value="1234" scope = "page"/>
<%-- <c:set var="name" value="${'홍길동'}" scope = "page"/> --%>
<c:set var="age" value="${22} " scope = "page"/>
<c:set var="height" value="177" scope = "page"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border=1 align="center">
		<tr><td>아이디</td><td>비밀번호</td>	<td>이름</td>	<td>나이</td><td>키</td></tr>
		<c:choose>
			<c:when test="${empty name }">
				<tr><td colspan="5">이름을 입력하세요.</td></tr>
			</c:when>
		
		<c:otherwise>
		<tr><td>${id }</td>
			<td>${pwd }</td>
			<td>${name }</td>
			<td>${age }</td>
			<td>${height }</td>
		</tr>
		</c:otherwise>
		</c:choose>
		</table>
	</body>
</html>