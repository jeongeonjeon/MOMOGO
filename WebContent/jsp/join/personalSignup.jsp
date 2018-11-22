

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/jsp/include/head.jsp" />
<script src = "/Lecture_Web/jquery/js/jquery-3.3.1.min.js"></script>
<script> 

   // 아이디와 비밀번호가 맞지 않을 경우 가입버튼 비활서황를 위한 변수 설정
   var idCheck = 0; 
   var nickCheck =0; 
   var pwdCheck = 0; 
   var form = document.joinForm;
   
   
   function checkId() {
      var inputed = $('#id').val(); 
      
      $.ajax({
         type : "post", //통신타입 post/ get
         url : "checkId.do",   // 요청할 url
         data : {
            id : inputed
         },   // 서버에 요청시 보낼 파라미터 기입 
    //   dataType : "xml" //응답받을 데이터의 타입 선택
         success : function(data){
            if(inputed == "" && data =='0'){
            	idCheck = 0; 
            }else if(data = '0'){
            	idCheck=1;
            	if(idCheck==1 && pwdCheck ==1){
            		
            	}
            }else if (data == '1'){
            	idCheck = 0; 
            }
    
    	 
         }
           //요청 및 응답에 성공하였을 때의 행위   
      })
      
   }
   
   function clickBtn(){
	   
	    //영문이나 숫자 4-20자리
		var re = /^[a-zA-Z0-9]{4,20}$/;
		//영문+숫자 조합으로 8-20자리
		var re2 =/^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		//이메일양식
		var re3 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		//휴대폰번호 양식		
		var re4 = /^\d{3}\d{3,4}\d{4}$/;
	   
 	   var id =$('#id').val(); 
       var pass = $('#pass').val(); 
       var passCheck = $('#passCheck').val(); 
       var email = $('#email').val(); 
       var name = $('#name').val(); 
       var phone = $('#phone').val(); 
       
       
       if(id ==""){
          alert("아이디를 입력하세요!")
          $("#id + .error").show();
          return false
        }else if(!check(re,id,"공백없이 4-20자")) {
        	$("#id + .error").show();
			return false
		}else {
			 $("#id + .error").hide();
		} 
       
       if(pass ==""){
    	  alert("비밀번호를 입력하세요")
          return false
       }
		   
       if(passCheck ==""){
          alert("비밀번호 확인란을 입력하세요!")
          return false
       }
	       
		if(pass != passCheck){
          alert("비밀번호가 일치하지 않습니다.")
          return false
       }
       
       if(email ==""){
          alert("이메일을 입력하세요!")
          return false
       }else if(!(check(re3,email,"정확한 이메일 양식이 아닙니다"))){
			return false
		}
       
       if(name ==""){
          alert("이름을 입력하세요!")
          return false
       }
       
       if(phone ==""){
          alert("휴대폰번호를 입력하세요!")
          return false
       }else if(!(check(re4,phone,"정확한 휴대폰번호가 아닙니다"))){
			return false; 
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
   
   function checkPass(){
      var pass = $('#pass').val(); 
       var passCheck = $('#passCheck').val(); 
       
       if(pass.length > 0 && pass.length < 8){
          $("#pass + .error").show();
          console.log("비밀번호가 8자리미만입니다")
 
       }else{
          $("#pass + .error").hide();
          if(passCheck == "" || passCheck == pass){
             $("#passCheck + .error").hide();
          }else{
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
	<div class="personalSignup_page page_shadow">
		<form method="post" action="<%= request.getContextPath() %>/join/personalSignupProcess.do" name="signUp" onsubmit="return clickBtn()">
			<div id="signupForm">
				<h3 class="signupGuide">필수 정보를 입력해주세요</h3>
	
				<div class="form-row">
					<p class="formName">아이디</p>
					<input id="id" class="inputValue insert_input" type="text" placeholder="아이디* (4~20자)" name="id">
					<p class="error">* 아이디를 입력하세요(4글자이상)</p>
				</div>
				<div class="form-row">
					<p class="formName">비밀번호</p>
					<input id="pass" class="inputValue insert_input" type="password" placeholder="비밀번호(8자리 이상)" name="pass" oninput="checkPass()">
					<p class="error">* 비밀번호를 입력하세요(8자리 이상)</p>
				</div>
				<div class="form-row">
					<p class="formName">비밀번호 재확인</p>
					<input id="passCheck" class="inputValue insert_input" type="password" placeholder="비밀번호 체크" name="passCheck" oninput="checkPass()">
					<p class="error">* 비밀번호가 일치하지않습니다</p>
				</div>
				<div class="form-row">
					<p class="formName">이메일</p>
					<input id="email" class="inputValue insert_input" type="email" placeholder="ex) momogo@momogo.com"	name="email">
					<p class="error">* 이메일을 입력하세요</p>
				</div>
				<div class="form-row">
					<p class="formName">이름</p>
					<input id="name" class="inputValue insert_input" type="text" placeholder="이름"	 name="name">
					<p class="error">* 이름을 입력하세요</p>
				</div>
				<div class="form-row">
					<p class="formName">전화번호</p>
					<input id="phone" class="inputValue insert_input" type="text" placeholder="ex) 01011112222" name="phone">
					<p class="error">* 전화번호를 입력하세요</p>
				</div>
			</div>
			<div class="joinBtn basic_btn">
				<button type="submit">가입 신청</button>
			</div>
		</form>
	</div>
   	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>