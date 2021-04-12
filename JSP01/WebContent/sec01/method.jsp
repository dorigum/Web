<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메소드 선언</title>
	</head>
	<body>
		<h3>메소드 선언(메소드 정의)</h3>
		<%!
			String id = "abcd";
		
			public String getId(){
				return id;
			}
		%>
		
		id 변수 : <%= id %><br>
		getId() 메소드 호출 결과 : <%= getId() %>
	</body>
</html>