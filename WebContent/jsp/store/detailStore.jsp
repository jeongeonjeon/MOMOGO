<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<jsp:include page="/jsp/include/head.jsp" />
<script>
   var totalPrice = 0;
   var eachPrice = 0;
   var foodName='';
   var orderFoodName = '';
   var price='';
   var cnt = 1;
   var parentNo='';
   var reviewNo = ''; 

   $(document).ready(function(){ 
            
	   $('.depth_wrap li, .swiper-wrapper li').click(function(){
		   
			foodName = $(this).find('.food_name').text();
			price = $(this).find('.price').text();
			totalPrice += Number( price );
			
			
			let length = $('.myOrder_wrap').find('.food_name').length;
			for(var i=0;i<length;i++){
				
				orderFoodName = $('.myOrder_wrap').find('.food_name').eq(i).text();
				if(orderFoodName == foodName)
					break;
				
			}
			
			if( i == length){
				var order = { "foodName" : foodName ,
					          "price" : price ,
						      "storeNum" : '${param.storeNo}',
						      "type" :"order"
						    };
				$.ajax({
					url : '<%=request.getContextPath()%>/store/detailStore.do',
					dataType    :   "text",
			        type        :   "post",
			        async       :   false, //동기: false, 비동기: ture
					data        :   order,
					success     :   callback2,
					error : function(request,status,error){
						alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					}
				});
			}else{
				let cnt = $('.myOrder_wrap').find('.food_name').eq(i).parent().find('.text-center').val();
				$('.myOrder_wrap').find('.food_name').eq(i).parent().find('.text-center').val(Number(cnt)+1);
				$('.sum_box p').text('합계 : ' + numberWithCommas(totalPrice) + '원');
			}
		});
   });
   
   $(document).ready(function(){ 
// 	댓글달기
      
      $('#comment_btn').click(function(){
         
<%--          if('${ empty userVO }'){
            location.href="<%=request.getContextPath()%>/login/loginForm.do";
         } --%>
         
   	   	 if(confirm('댓글은 등록 후 수정이 불가능합니다. 신중하게 입력해주세요.')){
	         
// 	         console.log($('.input').val());
	         
	            
	          var reply ={  "storeNo" : '${param.storeNo}', 
	                     "star" : $('#select_star').val() ,
	                     "id" :  '${ userVO.id }',
	                     "replyText": $('.input').val(),
	                     "depth" : '0', 
	                     "type" : "review", 
	                     "parentNo" : '0'
	                     
	                     };
	                      
	            $.ajax({
	               url : '<%=request.getContextPath()%>/store/detailStore.do',
	               dataType    :   "json",
	                 type        :   "post",
	                 async       :   false, //동기: false, 비동기: ture
	               data : reply,
	               success : callback
	            }); 
   	   	  }
            
      });
      
      
//    대댓글달기
      $('.reply_btn').click(function(){
         
    	  
    	  if(confirm('댓글은 등록 후 수정이 불가능합니다. 신중하게 입력해주세요.')){
	            parentNo = $(this).attr('parentNo'); 
	               
	            var reply2 ={  "storeNo" : '${param.storeNo}', 
	                  "id" :  '${ userVO.id }',
	                  "replyText": $(this).siblings().val(),
	                  "depth" : '1', 
	                  "type" : "review2", 
	                  "parentNo" : $(this).attr('parentNo')
	                  
	                  };
	                      
	         $.ajax({
	            url : '<%=request.getContextPath()%>/store/detailStore.do',
	            dataType    :   "json",
	              type        :   "post",
	              async       :   false, //동기: false, 비동기: ture
	            data : reply2,
	            success : callback3
	         });
         
    	  }

      });
      
//    댓글삭제

		$(".delete_reply").click(function(){
			
			 if(confirm('삭제하시겠습니까?')){
				var delete1 = {
						"reviewNo" : $(this).attr('reviewNo'),
						"type" : "delete"
				};
				
				$.ajax({
					 url : '<%=request.getContextPath()%>/store/detailStore.do',
					 dataType : "json", 
					 type : "post", 
					 async : false, 
					 data : delete1,
					 success : alert("댓글이 삭제되었습니다")
					 
				}); 
			}
	
		})
   });
   
	

   
      
   function callback(data){
	   
      var replyAppend = '';
      
      replyAppend += '<div class="reply_contents_wrap">';
      replyAppend += '   <div class="reply_content">';
      replyAppend += '      <p class="id">';
      replyAppend += '			${ userVO.id } <span class="time"> 방금 </span>';
      replyAppend += '			<c:if test ="${ review.id == userVO.id}">';
      replyAppend += '				<button class="delete_reply"  reviewNo ="${ review.reviewNo }">삭제</button>';
      replyAppend += '			</c:if>';
      replyAppend += '      </p>';
      replyAppend += '      <p class="grade">';
      replyAppend += '         평점 <span> '+  $('#select_star').val()  +'점 </span>';
      replyAppend += '      </p>';
      replyAppend += '      <p class="content">'+  $('.input').val()  +'</p>';
      replyAppend += '   </div>';
      replyAppend += '    <c:if test ="${not empty ceoVO && param.storeNo == userVO.storeNo}">';
      replyAppend += '      <div class="reply_btn_wrap">';
      replyAppend += '         <button type="button">답글달기</button>';
      replyAppend += '      </div>';
      replyAppend += '   </c:if>';     
      replyAppend += '   <div class="reply_textarea">';
      replyAppend += '      <textarea class="input_reply" placeholder="답글을 입력하세요."></textarea>';
      replyAppend += '      <input class="submit_btn basic_btn" type="button" id="comment_btn" value="등록">';
      replyAppend += '   </div>';
      replyAppend += '</div>';
      
      $('textarea.input').val('');
      $('.reply_container').append(replyAppend);
      
   }
   
