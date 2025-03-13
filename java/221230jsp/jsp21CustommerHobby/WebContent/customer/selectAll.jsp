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
<%
	java.time.LocalDateTime ld=java.time.LocalDateTime.now();
	request.setAttribute("ld", ld);
%>
<hr>
현재시간
<hr>
-${requestScope.ld }-
<fmt:parseDate value="${requestScope.ld }"
 pattern="yyyy-MM-dd'T'HH:mm:ss.SSS"
 var="now" type="both" ></fmt:parseDate>
 <hr>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"></fmt:formatDate>
<hr>
<table border="1" width="90%" id="customers">
	<tr>
	<th>id</th>
	<th>name</th>
	<th>height</th>
	<th>birthday</th>
	<th>birthday</th>
	</tr>
	<c:forEach items="${dtos }" var="customerDto">
		<fmt:parseDate value="${customerDto.birthday}"
		 pattern="yyyy-MM-dd'T'HH:mm"
		 var="now" type="both" ></fmt:parseDate>
		<tr>
			<td>${customerDto.id }</td>
			<td><a href='/jsp20CustommerHobby/customer/selectOne.customer?id=${customerDto.id}'>
			${customerDto.name }</a></td>
			<td>${customerDto.height}</td>
			<td><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/></td>	
			<td>${customerDto.birthday}</td>	
		</tr>
	</c:forEach>
</table>
<a href="/jsp20CustommerHobby/customer/insert.customer">고객추가</a>
</body>
</html>

