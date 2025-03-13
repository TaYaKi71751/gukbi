<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table boarder="1" width="90%" id="customers">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>height</th>
	<th>birthday</th>
	<th>hobby</th>
	</tr>
	<c:forEach items="${requestScope.dtos }" var="customerHobby">
	<tr>
		<td>${customerHobby.id }</td>
		<td><a href="/jsp20CustommerHobby/customerHobby/selectOne.customerHobby
		?id=${customerHobby.id }&hobby=${customerHobby.hobby.hobby }">
		${customerHobby.name }</a></td>
		<td>${customerHobby.height}</td>
		<td>${customerHobby.birthday }</td>
		<td>${customerHobby.hobby.hobby }</td>
		
	</tr>
	</c:forEach>
</table> 
<a href="/jsp20CustommerHobby/customerHobby/insert.customerHobby">추가</a>
</body>
</html>






