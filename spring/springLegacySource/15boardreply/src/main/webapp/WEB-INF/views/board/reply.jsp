<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<%@include file="../include/header.jsp"%>
<div class="main">

	<div class="box-header">
		<h1 class="box-title">답글쓰기</h3>
	</div>
	<!-- /.box-header -->
	<!-- action에 경로가 없으면 현재 페이지 주소로 이동한다.-->


	<form role="form" action="/ex/board/reply" method="post">
		<input type='hidden' name='bId' value="${boardDto.bId}"> 
		<h2>카테고리
			<input type="text" style="width:100%" name='bGroupKind' value="${boardDto.bGroupKind}" readonly="readonly">
		</h2>
		<h2> 제목  
			<input type="text" name='bTitle' placeholder="제목을 입력해 주세요" style="width:100%">
		</h2> 
		<h2> 내용 
			<textarea name="bContent" rows="8" style="width:100%" placeholder="내용을 50자 이상 입력해 주세요."></textarea>
		</h2>
		<h2> 작성자 
			<input type="text" name="bName"  placeholder="작성자"  style="width:100%">
		</h2> 
		<!-- /.box-body -->
		<input type="hidden" name='bGroup' value="${boardDto.bGroup}">
		<input type="hidden" name='bStep' value="${boardDto.bStep}">
		<input type="hidden" name='bIndent' value="${boardDto.bIndent}">
		<button type="submit" class="btn">새글등록</button>
	</form>

</div>

<%@include file="../include/footer.jsp"%>