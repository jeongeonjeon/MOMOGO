/*메인슬라이더*/

$(document).ready(function() {
	var swiper = new Swiper('.swiper-container', {
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
	});
});

/*회원가입 체크*/

function checkForm(){
	var f = document.wForm;
	
	if(f.id.value == ''){
		alert("제목을 입력하세요.");
		f.id.focus();
		return false;
	}
	
	if(f.pw.value ==""){
		alert("비밀번호를 입력하세요.");
		f.pw.focus();
		return false;
	}
	
	if(f.pw.value==""){
		alert("비밀번호를 확인하세요")
	}
}