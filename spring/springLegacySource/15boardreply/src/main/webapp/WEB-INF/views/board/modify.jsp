<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<%@include file="../include/header.jsp"%>
<div class="main">

	<form role="form" method="post">

		<div class="box-body">

			<h2>
				번호 <input type="text" name='bId' style="width: 100%"
					value="${boardDto.bId}" readonly="readonly">
			</h2>

			<h2>
				카테고리<select name="bGroupKind">
					<option value="공지사항">공지사항</option>
					<option value="자유게시판">자유게시판</option>
				</select>
			</h2>

			<h2>
				제목 <input type="text" name='bTitle' style="width: 100%"
					value="${boardDto.bTitle}">
			</h2>

			<h2>
				내용
				<textarea style="width: 100%" name="bContent" rows="3">${boardDto.bContent}</textarea>
			</h2>

			<h2>
				작성자 <input type="text" name="bName" style="width: 100%"
					value="${boardDto.bName}" readonly>
				<h2>
		</div>
		<!-- /.box-body -->
	</form>
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">저장</button>
		<button type="submit" class="btn btn-warning">취소</button>
	</div>
	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);
			$(".btn-warning").on("click", function() {
				self.location = "/ex/board/listAll";
			});
			$(".btn-primary").on("click", function() {
				formObj.submit();
			});
		});
	</script>


</div>

<%@include file="../include/footer.jsp"%>