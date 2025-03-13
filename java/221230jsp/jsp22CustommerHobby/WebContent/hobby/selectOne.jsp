<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HOBBY 정보</h1>
	<table border="1" width="40%" id="hobbys">
		<tr>
			<th>ID</th>
			<th>취미</th>
		</tr>
			<tr>
				<td>${requestScope.dto.id }</td>
				<td>${requestScope.dto.hobby }</td>
			</tr>
	</table>
	<a href="/jsp19CustommerHobby/hobby/selectAll.hobby">목록으로</a>
	<a href="/jsp19CustommerHobby/hobby/update.hobby?id=${requestScope.dto.id}&hobby=${requestScope.dto.hobby}">수정</a>
	<a href="/jsp19CustommerHobby/hobby/delete.hobby?id=${requestScope.dto.id}&hobby=${requestScope.dto.hobby}">삭제</a>
</body>
</html>