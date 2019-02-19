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
				<div class="bbs_wrap" id="noticeTable">
					<div class="bbs">
						<div class="tit num">번호</div>			
						<div class="tit title">제목</div>			
						<div class="tit name">글쓴이</div>			
						<div class="tit date">등록일</div>			
						<div class="tit views">조회수</div>			
					</div>
					<div class="bbs not_txt"> 
						<c:forEach items="${ requestScope.list }" var="notice">
							<div class="txt num">${ notice.noticeNo }</div>
							<div class="txt title">
								<a href="<%= request.getContextPath() %>/board/noticeView.do?noticeNo=${notice.noticeNo}"><c:out value="${ notice.title }" /></a>
							</div>
							<div class="txt name">${ notice.writer }</div>
							<div class="txt date">${ notice.regDate }</div>
							<div class="txt views">${ notice.viewCnt }</div>
						</c:forEach>
					</div>
				</div>
				
				
				
<%-- 			<div class="paging_wrap">
					<c:forEach begin="1" end="5" var= "page">
						<span class="inner">
							<a href="noticeList.do?page=${ page }"> ${ page } </a>
						</span>
					</c:forEach>
				</div> 
--%>
				<div class="paging_wrap">
					<%-- 처음 페이지 설정 --%>
					<c:choose>
						<c:when test="${pageNo == 1}" >
							<img alt="처음" src="<%= request.getContextPath() %>/img/startBtn.png" align="middle" width="14px">
						</c:when>
						<c:otherwise>
							<a href="noticeList.do?pageNo=1">
								<img alt="처음" src="<%= request.getContextPath() %>/img/startBtn.png" align="middle" width="14px">
							</a>
						</c:otherwise>
					</c:choose>
					
					<%-- 이전 페이지 설정 --%>
					<c:choose>
						<c:when test="${beginPage == 1}" >
							<img alt="이전" src="<%= request.getContextPath() %>/img/preBtn.png" align="middle" width="14px">
						</c:when>
						<c:otherwise>
							<a href="noticeList.do?pageNo=${beginPage - 1}">
								<img alt="이전" src="<%= request.getContextPath() %>/img/preBtn.png" align="middle" width="14px">
							</a>
						</c:otherwise>
					</c:choose>
					
					<%-- 페이지 번호 설정 --%>			
					<c:forEach var="i" begin="${beginPage}" end="${endPage}">
						<c:if test="${i eq pageNo}">
							<strong>[${i}]</strong>
						</c:if>
						<c:if test="${i ne pageNo}">
							<a href="noticeList.do?pageNo=${i}">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<%-- 다음 페이지 설정 --%>
					<c:choose>
						<c:when test="${endPage == lastPage}" >
							<img alt="다음" src="<%= request.getContextPath() %>/img/nextBtn.png" align="middle" width="14px">
						</c:when>
						<c:otherwise>
							<a href="noticeList.do?pageNo=${endPage + 1}">
								<img alt="다음" src="<%= request.getContextPath() %>/img/nextBtn.png" align="middle" width="14px">
							</a>
						</c:otherwise>
					</c:choose>
					
					<%-- 마지막 페이지 설정 --%>
					<c:choose>
						<c:when test="${pageNo == lastPage}" >
							<img alt="끝" src="<%= request.getContextPath() %>/img/endBtn.png" align="middle" width="14px">
						</c:when>
						<c:otherwise>
							<a href="noticeList.do?pageNo=${lastPage}">
								<img alt="끝" src="<%= request.getContextPath() %>/img/endBtn.png" align="middle" width="14px" top="5px">
							</a>
						</c:otherwise>
					</c:choose>
				</div>
				
				
				
				<c:if test="${ userVO.type.equals('S') }"><a href="<%= request.getContextPath()%>/board/noticeForm.do"><button class="basic_btn notice_btn">공지등록</button></a></c:if>

			</div>
		</div>
		<footer>
			<%@include file="/jsp/include/footer.jsp"%>
		</footer>
	</div>
</body>
</html>