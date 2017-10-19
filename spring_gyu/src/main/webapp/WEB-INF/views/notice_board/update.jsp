<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function check(f){
		if(f.title.value == ''){
			alert("제목을 입력해주세요.");
			f.title.focus();
			return false;
		}
		if(f.writer.value == ''){
			alert("작성자를 입력해주세요.");
			f.writer.focus();
			return false;
		}
		if(f.content.value == ''){
			alert("글 내용을 입력해주세요.");
			f.content.focus();
			return false;
		}
	}
	$(function(){
		remove = function(oldFile,noticeno){
			var result = confirm("삭제하시겠습니까?");
			if(result){
				$.ajax({
					type : 'post',
					url : './fileDel',
					data : {oldFile : oldFile,noticeno:noticeno},
					success : function(result){
						console.log("ddd");
						if(result){
							alert('삭제 성공');							
						}else{
							alert("삭제 실패");
						}
					}
				});
			}
			
		}
	});
</script>
<title> 공지사항 update11111111111111111 </title>
</head>
<body>
	<div class="container">
		<h2> 공지사항 </h2>
		<hr style="border: 2px solid #9b154b;">
		<form class="form-horizontal" action="./update" method="post" enctype="multipart/form-data" onsubmit="return check(this)" name="frm">
			<input type="hidden" name="nowPage" value="${nowPage}">
			<input type="hidden" name="col" value="${col}">
			<input type="hidden" name="word" value="${word}">
			<input type="hidden" name="noticeno" value="${dto.noticeno}">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">글 제 목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" placeholder="글 제목을 입력해주세요." name="title" value="${dto.title}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">작 성 자</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" placeholder="작성자를 입력해주세요" name="writer" value="${dto.writer}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="notice_content">글 내 용</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="15" cols="80" id="notice_content" name="content" placeholder="글 내용을 입력해주세요">${dto.content}</textarea> 
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">첨부된 파일</label>
				<c:set var="fname" value="${dto.fname}"></c:set>
				<c:set var="files" value="${fn:split(fname,' ')}"></c:set>
				<c:forEach var="files" items="${files}">
					<div class="col-sm-10" style="padding-bottom: 7px; float: right;">
						<span>${files}</span> <span class="glyphicon glyphicon-remove" onclick="remove('${files}','${dto.noticeno}')"></span>
		        	</div>
				</c:forEach>
				
				
<!-- 				<div class="col-sm-10"> -->
<!-- 					<div class="form-control"> -->
<%-- 						<span>${dto.fname}</span> <span class="glyphicon glyphicon-remove" onclick="remove()"></span> --%>
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">파 일 첨 부</label>
				<div class="col-sm-10">
					<input type="file" name="multipartFile" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="w3-button w3-pink" type="submit">수정</button>
					<button class="w3-button w3-black" type="button" onclick="history.back()">취소</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>