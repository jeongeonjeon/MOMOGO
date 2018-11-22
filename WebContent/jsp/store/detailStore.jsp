<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
</head>
<body>
<div class="detailStore_page">
	<div class="page_inner">
		<div class="detail_container">
			<section class="storeInfo_box">
				<div class="info_header">
					또래오래
				</div>
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
 						<p>평점 <span>4.6</span></p>
						<p>영업시간 <span>12:00 - 01:00</span></p>
						<p>결제 <span>신용카드, 현금</span></p>
						<p>매장주소<span>경기도 구리시 갈매동 111-111</span></p>
					</div>
				</div>
			</section>
			<section class="tabMenu_wrap">
				<ul class="tab_header">
					<li class="tab1">
						<a href="#tab1">메뉴 30</a>
					</li>
					<li class="tab2">
						<a href="#tab2">리뷰 15</a>
					</li>
					<li class="tab3">
						<a href="#tab3">정보</a>
					</li>
				</ul>
				<div class="tab_container">
					<div class="tab_content on" id ="tab1">
						<div class="swiper-container">
							<ul class="swiper-wrapper">
								<li class="swiper-slide slide01">
									<div class="txt_box">
										<p class="food_name">
											치킨주라 줘
										</p>
										<p class="price">18,000원</p>
									</div>
								</li>
								<li class="swiper-slide slide02">
									<div class="txt_box">
										<p class="food_name">
											치킨주라
										</p>
										<p class="price">18,000원</p>
									</div>
								</li>
								<li class="swiper-slide slide03">
									<div class="txt_box">
										<p class="food_name">
											치킨주라줘
										</p>
										<p class="price">18,000원</p>
									</div>
								</li>
								<li class="swiper-slide slide04">
									<div class="txt_box">
										<p class="food_name">
											치킨내놔
										</p>
										<p class="price">18,000원</p>
									</div>
								</li>
								<li class="swiper-slide slide05">
									<div class="txt_box">
										<p class="food_name">
											졸려
										</p>
										<p class="price">18,000원</p>
									</div>
								</li>
							</ul>
						</div>
						<div class="menu_category_wrap">
							<ul class="menu_category">
								<li class="category">
									<p class="menu_tit popular">인기메뉴</p>
									<div class="arrow_bg"></div>
									<ul class="depth_wrap on">
										<li>
											<div class="txt_wrap">
												<p class="food_name">
													후라이드반양념반
												</p>
												<p class="detail">오곡후라이드+양념치킨 </p>
												<p class="price">16,000원</p>
											</div>
											<div class="img"></div>
										</li>
										<li>
											<div class="txt_wrap">
												<p class="food_name">
													후라이드반양념반
												</p>
												<p class="detail">오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨</p>
												<p class="price">16,000원</p>
											</div>
											<div class="img"></div>
										</li>
									</ul>
								</li>
								<li class="category">
									<p class="menu_tit">반반메뉴</p>
									<div class="arrow_bg"></div>
									<ul class="depth_wrap">
										<li>
											<div class="txt_wrap">
												<p class="food_name">
													후라이드반양념반
												</p>
												<p class="detail">오곡후라이드+양념치킨 </p>
												<p class="price">16,000원</p>
											</div>
											<div class="img"></div>
										</li>
										<li>
											<div class="txt_wrap">
												<p class="food_name">
													후라이드반양념반
												</p>
												<p class="detail">오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨 오곡후라이드+양념치킨</p>
												<p class="price">16,000원</p>
											</div>
											<div class="img"></div>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
					<div class="tab_content" id ="tab2">
						<div class="grade_wrap">
							<p class="grade_tit">평점</p>
							<p class="grade">4.6</p>
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
								<div class="reply_textarea">
									<textarea class="input" placeholder="댓글을 입력하세요."></textarea>
									<input class="submit_btn basic_btn" type="submit" value="등록">
								</div>
								<div class="reply_contents_wrap">
									<div class="reply_content">
										<p class="id">
											giun123
											<span class="time">
												17시간전
											</span>
										</p>
										<p class="grade">
											평점
											<span>
												5점
											</span>
										</p>
										<p class="menu">
											불고기피자 1 , 짜파게티 2
										</p>
										<p class="content">
											피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 
											피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 피자 짱! 
										</p>
									</div>
									<div class="reply_box">
										<p class="id">
											사장님
											<span>2시간전</span>
										</p>
										<p class="content">
											맛이쪙
										</p>
									</div>
									<div class="reply_textarea">
										<textarea class="input" placeholder="댓글을 입력하세요."></textarea>
										<input class="submit_btn basic_btn" type="submit" value="등록">
									</div>
									<div class="reply_btn_wrap">
										<button type="button">댓글달기</button>
										<button type="button">답글달기</button>
									</div>
								</div>
								<div class="reply_contents_wrap">
									<div class="reply_content">
										<p class="id">
											giun123
											<span class="time">
												17시간전
											</span>
										</p>
										<p class="grade">
											평점
											<span>
												2점
											</span>
										</p>
										<p class="menu">
											불고기피자 1 , 짜파게티 2
										</p>
										<p class="content">
											우웩
										</p>
									</div>
									<div class="reply_textarea">
										<textarea class="input" placeholder="댓글을 입력하세요."></textarea>
										<input class="submit_btn basic_btn" type="submit" value="등록">
									</div>
									<div class="reply_btn_wrap">
										<button type="button">댓글달기</button>
										<button type="button">답글달기</button>
									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="tab_content" id ="tab3">
						<div class="store_info_wrap">
							<div class="store_info">
								<div class="info_header store">
									<p>업체정보</p>
								</div>
								<div class="info_content">
									<div class="info">
										<p class="tit">
											영업시간
										</p>
										<p class="txt">
											11:00 - 23:00
										</p>
									</div>
								</div>
							</div>
							<div class="store_info">
								<div class="info_header pay">
									<p>결제정보</p>
								</div>
								<div class="info_content">
									<div class="info">
										<p class="tit">
											결제수단
										</p>
										<p class="txt">
											신용카드 , 현금
										</p>
									</div>
								</div>
							</div>
							<div class="store_info">
								<div class="info_header license">
									<p>사업자정보</p>
								</div>
								<div class="info_content">
									<div class="info">
										<p class="tit">
											상호명
										</p>
										<p class="txt">
											도미노피자
										</p>
									</div>
									<div class="info">
										<p class="tit">
											사업자등록번호
										</p>
										<p class="txt">
											1111111111
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<form method="post" action="#">
			<aside class="order_wrap">
				<div class="order_header">
					<p>주문표</p>
					<button class="clear"></button>
				</div>
				<div class="order_contents cart_empty">
					<p>주문표에 담긴 메뉴가 없습니다</p>
				</div>
				<div class="order_contents cart">
					<div class="content">
						<p class="food_name">
							치킨
						</p>
						<div class="price_wrap">
							<button class="delete"></button>
							<p class="price">3000원</p>
							<div class="amount_wrap">
								<button class="box">
									-
								</button>
								<p class="num">1</p>
								<button class="box">
									+
								</button>
							</div>
						</div>
					</div>
					<div class="content">
						<p class="food_name">
							치킨
						</p>
						<div class="price_wrap">
							<button class="delete"></button>
							<p class="price">3000원</p>
							<div class="amount_wrap">
								<button class="box">
									-
								</button>
								<p class="num">1</p>
								<button class="box">
									+
								</button>
							</div>
						</div>
					</div>
					<div class="content">
						<p class="food_name">
							치킨
						</p>
						<div class="price_wrap">
							<button class="delete"></button>
							<p class="price">3000원</p>
							<div class="amount_wrap">
								<button class="box">
									-
								</button>
								<p class="num">1</p>
								<button class="box">
									+
								</button>
							</div>
						</div>
					</div>
					<div class="sum_box">
						<p>합계 : 9,000원</p>
					</div>
				</div>
				<input class="basic_btn order_btn" type="submit" value="주문하기">
			</aside>
		</form>
	</div>
</div>
</body>
</html>