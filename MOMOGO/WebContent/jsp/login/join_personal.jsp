<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>


	.form-row input {
		width: 325px; 
		height:50px; 
	}
	
	.form-row .input {
		padding: 12px 14px; 
		border : 1px solid #dddddd; 
		font-size: 16px; 
		line-height: 24px;
		box-sizing: border-box; 
	}
	
	.form-row + .form-row {
		margin-top : 15px; 
	}
	
	
	.error {
	
		font-size : 13px; 
		color: red; 
		display:none; 
	}
	
	
	
</style>
<script src = "/js/jquery-3.3.1.min.js"></script>
<script> 

	// 아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활서황를 위한 변수 설정
	var idCheck = 0; 
	var nickCheck =0; 
	var pwdCheck = 0; 
	var form = document.joinForm;
	
	
	function checkId() {
		var id = form.id;
		var inputed = id.value; 
		
		$.ajax({
			type : "post", //통신타입 post/ get
			url : "checkId.do",	// 요청할 url
			data : {
				id : inputed
			},	// 서버에 요청시 보낼 파라미터 기입 
		//	dataType : "xml" //응답받을 데이터의 타입 선택
			success : function(data){
				
			}
				
				
				//요청 및 응답에 성공하였을 때의 행위 
			

			
		})
		
	}
	
	function insertPass(){
		var form = document.joinForm;
 		var pass = form.pass; 
 		
 		if(pass.value ==""){
 			
 			alert("비밀번호를 입력하세요")
 			$('pass').focus(); 
 			
 		}else if(pass.size < 8 ){
 			console.log("비밀번호를 확인2")
 			$('pass').focus(); 
 		}else{
 			if(passCheck != pass){
 	 			console.log("비번을 확인하세요");
 	 			$('passCheck').focus(); 
 			}
 		}

	}
	
	function checkPass(){
		var form = document.joinForm;
 		var passCheck = form.passCheck;
 		var pass = form.pass; 
 		
 		if(pass.value ==""){
 			
 			alert("비밀번호를 입력하세요")
 			$('pass').focus(); 
 			
 		}else if(pass.size < 8 ){
 			console.log("비밀번호를 확인2")
 			$('pass').focus(); 
 		}else{
 			if(passCheck != pass){
 	 			console.log("비번을 확인하세요");
 	 			$('passCheck').focus(); 
 			}
 		}

	}
	
</script>
</head>
<body>
	<form method ="post" action="#" name ="joinForm">

		<p>필수 정보를 입력해주세요</p>
		
		<div class="form-row"> 
			<input class="input" type="text" placeholder="아이디* (4~20자)" name ="id">
			<p class="error">* 아이디를 입력하세요</p>
		</div>
		<div class="form-row"> 
			<input class="input" type="text" placeholder ="비밀번호" name ="pass" oninput="insertPass()">
		</div>
		<div class="form-row"> 
			<input class="input pass" type="text" placeholder ="비밀번호 체크" name ="passCheck" oninput="checkPass()">
		</div>
		<div class="form-row"> 
			<input class="input" type="text" placeholder ="이메일" name ="email">
		</div>
		<div class="form-row"> 
			<input class="input" type="text" placeholder ="이름" name ="name">
		</div>
		<div class="form-row"> 
			<input class="input" type="text" placeholder ="휴대폰" name ="phone">
		</div>
		
		<input type ="submit" value ="가입하기">
	</form>
	
</body>
</html>