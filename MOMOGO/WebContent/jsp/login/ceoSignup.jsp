<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="signUp">
		<h3 class="signupGuide">신청인 정보를 입력해주세요</h3>
		<div class="">
			<p class="formName">아이디</p>
			<div class ="formRow">
				<input class="input" type="text" name="id" placeholder="공백없이 4-20자">
			</div>
		</div>
		<div class ="formRow">
			<input class="input" type="password" name="pw" placeholder="영문+숫자,8-20자">
		</div>
		<div class ="formRow">
			<input class="input" type="password" name="pwCheck">
		</div>
		<div class ="formRow">
			<input class="input" type="text" name="email">
		</div>
		<div class ="formRow">
			<input class="input" type="text" name="name">
		</div>
		<div class ="formRow">
			<input class="input" type="text" name="phone">
		</div>
		<h3 class="signupGuide">업소 정보를 입력해주세요</h3>
		<div class ="formRow">
			<input class="input" type="text" name="BizNo">
		</div>


	</form>

</body>
</html>