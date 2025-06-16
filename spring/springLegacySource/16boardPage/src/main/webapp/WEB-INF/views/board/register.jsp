<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<div class="main">
	<div class="box-header">
		<h1 class="box-title">
			새 글쓰기
			</h3>
	</div>
	<!-- /.box-header -->
	<!-- action에 경로가 없으면 현재 페이지 주소로 이동한다.-->
	<form role="form" method="post">

		<h3>
			제목 <input type="text" name='bTitle' placeholder="제목 입력"
				style="width: 100%">
		</h3>
		<h2>
			카테고리<select name="bGroupKind">
				<option value="공지사항">공지사항</option>
				<option value="자유게시판">자유게시판</option>
			</select>
		</h2>
		<h2>
			내용
			<textarea name="bContent" rows="8" style="width: 100%"
				placeholder="내용 입력"></textarea>
		</h2>
		<h2>
			작성자 <input type="text" name="bName" placeholder="작성자"
				style="width: 100%">
		</h2>
		<!-- /.box-body -->
		<button type="submit" class="btn btn-primary">글쓰기</button>

	</form>
	<!-- <form role="form" method="post">
	
		<h2>댓글</h2>
		<input type="text" name='#' placeholder="댓글을 남겨보세요" style="width:100%"> 
</form> -->

</div>

<%@include file="../include/footer.jsp"%>