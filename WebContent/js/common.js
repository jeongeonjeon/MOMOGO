/*메인슬라이더*/

$(document).ready(function() {
	var swiper = new Swiper('#main .swiper-container', {
		navigation : {
			nextEl : '.swiper-button-next',
			prevEl : '.swiper-button-prev',
		},
		pagination: {
	        el: '.swiper-pagination'
        },
        loop : true,
        autoplay : {
        	delay: 5000
        }
	});
	
	/* myPage 화살표클릭*/
	   
   $(".myPage_page .item_header button").click(function(){   
      if(! $(this).hasClass("on")){
         $(this).addClass("on");
         $(this).parents().children(".contxt").addClass("on");
      } else {
         $(this).removeClass("on");
         $(this).parents().children(".contxt").removeClass("on");
      }
   })
   
   /* myPage 수정클릭*/
      
  $(".myPage_page .item_wrap .item .modify_btn").click(function(){   
     if( $(this).parent().hasClass("on") ){
        $(this).parent().removeClass("on");
        $(this).parent().siblings(".modify_content").addClass("on");
        $(this).hide();
        $(this).parent().siblings(".modify_content").find(".btn_wrap").show();
     }
  })
  
  /* myPage 취소클릭*/
   
   $(".myPage_page .item_wrap .modify_content .cancel_btn").click(function(){
      $(this).parents().siblings(".basic_content").addClass("on");
      $(this).parents().siblings(".basic_content").children("button").show();
      $(this).parents(".modify_content").removeClass("on");
      $(this).parent().hide();
   })
   
   /* myPage 지난주문내역 클릭*/
	
	$(".myPage_page .item_wrap .order_item .content").click(function(){
		$(".popup_cover").addClass("on");
		$(".popup_wrap").addClass("on");
	})
	
	$(".popup_wrap .close_btn").click(function(){
		$(".popup_cover").removeClass("on");
		$(".popup_wrap").removeClass("on");
	})
	
	/*mypage 파일 이름*/
	/*
	var fileTarget = $(".filebox .upload-hidden");
	
	fileTarget.on("change", function(){
		if(window.FileReader){
			var filename = $(this)[0].files[0].name;
		} else {
			var filename = $(this).val().split("/").pop().split("\\").pop();
		}
		
		$(this).siblings(".upload-name").val(filename);
	})
	 */
	
	/*mypage 음식 파일 이름*/
	/*
	var fileTarget = $(".filebox .upload-hidden1");
	
	fileTarget.on("change", function(){
		if(window.FileReader){
			var filename = $(this)[0].files[0].name;
		} else {
			var filename = $(this).val().split("/").pop().split("\\").pop();
		}
		
		$(this).siblings(".upload-name1").val(filename);
	})
	*/
	
	/*mypage select클릭*/
   
   $(".myPage_page .item_wrap .store_item select").click(function(){   
	   $(".myPage_page .item_wrap .store_item .sel_arrow").toggleClass("on");
   })
   
   /*detailStore_page slider*/
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
   
   /*detailStore_page tab메뉴 클릭*/
   	
   	$(".tab_content").hide();
   	$(".tab_header li:first").addClass("active").show();
   	$(".tab_content:first").show();
   	
   	$(".tab_header li").click(function(){
   		if(!$(this).hasClass("active")){
   			$(".tab_header li").removeClass("active");
   			$(this).addClass("active");
   			$(".tab_content").hide();
   			var activeTab = $(this).find("a").attr("href");
   			$(activeTab).show();
   		}
   	});
   	
   	/*detailStore_page category 클릭*/

   	/*	
   		$(".tab_content").hide();
   		$(".tab_header li:first").addClass("active").show();
   		$(".tab_content:first").show();
   		
   	*/	
	$(".menu_category .category .menu_tit").click(function(){
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
	
	/*detailStore_page 댓글달기 클릭*/

	$(".detailStore_page .reply_btn_wrap button").click(function(){
		if(!$(this).parent().siblings(".reply_textarea").hasClass("on")){
			console.log(this);
			$(this).parent().siblings(".reply_textarea").addClass("on");
		} else {			
			$(this).parent().siblings(".reply_textarea").removeClass("on");
		}
	})
	
	/*mHeader 제어*/

	$(".mHeader .menu_bar").click(function(){
		if(!$(".mHeader").hasClass("on")){
			$(".mHeader").addClass("on");
			$(".mHeader .menu_bar").addClass("on");
		} else {
			$(".mHeader").removeClass("on");
			$(".mHeader .menu_bar").removeClass("on");
		}
	})
	
	/*주문상태 변경*/

	$(".myPage_page .change_btn").click(function(){
		if(!$(this).parent().siblings().hasClass("on")){
			$(this).parent().removeClass("on");
			$(this).parent().siblings().addClass("on");
		}
	})
	
	/*음식 카테고리명 변경*/

	$(document).on("click","#nameChangeBtn",function(event){
		if($(this).parent().hasClass("on")){
			$(this).parent().removeClass("on");
			$(this).parent().siblings(".category_modify").addClass("on");
		}
	})
	
	$(document).on("click","#nameConfirmBtn",function(event){
		if($(this).parent().hasClass("on")){
			$(this).parent().removeClass("on");
			$(this).parent().siblings(".category_default").addClass("on");
		}
	})
	
	/*음식 카테고리 추가*/
	
	$(".myPage_page .add_category_btn").on("click",function(){
		addCategory();
	})
	
	/*음식 카테고리 삭제*/
	$(".myPage_page #deleteCategoryBtn").on("click",function(){
		confirm("정말 삭제하시겠습니까?");
	})
	
	/*인기 메뉴 추가,삭제*/
	$(".myPage_page .category .popular_btn").on("click", function(){
		if($(this).parents(".depth_wrap1").hasClass("popular1")){
			confirm("인기메뉴에서 삭제하시겠습니까");
		} else {
			confirm("인기메뉴에서 추가하시겠습니까");
		}
	})
	
	/*사업자 마이페이지 메뉴 삭제*/
	$(".myPage_page .category .menu_delete_btn").on("click", function(){
		confirm("카테고리에서 메뉴를 삭제하시겠습니까");
	})
});

function addCategory(){
	var categoryName = "";
	categoryName += '<li class="category">';
	categoryName += '	<div class="category_default on">';
	categoryName += '		<p class="menu_tit">메뉴1</p>';
	categoryName += '		<button type="button" class="name_change" id="nameChangeBtn">이름변경</button>';
	categoryName += '		<div class="arrow_bg"></div>';
	categoryName += '	</div>';
	categoryName += '	<div class="category_modify">';
	categoryName += '		<input type="text" placeholder="변경할 이름을 입력하세요.">';
	categoryName += '		<button type="button" class="name_confirm" id="nameConfirmBtn">확인</button>';
	categoryName += '		<div class="arrow_bg"></div>';
	categoryName += '	</div>';
	categoryName += '	<ul class="depth_wrap depth_wrap1 on">';
	/*
	categoryName += '		<c:forEach items="${ menuList }" var="menu">';
	categoryName += '			<c:if test="${ "P" eq pmenu.type }">';
	categoryName += '				<li>';
	categoryName += '					<div class="txt_wrap">';
	categoryName += '						<p class="food_name">${ pmenu.menuName }</p>';
	categoryName += '						<p class="detail">${ pmenu.detail }</p>';
	categoryName += '						<p class="price">${ pmenu.price }</p>';
	categoryName += '					</div>';
	categoryName += '					<div class="img"></div>';
	categoryName += '				</li>';
	categoryName += '			</c:if>';
	categoryName += '		</c:forEach>';
	*/
	categoryName += '	</ul>';
	categoryName += '</li>';
	
	$('.myPage_page .menu_category').append(categoryName);
}

