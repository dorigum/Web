/**
 * checkForm.js
 */

	window.onload = function() {
	// form의 id 가 newMemberForm인 form의 submit 버튼을 눌렀을 때 이벤트 처리
	document.getElementById('newMemberForm').onsubmit = function(){
		// 아이디를 입력하지 않고 [회원가입] 버튼 누른 경우
		var id = document.getElementById('id');

		if(id.value == "") { // id의 값이 비었으면
			alert("아이디를 입력하세요.");
			id.focus();
			return false; // 다음 페이지로 이동하지 않게
			}
			
		// 아이디 길이가 6~10자가 안되게 입력한 경우
		if(id.value.length < 6 || id.value.length > 10){
			alert("아이디는 6~10로 입력하세요.");
			id.value = ""; // 아이디 입력란 값 지우기
			id.focus();
			return false;
			}
			
		// '비밀번호'와 '비밀번호 확인' 이 일치하지 않는 경우
		var password = document.getElementById('password');
		var passwordCheck = document.getElementById('passwordCheck');

		// 값 비교해서 일치하지 않으면 경고창 출력, '비밀번호 확인' 입력값 지우기, '비밀번호 확인'에 포커스 추가
		if(password.value != passwordCheck.value) {
			alert("비밀번호 확인이 일치하지 않습니다.");
			passwordCheck.value = "";
			passwordCheck.focus();
					return false;	
				}
				
				
				
		// '이메일 수신 여부' 라디오 버튼을 하나도 선택하지 않은 경우	
		// 라디오 버튼인 경우에 id 속성을 사용하지 않고 그룹 name 속성 사용
		// 동일 그룹에 속한 여러 라디오 객체는 name 동일
		// 그룹 내에 여러 개의 라디오 객체가 있으므로 배열로 처리
		var chk = false; // false로 초기화
		for(var i=0; i<newMemberForm.emailRcv.length; i++){
			if(newMemberForm.emailRcv[i].checked == true){
				chk = true; // 하나라도 체크되어 있으면 true 값이 저장
			}
		}				
		
		
				
		// chk 확인 : 하나도 체크하지 않으면 초기값은 false 그대로 있음
		if(chk == false){
			alert("이메일 수신 여부를 선택하세요.");
			return false;
		}
		
		
		
		// 체크박스 모두 체크하지 않은 경우
		var agreement1 = document.getElementById('agreement1');
		var agreement2 = document.getElementById('agreement2');
		
		// 하나라도 false이면 경고창 출력
		if(agreement1.checked == false || agreement2.checked == false){
			alert("모두 동의해야 합니다.");
			return false;
		}
		
			}; // onsubmit 종료	
					
		}; // window.onload 종료