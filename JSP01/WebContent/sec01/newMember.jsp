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
	
		<!-- MemberBean 사용 / 모든 프로퍼티에 값 설정 -->
		<jsp:useBean id="member" class="sec01.MemberBean" scope="page">
		<jsp:setProperty property="*" name="member"/>
		</jsp:useBean>
		
		<h3>MemberBean의 속성 값 출력</h3>
		아이디 : <%=member.getId() %><br>
		비밀번호 : <%=member.getPwd() %><br>
		성명 : <%=member.getName() %><br>
		이메일 : <%=member.getEmail() %><br>
		
	</body>
</html>