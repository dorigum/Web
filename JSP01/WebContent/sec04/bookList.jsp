<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>도서 정보 조회</title>
	</head>
	<body>
		<table align="center" border="1">
			<tr><th>번호</th><th>책 이름</th><th>저자</th><th>가격</th><th>발행일</th><th>재고</th><th>출판사번호</th></tr>
		
		<c:choose>
			<c:when test="${bookList == null}">
			<tr><td colspan="5">등록된 도서가 없습니다.</td></tr>
			</c:when>

		<c:when test="${bookList != null}">
			<c:forEach var="book" items="${bookList }">
				<tr>
				<td>${book.bookNo }</td>
				<td>${book.bookName }</td>
				<td>${book.bookAuthor }</td>
				<td>${book.bookPrice }</td>
				<td>${book.bookDate }</td>
				<td>${book.bookStock }</td>
				<td>${book.pubNo }</td>
				</tr>
			</c:forEach>
			</c:when>
		</c:choose>
		</table>
	</body>
</html>