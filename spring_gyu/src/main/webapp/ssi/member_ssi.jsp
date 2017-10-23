<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

	<%
	String id_admin = (String)session.getAttribute("id");
	String grade = (String)session.getAttribute("grade");
	String nowPage = "";
	String col = "";
	String word = "";
	if(id_admin != null && grade.equals("A")){
		nowPage = request.getParameter("nowPage");
		col = request.getParameter("col");
		word = request.getParameter("word");
	}
	%>