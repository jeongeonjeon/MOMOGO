<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
</head>
<body>
	<header>
			<%@include file="/jsp/include/header.jsp"%>
	</header>
	<div class="myPage_page page_shadow">
		<div class="page_inner">
			<section class="item_wrap">
				<div class="left">
					<div class="item order_item">
						<div class="item_header">
							<h4 class="tit">신규 주문내역</h4>
							<button type="button"></button>
						</div>
						<p class="contxt">
							<span>'최근주문'한 주문내역</span> 정보입니다.<br> 3개월이 지난 주문 내역은 삭제됩니다.
						</p>
						<div class="item_content">
							<div class="content_header new">
								<div class="new"></div>
								<p class="date">15:44:32</p>
								<form>
									<div class="status_view on">
										<button type="button" class="change_btn">상태변경</button>
										<p class="status">주문대기</p>
									</div>
									<div class="status_change">
										<select>
											<option>주문상태를 선택해주세요</option>
											<option>접수완료</option>
											<option>주문취소</option>
											<option>주문완료</option>
										</select>
										<button type="button" class="change_btn">완료</button>
									</div>
								</form>
							</div>
							<div class="content">
								<div class="img">
									<img src="/MOMOGO/img/item01.jpg" alt="">
								</div>
								<div class="order_info">
									<p class="store_name">도미노피자</p>
									<p class="food_name">불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1
										불고기피자x1</p>
								</div>
							</div>
						</div>
						<div class="item_content">
							<div class="content_header new">
								<div class="new"></div>
								<p class="date">15:44:32</p>
								<form>
									<div class="status_view on">
										<button type="button" class="change_btn">상태변경</button>
										<p class="status">주문대기</p>
									</div>
									<div class="status_change">
										<select>
											<option>주문상태를 선택해주세요</option>
											<option>접수완료</option>
											<option>주문취소</option>
											<option>주문완료</option>
										</select>
										<button type="button" class="change_btn">완료</button>
									</div>
								</form>
							</div>
							<div class="content">
								<div class="img">
									<img src="/MOMOGO/img/item01.jpg" alt="">
								</div>
								<div class="order_info">
									<p class="store_name">도미노피자</p>
									<p class="food_name">불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1
										불고기피자x1</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="right">
					<div class="item order_item">
						<div class="item_header">
							<h4 class="tit">완료 주문내역</h4>
							<button type="button"></button>
						</div>
						<p class="contxt">
							<span>'최근주문'한 주문내역</span> 정보입니다.<br> 3개월이 지난 주문 내역은 삭제됩니다.
						</p>
						<div class="item_content">
							<div class="content_header">
								<p class="date">2018.11.21</p>
								<p class="status">주문완료</p>
							</div>
							<div class="content">
								<div class="img">
									<img src="/MOMOGO/img/item01.jpg" alt="">
								</div>
								<div class="order_info">
									<p class="store_name">도미노피자</p>
									<p class="food_name">불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1
										불고기피자x1</p>
								</div>
							</div>
						</div>
						<div class="item_content">
							<div class="content_header">
								<p class="date">2018.11.21</p>
								<p class="status">주문완료</p>
							</div>
							<div class="content">
								<div class="img">
									<img src="/MOMOGO/img/item01.jpg" alt="">
								</div>
								<div class="order_info">
									<p class="store_name">도미노피자</p>
									<p class="food_name">불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1
										불고기피자x1</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>

</body>
</html>