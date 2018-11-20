<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
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
		<div class="notice_wrap page_shadow">
			
			<h3>공지사항</h3>
			<div id="noticeTable">
				<div class="thead">
					<div>번호</div>			
					<div class="title">제목</div>			
					<div>글쓴이</div>			
					<div>등록일</div>			
					<div>조회수</div>			
				</div>
				<div class="tbody"> 
					<c:forEach items="${ requestScope.list }" var="notice">
						<div>${ notice.noticeNo }</div>
						<div class="title">
							<a href=""><c:out value="${ notice.title }" /></a>
						</div>
						<div>${ notice.writer }</div>
						<div>${ notice.regDate }</div>
						<div>${ notice.viewCnt }</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<footer>
			<%@include file="/jsp/include/footer.jsp"%>
		</footer>
	</div>
</body>
</html>