<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/jsp/include/head.jsp" />
</head>
<body>
	<header>
		<%-- <jsp:include page="/include/header.jsp"> --%>
		<%@include file="/jsp/include/header.jsp"%>
	</header>
	<div id="storeList_page" class="page_shadow">
		<div class="page_inner">
			<c:set var="categories"
				value="치킨,중국집,피자,족발/보쌈,야식" />
			<c:set var="category" value="${fn:split(categories, ',')}" />
			<c:set var="i" value="0" />
			<ul class="itemList_wrap">
				<c:forEach items="${ category }" var="c">
					<c:set var="i" value="${i+1}" />
					<li class="itemList0${ i }">
						<div class="item_cover"></div> <a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<button type="submit" class="moreBtn">더보기</button>
							</div>
							<div class="heading">
								<h4>${ c }</h4>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<footer>
		<%@include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>