<<<<<<< HEAD
=======
   function callback2(data){
       
       var orderAppend = '';
       orderAppend +='  <div class="content">';
       orderAppend +='     <p class="food_name">' + foodName + '</p>';
       orderAppend +='     <div class="price_wrap">';
       orderAppend +='        <button type="button" class="delete">X</button>';
       orderAppend +='        <p class="price">'+numberWithCommas(price)+'</p>';
       orderAppend +='  		<div class="row">';
       orderAppend +='  			<div class="col-xs-3 col-xs-offset-3">';
       orderAppend +='  				<div class="input-group number-spinner">';
       orderAppend +='  					<span class="input-group-btn">';
       orderAppend +='  						<button type="button" class="btn btn-default" data-dir="dwn"><span class="glyphicon glyphicon-minus">-</span></button>';
       orderAppend +='  					</span>';
       orderAppend +='  					<input type="text" class="form-control text-center" value="1" readonly>';
       orderAppend +='  					<span class="input-group-btn">';
       orderAppend +='  						<button  type="button" class="btn btn-default" data-dir="up"><span class="glyphicon glyphicon-plus">+</span></button>';
       orderAppend +='  					</span>';
       orderAppend +='  				</div>';
       orderAppend +='  			</div>';
       orderAppend +='  		</div>';
       orderAppend +='     </div>';
       orderAppend +='  </div>';

       
       $('.order_contents.cart_empty').css("display","none");
       
       $('.sum_box p').text('합계 : ' + numberWithCommas(totalPrice) + '원');

       $('.myOrder_wrap').append(orderAppend);
       $('.order_wrap').trigger('create');
       $('.content').trigger('create');
       $('.order_contents').trigger('create');
    }
   
   
