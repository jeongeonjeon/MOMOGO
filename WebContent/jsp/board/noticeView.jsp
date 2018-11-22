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
	<div id="wrapper">
		<header>
			<%@include file ="/jsp/include/header.jsp"%>
		</header>
		<div class="noticeView_page page_shadow">
			<div class="page_inner">
				<div class="bbs_page_tit">공지사항</div>
				<div class="bbs_write">
					<div class="content">
						<div class="tit">제목</div>
						<div class="txt">${notice.title}</div>
					</div>
					<div class="content">
						<div class="half">
							<div class="tit">작성자</div>
							<div class="txt">${notice.writer}</div>
						</div>
						<div class="half">
							<div class="tit">작성일</div>
							<div class="txt">${notice.regDate}</div>
						</div>
					</div>
					<div class="text_area">${notice.content}</div>
				</div>
				<div class="bbs_btn_wrap">
					<a href="<%= request.getContextPath() %>/board/noticeDeleteProcess.do?noticeNo=${notice.noticeNo}" id="modify">
						<div class="bbs_btn cancel" id="delete">삭제</div>
					</a>
					<a href="<%= request.getContextPath() %>/board/noticeUpdate.do?noticeNo=${notice.noticeNo}" id="modify">
						<div class="bbs_btn registration">수정</div>
					</a>
				</div>
			</div>	
		</div>
		<footer>
			<%@include file ="/jsp/include/footer.jsp" %>
		</footer>
	</div>
</body>
</html>