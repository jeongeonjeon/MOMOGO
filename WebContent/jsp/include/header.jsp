<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header_inner">
	<div class="header_top">
		<ul class="hmenu_wrap">
			<li><c:if test="${ not empty userVO }">${ userVO.id }님</c:if></li>
			<li><c:if test="${ empty userVO }"><a href="<%= request.getContextPath()%>/login/loginForm.do">LOGIN</a></c:if></li>
			<li><c:if test="${ empty userVO }"><a href="<%= request.getContextPath()%>/join/choiceJoin.do">JOIN</a></c:if></li>
			<li><c:if test="${ not empty userVO }"><a href="<%= request.getContextPath()%>/login/logout.do">LOGOUT</a></c:if></li>
			<li>
				<c:choose>
					<c:when test="${ not empty userVO }"><a href="<%= request.getContextPath()%>"></a>
						<c:choose>
						<c:when test="${ not empty ceoVO }"><a href="<%= request.getContextPath()%>/mypage/ceoMypage.do">MYPAGE</a></c:when>
						<c:when test="${ not empty personalVO }"><a href="<%= request.getContextPath()%>/mypage/personalMypage.do">MYPAGE</a></c:when>
						</c:choose>		
					</c:when>
					<c:otherwise><a href="<%= request.getContextPath()%>/login/loginForm.do">MYPAGE</a></c:otherwise>
				</c:choose>
			</li>
		</ul>
	</div>
	<div class="header_bottom">
		<h2 class="logo">
			<a href="/MOMOGO/index.jsp">
				<img src="/MOMOGO/img/logo.png" alt="">
			</a>
		</h2>
		<ul class="board_menu">
			<li><a href="<%= request.getContextPath()%>/index.jsp#section03">주문하기</a></li>
			<li><a href="<%= request.getContextPath()%>/board/eventList.do">EVENT</a></li>
			<li><a href="<%= request.getContextPath()%>/board/noticeList.do">공지사항</a></li>
		</ul>
	</div>
	
</div>
