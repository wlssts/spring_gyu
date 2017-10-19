<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function read(noticeno){
		var url = './read';
		url += '?noticeno='+noticeno;
		url += '&nowPage=${nowPage}';
		url += '&col=${col}';
		url += '&word=${word}';
		location.href = url;
	}
</script>
<title>공지사항 게시판 list</title>

</head>
<body>
	<div class="container">
		<h2> 공지사항 </h2>
		<p>해야할 것 : 우선순위 3개 공지로 올리기!</p>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제&nbsp;목</th>
					<th>조회수</th>
				</tr>
			</thead>
			<c:forEach var="dto" items="${list}">
				<tbody>
					<tr>
						<td>${dto.noticeno}</td>
						<td>${dto.writer}</td>
						<td><a href="javascript:read('${dto.noticeno}')">${dto.title}</a></td>
						<td>${dto.viewcnt}</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

	<div class="container">
		${paging}
	</div>
</body>
</html>