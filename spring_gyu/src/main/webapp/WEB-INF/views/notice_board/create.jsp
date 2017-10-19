<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		var num = 0;
		fileAdd = function(){
			num = num+1;
			$('.fileAdd').append("<input type='file' id='file"+(num)+"' name='multipartFiles["+num+"]' style='display: inline-block; border: 1px solid #ccc;border-radius: 4px;'>");
			$('.fileAdd').append("<i class='glyphicon glyphicon-minus "+num+"' style='padding-left: 4px;' onclick='fileDel("+num+")'></i>");
			console.log(num+":::num");
		}
		
		fileDel = function(n){
			console.log("삭제 성공:::"+n);
			$('#file'+n).remove();
			$('.'+n).remove();
			num--;
		}
	});
	
</script>
<title> 공지사항 create </title>
</head>
<body>
	<div class="container">
		<h2> 공지사항 </h2>
		<hr style="border: 2px solid #9b154b;"> 
		<form class="form-horizontal" action="./create" method="post" enctype="multipart/form-data" onsubmit="return check(this)" name="frm">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">글 제 목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" placeholder="글 제목을 입력해주세요." name="title">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="writer">작 성 자</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="writer" placeholder="작성자를 입력해주세요" name="writer">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="notice_content">글 내 용</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="15" cols="80" id="notice_content" name="content" placeholder="글 내용을 입력해주세요"></textarea> 
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">파 일 첨 부</label>
				<div class="col-sm-5 fileAdd">
					<input type="file" id="file0" name="multipartFiles[0]" style="display: inline-block; border: 1px solid #ccc;border-radius: 4px;">
					<i class="glyphicon glyphicon-plus" onclick="fileAdd()"></i>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="w3-button w3-pink" type="submit">등록</button>
					<button class="w3-button w3-black" type="button">취소</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>