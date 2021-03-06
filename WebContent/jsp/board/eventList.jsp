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
<%-- 			<jsp:include page="/include/header.jsp"> --%>
			<%@include file="/jsp/include/header.jsp"%>
		</header>
		<div class="noticeList_page page_shadow">
			<div class="page_inner">
				<h3 class="bbs_page_tit">공지사항</h3>
				<c:if test="${ userVO.type.equals('S') }"><a href="<%= request.getContextPath()%>/board/eventForm.do"><button class="basic_btn notice_btn">공지등록</button></a></c:if>
				<div class="bbs_wrap" id="eventTable">
					<div class="bbs">
						<div class="tit num">번호</div>			
						<div class="tit title">제목</div>			
						<div class="tit name">글쓴이</div>			
						<div class="tit date">등록일</div>			
						<div class="tit views">조회수</div>			
					</div>
					<div class="bbs not_txt"> 
						<c:forEach items="${ requestScope.list }" var="event">
							<div class="txt num">${ event.noticeNo }</div>
							<div class="txt title">
								<a href="<%= request.getContextPath() %>/board/eventView.do?noticeNo=${event.noticeNo}"><c:out value="${ event.title }" /></a>
							</div>
							<div class="txt name">${ event.writer }</div>
							<div class="txt date">${ event.regDate }</div>
							<div class="txt views">${ event.viewCnt }</div>
						</c:forEach>
					</div>
				</div>
				<div>
					<c:forEach begin="1" end="5" var= "page">
						<span class="inner">
							<a href="eventList.do?page=${ page }"> ${ page } </a>
						</span>
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