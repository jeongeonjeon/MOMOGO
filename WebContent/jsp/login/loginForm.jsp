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
		var f = document.loginform;
		
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
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
</head>
<body>
	<header>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
    <div class="login_page page_shadow" align="center">
        <div class="cont-inner login-wrap">
            <div class="tit-area">
                <h3 class="tit">로그인</h3>
            </div>
            <form action="<%= request.getContextPath() %>/login/loginFormProcess.do" name="loginform" id="loginForm" method="post" onsubmit="return checkForm()">
                <div class="fieldset">
                	<div class="user-select">
						<input type="radio" id="per" name="userSelect" value="personal" checked="checked">
						<label for="per">개인</label>
						<input id="ceo" type="radio" name="userSelect" value="ceo">	
						<label for="ceo">사업자</label>
					</div>	
                    <div class="input-group">
                        <input type="text" class="input insert_input" id="id" placeholder="아이디" value="" name="id" />                        
                    </div>
                    <div class="input-group">
                        <input type="password" class="input insert_input" id="pw" placeholder="비밀번호" name="password" value="" />                        
                    </div>                
                    <div class="login-link">
                        <a class="btn-find" href="<%= request.getContextPath() %>/login/searchId.do">아이디 찾기</a>&nbsp;&#47;
                        <a class="btn-find" href="<%= request.getContextPath() %>/login/searchPassword.do">비밀번호 찾기</a><br><br>
                        <a class="btn-join" href="<%= request.getContextPath() %>/join/choiceJoin.do">회원가입</a>&nbsp;&#47;
                        <a class="btn-join" href="<%= request.getContextPath() %>/join/choiceJoin.do">회원탈퇴</a><br>
                    </div>
                    <input type="submit" class="btn-login basic_btn" value="로그인">
                </div>
            </form>
			<a id="kakao-login-btn"></a>
			<p>카카오로그인은 개인회원만 가능합니다.</p>
			<script type='text/javascript'>
			  //<![CDATA[
			    // 사용할 앱의 JavaScript 키를 설정해 주세요.
			    Kakao.init('1fe41c09db40fafd2cb9304b55b471f7');
			    // 카카오 로그인 버튼을 생성합니다.
			    Kakao.Auth.createLoginButton({
			      container: '#kakao-login-btn',
			      success: function(authObj) {
			        // 로그인 성공시, API를 호출합니다.
			        Kakao.API.request({
			          url: '/v2/user/me',
			          success: function(res) {
	                      console.log(JSON.stringify(res));
	                      console.log(res.id);
	                      console.log(res.properties.nickname);
	                      location.href = "<%=request.getContextPath()%>/login/kakaologin.do?id="+res.id+"&nickname="+res.properties.nickname;
			          },
			          fail: function(error) {
			            alert(JSON.stringify(error));
			          }
			        });
			      },
			      fail: function(err) {
			        alert(JSON.stringify(err));
			      }
			    });
			  //]]>
			</script>
        </div>
    </div>
	<footer>
			<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>




