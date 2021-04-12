<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
	<%
	request.setCharacterEncoding("utf-8");
	String msg = request.getParameter("msg");
	if(msg != null){
	%>
		<h3><%=msg %></h3>
	<%
	}
	%>
		<form name = "frmLogin" method = "post" action = "paramResult.jsp">
			아이디 : <input type = "text" name = "user_id"><br>
			비밀번호 : <input type = "password" name = "user_pw"><br>
			<input type = "submit" value = "로그인">
			<input type = "reset" value = "다시 입력">
		</form>
	</body>
</html>