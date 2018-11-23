<%@page import="kr.co.mlec.join.dao.CeoSignUpDAO"%>
<%@page import="kr.co.mlec.join.dao.PersonalDAO"%>
<%@ page contentType = "text/plain; charset=euc-kr" %>
<%@ page import = "java.util.List" %>
<%
	String id = request.getParameter("id");
	CeoSignUpDAO dao = new CeoSignUpDAO();
	int re = dao.checkId(id);
%>
<%=re%>