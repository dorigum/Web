<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>형변환</title>
	</head>
	<body>
		<%!
		int width, height;
		%>
		<%
		width = Integer.parseInt(request.getParameter("width"));
		height = Integer.parseInt(request.getParameter("height"));
		%>
		
		사각형의 넓이 : <%= width * height %>
	</body>
</html>