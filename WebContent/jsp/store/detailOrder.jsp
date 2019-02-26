<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
<script>

	
// 	상세주소 공란
	function detailAddr() {
		
		var del_detail = document.details.detail_addr; 
		
		console.log(del_detail.value.length);
		
		if(del_detail.value.length < 1 || del_detail.value == "") {
			$('#detail_addr + .warning').text("필수 항목입니다");
			
		}else{
			$('#detail_addr + .warning').text("");	
		}
		
	}
	
// 	휴대폰 공란
	function phoneNo() {
		
		var phone = document.details.phone; 
		var regExp = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
		
		console.log(phone.value.length);
		
		if(phone.value.length < 1 || phone.value == "") {
			$('#phone + .warning').text("필수 항목입니다");	
		}else if(p){
			$('#phone + .warning').text("잘못된 휴대폰 번호입니다. 휴대폰 번호를를 확인해주세요.");	
		}
		
	}
	
// 	요청사항 텍스트 수 제한
	function options(){
		var option = document.details.option; 
		
		console.log(option.value.length); 

		if(option.value.length > 0 && option.value.length < 101) {
			$('.option_length').text(option.value.length);
		}
		else {
			option.value = option.value.substring(0,100);  
		}
		
	}
	
	
// 	결제수단 체크시 박스 색상 변경
	$(document).ready(function(){

		$("input[name=pay_method]").change(function(){//인풋의 name이 send 인 태그가 change될때마다, 즉 바뀔때마다
		
		    var result = $(this).val()  // 변수 result에 $(this).val() 즉, input[name=send] 이거의 value 값을 대입합니다.
		    
		
		    if(result=='CASH'){  //value가 1이면
		
		    	$("#credit_btn").removeClass('selected_m');
		        $("#cash_btn").addClass('selected_m'); //아이디가 email인 태그의 폰트 css 를 바꿉니다.
		        console.log(result);
		
		    }else{ // value가 1이 아니면
		
		    	 $("#cash_btn").removeClass('selected_m'); //아이디가 email인 태그의 폰트 css 를 바꿉니다.
		    	 $("#credit_btn").addClass('selected_m'); //아이디가 email인 태그의 폰트 css 를 바꿉니다.
		    	 console.log(result);
		
		    }
		
		})
		
	});
	
	
</script>
</head>
<body>
	<header>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
	<div class="detailStore_page">
		<div class="page_shadow">
			<div class="page_inner">
					<div class="detail_container">
						<section class="storeInfo_box">
							<form method="get" name ="details" action="<%= request.getContextPath() %>/store/detailStoreProcess.do" onsubmit="return checkOrder()">
								<div class="ordered_header bg_bl">결제하기</div>
								<div class="ordered_header">배달정보</div>
								<div class="ordered_contents">
									<div class="addr clr">
										<div class="content_item">주소</div>
										<div class="input_item">
											<input type="text" name ="basic_addr" readonly />
											<input type="text" name ="detail_addr" id="detail_addr" placeholder="상세주소를 입력해주세요(필수)" oninput="detailAddr()"/>
											<span class="warning"></span>
										</div>
									</div>
									<div class="phone clr">
										<div class="content_item">휴대폰번호</div>
										<div class="input_item">
											<input type="text" name ="phone" id="phone" placeholder="휴대폰 번호를 입력해주세요(필수)" oninput="phoneNo()"/>
											<span class="warning"></span>
										</div>
									</div>
								</div>	
								<div class="ordered_header">주문시 요청사항</div>
								<div class="ordered_option">
									<textarea rows="3" cols="1" name="option" oninput ="options()"></textarea>
									<p class="txt_cnt"><span class="option_length">1</span>/100</p>
								</div>
								<div class="ordered_header">결제수단 선택</div>
								<div class="payment">
									<p>현장결제 수단을 선택해주세요</p> 
									<label for="cash" class="pay_m selected_m" id="cash_btn">현금</label>
									<label for="credit" class="pay_m" id="credit_btn">신용카드</label>
									
									<input type="radio" name="pay_method" value="CASH" id="cash" checked="checked">
									<input type="radio" name="pay_method" value="CREDIT" id="credit">
								</div>
							</form>
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
								<p>주문내역</p>
								<button="clear"></button>
							</div>
						<div class="order_contents cart on">
							<div class="myOrder_wrap">
								<div class="content">
									<p class="food_name">어디어디 가게게게게게ㅔ겍가ㅔ</p>
									</div>
								</div>
								<div class="selected_menu">
									<p> 메뉴 어쩍 </p>
									<p>	10,000</p>
								</div>
								<div class="sum_box">
									<p>합계</p>
									<p class ="total">1,000</p>
								</div>
							</div>
							<input class="basic_btn order_btn" type="submit" value="주문하기">
						</aside>
					</form>
					
			</div>

		</div>
	</div>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>