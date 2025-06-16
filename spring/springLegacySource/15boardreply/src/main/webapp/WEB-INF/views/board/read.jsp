<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<%@include file="../include/header.jsp"%>
 	<script>
				
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/ex/board/modify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		formObj.attr("action", "/ex/board/remove");
		formObj.submit();
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "/ex/board/listAll";
	});
	$(".btn-bLike").on("click", function(){
		formObj.attr("action", "/ex/board/bLike");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	$(".btn-reply").on("click", function(){
		formObj.attr("action", "/ex/board/reply");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
});
</script>
  <div class="main">
  
<form role="form" method="post">
	<input type='hidden' name='bId' value="${boardDto.bId}">
</form>
		<h2>카테고리
				<input type="text"
			name='bGroupKind'  style="width:100%" value="${boardDto.bGroupKind}"
			readonly="readonly"></h2>
	
			</h2>
		<h1>제목</h1>
		<h2>
		<input type="text"
			name='bTitle'  style="width:100%" value="${boardDto.bTitle}"
			readonly="readonly"></h2>
	
		<h2>
		내용
		<textarea  style="width:100%" name="bContent" rows="3"
			readonly="readonly">${boardDto.bContent}</textarea>	</h2>
	
		<h2>
		작성자 <input type="text"
			name="bName" style="width:100%" value="${boardDto.bName}"
			readonly="readonly">
		<h2>

<!-- /.box-body -->
<div class="box-footer">
	<button type="submit" class="btn btn-warning">수정</button>
	<button type="submit" class="btn btn-danger">삭제</button>
	<button type="submit" class="btn btn-primary">전체글보기</button>
	<button type="submit" class="btn btn-bLike">좋아요${boardDto.bLike }</button>
	<button type="submit" class="btn btn-reply">답글</button>
</div>
</div>
		
<%@include file="../include/footer.jsp"%>