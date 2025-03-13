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
<h1>고객 정보</h1>
<table boarder="1" width="90%" id="customers">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>height</th>
	<th>birthday</th>
	<th>hobbys</th>
	</tr>
	<c:forEach items="${dtos }" var="customerHobby">
	<tr>
		<td>${customerHobby.id }</td>
		<td><a href='/jsp20CustommerHobby/customerHobbys/deleteCustomer.customerHobbys?
		id=${customerHobby.id}'>
		${customerHobby.name }</a></td>
		<td>${customerHobby.height}</td>
		<td>${customerHobby.birthday }</td>
		<td>
		<c:forEach items="${customerHobby.hobbys }" var="hobby">
		<a href='/jsp20CustommerHobby/customerHobbys/deleteHobby.customerHobbys
		?id=${hobby.id}&hobby=${hobby.hobby}'>${hobby.hobby} </a>
		</c:forEach>
		</td>
	</tr>
	</c:forEach>
</table> 
<a href="/jsp20CustommerHobby/customerHobbys/insert.customerHobbys">고객추가</a>
</body>
</html>






