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
<script>
	function moreBtn(category){
		
		if($('#address').val() == ""){
			alert("주소를 입력해주세요");
		}else{
			var address = $('#address').val();
			location.href = "${url}/store/storeList.do?category=" + category + "&address=" + address;
		}
	}

</script>
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
				<form>
					<div class="search_wrap">
					<button class="current_btn" type="button"></button>
					<div class="input_wrap">
						<div class="input_box">
							<input type="text" class="search_addr" name="address"
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
							<li class="itemList0${ i }">
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
			</div>
		</div>
		<footer>
			<%@include file="/jsp/include/footer.jsp"%>
		</footer>
	</div>
</body>
</html>