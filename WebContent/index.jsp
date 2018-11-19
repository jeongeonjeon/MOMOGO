<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1fe41c09db40fafd2cb9304b55b471f7&libraries=services"></script>
<script src="/MOMOGO/js/map.js"></script>
</head>
<body>
	<div id="wrapper">
		<header>
			<%-- <jsp:include page="/include/header.jsp"> --%>
			<%@include file="/jsp/include/header.jsp"%>
		</header>
		<div id="main" class="page_shadow">
			<div class="page_inner">
				<div class="main_visual swiper-container">
					<div class="swiper-wrapper">
						<div class="swiper-slide slide01">
							<a href="#"></a>
						</div>
						<div class="swiper-slide slide02">
							<a href="#"></a>
						</div>
					</div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
				</div>
				<div class="search_wrap">
					<form>
						<button class="current_btn" type="button"></button>
						<div class="input_wrap">
							<div class="input_box">
								<input type="text" class="search_addr"  placeholder="예) 역삼동, 신림동">
								<button type="button" class="search_btn">검색</button>
							</div>
						</div>
					</form>
				</div>
				<ul class="item_wrap">
					<li class="item01">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item02">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item03">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item04">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item05">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item06">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item07">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item08">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
					<li class="item09">
						<div class="item_cover"></div>
						<a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<!-- <p>중국집</p> -->
								<a href="">더보기</a>
							</div>
							<div class="heading">
								<h4>중국집</h4>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<footer>
			<%@include file="/jsp/include/footer.jsp"%>
		</footer>
	</div>
</body>
</html>