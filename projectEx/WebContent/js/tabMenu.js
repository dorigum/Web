/**
 * tab
 */

$(document).ready(function() {




$(document).ready(function() {
	// tab content box
	var $tabContent = $('#tabContent div');

	// 첫번째 메뉴 항목이 선택되어 있도록 클래스 동적으로 적용
	$('#tab li:first-child').addClass('selectItem');

	$('#tab li').on('click', function(){
	// 클릭한 탭 항목 인덱스 알아오기
var index = $(this).index();

// 모든 탭 메뉴에 적용된 css 효과 제거하고
$('#tab li').removeClass('selectItem');

// 클릭한 항목에만 css 효과 적용
$(this).removeClass('selectItem');

// 컨텐츠 이미지 변경
// content 모든 div 숨기고
$tabContent.css('display', 'none');

// 클릭한 탭 메뉴 항목의 index에 해당하는 div만 보임
$tabContent.eq(index).css('display', 'block');
}
});

});