<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/jsp/include/head.jsp" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	//daum주소 API사용
	function execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('address2').focus();
					}
				}).open();
	}

	// 아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활서황를 위한 변수 설정
	var idCheck = 0;
	var nickCheck = 0;
	var pwdCheck = 0;
	var form = document.joinForm;

	function checkId() {
		var inputed = $('#id').val();

		$.ajax({
			type : "post", //통신타입 post/ get
			url : "checkId.do", // 요청할 url
			data : {
				id : inputed
			}, // 서버에 요청시 보낼 파라미터 기입 
			//   dataType : "xml" //응답받을 데이터의 타입 선택
			success : function(data) {

			}

		//요청 및 응답에 성공하였을 때의 행위   
		})

	}

	function clickBtn() {

		var id = $('#id').val();
		var pass = $('#pass').val();
		var passCheck = $('#passCheck').val();
		var email = $('#email').val();
		var name = $('#name').val();
		var phone = $('#phone').val();
		var storeName = $("#storeName").val();
		var licenseNum = $("#licenseNum").val();
		var storeTel = $("#storeTel").val();
		var basicAddr = $("#basicAddr").val();
		var detailAddr = $("#detailAddr").val();
		var deliveryArea = $("#deliveryArea").val();

		if (id == "") {
			alert("아이디를 입력하세요!")
			$("#id + .error").show();
			return false
		} else if (id.length < 4) {
			alert("아이디 글자 수를 확인하세요")
			$("#id + .error").show();
			return false
		} else {
			$("#id + .error").hide();
		}

		if (pass == "") {
			alert("비밀번호 입력하세요!");
			return false
		} else if (pass.length < 8) {
			checkPass();
			return false;
		}

		if (passCheck == "") {
			alert("비밀번호 확인란을 입력하세요!");
			return false
		}

		if (pass != passCheck) {
			alert("비밀번호가 일치하지 않습니다.");
			return false
		}

		if (email == "") {
			alert("이메일을 입력하세요!");
			return false
		}

		if (name == "") {
			alert("이름을 입력하세요!");
			return false
		}

		if (phone == "") {
			alert("휴대폰번호를 입력하세요!");
			return false
		}

		if (storeName == "") {
			alert("음식점 이름을 입력하세요!");
			return false
		}

		if (licenseNum == "") {
			alert("사업자 등록번호를 입력하세요!");
			return false
		}

		if (storeTel == "") {
			alert("음식점 전화번호를 입력하세요!");
			return false
		}

		if (basicAddr == "") {
			alert("음식점 기본주소를 입력하세요!");
			return false
		}

		if (detailAddr == "") {
			alert("음식점 상세주소를 입력하세요!");
			return false
		}

		if (deliveryArea == "") {
			alert("배달 가능지역을 입력하세요!");
			return false
		}

		return true
	}

	function checkPass() {
		var pass = $('#pass').val();
		var passCheck = $('#passCheck').val();

		if (pass.length > 0 && pass.length < 8) {
			$("#pass + .error").show();
			alert("비밀번호가 8자리미만입니다")
			

		} else {
			$("#pass + .error").hide();
			if (passCheck == "" || passCheck == pass) {
				$("#passCheck + .error").hide();
			} else {
				$("#passCheck + .error").show();

			}
		}
	}
</script>
</head>
<body>
	<header>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
	<div class="ceoSignup_page page_shadow">
		<form name="signUp" method="post" action="<%= request.getContextPath() %>/join/ceoJoin.do"
			onsubmit="return clickBtn()">
			<div id="signupForm">
				<div class="left_wrap">
					<h3 class="signupGuide">사업자 정보를 입력해주세요</h3>
					<div class="formRow">
						<p class="formName">아이디</p>
						<div class="inputArea">
							<input id="id" class="inputValue insert_input" type="text" name="id"
								placeholder="공백없이 4-20자">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">비밀번호</p>
						<div class="inputArea">
							<input id="pass" class="inputValue insert_input" type="password"
								name="password" placeholder="영문+숫자 포함,8-20자">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">비밀번호 재확인</p>
						<div class="inputArea">
							<input id="passCheck" class="inputValue insert_input" type="password"
								name="passwordCheck">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">이메일</p>
						<div class="inputArea">
							<input id="email" class="inputValue insert_input" type="text" name="email"
								size="35">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">이름</p>
						<div class="inputArea">
							<input id="name" class="inputValue insert_input" type="text" name="name">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">휴대폰번호</p>
						<div class="inputArea">
							<input id="phone" class="inputValue insert_input" type="text" name="phone">
						</div>
					</div>
				</div>
				<div class="right_wrap">
					<h3 class="signupGuide">음식점 정보를 입력해주세요</h3>
					<div class="formRow">
						<p class="formName">음식점 이름</p>
						<div class="inputArea">
							<input id="storeName" class="inputValue insert_input" type="text"
								name="storeName">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">사업자 등록번호</p>
						<div class="inputArea">
							<input id="licenseNum" class="inputValue insert_input" type="text"
								name="licenseNum">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">음식점 전화번호</p>
						<div class="inputArea">
							<input id="storeTel" class="inputValue insert_input" type="text"
								name="storeTel">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">음식점 주소</p>
						<div class="inputArea">
							<input class="inputAddr insert_input" type="text" name="basicAddr"
								id="basicAddr" placeholder="주소" readonly="readonly" size="35">
							<input class="addr_btn" type="button"
								onclick="execDaumPostcode()" value="주소검색"><br> <input
								class="inputAddr inputAddr1 insert_input" type="text" name="detailAddr"
								id="detailAddr" placeholder="상세주소" size="35">
						</div>
					</div>
					<div class="formRow">
						<p class="formName">업종 카테고리</p>
						<div class="inputArea">
							<select class="inputValue" name="category">
								<option value="1">치킨</option>
								<option value="2">중국집</option>
								<option value="3">피자</option>
								<option value="4">족발/보쌈</option>
								<option value="5">야식</option>
								<option value="6">찜/탕</option>
								<option value="7">한식/분식/죽</option>
								<option value="8">돈까스/회/일식</option>
								<option value="9">도시락/패스트푸드</option>
							</select>
						</div>
					</div>
					<div class="formRow">
						<p class="formName">배달가능지역</p>
						<div class="inputArea">
							<input class="inputValue inputValue2 insert_input" type="text"
								name="restaurAddr"> <input type="button" class="areaBtn"
								value="검색">
						</div>
					</div>
				</div>
			</div>
			<div class="joinBtn">
				<button type="submit">가입 신청</button>
			</div>
		</form>
	</div>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>
