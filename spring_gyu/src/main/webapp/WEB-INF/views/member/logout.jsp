<%@ page contentType="text/html; charset=UTF-8" %> 
<% 
request.setCharacterEncoding("utf-8"); 
session.invalidate();//모든 세션변수 제거
 
response.sendRedirect("../index.jsp");
 
%> 