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
			// 아이디 입력 값 받아서
			request.setCharacterEncoding("utf-8");
			String user_id = request.getParameter("user_id");
			
			// 아이디를 입력하지 않았으면 다시 로그인 페이지로 포워딩 시키고
			if(user_id.length() == 0){
			%>
				<jsp:forward page="login.jsp"/>
			<%
			}
			
			// 입력했으면 "~님~" 출력
		%>
		<h3>환영합니다. <%=user_id %>님!</h3>
	</body>
</html>