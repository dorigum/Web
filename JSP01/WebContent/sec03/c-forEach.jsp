<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List dataList = new ArrayList();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요!");
%>
<c:set var="list" value="<%=dataList %>"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>c:forEach 반복문</title>
	</head>
	<body>
		<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
			i = ${i } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 반복 횟수 : ${loop.count }<br>
		</c:forEach>
		<c:forEach var="data" items="${list }">
		${data }
		</c:forEach>
	</body>
</html>