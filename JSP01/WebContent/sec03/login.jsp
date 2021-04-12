<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>forward 액션 태그</title>
	</head>
	<body>
		<form name = "frmLogin" method = "post" action = "forwardResult.jsp">
			아이디 : <input type = "text" name = "user_id"><br>
			비밀번호 : <input type = "password" name = "user_pw"><br>
			<input type = "submit" value = "로그인">
			<input type = "reset" value = "다시 입력">
		</form> <br>
		
		<a href="${contextPath }/sec02/memberForm2.jsp">회원 등록하기</a>
	</body>
</html>