<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1fe41c09db40fafd2cb9304b55b471f7&libraries=services"></script>
<script src="/MOMOGO/js/map.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/MOMOGO/js/mainMap.js"></script>
<script src="/MOMOGO/js/storeClick.js"></script>
</head>
<body>
	<div id="wrapper">
		<header class="main_header">
			<%-- <jsp:include page="/include/header.jsp" > --%>
			<%@include file="/jsp/include/header.jsp"%>
		</header>
		<header class="mHeader">
			<%@include file="/jsp/include/mHeader.jsp"%>
		</header>
		<div id="main" class="page_shadow">
			<div class="main_visual swiper-container">
				<div class="swiper-wrapper">
					<div class="swiper-slide slide01">
						<div class="text_box">
							<img src="/MOMOGO/img/mSlide_txt01.png" alt="">
						</div>
					</div>
					<div class="swiper-slide slide02">
						<div class="text_box">
							<img src="/MOMOGO/img/mSlide_txt02.png" alt="">
						</div>
					</div>
					<div class="swiper-slide slide03">
						<div class="text_box">
							<img src="/MOMOGO/img/mSlide_txt03.png" alt="">
						</div>
					</div>
				</div>
				<div class="swiper-pagination"></div>
				<div class="swiper-button-next slider_arrow slider_next"></div>
				<div class="swiper-button-prev slider_arrow slider_prev"></div>
			</div>
			<section class="section01">
				<div class="txt_box">
					<p class="en">Goood for natural<br>Good for you</p>
					<p class="ko">
						빠르게 변해가고 있는 현대의 사회에서<br>
						가장 신선한 재료만을 엄선하여 요리한 음식으로<br>
						신속하고 정확하게 배달해드리겠습니다<br><br>
						<span>배달은</span>
					</p>	
					<p class="momogo">MOMOGO</p>
				</div>
			</section>
			<section class="section02">
				<div class="text_wrap">
					<p class="tit">
						Event
					</p>
					<p class="sort">
						회원가입 축하 이벤트
					</p>
					<p class="info">
						주문시 5,000원 할인
					</p>
					<a href="#" class="basic_btn">바로가기</a>
				</div>
			</section>
			<section id="section03">
				<form>
					<div class="search_wrap">
					<button class="current_btn" type="button"></button>
					<div class="input_wrap">
						<div class="input_box">
							<input type="text" class="insert_input search_addr" name="address"
								placeholder="버튼을 눌러 주소를 검색해주세요" id="address" readonly >
							<button type="button" class="search_btn"
								onclick="daumPostcode()">주소검색</button>
						</div>
					</div>
					</div>
					<c:set var="categories"	value="치킨,중국집,피자,족발/보쌈,야식,찜/탕,한식/분식/죽,돈까스/회/일식,패스트푸드" />
					<c:set var="category" value="${fn:split(categories, ',')}" />
					<c:set var="i" value="0" />
					<ul class="itemList_wrap">
						<c:forEach items="${ category }" var="c">
							<c:set var="i" value="${i+1}" />
							<li class="itemList itemList0${ i }">
								<div class="item_cover"></div> <a href="#"></a>
								<div class="line">
									<div class="txt_box">
										<button type="button" class="moreBtn" onclick="moreBtn('${c}')">더보기</button>
									</div>
									<div class="heading">
										<h4>${ c }</h4>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</form>
			</section>
		</div>
		<footer>
			<%@include file="/jsp/include/footer.jsp"%>
		</footer>
	</div>
</body>
</html>