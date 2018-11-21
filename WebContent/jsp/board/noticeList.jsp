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
<%-- 	
		<header>
			<jsp:include page="/include/header.jsp">
			<%@include file="/jsp/include/header.jsp"%>
		</header>
 --%>		
		<div class="noticeList_page">
			<div class="page_inner">
				<h3 class="bbs_page_tit">공지사항</h3>
				<div class="bbs_wrap" id="noticeTable">
					<div class="bbs">
						<div class="tit num">번호</div>			
						<div class="tit title">제목</div>			
						<div class="tit name">글쓴이</div>			
						<div class="tit date">등록일</div>			
						<div class="tit views">조회수</div>			
					</div>
					<div class="bbs"> 
						<c:forEach items="${ requestScope.list }" var="notice">
							<div class="txt num">${ notice.noticeNo }</div>
							<div class="txt title">
								<a href=""><c:out value="${ notice.title }" /></a>
							</div>
							<div class="txt name">${ notice.writer }</div>
							<div class="txt date">${ notice.regDate }</div>
							<div class="txt views">${ notice.viewCnt }</div>
						</c:forEach>
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