>>>>>>> branch 'master' of https://github.com/jeongeonjeon/MOMOGO.git
   function callback3(data){
      var replyAppend = '';
            
      replyAppend += '<div class="re_reply_contents_wrap">';
      replyAppend += '   <div class="reply_content">';
      replyAppend += '      <p class="id">';
      replyAppend += '          <img src="/MOMOGO/img/reply.png" alt="">';
      replyAppend += '         ${ userVO.id } <span class="time"> 방금 </span>';
      replyAppend += '      </p>';
      replyAppend += '      <p class="re_content">'+  $('[parentNo="'+parentNo+'"]').siblings().val()  +'</p>';
      replyAppend += '   </div>';
      replyAppend += '</div>';
      
      $('textarea.input_reply').val('');
      $('[parentNo="'+parentNo+'"]').parent().parent().append(replyAppend);
      $('.reply_textarea').removeClass("on");
   }
  
   function numberWithCommas(x) {
       return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
   }
   
   function checkOrder(){
      if(totalPrice == 0){
         alert("음식을 선택해주세요");
         return false;
      }
      
      if(${ empty userVO }){
         
         alert("로그인 후 주문할 수 있습니다");
         return false;
      }
      
      
      return true;
   }

   
   $(document).on('click', '.number-spinner button', function () {    
		price = $(this).parents('.price_wrap').children('.price').text();
		price = price.replace(/[^0-9\.]+/g, "");
		
		var btn = $(this),
			oldValue = btn.closest('.number-spinner').find('input').val().trim(),
			newVal = 0;

		if (btn.attr('data-dir') == 'up') {
			newVal = parseInt(oldValue) + 1;
			totalPrice += Number(price);
		} else {
			if (oldValue > 1) {
				newVal = parseInt(oldValue) - 1;
				totalPrice -= Number(price);
			} else {
				newVal = 1;
				totalPrice -= 0;
			}
		}
		
		btn.closest('.number-spinner').find('input').val(newVal);
		$('.sum_box p').text('합계 : ' + numberWithCommas(totalPrice) + '원');
	});
   
	$(document).on('click', '.delete', function () {
		
		let oriPrice = $(this).parent().find('.price').text();
		oriPrice = oriPrice.replace(/[^0-9\.]+/g, "");
		let oriCnt = $(this).parent().find('.text-center').val();
		
		totalPrice -= Number(oriPrice) * oriCnt;
		$('.sum_box p').text('합계 : ' + numberWithCommas(totalPrice) + '원');
		$(this).parents('.content').remove();
		
		if($('.myOrder_wrap').children().length == 0){
			$('.cart_empty').attr('style','display:block');
		}
		
	});


