<%@page import="kr.co.mlec.join.dao.PersonalDAO"%>
<%@ page contentType = "text/plain; charset=euc-kr" %>
<%@ page import = "java.util.List" %>
<%
	String id = request.getParameter("id");
	PersonalDAO dao = new PersonalDAO();
	int re = dao.checkId(id);
%>
<%=re%>