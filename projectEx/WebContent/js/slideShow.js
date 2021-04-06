/**
 * slideShow.js
 */

$(document).ready(function() {
	//이동한 이미지의 index 값 저장 (현재 위치)
	var movedIndex = 0;
	
	// 슬라이드 패널을 움직이는 함수
	function moveSlide(index){
		// 전달 받은 index 값을 movedIndex에 저장
		movedIndex = index;
		
		// 슬라이드 이동
		var moveLeft = -(index * 1280); //왼쪽 이동 거리
		$('#slidePanel').animate({'left': moveLeft}, 'slow');
	}
	
	//pre 버튼 (이전 버튼) 클릭하면 앞으로 이동
	$('#prevButton').on('click', function(){
		// 첫 번째가 아니면 인텍스 값 -1
		if(movedIndex != 0) {
			movedIndex = movedIndex -1;
		}
		
		moveSlide(movedIndex); 
	});
	
	//next 버튼 (다음 버튼) 클릭하면 앞으로 이동
	$('#nextButton').on('click', function(){
		// 첫 번째가 아니면 인텍스 값 -1
		if(movedIndex != 4) {
			movedIndex = movedIndex + 1;
		}
		
		moveSlide(movedIndex); 
	});
	
	
	//초기 슬라이더 위치 랜덤하게 지정
	var randomNumber = Math.floor(Math.random() * 5);
	moveSlide(randomNumber);
	
	// 각 컨트롤 버튼에 대해 마우스 올렸을 떄 이미지 변경
	$('.controlButton').each(function(index){
		$(this).hover(
		)
		function(){
			$(this).attr('src', 'image/controlButton2.png');
		},
		
		function(){
		$(this).attr('src', 'image/controlButton2.png');	
		}
	);
	
	// 클릭했을 때 현재 인덱스 값을 moveSlide() 함수에게 전달
	$(this).on('click', function())
		)
		function(){
	});
});














