<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("공지사항이 수정되었습니다");
	location.href = "<%= request.getContextPath()%>/board/eventList.do"
</script>