/**
 * showAlert.js

(1) HTML 태그의 이벤트 핸들러 속성 사용
(2) JavaScript의 addEventListener() : id 지정 getElementById()
(3) jQuery로 id 없이 (태그에 코드 추가 없이 있는 코드로 작성)
	- 속성 선택자 이용
 */

/* (1) HTML 태그의 이벤트 핸들러 속성 사용 */
/*function showAlert() {
	alert("AI 기술 사이트로 이동하시겠습니까?");
}*/



/* (2) JavaScript의 addEventListener() : id 지정 getElementById() */
/*window.onload = function() {
 var banner2 = document.getElementById('banner2');

banner2.addEventListener('click', function() {
	alert("AI 기술 사이트로 이동하시겠습니까?");
});
});*/



/* (3) jQuery로 id 없이 (태그에 코드 추가 없이 있는 코드로 작성) */
$(document).ready(function() {
	$('img[alt="banner2"]').on('click', function(){
	alert("AI 기술 사이트로 이동하시겠습니까?");

})
});