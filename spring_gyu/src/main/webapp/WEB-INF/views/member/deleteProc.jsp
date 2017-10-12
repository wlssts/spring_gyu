<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/ssi/member_ssi.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
</style>
<script type="text/javascript">
	function mlist() {
		var url = "${root}/list";
		url += "?col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";

		location.href = url;
	}
</script>
</head>
<!-- *********************************************** -->
<body>

	<DIV class="title">회원탈퇴</DIV>

	<div class="content">
		<c:choose>
			<c:when test="${flag }">
				탈퇴되었습니다. 자동 로그아웃됩니다.
			</c:when>
			<c:otherwise>
				탈퇴가 실패되었습니다.
			</c:otherwise>
		</c:choose>
	</div>
	<DIV class='bottom'>
		<input type='button' value='홈' onclick="location.href='${root}'">
		<input type='button' value='다시시도' onclick="history.back()">
		<c:if
			test="${not empty sessionScope.id && sessionScope.grade == 'A' }">
			<button type="button" onclick="mlist()">목록</button>
		</c:if>
	</DIV>

</body>
<!-- *********************************************** -->
</html>
