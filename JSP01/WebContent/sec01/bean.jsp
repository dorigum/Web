<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "student" class="sec01.StudentBean" scope="page"/>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>자바 빈</title>
	</head>
	<body>
		<h3>빈 속성 값 설정</h3>
		<jsp:setProperty property="stdNo" name="student" value="2018001"/>
		<jsp:setProperty property="stdName" name="student" value="홍길동"/>
		<jsp:setProperty property="stdPhone" name="student" value="010-1234-1234"/>
		<jsp:setProperty property="stdAddress" name="student" value="서울시 강남구"/>
		<jsp:setProperty property="stdYear" name="student" value="4"/>
	
	<h3>빈 속성 값 출력</h3>
	학번 : <jsp:getProperty property="stdNo" name="student"/><br>
	성명 : <jsp:getProperty property="stdName" name="student"/><br>
	전화 : <jsp:getProperty property="stdPhone" name="student"/><br>
	주소 : <jsp:getProperty property="stdAddress" name="student"/><br>
	학년 : <jsp:getProperty property="stdYear" name="student"/><br>
	
	<h3>빈 속성 값 설정(Getter 사용)</h3>
	학번 : <%= student.getStdNo() %><br>
	성명 : <%= student.getStdName() %><br>
	전화 : <%= student.getStdPhone() %><br>
	주소 : <%= student.getStdAddress() %><br>
	학년 : <%= student.getStdYear() %><br>
	</body>
</html>