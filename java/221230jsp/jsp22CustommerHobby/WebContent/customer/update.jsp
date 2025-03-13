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
<form action='/jsp20CustommerHobby/customer/updateDB.customer' method="get">
<table border="1" width="90%" id="customers">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>height</th>
	<th>birthday</th>
	</tr>
	<fmt:parseDate value="${requestScope.dto.birthday}"
	 pattern="yyyy-MM-dd'T'HH:mm"
	 var="now" type="both" ></fmt:parseDate>
	<tr>
		<input type='hidden' name="id" value='${requestScope.dto.id }'>
		<td>${requestScope.dto.id }</td>
		<td><input type='text' name="name" value='${requestScope.dto.name }'></td>
		<td>${requestScope.dto.height}</td>
		<td><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/></td>	
	</tr>
</table>
<a href="/jsp20CustommerHobby/customer/selectAll.customer">목록가기</a>
<input type="submit" value='수정'>
</form>
</body>
</html>