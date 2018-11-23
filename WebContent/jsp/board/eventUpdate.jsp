<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
<script>

	function checkForm() {
		var title = $('#title').val();
		var content = $('#content').val();		
		
		if (title == ""){
			alert("제목을 입력해주세요!");
			return false
		}
		if (content == ""){
			alert("내용을 입력해주세요!");
			return false
		}
		return true
	}
	
</script>
</head>
<body>
	<header>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
	<div class="noticeForm_page">
		<div class="page_inner">
			<div class="bbs_page_tit">공지사항</div>
			<form method="post" action="<%= request.getContextPath() %>/board/noticeUpdateProcess.do?noticeNo=${ notice.noticeNo }"
				name="nform" onsubmit="return checkForm()">
			<input type="hidden" name="writer" size="50" value="${ id }">
			<div class="bbs_write">
				<div class="content">
					<div class="tit">제목</div>
					<input type="text" placeholder="제목을 입력해주세요" name="title" id="title" value="${ notice.title }">
				</div>
				<div class="content">
					<div class="half">
						<div class="tit">작성자</div>
						<div class="txt">${ id }</div>
					</div>
<!-- 					<div class="half">
						<div class="tit">작성일</div>
						<div class="txt">2017.10.26</div>
					</div> -->
				</div>
				<textarea placeholder="내용을 입력해주세요." name="content" id="content">${ notice.content }</textarea>
			</div>
			<div class="bbs_btn_wrap">
				<a href="noticeList.jsp">
					<div class="bbs_btn cancel" id="cancel">취소</div>
				</a>
				<!-- <a href="noticeView.jsp"> -->
					<!-- <div class="bbs_btn registration" id="registration"> --><button type="submit">등록</button><!-- </div> -->
				<!-- </a> -->
			</div>
			</form>
		</div>
	</div>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>