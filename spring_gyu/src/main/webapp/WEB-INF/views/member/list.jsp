<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/ssi/member_ssi.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
<script type="text/javascript">
function read(id){
	var url = "read";
	url += "?id=" + id;
	url += "&col=${col}";
	url += "&word=${word}";
	url += "&nowPage=${nowPage}";

		location.href = url;
}
</script>
</head>
<body>
	<DIV class="title">회원목록</DIV>
	<div class="search" style="text-align: center;">
		<FORM name='frm' method='POST' action='list'>
			<select name="col">
				<option value="name"
					<c:out value="${col eq 'name' ? 'selected' : '' }" />>성명</option>
				<option value="id"
					<c:out value="${col eq 'id' ? 'selected' : '' }" />>아이디</option>
				<option value="total">전체출력</option>
			</select> <input type="text" name="word" value='${word }'> <input
				type="submit" value="검색"> <input type="button" value="회원가입"
				onclick="location.href='${root}/member/agreement'">
		</FORM>
	</div>
	<TABLE>
		<c:forEach var="dto" items="${list}">
			<TR>
				<tH width="20%">아이디</tH>
				<TD width="50%"><a href="javascript:read('${dto.id}')">
						${dto.id}</a></TD>
			</TR>
			<TR>
				<TH>성명</TH>
				<TD>${dto.name}</TD>
			</TR>
			<TR>
				<TH>전화번호</TH>
				<TD>${dto.phone}</TD>
			</TR>
		</c:forEach>
	</TABLE>

	<DIV class='bottom'>${paging}</DIV>


</body>
</body>
</html>