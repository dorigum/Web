<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>표현식 예제</title>
	</head>
	<body>
		<%!
			int add(int a, int b){
				return a * b;
			}
		
		int getMinius(int a, int b){
			return a - b;
		}
		
			int x = 10, y = 20;
		%>
		
		x = <%= x %> <br>
		y = <%= y %> <br>
		add(x, y) = <%= add(x, y) %> <br>
		
		<%
			int a = 10;
			int b;
			b = 10;
			
		%>
		a = <%=a %><br>
		b = <%=b %>

		getMinius(x, y) = <%= getMinius(x, y) %> <br>
	</body>
</html>