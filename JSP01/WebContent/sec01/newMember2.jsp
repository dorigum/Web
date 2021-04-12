<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>폼에 입력한 값으로 자바 빈의 속성 값 설정</title>
	</head>
	<body>
	<%
	request.setCharacterEncoding("utf-8");
	
/* 	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email"); */
	%>

		<h3>MemberBean의 속성 값 출력</h3>
		아이디 : ${param.id }<br>
		비밀번호 : ${param.name }<br>
		성명 : ${param.pwd }<br>
		이메일 : ${param.email }<br>
		
	</body>
</html>