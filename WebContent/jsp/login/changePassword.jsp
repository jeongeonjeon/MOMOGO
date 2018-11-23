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
	function checkForm(){
		
		var id = $('#id');
		var pw = $('#pw');
		var pwCheck = $('#pwcheck');
		
		if (id.val() == "") {
			alert("아이디를 입력하세요!")
			return false
		}
		if (pw.val() == ""){
			alert("비밀번호를 입력하세요!")
			return false
		}
		if (pwCheck.val() == "") {
			alert("비밀번호 확인란을 입력하세요!");
			return false			
		}
		if (pw.val() != pwcheck.val()) {
			alert("변경할 비밀번호가 일치하지 않습니다.");
			return false
		}
		return true
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
                <h3 class="tit">비밀번호 변경</h3>
            </div>
            <form action="<%= request.getContextPath() %>/login/changePasswordProcess.do" name="changePwForm" id="changePwForm" method="post" onsubmit="return checkForm()">
                <div class="fieldset">
                	<div class="user-select">
						<input type="radio" name="userSelect" value="personal" checked="checked">개인
						<input type="radio" name="userSelect" value="ceo">사업자<br>	
					</div>	
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="id" placeholder="아이디" value="" name="id" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input insert_input" id="pw" placeholder="변경할 비밀번호" name="password" value="" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input insert_input" id="pwcheck" placeholder="비밀번호 체크" name="passwordCheck" value="" />                        
                    </div>                
                    <input type="submit" class="btn-login" value="비밀번호 변경">
                </div>
            </form>
        </div>
    </div>
	<footer>
			<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>