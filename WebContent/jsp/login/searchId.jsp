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
		var f = document.searchId;
		
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
    <div class="login_page page_shadow" align="center">
        <div class="cont-inner login-wrap">
            <div class="tit-area">
                <h3 class="tit">아이디 찾기</h3>
            </div>
            <form action="<%= request.getContextPath() %>/login/searchIdProcess.do" name="searchId" id="searchId" method="post" onsubmit="return checkForm()">
                <div class="fieldset">
                	<div class="user-select">
						<input type="radio" id="per" name="userSelect" value="personal" checked="checked">
						<label for="per">개인</label>
						<input id="ceo" type="radio" name="userSelect" value="ceo">	
						<label for="ceo">사업자</label>
					</div>	
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="name" placeholder="이름" name="name" value="" />                        
                    </div>
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="phone" placeholder="휴대전화" name="phone" value="" />                         
                    </div>    
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="email" placeholder="이메일주소" name="email" value="" />                        
                    </div>
                    <input type="submit" class="btn-login basic_btn" value="확인">
                </div>
            </form>
        </div>
    </div>
	<footer>
			<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>




