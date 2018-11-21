<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
<script>

</script>
</head>
<body>
<!-- 	<header> -->
<%-- 		<%@include file ="/jsp/include/header.jsp"%> --%>
<!-- 	</header> -->
	<div class="noticeView_page">
		<div class="page_inner">
			<div class="bbs_page_tit">공지사항</div>
			<div class="bbs_write">
				<div class="content">
					<div class="tit">제목</div>
					<div class="txt">${board.title}</div>
				</div>
				<div class="content">
					<div class="half">
						<div class="tit">작성자</div>
						<div class="txt">${board.writer}</div>
					</div>
					<div class="half">
						<div class="tit">작성일</div>
						<div class="txt">${board.regDate}</div>
					</div>
				</div>
				<div class="text_area">${board.content}</div>
			</div>
			<div class="bbs_btn_wrap">
				<div class="bbs_btn cancel" id="delete">
					삭제</div>
				<a href="noticeForm.jsp" id="modify">
					<div class="bbs_btn registration">수정</div>
				</a>
			</div>
		</div>	
	</div>
	<footer>
		<%@include file ="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>