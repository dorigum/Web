/**
 * index.js
 */

$(document).ready(function() {
	$(window).on('scroll', function() {
  		// 스크롤되는 문서의 top이 #headerbox 이상이면 메인 메뉴 고정하고 그림자 표시
  		if($(document).scrollTop() >= $('#headerBox').height()){
			$('#mainMenuBox').addClass('mainMenuFixed mainMenuShadow');
		} else {
			$('#mainMenuBox').removeClass('mainMenuFixed mainMenuShadow');
		}
    });

// moveToTop 이미지 클릭 시 top으로 이동
$('#moveToTop').on('click', function() {
	$('html, body').animate({scrollTop:0}, 500);

	});
});