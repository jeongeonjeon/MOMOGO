<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/jsp/include/head.jsp" />
<link rel="stylesheet" href="/MOMOGO/css/login.css">
<script>
	
	function checkForm() {
		var f = document.loginform;
		
		if(f.name.value == "") {
			alert("이름을 입력하세요");
			return false;
		}
		
		if(f.phone.value == "") {
			alert("휴대전화번호를 입력하세요");
			return false;
		}
		
		if(f.email.value == "") {
			alert("이메일주소를 입력하세요");
			return false;
		}
		
		return true;
	}
	
</script>
<script>
</script>
</head>
<body>
	<header>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
    <div class="content page_shadow" align="center">
        <div class="cont-inner login-wrap">
            <div class="tit-area">
                <h3 class="tit">아이디 찾기</h3>
            </div>
            <form action="<%= request.getContextPath() %>/login/loginProcess.do" name="loginform" id="loginForm" method="post" onsubmit="return checkForm()">
                <div class="fieldset">
                	<div class="user-select">
						<input type="radio" name="userSelect" value="personal" checked="checked">개인
						<input type="radio" name="userSelect" value="ceo">사업자<br>	
					</div>	
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="name" placeholder="이름" name="name" value="" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input insert_input" id="phone" placeholder="휴대전화" name="phone" value="" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input insert_input" id="email" placeholder="이메일주소" name="email" value="" />                        
                    </div>                 
                    <input type="submit" class="btn-login" value="확인">
                </div>
            </form>
        </div>
    </div>
	<footer>
			<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>




