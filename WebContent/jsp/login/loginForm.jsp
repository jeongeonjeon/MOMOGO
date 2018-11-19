<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MOMOGO/css/style.css">
<script>
	
	function checkForm() {
		var f = document.loginform;
		
		if(f.userSelect.value == "") {
			alert("이용자를 선택해주세요");
			return false;
		}
		
		if(f.id.value == "") {
			alert("아이디를 입력하세요");
			return false;
		}
		
		if(f.password.value == "") {
			alert("패스워드를 입력하세요");
			return false;
		}
		
		return true;
	}
	
</script>
<script>
</script>
</head>
<body>
    <div class="content" align="center">
        <div class="cont-inner login-wrap">
            <div class="tit-area">
                <h3 class="tit">로그인</h3>
            </div>
            <form action="" name="loginform" id="loginForm" method="post" onsubmit="checkForm()">
                <div class="fieldset">
                	<div class="user-select">
						<input type="radio" name="userSelect" value="user">일반 이용자님
						<input type="radio" name="userSelect" value="ceo">사장님 이용자님<br>	
					</div>	
                    <div class="input-group">
                        <input type="text" class="input" id="id" placeholder="아이디" value="" name="id" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input" id="pw" placeholder="비밀번호" name="password" value="" />                        
                    </div>
                    <input type="hidden" id="redirectUrl" name="redirectUrl" value="https://ceo.baemin.com/" />                 
                        <div class="login-link">
                            <a class="btn-find" href="">아이디</a>&nbsp;&#47;
                            <a class="btn-find" href="">비밀번호 찾기</a>
                            <a class="btn-join" href="">회원가입</a><br>
                        </div>
                    <input type="submit" class="btn-login" value="로그인">
                </div>
            </form>
        </div>
    </div>
</body>
</html>



