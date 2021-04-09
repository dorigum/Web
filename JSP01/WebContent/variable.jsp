<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>변수 선언 및 사용</title>
	</head>
	<body>
		<%!
			// 선언부		
			// 변수 선언 및 초기화
			int x = 10;
			long y;
			
			//y = 100; 값 설정 시 오류 (선언부에서는 설정 불가(초기화만 가능))
			float floatValue = 3.14f;	// float형은 f 붙임
			double doubleValue = 3.14; // double형 기본
			
			char ch = 'a';
			String job = "프로그래머";
			boolean b = true;			
		%>
		<%
			// 스크립트 릿 영역 : 자바 코드 자유롭게 기술
			y = 100;
		%>
		<h3>변수 값 출력</h3>
		x : <%= x %><br>
		y : <%= y %><br>
		floatValue : <%= floatValue %><br>
		doubleValue : <%= doubleValue %><br>
		ch : <%= ch %><br>
		job : <%= job %><br>
		b : <%= b %><br>
	</body>
</html>