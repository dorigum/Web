<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>전송된 데이터 받아서 출력</title>
	</head>
	<body>
<%!
	// 선언부에서 변수 선언
	/* String name, id, pwd, h1, h2, h3, year, department;
	String[] interest; */
%>
<%
	request.setCharacterEncoding("utf-8");
	
	// 폼에 입력한 값 받아오기
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String hp1 = request.getParameter("hp1");
	String hp2 = request.getParameter("hp2");
	String hp3 = request.getParameter("hp3");
	String year = request.getParameter("year"); // 라디오 버튼 : year 이름으로 4개 값 중 1개가 전달
	String[] interest = request.getParameterValues("interest"); // 체크박스 : 동일한 이름 interest로 4개 전달(배열로 받음)
	String department = request.getParameter("department"); // select : select 태그의 이름으로 여러 option 중 1개 값 받아옴
	
/* 	// 데이터 전처리
	// 전화번호 : hp1 hp2 hp3 -> 010-1234-1234
	String hp = hp1 + "-" + hp2 + "-" + hp3;
	// 체크박스를 받은 배열 처리 : 배열에서 각 원소의 값 추출해서 하나의 문자열로 연결
	String interest_list = "";
	
	for(String elm : interest) {
		interest_list += elm + " ";
} */

%>

성명 : <%= name %><br>
아이디 :  <%= id %><br>
비밀번호 :  <%= pwd %><br> 
전화번호 : <%= hp1 + "-" + hp2 + "-" + hp3 %><br>
학년 : <%= year %><br>
관심분야 :
<%
	// 배열 interest의 각 요소 출력
	for(int i=0; i<interest.length; i++){
		%><br>
		<!-- 출력은 HTML 영역에 변수 값으로 출력 -->
		<%=interest[i] + "," %>
<%
	}
%>
학과 : <%=department %><br>
	</body>
</html>