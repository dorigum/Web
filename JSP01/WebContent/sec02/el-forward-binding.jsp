<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sec01.MemberBean" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>데이터 바인딩</title>
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		request.setAttribute("id", "hong");
		request.setAttribute("pwd", "1234");
		session.setAttribute("name", "홍길동");
		application.setAttribute("email", "hong@test.com");		
		
		// MemberBean 객체 바인딩
		MemberBean member = new MemberBean("lee", "1234", "이몽룡", "lee@test.com");
		request.setAttribute("member", member);
		
		// ArrayList에 바인딩
		List memList = new ArrayList();
		MemberBean m1 = new MemberBean("lee", "1234", "이몽룡", "lee@test.com");
		MemberBean m2 = new MemberBean("kim", "1234", "김길동", "kim@test.com");
		MemberBean m3 = new MemberBean("park", "1234", "박길동", "park@test.com");
		
		// ArrayList에 추가
		memList.add(m1);
		memList.add(m2);
		memList.add(m3);
		
		// ArrayList바인딩
		request.setAttribute("memList", memList);
		%>
		<jsp:forward page="result.jsp"/>
	</body>
</html>