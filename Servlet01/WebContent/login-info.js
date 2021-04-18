/**
 * login-info.js
 */

$(document).ready(function(){
	// id와 비밀번호 입력하고 [로그인] 버튼 눌렀을 때
	// id와 비밀번호 값 가져와서 변수에 저장하고
	// alert()로 출력
	
	// 시작 시 id에 포커스
	$('#frmLogin').on('submit', function(){
		var id = $('#user_id').val();
		var pw = $('#user_pw').val();
		
		alert(id + ',' + pw);
		
		return false;
	});
});