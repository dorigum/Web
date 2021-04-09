<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	String name = "홍길동";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 파일 include</title>
	</head>
	<body>
		<h1>JSP 파일 include</h1>
		이 부분은 jspInclude.jsp의 내용입니다.
		
		<hr>이 부분에 top.jsp의 내용이 포함될 것입니다. <p>
		<%@ include file="top.jsp" %>
		
		<hr>이 부분에 bottom.jsp의 내용이 포함될 것입니다. <p>
		<%@ include file="bottom.jsp" %>
		
	</body>
</html>