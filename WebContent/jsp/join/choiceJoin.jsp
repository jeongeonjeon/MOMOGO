<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
</head>
<body>
	<div id="wrapper">
		<header>
			<%-- <jsp:include page="/include/header.jsp"> --%>
			<%@include file="/jsp/include/header.jsp"%>
		</header>
		<div id="choice" class="page_shadow">
			<div class="container">
				<h1>회원가입</h1>
				<div class="block1">
					<strong>개인</strong>
					<div class="joinBtn">
						<a href="/MOMOGO/jsp/join/personalSignup.jsp">개인 회원가입 </a>
					</div>
				</div>
				<div class="block2">
					<strong>사업자</strong>
					<div class="joinBtn">
						<a href="/MOMOGO/jsp/join/ceoSignup.jsp">사업자 회원가입 </a>
					</div>
				</div>
			</div>
		</div>
		<footer>
			<%@include file="/jsp/include/footer.jsp"%>
		</footer>
	</div>
</body>
</html>