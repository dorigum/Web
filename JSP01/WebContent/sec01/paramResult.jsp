<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> jsp:param 액션태그</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		String msg = "아이디를 입력하지 않았습니다. 아이디를 입력해주세요.";
		
		String user_id = request.getParameter("user_id");
		
		if(user_id.length() == 0){
		%>
		<jsp:forward page="login2.jsp">
			<jsp:param name="msg" value="<%=msg %>" />
		</jsp:forward>
		<%
		}
		%>
		<h3>환영합니다. <%= user_id %>님!!</h3>
	</body>
</html>