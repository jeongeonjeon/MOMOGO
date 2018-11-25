

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/jsp/include/head.jsp" />
<script src="/Lecture_Web/jquery/js/jquery-3.3.1.min.js"></script>
<script> 

   // 아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활서황를 위한 변수 설정
   var checkFirst = false; 
   var lastKeyword = '';
   var loopSendKeyword =false; 
   
   var id = $('#id');
   var checkBool = false;
   
   console.log(id);
 
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

		return true;
	}

	function check(re, what, msg) {
		if (re.test(what)) {
			return true;
		}
		alert(msg);
		what = "";
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
				sendRequest("<%= request.getContextPath() %>/join/personal_id_check.do", params, displayResult, 'POST');
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
	<div class="personalSignup_page page_shadow">
		<form method="post"
			action="<%=request.getContextPath()%>/join/personalSignupProcess.do"
			name="signUp" onsubmit="return clickBtn()">
			<div id="signupForm">
				<h3 class="signupGuide">필수 정보를 입력해주세요</h3>

				<div class="form-row">
					<p class="formName">아이디</p>
					<input id="id" class="inputValue insert_input" type="text"
						placeholder="아이디* (4~20자)" name="id" onkeydown="checkId()">
					<p id="checkMsg" class="error"></p>
				</div>
				<div class="form-row">
					<p class="formName">비밀번호</p>
					<input id="pass" class="inputValue insert_input" type="password"
						placeholder="비밀번호(8자리 이상)" name="pass" oninput="checkPass()">
					<p class="error"></p>
				</div>
				<div class="form-row">
					<p class="formName">비밀번호 재확인</p>
					<input id="passCheck" class="inputValue insert_input"
						type="password" placeholder="비밀번호 체크" name="passCheck"
						oninput="checkPass()">
					<p class="error"></p>
				</div>
				<div class="form-row">
					<p class="formName">이메일</p>
					<input id="email" class="inputValue insert_input" type="email"
						placeholder="ex) momogo@momogo.com" name="email">
					<p class="error"></p>
				</div>
				<div class="form-row">
					<p class="formName">이름</p>
					<input id="name" class="inputValue insert_input" type="text"
						placeholder="이름" name="name">
					<p class="error"></p>
				</div>
				<div class="form-row">
					<p class="formName">전화번호</p>
					<input id="phone" class="inputValue insert_input" type="text"
						placeholder="ex) 01011112222" name="phone">
					<p class="error"></p>
				</div>
				<button class="basic_btn" type="submit">가입 신청</button>
			</div>
		</form>
	</div>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>