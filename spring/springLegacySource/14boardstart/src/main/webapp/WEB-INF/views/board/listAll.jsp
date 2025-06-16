<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<%@include file="../include/header.jsp"%>
<script>
var result = '${msg}';
if(result == 'success'){
	alert("처리가 완료되었습니다.");
}
$(document).ready(function(){
	$(".btn").on("click", function(){
		location.href="/ex/board/register"
	});
});
</script>
  <div class="main">
  <h1></h1>
  <h1> 게 시 판 </h1>
  <h1></h1>
  <div class="horizontal-line"></div>
  <table id='customers' width=100% border="1">
	<tr>
		<th style="width: 175px">카테고리</th>
		<th style="width: 80px">번호</th>
		<th style="width: 145px">제목</th>
		<th style="width: 140px">작성자</th>
		<th style="width: 200px">작성일</th>
		<th style="width: 80px">조회</th>
		<th style="width: 130px">좋아요</th>
		<th style="width: 130px">bGroup</th>
		<th style="width: 130px">bStep</th>
		<th style="width: 130px">bIndent</th>
		
	</tr>
<c:forEach items="${list}" var="boardDto">
	<tr>
		<td>${boardDto.bGroupKind }</td>
		<td>${boardDto.bId}</td>
		<td><a href='/ex/board/read?bId=${boardDto.bId}&'>${boardDto.bTitle}</a></td>
		<td>${boardDto.bName}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${boardDto.bWriteTime}" /></td>
		<td><span class="badge bg-red">${boardDto.bHit }</span></td>
		<td>${boardDto.bLike }</td>
		<td>${boardDto.bGroup }</td>
		<td>${boardDto.bStep }</td>
		<td>${boardDto.bIndent }</td>
	</tr>
</c:forEach>
</table>
<button class="btn">글쓰기</button>
</div>
		
<%@include file="../include/footer.jsp"%>