<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/ssi/member_ssi.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<div align="center">

	<form action="login" method="POST">
	<table>
		<tr>
			<td colspan="2"><h2>로그인</h2></td>
		</tr>
		<TR>
			<TH>아이디</TH>
			<TD>
			<input type="text" name="id" value='${c_id_val}'>
				<c:choose>
					<c:when test="${c_id == 'Y' }">
						<input type='checkbox' name='c_id' value='Y' checked='checked'> ID 저장 
	      			</c:when>
					<c:otherwise>
						<input type='checkbox' name='c_id' value='Y'> ID 저장 
	      			</c:otherwise>
				</c:choose>
			</TD>
			</TR>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="passwd"></td>
		</tr>
	</table>
	
	<div>
		<input type='submit' value='로그인'>
		<input type='button' value='취소' onclick="history.back()">
		<input type='button' value='회원가입' onclick="location.href='agreement'">
	</div>
	</form>

</div>
</body>
</html>