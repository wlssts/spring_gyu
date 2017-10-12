<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

 	<c:if test="${not empty sessionScope.id && sessionScope.grade == 'A' }">
 		
 		<c:set var="col" value="${param.col }"/>
 		<c:set var="word" value="${param.word }"/>
 		<c:set var="nowPage" value="${param.nowPage }"/>
 	
 	</c:if>
<!--  	String id_admin = (String)session.getAttribute("id");
	String grade = (String)session.getAttrib
	ute("grade");
	String nowPage = "";
	String col = "";
	String word = "";
	if(id_admin! = null && grade.equals("A")){
		nowPage = request.getParameter("nowPage");
		col = request.getParameter("col");
		word = request.getParameter("word");
	} -->