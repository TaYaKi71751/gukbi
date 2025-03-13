<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/jsp19CustommerHobby/hobby/updateDB.hobby" method="get">
<h1>고객 정보</h1>
	<table border="1" width="90%" id="hobbys">
		<tr>
			<th>ID</th>
			<th>취미</th>
		</tr>
		<tr>
			<input type="hidden" value="${requestScope.dto.id }" name='id'>
			<td>${requestScope.dto.id }</td>
			<input type="hidden" value="${requestScope.dto.hobby}" name='beforehobby'>
			<td><input type="text" value="${requestScope.dto.hobby}" name='afterhobby'></td>
		</tr>
	</table>
	<a href="/jsp19CustommerHobby/hobby/selectAll.hobby">목록으로</a>

	<input type="submit" value='수정'>
	</form>
</body>
</html>