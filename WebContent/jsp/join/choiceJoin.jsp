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
				<div class="block block1">
					<div class="type_wrap">
						<strong>개인</strong>
						<a class="basic_btn" href="<%= request.getContextPath()%>/join/personalSignup.do">개인 회원가입 </a>
					</div>
				</div>
				<div class="block block2">
					<div class="type_wrap">
						<strong>사업자</strong>
						<a class="basic_btn" href="<%= request.getContextPath()%>/join/ceoSignup.do">사업자 회원가입 </a>
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