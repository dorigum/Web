<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL</title>
	</head>
	<body>
		\${100} : ${100 }<br>
		${3.14 }<br>
		${"홍길동" }<br>
		${true }<br>
		${10+1 }<br>
		${100 mod 9 }<br>
		<%-- ${"hello" + "world" }<br> --%>
		<!-- 문자열 연산할 수 없음 (오류) -->
	</body>
</html>