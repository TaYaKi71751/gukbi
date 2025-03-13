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
<h1>HOBBY 정보</h1>
	<table border="1" width="40%" id="hobbys">
		<tr>
			<th>ID</th>
			<th>취미</th>
		</tr>
		<c:forEach items="${dtos }" var="hobbyDto">
			<tr>
				<td>${hobbyDto.id }</td>
				<td><a href='/jsp19CustommerHobby/hobby/selectOne.hobby?id=${hobbyDto.id}&hobby=${hobbyDto.hobby}'>
				${hobbyDto.hobby }</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href='/jsp19CustommerHobby/hobby/insert.hobby'>추가</a>
</body>
</html>