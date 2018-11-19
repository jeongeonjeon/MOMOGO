<%@page import="kr.co.mlec.member.vo.MemberVO"%>
<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");

	MemberDAO dao = new MemberDAO();
	MemberVO member = dao.selectById(id);
	
	pageContext.setAttribute("member",member);
%>
<div class="myPage flex_add">
	<div class="page_inner">
		<section class="item_wrap">
			<div class="item area_item">
				<div class="item_header">
					<h4 class="tit">회원정보</h4>
					<button type="button"></button>
				</div>
				<p class="contxt">
					<span>'나'의 회원</span> 정보입니다.<br>회원유형과 가입일은 수정이 불가능합니다.
				</p>
				<div class="item_content basic_content on">
					<div class="info_wrap">
						<div class="info">
							<p class="tit">회원유형</p>
							<p class="txt">${ member.type }</p>
						</div>
						<div class="info">
							<p class="tit">가입날짜</p>
							<p class="txt">${ member.regDate }</p>
						</div>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="item_header">
					<h4 class="tit">프로필</h4>
					<button type="button"></button>
				</div>
				<p class="contxt">
					<span>'나'를 표현하는 프로필</span> 정보입니다.<br> 수정 화면에서 비밀번호를 변경하세요.
				</p>
				<div class="item_content basic_content on">
					<div class="pic">
						<img src="/Mission-Web/img/default.png" alt="">
					</div>
					<div class="info_wrap">
						<div class="info">
							<p class="tit">아이디</p>
							<p class="txt">${ member.id }</p>
						</div>
						<div class="info">
							<p class="tit">이름</p>
							<p class="txt">${ member.name }</p>
						</div>
						<div class="info">
							<p class="tit">비밀번호</p>
							<p class="txt">${ member.password }</p>
						</div>
					</div>
					<button class="basic_btn modify_btn" type="button">수정</button>
				</div>
				<div class="item_content modify_content">
					<div class="pic">
						<img src="/Mission-Web/img/default.png" alt="">
					</div>
					<div class="info_wrap">
						<form method="post" action="updateProfile.jsp">
							<input type="hidden" name="id" value="${ member.id }">
							<div class="info">
								<p class="tit">아이디</p>
								<p class="txt">${ member.id }</p>
							</div>
							<div class="info">
								<p class="tit">이름</p>
								<input type="text" name="name" value="${ member.name }">
							</div>
							<div class="info">
								<p class="tit">비밀번호</p>
								<input type="password" name="password"
									value="${ member.password }">
							</div>
							<div class="btn_wrap">
								<button type="reset" class="basic_btn cancel_btn">취소</button>
								<button type="submit" class="basic_btn complete_btn">완료</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="item area_item">
				<div class="item_header">
					<h4 class="tit">연락처 설정</h4>
					<button type="button"></button>
				</div>
				<p class="contxt">
					<span>'나'의 연락처</span> 정보입니다.<br> 수정 화면에서 핸드폰번호와 이메일주소를 변경하세요.
				</p>
				<div class="item_content basic_content on">
					<div class="info_wrap">
						<div class="info">
							<p class="tit">전화번호</p>
							<p class="txt">${ member.tel1 }-${ member.tel2 }-${ member.tel3 }</p>
						</div>
						<div class="info">
							<p class="tit">이메일주소</p>
							<p class="txt">${ member.emailId }@${ member.emailDomain}</p>
						</div>
					</div>
					<button class="basic_btn modify_btn" type="button">수정</button>
				</div>
				<div class="item_content modify_content">
					<div class="info_wrap">
						<form action="updateContact.jsp" method="post">
							<input type="hidden" name="id" value="${ member.id }">
							<div class="info tel">
								<p class="tit">전화번호</p>
								<select name="tel1">
									<option selected value="010">010</option>
									<option value="011">011</option>
									<option value="016">016</option>
									<option value="018">018</option>
								</select> <span>-</span> <input type="text" name="tel2"
									value="${ member.tel2 }"> <span>-</span> <input
									type="text" name="tel3" value="${ member.tel3 }">
							</div>
							<div class="info mail">
								<p class="tit">이메일주소</p>
								<input type="text" name="emailId" value="${ member.emailId }">
								<span>@</span> <input type="text" name="emailDomain"
									value="${ member.emailDomain }">
							</div>
							<div class="btn_wrap">
								<button type="reset" class="basic_btn cancel_btn">취소</button>
								<button type="submit" class="basic_btn complete_btn">완료</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="item area_item">
				<div class="item_header">
					<h4 class="tit">지역설정</h4>
					<button type="button"></button>
				</div>
				<p class="contxt">
					<span>'나'의 주소지</span> 정보입니다.<br> 수정 화면에서 주소와 우편번호를 변경하세요.
				</p>
				<div class="item_content basic_content on">
					<div class="info_wrap">
						<div class="info">
							<p class="tit">우편번호</p>
							<p class="txt">${ member.post }</p>
						</div>
						<div class="info">
							<p class="tit">기본주소</p>
							<p class="txt">${ member.basicAddr }</p>
						</div>
						<div class="info">
							<p class="tit">상세주소</p>
							<p class="txt">${ member.detailAddr }</p>
						</div>
					</div>
					<button class="basic_btn modify_btn" type="button">수정</button>
				</div>
				<div class="item_content modify_content">
					<div class="info_wrap">
						<form method="post" action="updateArea.jsp">
							<input type="hidden" name="id" value="${ member.id }">
							<div class="info">
								<p class="tit">우편번호</p>
								<input type="text" name="post" value="${ member.post }">
							</div>
							<div class="info">
								<p class="tit">기본주소</p>
								<input type="text" name="basicAddr"
									value="${ member.basicAddr }">
							</div>
							<div class="info">
								<p class="tit">상세주소</p>
								<input type="text" name="detailAddr"
									value="${ member.detailAddr }">
							</div>
							<div class="btn_wrap">
								<button type="reset" class="basic_btn cancel_btn">취소</button>
								<button type="submit" class="basic_btn complete_btn">완료</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>
		<a class="basic_btn list_btn" href="allMember.jsp">목록</a>
	</div>
</div>