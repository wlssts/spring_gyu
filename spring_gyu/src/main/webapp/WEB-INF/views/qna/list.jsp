<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/ssi/ssi.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function read(qnano) {
		var url = "./read";
		url += "?qnano=" + qnano;
		url += "&col=${col}";
		url += "&word=${word}";
		url += "&nowPage=${nowPage}";

		location.href = url;
	}
</script>
<style type="text/css">
</style>
</head>
<!-- *********************************************** -->
<body>
	<div>
		<form name="frm" method="post" action="list">
         <select name="col">
            <option value="title"
               <c:out value="${col eq 'title' ? 'selected' : '' }" />
               >제목</option>
            <option value="content"
               <c:out value="${col eq 'content' ? 'selected' : '' }" />
               >내용</option>
            <option value="subject_content"
               <c:out value="${col eq 'subject_content' ? 'selected' : '' }" />
               >제목,내용</option>
            <option value="total"
               <c:out value="${col eq 'total' ? 'selected' : '' }" />
               >전체</option>
         </select> 
           <input type="text" placeholder="검색어 입력" name = "word" value = "${word }" class = "d1">
         <button>검색</button>
         <button type="button" class="btn btn-success" onclick="location.href = 'create'">등록</button>
      </form>

	</div>
	<div>
		<h2>게시판 목록</h2>
		<TABLE>
			<TR>
				<TH>번호</TH>
				<TH>제목</TH>
				<TH>성명</TH>
				<TH>ID</TH>
				<TH>조회수</TH>
				<TH>등록일</TH>
			</TR>
			<c:choose>
				<c:when test="${empty list }">
					<tbody>
						<tr>
							<td colspan="8">등록된 글이 없습니다.</td>
						</tr>
					</tbody>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${list }">

						<tr>
							<td>${dto.qnano}</td>
							
							<td><c:forEach var="j" begin="1" end="${dto.indent }">
									<c:out value="&nbsp;" escapeXml="false" />
									
								</c:forEach> <c:if test="${dto.indent > 0 }">
									<img src='${root }/images/re.jpg'>
									
								</c:if>
								 <a href="javascript:read('${dto.bbsno}')"> ${dto.title}
								 </a> <c:if test="${util:newImage(fn:substring(dto.wdate, 0,10)) }">
									<img src="${root }/images/new.gif">
								</c:if></td>
							<td>${dto.name}</td>
							<td>${dto.id}</td>
							<td>${dto.viewcnt}</td>
							<td>${dto.wdate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>


		</TABLE>
	</div>

	<div>${paging }</div>
</body>
</html>