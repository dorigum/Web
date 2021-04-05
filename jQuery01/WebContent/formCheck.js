/**
 *  formCheck.js
	회원가입폼 입력 유효성 확인
 */

$(document).ready(function() {
	
	// 시작 시 id에 포커스
	$('#id').focus();
	
	// 엔터키 눌렀을 때 무조건 submit 되지 않도록
	// 문서 전체에 이벤트 처리
	// [Enter] 키의 아스키 코드 값 : 13
	$(document).on('keydown', function(e){
		if(e.keyCode == 13) return false;
	});
	
	
	
	// id를 입력하고 엔터키 눌렀을 때 비밀번호로 포커스 이동
	$('#id').on('keydown', function(e){
		if($('#id').val() != "" && e.keyCode == 13) {
		$('#pwd').focus();	
		}
	});
	
	
	// 키보드 이벤트
	// 휴대폰 번호 첫 번째 입력란에서 입력 값이 3개가 되면 두번째로 포커스 이동
	$('#hp1').on('keyup', function(){
		if($(this).val().length == 3){
			$('#hp2').focus();
		}
	});
	
	// 휴대폰 번호 첫 번째 입력란에서 입력 값이 4개가 되면 세번째로 포커스 이동
		$('#hp2').on('keyup', function(){
		if($(this).val().length == 4){
			$('#hp3').focus();
		}
	});
	
	// newMemberForm의 submit(전송) 버튼 눌렀을 때
	$('#newMemberForm').on('submit', function(){
		// id 입력하지 않은 경우 : alert(), 포커스, 다음 페이지로 안 넘어가게
		if($('#id').val() == ""){
			alert("아이디를 입력하세요.");
			$('#id').focus();
			return false;
		}
		
		// 비밀번호 입력하지 않은 경우
		if($('#pwd').val() == ""){
			alert("비밀번호를 입력하세요.");
			$('#pwd').focus();
			return false;
		}
		
		// 라디오 버튼 선택하지 않은 경우
		if(!$('input[type="radio"]').is(':checked')) {
			alert("학년을 선택하세요.");
			return false;
		}
		
		// 비밀번호 입력하지 않은 경우 : 속성 선택자
		//if(!$('input[type="radio"]').is(':checked')) {
			if(!$(':radio').is(':checked')){ // 속성 선택자 축약형
			alert("학년을 선택하세요.");
			return false;
		}
		
		
		// 체크박스를 선택하지 않은 경우
		//if(!$('input[type="checkbox"]').is(':checked')) {
			if(!$(':checkbox').is(':checked')){
			alert("관심분야는 1개 이상 선택하세요.");
			return false;
		}
		
		// select 선택하지 않은 경우
		if($('select').val() == ""){
			alert("학과를 선택하세요.");
			//$('#select').focus();
			return false;
		}
		
	}); // 폼 submit 종료
	
}); // ready() 종료