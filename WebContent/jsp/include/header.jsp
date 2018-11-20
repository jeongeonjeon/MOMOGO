<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="header_inner">
	<div class="header_top">
		<ul class="hmenu_wrap">
			<li><a href="/MOMOGO/jsp/login/loginForm.jsp">LOGIN</a></li>
			<li><a href="/MOMOGO/jsp/join/choiceJoin.jsp">JOIN</a></li>
			<li><a href="#">ORDER</a></li>
			<li><a href="#">MYPAGE</a></li>
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
			<li><a href="<%= request.getContextPath() %>/board/notice.do">공지사항</a></li>
		</ul>
	</div>
	
</div>
