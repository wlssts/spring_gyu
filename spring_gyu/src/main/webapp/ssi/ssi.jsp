<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="util" uri="/ELFunctions"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

	<%
	String id_admin = (String)session.getAttribute("id");
	String grade = (String)session.getAttribute("grade");
	String passwd = (String)session.getAttribute("passwd");
	String nowPage = "";
	String col = "";
	String word = "";
	if(id_admin != null && grade.equals("A")){
		nowPage = request.getParameter("nowPage");
		col = request.getParameter("col");
		word = request.getParameter("word");
	}
	%>