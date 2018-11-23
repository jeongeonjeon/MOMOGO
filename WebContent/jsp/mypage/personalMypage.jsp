<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
</head>
<body>
<div class="popup_cover"></div>
<div class="popup_wrap">
	<div class="popup mCustomScrollbar" data-mcs-theme="dark-thin">
		<div class="popup_inner">
			<section class="store_name">
				도미노피자
			</section>
			<section class="content_wrap">
				<div class="content_header">
					<p>주문상태</p>
					<p class="status">주문완료</p>
				</div>
				<div class="content mb5">
					<p class="left_txt">
						주문시간
					</p>
					<p class="right_txt">2018.11.21 11:22</p>
				</div>
			</section>
			<section class="content_wrap">
				<div class="content_header">
					<p>주문내역</p>
				</div>
				<div class="content">
					<p class="left_txt">
						불고기피자x1
					</p>
					<p class="right_txt">500원</p>
				</div>
				<div class="content">
					<p class="left_txt">
						불고기피자x1
					</p>
					<p class="right_txt">500원</p>
				</div>
				<div class="content">
					<p class="left_txt">
						불고기피자x1
					</p>
					<p class="right_txt">500원</p>
				</div>
				<div class="content">
					<p class="left_txt">
						불고기피자x1
					</p>
					<p class="right_txt">500원</p>
				</div>
				<div class="content">
					<p class="left_txt">
						불고기피자x1
					</p>
					<p class="right_txt">500원</p>
				</div>
				<div class="content sum">
					<p class="left_txt">상품합계</p>
					<p class="right_txt">1500원</p>
				</div>
				<div class="content payment">
					<p class="left_txt">결제금액</p>
					<p class="right_txt">1500원</p>
				</div>
			</section>
			<section class="content_wrap">
				<div class="content_header">
					<p>주문자 정보</p>
				</div>
				<div class="content">
					<p class="left_txt">
						연락처
					</p>
					<p class="right_txt">01011112222</p>
				</div>
				<div class="content addr">
					<p class="left_txt">
						주소
					</p>
					<p class="right_txt">
						경기도 구리시 갈매동 갈매중앙로 111<br>111동 1111호
					</p>
				</div>
				<div class="content addr">
					<p class="left_txt">
						요청사항
					</p>
					<p class="right_txt">
						(없음)
					</p>
				</div>
			</section>
		</div>
	</div>
	<div class="popup_close_btn">
		<button type="button" class="close_btn"></button>
	</div>
</div>
<div class="myPage_page">
	<div class="page_inner">
		<section class="item_wrap">
			<div class="left">
				<div class="item m2_item">
					<div class="item_header">
						<h4 class="tit">회원정보</h4>
						<button type="button"></button>
					</div>
					<p class="contxt">
						<span>'나'의 회원</span> 정보입니다.<br>회원유형과 가입일은 수정이 불가능합니다.
					</p>
					<div class="item_content basic_content on">
						<div class="info_wrap">
							<div class="info">
								<p class="tit">회원유형</p>
								<p class="txt">${personal.type}</p>
							</div>
							<div class="info">
								<p class="tit">가입날짜</p>
								<p class="txt">${personal.regDate}</p>
							</div>
						</div>
					</div>
				</div>
				<div class="item">
					<div class="item_header">
						<h4 class="tit">프로필</h4>
						<button type="button"></button>
					</div>
					<p class="contxt">
						<span>'나'를 표현하는 프로필</span> 정보입니다.<br> 수정 화면에서 비밀번호를 변경하세요.
					</p>
					<div class="item_content basic_content on">
						<div class="pic">
							<img src="/MOMOGO/img/default.png" alt="">
						</div>
						<div class="info_wrap">
							<div class="info">
								<p class="tit">아이디</p>
								<p class="txt">${ personal.id }</p>
							</div>
							<div class="info">
								<p class="tit">이름</p>
								<p class="txt">${ personal.name }</p>
							</div>
							<div class="info">
								<p class="tit">비밀번호</p>
								<p class="txt">${ personal.pass }</p>
							</div>
						</div>
						<button class="basic_btn modify_btn" type="button">수정</button>
					</div>
					<div class="item_content modify_content">
						<div class="pic">
							<img src="/MOMOGO/img/default.png" alt="">
						</div>
						<div class="info_wrap">
							<form method="post" action="updateProfile.jsp">
								<input type="hidden" name="id" value="${ personal.id }">
								<div class="info">
									<p class="tit">아이디</p>
									<p class="txt">${ personal.id }</p>
								</div>
								<div class="info">
									<p class="tit">이름</p>
									<input type="text" name="name" value="${ personal.name }">
								</div>
								<div class="info">
									<p class="tit">비밀번호</p>
									<input type="password" name="password"
										value="${ personal.pass }">
								</div>
								<div class="btn_wrap">
									<button type="reset" class="basic_btn cancel_btn">취소</button>
									<button type="submit" class="basic_btn complete_btn">완료</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="item m2_item">
					<div class="item_header">
						<h4 class="tit">연락처 설정</h4>
						<button type="button"></button>
					</div>
					<p class="contxt">
						<span>'나'의 연락처</span> 정보입니다.<br> 수정 화면에서 핸드폰번호와 이메일주소를 변경하세요.
					</p>
					<div class="item_content basic_content on">
						<div class="info_wrap">
							<div class="info">
								<p class="tit">전화번호</p>
								<p class="txt">${ personal.phone }</p>
							</div>
							<div class="info">
								<p class="tit">이메일주소</p>
								<p class="txt">${ personal.email }</p>
							</div>
						</div>
						<button class="basic_btn modify_btn" type="button">수정</button>
					</div>
					<div class="item_content modify_content">
						<div class="info_wrap">
							<form action="updateContact.jsp" method="post">
								<input type="hidden" name="id" value="${ personal.id }">
								<div class="info tel">
									<p class="tit">전화번호</p>
									<select name="tel1">
										<option selected value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="018">018</option>
									</select> <span>-</span> <input type="text" name="phone"
										value="${ personal.phone }">
								</div>
								<div class="info mail">
									<p class="tit">이메일주소</p>
									<input type="text" name="emailId" value="${ personal.email }">
								</div>
								<div class="btn_wrap">
									<button type="reset" class="basic_btn cancel_btn">취소</button>
									<button type="submit" class="basic_btn complete_btn">완료</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="right">
				<div class="item order_item">
					<div class="item_header">
						<h4 class="tit">주문내역</h4>
						<button type="button"></button>
					</div>
					<p class="contxt">
						<span>'최근주문'한  주문내역</span> 정보입니다.<br> 3개월이 지난 주문 내역은 삭제됩니다.
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
								<p class="food_name">
									불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1 
								</p>
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
								<p class="food_name">
									불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1 불고기피자x1 
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</div>
</body>
</html>