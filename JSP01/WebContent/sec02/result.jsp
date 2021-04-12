<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		id:${id }<br>
		pwd:${pwd }<br>
		name:${name }<br>
		email:${email }<br>
		
		<hr>
		<h3>바인딩된 MemberBean 객체로 속성에 접근해서 데이터 출력</h3>
		id:${member.id }<br>
		pwd:${member.pwd }<br>
		name:${member.name }<br>
		email:${member.email }<br>
		
		<hr>
		<h3>바인딩된 ArrayList 인덱스로 속성에 접근해서 데이터 출력</h3>
		<%-- <table border=1>
			<tr><td>${memList[0].id }</td>
				<td>${memList[0].pwd }</td>
				<td>${memList[0].name }</td>
				<td>${memList[0].email }</td></tr>
				
			<tr><td>${memList[1].id }</td>
				<td>${memList[1].pwd }</td>
				<td>${memList[1].name }</td>
				<td>${memList[1].email }</td></tr>
		</table> --%>
		
		<!-- JSTL 반복문 사용해서 모든 행 출력 -->
		<table border="1">
			<tr><th>아이디</th><th>비밀번호</th><th>성명</th><th>이메일</th></tr>
			<c:forEach var="dto" items="${memList }">
				<tr><td>${dto.id }</td><td>${dto.pwd }</td>
					<td>${dto.name }</td><td>${dto.email }</td></tr>
			</c:forEach>
		</table>
	</body>
</html>