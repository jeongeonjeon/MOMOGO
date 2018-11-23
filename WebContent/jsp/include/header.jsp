<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header_inner">
	<div class="header_top">
		<ul class="hmenu_wrap">
			<li><c:if test="${ not empty userVO }">${ userVO.id }님</c:if></li>
			<li><c:if test="${ empty userVO }"><a href="/MOMOGO/jsp/login/loginForm.jsp">LOGIN</a></c:if></li>
			<li><c:if test="${ empty userVO }"><a href="<%= request.getContextPath()%>/join/choiceJoin.do">JOIN</a></c:if></li>
			<li><c:if test="${ not empty userVO }"><a href="<%= request.getContextPath()%>/login/logout.do">LOGOUT</a></c:if></li>
			<li><a href="#">ORDER</a></li>
			<li><a href="/MOMOGO/mypage/mypage.do">MYPAGE</a></li>
		</ul>
	</div>
	<h2 class="logo">
		<a href="/MOMOGO/index.jsp">
			<img src="/MOMOGO/img/logo.png" alt="">
		</a>
	</h2>
	<div class="header_board">
		<ul class="board_menu">
			<li><a href="#">EVENT</a></li>
			<li><a href="<%= request.getContextPath()%>/board/noticeList.do">공지사항</a></li>
		</ul>
	</div>
	
</div>
