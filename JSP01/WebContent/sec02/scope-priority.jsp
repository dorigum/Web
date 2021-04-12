<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>스코프 우선 순위</title>
	</head>
	<body>
		<%
		request.setAttribute("name", "request");
		session.setAttribute("name", "세션");
		application.setAttribute("name", "애플리케이션");
		%>
		
		<jsp:forward page="scope-result.jsp"/>
	</body>
</html>