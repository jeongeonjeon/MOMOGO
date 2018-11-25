<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>Insert title here</title>
<jsp:include page="/jsp/include/head.jsp" />
<link rel="stylesheet" href="/MOMOGO/css/login.css">
<script>
	
	function checkForm() {
		var f = document.leaveForm;
		
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
	<header>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
    <div class="login_page page_shadow" align="center">
        <div class="cont-inner login-wrap">
            <div class="tit-area">
                <h3 class="tit">회원탈퇴</h3>
            </div>
            <form action="<%= request.getContextPath() %>/login/leaveMemberProcess.do" name="leaveForm" id="leaveForm" method="post" onsubmit="return checkForm()">
                <div class="fieldset">
                	<div class="user-select">
						<input type="radio" name="userSelect" value="personal" checked="checked">
						<label for="per">개인</label>
						<input type="radio" name="userSelect" value="ceo">	
						<label for="ceo">사업자</label>	
					</div>	
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="id" placeholder="아이디" value="" name="id" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input insert_input" id="pw" placeholder="비밀번호" name="password" value="" />                        
                    </div>                
                    <input type="submit" class="basic_btn" value="회원 탈퇴">
                </div>
            </form>
        </div>
    </div>
	<footer>
			<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>