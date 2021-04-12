<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>formatNumber / formatDate</title>
	</head>
	<body>
		<h3>fmt의 number 태그를 이용한 숫자 포맷팅</h3>
		<c:set var="price" value="1000000000"/>
		<fmt:formatNumber value="${price }" type="number" var="priceNumber"/>
		통화로 표현 :
		<fmt:formatNumber value="${price }" type="currency" currencySymbol="￦" groupingUsed="true"/><br>
		퍼센트 표시 :
		<fmt:formatNumber value="${price }" type="percent" currencySymbol="￦" groupingUsed="false"/><br>
		일반 숫자로 표시 : ${priceNumber }
		
		<h3>formatDate</h3>
		<c:set var="now" value="<%=new Date() %>"/>
		<fmt:formatDate value="${now }" type="date" dateStyle="full"/><br>
		<fmt:formatDate value="${now }" type="date" dateStyle="short"/><br>
		<fmt:formatDate value="${now }" type="time"/><br>
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
		<fmt:formatDate value="${now }" pattern="YYYY-MM-dd :hh:mm:ss"/><br>
		
		한국 현재 시간 :
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
		
		뉴욕 현재 시간 :
		<fmt:timeZone value="America/New York">
		<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>
		</fmt:timeZone>
	</body>
</html>