/*메인슬라이더*/

$(document).ready(function() {
	var swiper = new Swiper('#main .swiper-container', {
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

/* myPage 지난주문내역 클릭*/

$(document).ready(function(){
	
	$(".myPage_page .item_wrap .order_item .content").click(function(){
		$(".popup_cover").addClass("on");
		$(".popup_wrap").addClass("on");
	})
	
	$(".popup_wrap .close_btn").click(function(){
		$(".popup_cover").removeClass("on");
		$(".popup_wrap").removeClass("on");
	})
})

/*detailStore_page slider*/

$(document).ready(function() {
	var swiper = new Swiper('.tabMenu_wrap .swiper-container', {
		effect: 'coverflow',
	      grabCursor: true,
	      centeredSlides: true,
	      slidesPerView: 'auto',
	      coverflowEffect: {
	        rotate: 50,
	        stretch: 0,
	        depth: 100,
	        modifier: 1,
	        slideShadows : true,
	      }
	});
});

/*detailStore_page tab메뉴 클릭*/

$(document).ready(function(){
	
	$(".tab_content").hide();
	$(".tab_header li:first").addClass("active").show();
	$(".tab_content:first").show();
	
	$(".tab_header li").click(function(){
		if(!$(this).hasClass("active")){
			$(".tab_header li").removeClass("active");
			$(this).addClass("active");
			$(".tab_content").hide();
			var activeTab = $(this).find("a").attr("href");
			$(activeTab).fadeIn();
		}
	});
})

/*detailStore_page category 클릭*/

$(document).ready(function(){
/*	
	$(".tab_content").hide();
	$(".tab_header li:first").addClass("active").show();
	$(".tab_content:first").show();
	
*/	
	$(".detailStore_page .tabMenu_wrap .category .menu_tit").click(function(){
		if($(this).siblings(".depth_wrap").hasClass("on")){
			console.log(this);
			$(this).siblings(".depth_wrap").removeClass("on");
		} else {			
			$(this).siblings(".depth_wrap").addClass("on");
		}
		
		if($(this).siblings(".arrow_bg").hasClass("on")){
			$(this).siblings(".arrow_bg").removeClass("on");
		} else {
			$(this).siblings(".arrow_bg").addClass("on");
		}
	})
})

/*detailStore_page 댓글달기 클릭*/

$(document).ready(function(){

	$(".detailStore_page .reply_btn_wrap button").click(function(){
		if(!$(this).parent().siblings(".reply_textarea").hasClass("on")){
			console.log(this);
			$(this).parent().siblings(".reply_textarea").addClass("on");
		} else {			
			$(this).parent().siblings(".reply_textarea").removeClass("on");
		}
	})
})