</script>
</head>
<body>
   <header>
      <%-- <jsp:include page="/include/header.jsp"> --%>
      <%@include file="/jsp/include/header.jsp"%>
   </header>
   <div class="detailStore_page">
      <div class="page_shadow">
         <div class="page_inner">
            <c:forEach items="${ requestScope.storeList }" var="store">
               <div class="detail_container">
                  <section class="storeInfo_box">
                     <div class="info_header">${store.storeName}</div>
                     <div class="info_contents">
                        <div class="store_logo">
                           <img src="/MOMOGO/img/store_logo_001.jpg" alt="">
                        </div>
                        <div class="txt_wrap">
                           <!--                
                        <div class="star_wrap">
                           <span class="on">★</span>
                           <span class="on">★</span>
                           <span class="on">★</span>
                           <span class="on">★</span>
                           <span>★</span>
                           <span class="txt">4.6</span>
                        </div>
       -->
                           <p>
                              평점 
                              <span> 
                                 <c:set var="total" value="0" /> 
                                 <c:set var="cnt" value="0" /> 
                                 <c:forEach items="${ requestScope.reviewList }" var="review">
                                    <c:if test="${review.depth == '0' }">
                                       <c:set var="star" value="${ review.star}" />
                                       <c:set var="total" value="${ total + star }" />
                                       <c:set var="cnt" value="${cnt + 1}" />
                                    </c:if>
                                 </c:forEach> <c:set var="avg" value="0" /> <c:if test="${ cnt != 0 }">
                                    <c:set var="avg"
                                       value="${ (total * 10 - (total * 10) % cnt) / cnt / 10  }" />
                                 </c:if> ${ avg }
                              </span>
                           </p>

                           <p>
                              영업시간 <span> ${ store.start }시 ~ ${ store.end }시 </span>
                           </p>
                           <p>
                              결제 <span>신용카드, 현금</span>
                           </p>
                           <p>
                              매장주소<span>${store.address}</span>
                           </p>

                        </div>
                     </div>
                  </section>
                  <section class="tabMenu_wrap">
                     <ul class="tab_header">
                        <li class="tab1"><a href="#tab1">메뉴 ${ fn:length(menuList) }</a></li>
                        <li class="tab2"><a href="#tab2">리뷰 ${ fn:length(reviewList) }</a></li>
                        <li class="tab3"><a href="#tab3">정보</a></li>
                     </ul>
                     <div class="tab_container">
                        <div class="tab_content on" id="tab1">
                           <div class="swiper-container">
                              <ul class="swiper-wrapper">
                                 <c:set var="i" value="0" />
                                 <c:forEach items="${ requestScope.menuList }" var="pmenu">
                                    <c:if test="${ 'P' eq pmenu.type }">
                                       <c:set var="i" value="${ i+1 }" />
                                       <li class="swiper-slide slide0${ i }">
                                          <div class="txt_box">
                                             <p class="food_name">${ pmenu.menuName }</p>
                                             <p class="price">${pmenu.price }</p>
                                          </div>
                                       </li>
                                    </c:if>
                                 </c:forEach>
                              </ul>
                           </div>
                           <div class="menu_category_wrap">
                              <ul class="menu_category">
                                 <li class="category">
                                    <p class="menu_tit popular">인기메뉴</p>
                                    <div class="arrow_bg"></div>
                                    <ul class="depth_wrap on">
                                       <c:forEach items="${ requestScope.menuList }" var="pmenu">
                                          <c:if test="${ 'P' eq pmenu.type }">
                                             <li>
                                                <div class="txt_wrap">
                                                   <p class="food_name">${ pmenu.menuName }</p>
                                                   <p class="detail">${ pmenu.detail }</p>
                                                   <p class="price">${ pmenu.price }</p>
                                                </div>
                                                <div class="img"></div>
                                             </li>
                                          </c:if>
                                       </c:forEach>
                                    </ul>
                                 </li>
                                 <li class="category">
                                    <p class="menu_tit">메뉴</p>
                                    <div class="arrow_bg"></div>
                                    <ul class="depth_wrap">
                                       <c:forEach items="${ requestScope.menuList }" var="rmenu">
                                          <c:if test="${ 'R' eq rmenu.type }">
                                             <li>
                                                <div class="txt_wrap">
                                                   <p class="food_name">${ rmenu.menuName }</p>
                                                   <p class="detail">${ rmenu.detail }</p>
                                                   <p class="price">${ rmenu.price }</p>
                                                </div>
                                                <div class="img"></div>
                                             </li>
                                          </c:if>
                                       </c:forEach>
                                    </ul>
                                 </li>
                              </ul>
                           </div>
                        </div>
                        <div class="tab_content" id="tab2">
                           <div class="grade_wrap">
                              <p class="grade_tit">평점</p>
                              <p class="grade">${ avg }</p>
                              <!--                      
                        <div class="star_wrap">
                           <span class="on">★</span>
                           <span class="on">★</span>
                           <span class="on">★</span>
                           <span class="on">★</span>
                           <span>★</span>
                        </div>
    -->
                           </div>
                           <form method="post" action="#">
                              <div class="reply_container">
                                 <p>
                                   		 평점 : <select id="select_star">
                                       <option value="1">1</option>
                                       <option value="2">2</option>
                                       <option value="3">3</option>
                                       <option value="4">4</option>
                                       <option value="5">5</option>
                                    </select>
                                 </p>
                                 <div class="reply_textarea">
                                    <textarea class="input" placeholder="댓글을 입력하세요."></textarea>
                                    <input class="submit_btn basic_btn" type="button" id="comment_btn" value="등록">
                                 </div>
                                 
                                 <c:forEach items="${ requestScope.reviewList }" var="review">
                                    <c:if test="${review.depth=='0'}">
                                       <div class="reply_contents_wrap" reviewNo ="${ review.reviewNo }">
                                          <div class="reply_content">
                                             <p class="id">
                                                ${ review.id } <span class="time"> ${ review.writeDate }
                                                <c:if test ="${ review.id == userVO.id}">
                                                	<button class="delete_reply"  reviewNo ="${ review.reviewNo }">삭제</button>
                                                </c:if>
                                                </span>
                                             </p>
                                             <p class="grade">
                                            	평점 <span> ${ review.star }점 </span>
                                             </p>
                                             <p class="content">${review.content }</p>
                                          </div>

                                          <c:if test ="${not empty ceoVO && param.storeNo == userVO.storeNo}">
                                             <div class="reply_btn_wrap">
                                                <button type="button">답글달기</button>
                                             </div>
                                          </c:if>
                                          
                                          <!--  답글입력창   -->
                                          <div class="reply_textarea">
                                             <textarea class="input_reply" placeholder="답글을 입력하세요."></textarea>
                                             <input class="submit_btn basic_btn reply_btn"
                                                type="button" parentNo="${ review.reviewNo }"
                                                id="reply_btn" value="등록">
                                          </div>
                                          
                                          <c:forEach items="${ requestScope.reviewList }" var="review2">
                                             <c:if test="${review2.depth != '0' && review2.parentNo == review.reviewNo}">
                                                <div class="re_reply_contents_wrap"  reviewNo ="${ review2.reviewNo }">
                                                   <div class="reply_content">
                                                      <p class="id">
                                                         <img src="/MOMOGO/img/reply.png" alt="">
                                                         ${ review2.id } <span class="time"> ${review2.writeDate} </span> 
                                                         <c:if test ="${ review2.id == userVO.id}">
                                                			<button class="delete_reply"  reviewNo ="${ review.reviewNo }">삭제</button>
                                                		</c:if>
                                                      </p>
                                                      <p class="re_content"> ${ review2.content}</p>
                                                   </div>
                                                </div>
                                             </c:if>
                                          </c:forEach>
                                       </div>
                                    </c:if>
                                    
                                 </c:forEach>
                                 
                              </div>
                           </form>
                        </div>
                        <div class="tab_content" id="tab3">
                           <div class="store_info_wrap">
                              <div class="store_info">
                                 <div class="info_header store">
                                    <p>업체정보</p>
                                 </div>
                                 <div class="info_content">
                                    <div class="info">
                                       <p class="tit">영업시간</p>
                                       <p class="txt">${ store.start }시~ ${ store.end }시</p>
                                    </div>
                                 </div>
                              </div>
                              <div class="store_info">
                                 <div class="info_header pay">
                                    <p>결제정보</p>
                                 </div>
                                 <div class="info_content">
                                    <div class="info">
                                       <p class="tit">결제수단</p>
                                       <p class="txt">신용카드 , 현금</p>
                                    </div>
                                 </div>
                              </div>
                              <div class="store_info">
                                 <div class="info_header license">
                                    <p>사업자정보</p>
                                 </div>
                                 <div class="info_content">
                                    <div class="info">
                                       <p class="tit">상호명</p>
                                       <p class="txt">${store.storeName}</p>
                                    </div>
                                    <div class="info">
                                       <p class="tit">사업자등록번호</p>
                                       <p class="txt">${store.licenseNo }</p>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </section>
               </div>
               <form method="get" action="<%= request.getContextPath() %>/store/detailStoreProcess.do" onsubmit="return checkOrder()">
                  <input type="hidden" name="id" value="${ userVO.id  }" >
                  <input type="hidden" name="storeNo" value="${ param.storeNo }">
                  <aside class="order_wrap">
                     <div class="order_header">
                        <p>주문표</p>
                        <button="clear"></button>
                     </div>
                  <div class="order_contents cart_empty">
                     <p>주문표에 담긴 메뉴가 없습니다</p>
                  </div>
                     <div class="order_contents cart">

                        <div class="myOrder_wrap">
                        	
							<!-- 주문표 -->
                        </div>
                        <div class="sum_box">
                           <p>합계 : 0원</p>
                        </div>
                     </div>
                     <input class="basic_btn order_btn" type="submit" value="주문하기">
                  </aside>
               </form>
            </c:forEach>
         </div>
      </div>
   </div>
   <footer>
      <%@include file="/jsp/include/footer.jsp"%>
   </footer>
</body>
</html>