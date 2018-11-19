/*메인슬라이더*/

$(document).ready(function() {
	var swiper = new Swiper('.swiper-container', {
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
	});
});

/*헤더 고정*/
/*
$(document).ready(function(){
	$(window).scroll(function(){
		if($(this).scrollTop() >= 50){
			$("header").css("position","fixed");
			$("#main").css("padding-top","110px");
		} else {
			$("header").css("position","relative");
			$("#main").css("padding-top","0");
		}
	});
})
*/