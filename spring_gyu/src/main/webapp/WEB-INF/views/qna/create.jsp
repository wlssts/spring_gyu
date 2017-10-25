<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/ssi/ssi.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>create</title>
</head>
<body>
	<div>
		<form name='frm' method='POST' action='create'>
			<table>
				<tr>
					<th>ID</th>
					<td>${sessionScope.id }</td>
					<th>날짜</th>
					<td><script type="text/javascript"> // 날짜 출력
						var today = new Date();
						var dd = today.getDate();
						var mm = today.getMonth()+1; //January is 0!
						var yyyy = today.getFullYear();
					
						if(dd<10) {
						    dd='0'+dd
						} 
					
						if(mm<10) {
						    mm='0'+mm
						} 
					
						today = yyyy+'/'+mm+'/'+dd;
						document.write(today);
					</script>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="title"></td>
				</tr>
				<tr>
					<th colspan="4">내용</th>
				</tr>
				<tr>
					<td colspan="4">
						<textarea rows="10" cols="50" name="content"></textarea>
					</td>
					<td>
						<input type="hidden" name="passwd" value="${sessionScope.passwd }">
					</td>
				</tr>
			</table>
			
			<div>
				<input type='submit' value='등록'>
				<input type='button' value='취소' onclick="history.back()">
			</div>
		</form>
	</div>
</body>
</html>