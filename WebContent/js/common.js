/*메인슬라이더*/

$(document).ready(function() {
	var swiper = new Swiper('.swiper-container', {
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
	});
});

/* myPage 화살표클릭*/
$(document).ready(function(){
   
   $(".myPage_page .item_header button").click(function(){   
      if(! $(this).hasClass("on")){
         $(this).addClass("on");
         $(this).parents().children(".contxt").addClass("on");
      } else {
         $(this).removeClass("on");
         $(this).parents().children(".contxt").removeClass("on");
      }
   })
});

/* myPage 수정클릭*/
$(document).ready(function(){
   
   $(".myPage_page .item_wrap .item .modify_btn").click(function(){   
      if( $(this).parent().hasClass("on") ){
         $(this).parent().removeClass("on");
         $(this).parent().siblings(".modify_content").addClass("on");
         $(this).hide();
         $(this).parent().siblings(".modify_content").find(".btn_wrap").show();
      }
   })
   
});

/* myPage 취소클릭*/

$(document).ready(function(){
   
   $(".myPage_page .item_wrap .modify_content .cancel_btn").click(function(){
      $(this).parents().siblings(".basic_content").addClass("on");
      $(this).parents().siblings(".basic_content").children("button").show();
      $(this).parents(".modify_content").removeClass("on");
      $(this).parent().hide();
   })
   
});