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
	<div id="storeList_page">
		<div class="page_inner">
			<c:set var="categories"
				value="치킨,중국집,피자,족발/보쌈,야식,찜/탕,한식/분식/죽,돈까스/회/일식,패스트푸드" />
			<c:set var="category" value="${fn:split(categories, ',')}" />
			<c:set var="i" value="0" />
			<ul class="itemList_wrap">
				<c:forEach items="${ category }" var="c">
					<c:set var="i" value="${i+1}" />
					<li class="itemList0${ i }">
						<div class="item_cover"></div> <a href="#"></a>
						<div class="line">
							<div class="txt_box">
								<a href="">더보기</a>
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
</body>
</html>