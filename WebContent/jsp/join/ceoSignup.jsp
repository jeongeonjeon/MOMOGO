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
						document.getElementById('basicAddr').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('detailAddr').focus();
					}
				}).open();
	}
	
	
	var checkFirst = false; 
	var lastKeyword = '';
	var loopSendKeyword =false; 
	  
	var id = $('#id');
	var checkBool = false;


	function clickBtn() {
		
		var re = /^[a-zA-Z0-9]{4,12}$/;
		var re2 =/^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		var re3 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var re4 = /^\d{3}\d{3,4}\d{4}$/;
		var re5 = /^\d{2,3}\d{3,4}\d{4}$/;
		
		var id = $('#id');
		var pass = $('#pass');
		var passCheck = $('#passCheck');
		var email = $('#email');
		var name = $('#name');
		var phone = $('#phone');
		var storeName = $("#storeName");
		var licenseNum = $("#licenseNum");
		var storeTel = $("#storeTel");
		var basicAddr = $("#basicAddr");
		var detailAddr = $("#detailAddr");
		var deliveryArea = $("#deliveryArea");

		if (id.val() == "") {
			alert("아이디를 입력하세요!")
			id.focus(); 
			return false
		}else if(!check(re,id.val(),"공백없이 4-20자")) {
			id.focus(); 
			return false
		}else if(checkBool) {
			alert('아이디가 중복되었습니다');
			id.focus();
			return false;
		} 

		if (pass.val() == "") {
			alert("비밀번호 입력하세요!");
			pass.focus(); 
			return false
		}else if(!check(re2,pass.val(),"영문+숫자 포함, 8-20자")) {
			pass.focus(); 
			return false
		} 
		
		if (passCheck.val() == "") {
			alert("비밀번호 확인란을 입력하세요!");
			passCheck.focus();
			return false
		}else if (pass.val() != passCheck.val()) {
			alert("비밀번호가 일치하지 않습니다.");
			passCheck.focus();
			return false
		}

		if (email.val() == "") {
			alert("이메일을 입력하세요!");
			email.focus(); 
			return false
		}else if(!(check(re3,email.val(),"올바른 이메일이 아닙니다"))){
			email.focus(); 
			return false
		}

		if (name.val() == "") {
			alert("이름을 입력하세요!");
			name.focus();
			return false
		}

		if (phone.val() == "") {
			alert("휴대폰번호를 입력하세요!");
			phone.focus(); 
			return false
		}else if(!(check(re4,phone.val(),"올바른 휴대폰번호가 아닙니다"))){
			phone.focus();
			return false; 
		}

		if (storeName.val() == "") {
			alert("음식점 이름을 입력하세요!");
			storeName.focus();
			return false
		}

		if (licenseNum.val() == "") {
			alert("사업자 등록번호를 입력하세요!");
			licenseNum.focus();
			return false
		}else if(!(check(re4,licenseNum.val(),"사업자번호: 10자리의 숫자를 입력하세요"))){
			licenseNum.focus();
			return false; 
		}

		if (storeTel.val() == "") {
			alert("음식점 전화번호를 입력하세요!");
			storeTel.focus(); 
			return false
		}else if(!(check(re5,storeTel.val(),"올바른 전화번호가 아닙니다"))){
			storeTel.focus(); 
			return false; 
		}

		if (basicAddr.val() == "") {
			alert("음식점 기본주소를 입력하세요!");
			basicAddr.focus();
			return false
		}

		if (detailAddr.val() == "") {
			alert("음식점 상세주소를 입력하세요!");
			detailAddr.focus(); 
			return false
		}

		if (deliveryArea.val() == "") {
			alert("배달 가능지역을 입력하세요!");
			deliveryArea.focus();
			return false
		}

		return true
	}
	
	function check(re, what, msg){
		if(re.test(what)){
			return true; 
		}
		alert(msg);
		what ="";
	}
	
	
	
	function checkId() {

		if (checkFirst == false) {
			setTimeout("sendId();", 10);
			loopSendKeyword = true;
		}
		checkFirst = true;

	}
   
   
	function sendId() {
		if (loopSendKeyword == false)
			return;

		var keyword = document.signUp.id.value;
		if (keyword == '') {
			lastKeyword = '';
			document.getElementById('checkMsg').style.color = "red";
			document.getElementById('checkMsg').innerHTML = "아이디를 입력하세요.";
		} else if (keyword != lastKeyword) {
			lastKeyword = keyword;

			if (keyword != '') {
				var params = "id=" + encodeURIComponent(keyword);
				sendRequest("<%= request.getContextPath() %>/join/ceo_id_check.do", params, displayResult, 'POST');
			} else {
			}
		}
		setTimeout("sendId();", 10);
	}
	
	function displayResult() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var resultText = httpRequest.responseText;
				var listView = document.getElementById('checkMsg');
				console.log(listView + " : " + resultText.trim());
				if (resultText == 0) {
					listView.innerHTML = "사용 할 수 있는 ID 입니다";
					listView.style.color = "blue";
					checkBool = false;
				} else {
					listView.innerHTML = "이미 등록된 ID 입니다";
					listView.style.color = "red";
					checkBool = true;
				}
			} else {
				alert("에러 발생: " + httpRequest.status);
			}
		}
	}
	
		
	function checkPass() {
		var pass = $('#pass').val();
		var passCheck = $('#passCheck').val();

		if (pass.length > 0 && pass.length < 8) {
			$("#pass + .error").text("비밀번호는 영문+숫자 조합, 8자 이상이어야합니다.");
		

		} else {
			$("#pass + .error").text("");
			if (passCheck == "" || passCheck == pass) {
				$("#passCheck + .error").text("");
			} else {
				$("#passCheck + .error").text("비밀번호가 일치하지 않습니다");

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
								placeholder="공백없이 4-20자" onkeyup="checkId()">
							<p id="checkMsg" class="error"></p>
						</div>
					</div>
					<div class="formRow">
						<p class="formName">비밀번호</p>
						<div class="inputArea">
							<input id="pass" class="inputValue insert_input" type="password"
								name="password" placeholder="영문+숫자 포함,8-20자" oninput ="checkPass()">
							<p class="error"></p>
						</div>
					</div>
					<div class="formRow">
						<p class="formName">비밀번호 재확인</p>
						<div class="inputArea">
							<input id="passCheck" class="inputValue insert_input" type="password"
								name="passwordCheck" oninput ="checkPass()">
							<p class="error"></p>
						</div>
					</div>
					<div class="formRow">
						<p class="formName">이메일</p>
						<div class="inputArea">
							<input id="email" placeholder="ex)momogo@momogo.com" class="inputValue insert_input" type="text" name="email"
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
							<input id="phone" placeholder="ex) 01011112222" class="inputValue insert_input" type="text" name="phone">
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
							<input id="storeTel" placeholder="ex) 02-111-2222" class="inputValue insert_input" type="text"
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
								<option value="9">패스트푸드</option>
							</select>
						</div>
					</div>
					<div class="formRow">
						<p class="formName">배달가능지역</p>
						<div class="inputArea">
							<input class="inputValue inputValue2 insert_input" type="text"
								name="deliveryArea"> <input type="button" class="areaBtn"
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
