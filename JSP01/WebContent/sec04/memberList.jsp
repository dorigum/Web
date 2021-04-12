<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원 정보 조회</title>
	</head>
	<body>
		<table align="center" border="1">
			<tr><th>아이디</th><th>비밀번호</th><th>성명</th><th>이메일</th><th>가입일</th></tr>
		<!-- 가입된 회원이 없는 경우 "등록된 회원이 없습니다." -->
		<c:choose>
			<c:when test="${memberList == null}">
			<tr><td colspan="5">등록된 회원이 없습니다.</td></tr>
			</c:when>

		<c:when test="${memberList != null}">
			<c:forEach var="mem" items="${memberList }">
				<tr>
				<td>${mem.id }</td>
				<td>${mem.pwd }</td>
				<td>${mem.name }</td>
				<td>${mem.email }</td>
				<td>${mem.joinDate }</td>
				</tr>
			</c:forEach>
			</c:when>
		</c:choose> <!-- 회원 정보 출력 -->
		</table>
	</body>
</html>