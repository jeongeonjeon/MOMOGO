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
<header>
	<%@include file="/jsp/include/header.jsp"%>
</header>
<div class="myPage_page page_shadow">
	<div class="page_inner">
		<section class="item_wrap">
			<div class="left">
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
								<p class="txt">${ ceo.type }</p>
							</div>
							<div class="info">
								<p class="tit">가입날짜</p>
								<p class="txt">${ ceo.regDate }</p>
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
								<p class="txt">${ ceo.id }</p>
							</div>
							<div class="info">
								<p class="tit">이름</p>
								<p class="txt">${ ceo.name }</p>
							</div>
							<div class="info">
								<p class="tit">비밀번호</p>
								<p class="txt">${ ceo.password }</p>
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
								<input type="hidden" name="id" value="${ ceo.id }">
								<div class="info">
									<p class="tit">아이디</p>
									<p class="txt">${ ceo.id }</p>
								</div>
								<div class="info">
									<p class="tit">이름</p>
									<input type="text" name="name" value="${ ceo.name }">
								</div>
								<div class="info">
									<p class="tit">비밀번호</p>
									<input type="password" name="password"
										value="${ ceo.password }">
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
				<div class="item store_item mCustomScrollbar" data-mcs-theme="dark-thin"">
					<div class="item_inner">
						<div class="item_header">
							<h4 class="tit">업체설정</h4>
							<button type="button"></button>
						</div>
						<p class="contxt">
							<span>'가입한 업체'의 상세</span> 정보입니다.<br> 정보를 이력해주시기 바랍니다
						</p>
						<form>
							<div class="input_container">
								<div class="input_content">
									<div class="logo"></div>
									<div class="logoInput_wrap">
										<div class="filebox">
											<input class="upload-name" value="로고를 선택해주세요" disabled="disabled">
											<label for="ex_filename">업로드</label>
											<input type="file" id="ex_filename" class="upload-hidden">
										</div>
										<div class="input_box input_txt">
											도미노피자
										</div>
										<div class="input_box input_txt">
											사업자번호 <span>1111111111</span>
										</div>
									</div>
								</div>
								<div class="input_content">
									<div class="input_box input_txt">
										배달업종 <span>치킨</span>
									</div>
									<div class="input_box input_txt">
										배달 가능 지역 <span>인창동</span>
									</div>
									<div class="input_box input_txt">
										배달 가능 지역 <span>갈매동</span>
									</div>
									<div class="input_box input_txt">
										배달 가능 지역 <span>동구동</span>
									</div>
								</div>
								<div class="input_content food_info">
									<select name="menu_sel">
										<option checked>메뉴 카테고리를 선택하세요</option>
										<option value="popular">인기메뉴</option>
										<option value="general">일반메뉴</option>
									</select>
									<div class="sel_arrow"></div>
									<div class="food_input_container">
										<div class="food"></div>
										<div class="foodInput_wrap">
											<div class="filebox filebox1">
												<input class="upload-name upload-name1" value="음식사진을 선택해주세요" disabled="disabled">
												<label for="ex_filename1">업로드</label>
												<input type="file" id="ex_filename1" class="upload-hidden upload-hidden1">
											</div>
											<div class="input_box">
												<input type="text" placeholder="음식명을 입력하세요">
											</div>
											<div class="input_box">
												<input type="text" placeholder="음식가격을 입력하세요">
											</div>
											<div class="input_box">
												<input type="text" placeholder="음식설명을 입력하세요">
											</div>
										</div>
									</div>
									<div class="food_input_container">
										<div class="food"></div>
										<div class="foodInput_wrap">
											<div class="filebox filebox1">
												<input class="upload-name upload-name1" value="음식사진을 선택해주세요" disabled="disabled">
												<label for="ex_filename1">업로드</label>
												<input type="file" id="ex_filename1" class="upload-hidden upload-hidden1">
											</div>
											<div class="input_box">
												<input type="text" placeholder="음식명을 입력하세요">
											</div>
											<div class="input_box">
												<input type="text" placeholder="음식가격을 입력하세요">
											</div>
											<div class="input_box">
												<input type="text" placeholder="음식설명을 입력하세요">
											</div>
										</div>
									</div>
									<button class="food_add_btn"></button>
								</div>
								<input class="food_btn basic_btn" type="submit" value="완료">
							</div>
						</form>
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
								<p class="txt">${ ceo.phone }</p>
							</div>
							<div class="info">
								<p class="tit">이메일주소</p>
								<p class="txt">${ ceo.email }</p>
							</div>
						</div>
						<button class="basic_btn modify_btn" type="button">수정</button>
					</div>
					<div class="item_content modify_content">
						<div class="info_wrap">
							<form action="updateContact.jsp" method="post">
								<input type="hidden" name="id" value="${ ceo.id }">
								<div class="info tel">
									<p class="tit">전화번호</p>
									<select name="tel1">
										<option selected value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="018">018</option>
									</select> <span>-</span> <input type="text" name="tel2"
										value="${ member.tel2 }"> <span>-</span> <input
										type="text" name="tel3" value="${ member.tel3 }">
								</div>
								<div class="info mail">
									<p class="tit">이메일주소</p>
									<input type="text" name="emailId" value="${ ceo.email }">
									<span>@</span> <input type="text" name="emailDomain"
										value="${ ceo.email }">
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
						<h4 class="tit">지역설정</h4>
						<button type="button"></button>
					</div>
					<p class="contxt">
						<span>'나'의 주소지</span> 정보입니다.<br> 수정 화면에서 주소와 우편번호를 변경하세요.
					</p>
					<div class="item_content basic_content on">
						<div class="info_wrap">
							<div class="info">
								<p class="tit">우편번호</p>
								<p class="txt">${ ceo.email }</p>
							</div>
							<div class="info">
								<p class="tit">기본주소</p>
								<p class="txt">${ ceo.basicAddr }</p>
							</div>
							<div class="info">
								<p class="tit">상세주소</p>
								<p class="txt">${ ceo.detailAddr }</p>
							</div>
						</div>
						<button class="basic_btn modify_btn" type="button">수정</button>
					</div>
					<div class="item_content modify_content">
						<div class="info_wrap">
							<form method="post" action="updateArea.jsp">
								<input type="hidden" name="id" value="${ ceo.id }">
								<div class="info">
									<p class="tit">기본주소</p>
									<input type="text" name="basicAddr"
										value="${ ceo.basicAddr }">
								</div>
								<div class="info">
									<p class="tit">상세주소</p>
									<input type="text" name="detailAddr"
										value="${ ceo.detailAddr }">
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
		</section>
	</div>
</div>
<footer>
	<%@include file="/jsp/include/footer.jsp"%>
</footer>
</body>
</html>