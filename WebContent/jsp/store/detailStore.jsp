<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
<script>
	var totalPrice = 0;
	var foodName='';
	var price='';

	$(document).ready(function(){
		$('#comment_btn').click(function(){
			alert("추후 업데이트 예정입니다.");
		});
		
		$('.depth_wrap li, .swiper-wrapper li').click(function(){
			foodName = $(this).find('.food_name').text();
			price = $(this).find('.price').text();
			totalPrice += Number( price );
			
			var order = { "foodName" : foodName ,
				          "price" : price ,
					      "storeNum" : '${param.storeNo}',
					      "type" :"order"
					    };
			
			
			$.ajax({
				url : '<%=request.getContextPath()%>/store/detailStore.do',
				dataType    :   "json",
		        type        :   "post",
		        async       :   false, //동기: false, 비동기: ture
				data : order,
				success : callback2
			});
		});

		
		
		$('#reply_btn').click(function(){
			
<%-- 			if(${ empty userVO }){
				location.href="<%=request.getContextPath()%>/login/loginForm.do";
			} --%>

				
		    var reply ={ "replyText": $('.input').val(),
		    			  "star" : $('#select_star').val() ,
		    			  "id" :  '${ userVO.id }',
		    			  "type" : "review",
		    			  "storeNum" : '${param.storeNo}'
		   				};
		    				
				$.ajax({
					url : '<%=request.getContextPath()%>/store/detailStore.do',
					dataType    :   "json",
			        type        :   "post",
			        async       :   false, //동기: false, 비동기: ture
					data : reply,
					success : callback
				}); 
				
		});
	});
	
		
	function callback(data){
		var replyAppend = '';
		replyAppend += '<div class="reply_contents_wrap">';
		replyAppend += '	<div class="reply_content">';
		replyAppend += '		<p class="id">';
		replyAppend += 			'${ userVO.id } <span class="time"> 방금 </span>';
		replyAppend += '		</p>';
		replyAppend += '		<p class="grade">';
		replyAppend += '			평점 <span> '+  $('#select_star').val()  +'점 </span>';
		replyAppend += '		</p>';
		replyAppend += '		<p class="content">'+  $('.input').val()  +'</p>';
		replyAppend += '	</div>';
		replyAppend += '	<div class="reply_textarea">';
		replyAppend += '		<textarea class="input" placeholder="답글을 입력하세요."></textarea>';
		replyAppend += '		<input class="submit_btn basic_btn" type="button" id="comment_btn" value="등록">';
		replyAppend += '	</div>';
		replyAppend += '	<div class="reply_btn_wrap">';
		replyAppend += '		<button type="button">답글달기</button>';
		replyAppend += '	</div>';
		replyAppend += '</div>';
		
		$('textarea.input').val('');
		$('.reply_container').append(replyAppend);
		
	}
	 
	function callback2(data){
		
		var orderAppend = '';
		orderAppend +='	<div class="content">';
		orderAppend +='		<p class="food_name">' + foodName + '</p>';
		orderAppend +='		<div class="price_wrap">';
		orderAppend +='			<button class="delete"></button>';
		orderAppend +='			<p class="price">'+price+'원</p>';
		orderAppend +='		</div>';
		orderAppend +='	</div>';
		orderAppend +='	<input type="hidden" name="food_name" value='+foodName+'>';
		
		$('.order_contents.cart_empty').css("display","none");
		
		$('.sum_box p').text('합계 : ' + numberWithCommas(totalPrice) + '원');

		$('.myOrder_wrap').append(orderAppend);
		$('.order_wrap').trigger('create');
		$('.content').trigger('create');
		$('.order_contents').trigger('create');
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
										평점 <span> <c:set var="total" value="0" /> <c:set
												var="cnt" value="0" /> <c:forEach
												items="${ requestScope.reviewList }" var="review">
												<c:set var="star" value="${ review.star }" />
												<c:set var="total" value="${ total + star }" />
												<c:set var="cnt" value="${cnt + 1}" />
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
												<input class="submit_btn basic_btn" type="button"
													id="reply_btn" value="등록">
											</div>
											<c:forEach items="${ requestScope.reviewList }" var="review">
												<div class="reply_contents_wrap">
													<div class="reply_content">
														<p class="id">
															${ review.id } <span class="time"> ${ review.writeDate }
															</span>
														</p>
														<p class="grade">
															평점 <span> ${ review.star }점 </span>
														</p>
														<p class="content">${review.content }</p>
													</div>
													<div class="reply_textarea">
														<textarea class="input" placeholder="답글을 입력하세요."></textarea>
														<input class="submit_btn basic_btn" type="button"
															id="comment_btn" value="등록">
													</div>
													<div class="reply_btn_wrap">
														<button type="button">답글달기</button>
													</div>
												</div>
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
<!-- 								<div class="amount_wrap">
									<button class="box">-</button>
									<p class="num">1</p>
									<button class="box">+</button>
								</div> -->
								<p>주문표</p>
								<button="clear"></button>
							</div>
						<div class="order_contents cart_empty">
							<p>주문표에 담긴 메뉴가 없습니다</p>
						</div>
							<div class="order_contents cart">

								<div class="myOrder_wrap">
<!-- 									<div class="content">
										<p class="food_name">치킨</p>
										<div class="price_wrap">
											<button class="delete"></button>
											<p class="price">3000원</p>
										</div>
									</div> -->
	<!-- 							<div class="content">
									<p class="food_name">치킨</p>
									<div class="price_wrap">
										<button class="delete"></button>
										<p class="price">3000원</p>
										<div class="amount_wrap">
											<button class="box">-</button>
											<p class="num">1</p>
											<button class="box">+</button>
										</div>
									</div>
-->
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