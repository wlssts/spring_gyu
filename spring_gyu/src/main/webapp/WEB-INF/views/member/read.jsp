<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/ssi/ssi.jsp"%>
<c:if test="${empty nowPage || nowPage == 'null' }">
	<c:set var="nowPage" value="1" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
<title></title>
<script type="text/javascript">
	function mlist() {
		var url = "./list";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";

		location.href = url;
	}
	function mdelete() {
		var url = "./delete";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		url += "&oldFile=${dto.fname}";
		url += "&id=${dto.id}";

		location.href = url;
	}
	function update() {
		var url = "./update";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		url += "&id=${dto.id}";

		location.href = url;
	}
	function updatePw() {
		var url = "./updatePwForm";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";
		url += "&id=${dto.id}";

		location.href = url;
	}
</script>
</head>
<!-- *********************************************** -->
<body>

	<DIV>${dto.name}의회원정보</DIV>


	<TABLE>
		<TR>
			<TH>아이디</TH>
			<TD>${dto.id}</TD>
		</TR>
		<TR>
			<TH>성명</TH>
			<TD>${dto.name}</TD>
		</TR>
		<TR>
			<TH>전화번호</TH>
			<TD>${dto.phone}</TD>
		</TR>
		<TR>
			<TH>우편번호</TH>
			<TD>${dto.zipcode}</TD>
		</TR>
		<TR>
			<TH>주소</TH>
			<TD>${dto.address1} ${dto.address2}</TD>
		</TR>
	</TABLE>

	<DIV class='bottom'>
		<c:if
			test="${not empty sessionScope.id && sessionScope.grade != 'A' }">
			<input type='button' value='비번변경' onclick="updatePw()">
			<input type='button' value='정보수정' onclick="update()">
		</c:if>
		<c:if
			test="${not empty sessionScope.id && sessionScope.grade = 'A' }">
			<input type='button' value='회원목록' onclick="mlist()">
			<input type='button' value='회원삭제' onclick="mdelete()">
		</c:if>
	</DIV>


</body>
<!-- *********************************************** -->
</html>
