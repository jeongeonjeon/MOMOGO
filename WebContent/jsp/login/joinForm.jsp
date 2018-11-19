<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="joinForm_page flex_add">
	<div class="page_inner">
		<section class="section01">
			<h2 class="blind"></h2>
			<form method="post" action="/Mission-Web/jsp/member/join.jsp" name="joinForm" onsubmit="return checkForm()">
				<div class="input_wrap">
					<p>아이디</p>
					<input type="text" name="id">						
				</div>
				<div class="input_wrap">
					<p>이름</p>
						<input type="text" name="name">
				</div>
				<div class="input_wrap password_box">
					<p>비밀번호</p>
					<input type="password" name="password">
					<img src="/Mission-Web/img/m_icon_pass.png" alt="">
				</div>
				<div class="input_wrap email_wrap">
					<p>이메일</p>
					<input type="text" name="email_id">
					<span>@</span>			
					<input type="text" name="email_domain">
				</div>
				<div class="input_wrap tel_wrap">
					<p>전화번호</p>
					<input type="text" name="tel1">
					<input type="text" name="tel2">
					<input type="text" name="tel3">
				</div>
				<div class="input_wrap">
					<p>우편번호</p>
					<input type="text" name="post">			
				</div>
				<div class="input_wrap">
					<p>기본주소</p>
					<input type="text" name="basic_addr">	
				</div>
				<div class="input_wrap">
					<p>상세주소</p>
					<input type="text" name="detail_addr">			
				</div>
				<div class="input_wrap">
					<p>회원유형</p>
					<select name="type">
						<option selected value="U">일반회원</option>
						<option value="A">관리자</option>
					</select>
				</div>
				<button class="basic_btn joinForm_btn" type="submit">가입하기</button>
			</form>
		</section>
	</div>
</div>