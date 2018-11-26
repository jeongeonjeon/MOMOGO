<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="header_top">
	<div class="mLogo">
		<a href="<%= request.getContextPath()%>/index.jsp" alt="">
			<img src="/MOMOGO/img/logo.png" alt="">
		</a>
	</div>
	<button class="menu_bar"></button>
</div>
<div class="header_bottom">
	<ul class="mHmenu_wrap">
		<li><c:if test="${ not empty userVO }">${ userVO.id }님</c:if></li>
		<li><c:if test="${ empty userVO }"><a href="<%= request.getContextPath()%>/login/loginForm.do">LOGIN</a></c:if></li>
		<li><c:if test="${ empty userVO }"><a href="<%= request.getContextPath()%>/join/choiceJoin.do">JOIN</a></c:if></li>
		<li><c:if test="${ not empty userVO }"><a href="<%= request.getContextPath()%>/login/logout.do">LOGOUT</a></c:if></li>
		<li><a href="#">ORDER</a></li>
		<li><c:choose>
			<c:when test="${ not empty personalVO }"><a href="<%= request.getContextPath()%>/mypage/personalMypage.do">MYPAGE</a></c:when>
			<c:when test="${ not empty ceoVO }"><a href="<%= request.getContextPath()%>/mypage/ceoMypage.do">MYPAGE</a></c:when>
			<c:otherwise><a href="<%= request.getContextPath()%>/login/loginForm.do">MYPAGE</a></c:otherwise>
			</c:choose>		
		</li>
		<li><a href="<%= request.getContextPath()%>/index.jsp#section03">주문하기</a></li>
		<li><a href="<%= request.getContextPath()%>/board/eventList.do">EVENT</a></li>
		<li><a href="<%= request.getContextPath()%>/board/noticeList.do">공지사항</a></li>
	</ul>
</div>