<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function download(fname){
		var url = '${pageContext.request.contextPath}/download';
		url += '?dir=/notice_board/storage';
		url += '&filename='+fname;
		location.href = url;
	}
	function list(){
		var url = './list';
		url += '?nowPage=${nowPage}';
		url += '&col=${col}';
		url += '&word=${word}';
		location.href = url;
	}
	function update(){
		var url = './update';
		url += '?nowPage=${nowPage}';
		url += '&col=${col}';
		url += '&word=${word}';
		url += '&noticeno=${dto.noticeno}'
		location.href = url;
	}
	function del(){
		if(confirm("글을 삭제하시겠습니까?")){
			var url = './delete';
			url += '?nowPage=${nowPage}';
			url += '&col=${col}';
			url += '&word=${word}';
			url += '&noticeno=${dto.noticeno}';
			url += '&oldFile=${dto.fname}';
			location.href = url;
		}
	}
	function create(){
		var url = './create';
		location.href = url;
	}
</script>
<title> 공지사항 게시판 read </title>
</head> 
<body>
	<div class="container">
		<h2> 공지사항 </h2>
		<div class="form-group">
			<form class="form-horizontal">
				<table class="table">
					<thead>
					</thead>
					<tbody>
						<tr>
							<th> 제&nbsp;&emsp;&nbsp;목 </th>
							<td>
								<div class="col-sm-10">
									<p class="form-control-static">${dto.title}</p>
								</div>
							</td>
							<th> 조 회 수 </th>
							<td>
								<div class="col-sm-10">
									<p class="form-control-static">${dto.viewcnt}</p>
								</div>
							</td>
						</tr>
						<tr>
							<th> 작 성 자 </th>
							<td colspan="3">
								<div class="col-sm-10">
									<p class="form-control-static">${dto.writer}</p>
								</div>
							</td>
						</tr>
						<tr>
							<th> 내&emsp;&nbsp;&nbsp;용 </th>
							<td colspan="3">
								<div class="col-sm-10">
									<textarea class="form-control-static" readonly="readonly" cols="109" style="border: none; resize: none;">${dto.content}</textarea>
								</div>
							</td>
						</tr>
						<tr>
							<th> 첨부파일 </th>
							<td colspan="3">
								<c:set var="fname" value="${dto.fname}"></c:set>
								<c:set var="files" value="${fn:split(fname,' ')}"></c:set>
								<c:forEach var="files" items="${files}">
									<div class="col-sm-10" style="padding-bottom: 7px;">
										<a href="javascript:download('${files}')" style="margin-left: 15px;">
								        	<span class="glyphicon glyphicon-save">${files}</span>
								        </a>
						        	</div>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<td colspan="4">
								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button class="w3-button w3-black" type="button" onclick="list()">목록</button>
										<button class="w3-button w3-pink" type="button" onclick="update()">수정</button>
										<button class="w3-button w3-deep-purple" type="button" onclick="del()">삭제</button>
										<button class="w3-button w3-purple" type="button" onclick="create()">등록</button>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
				
			</form>
		</div>
	</div>
</body>
</html>