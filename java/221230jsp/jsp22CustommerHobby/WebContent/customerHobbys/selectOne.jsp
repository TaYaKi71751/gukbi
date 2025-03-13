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
	
		<td>${requestScope.dto.id }</td>
		<td>${requestScope.dto.name }</td>
		<td>${requestScope.dto.height}</td>
		<td><fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/></td>	
	</tr>
</table>



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
	
	<form action="/jsp20CustommerHobby/customerHobby/update.customerHobby">
		<input type="hidden" name="id" value=${requestScope.dto.id }>
		<input type="hidden" name="hobby" value=${requestScope.dto.hobby.hobby }>
		고객의 키 수정:<input type="text" name='newHeight' ><br>
		고객의 취미 변경:<input type="text" name="newHobby"><br>
		<input type="submit" value="수정">
	</form>
	
	<a href="/jsp20CustommerHobby/customerHobby/selectAll.customerHobby">목록가기</a>
	<a href="/jsp20CustommerHobby/customerHobby/deleteCustomer.customerHobby
	?id=${requestScope.dto.id}">고객삭제</a>
	<a href="/jsp20CustommerHobby/customerHobby/deleteHobby.customerHobby
	?id=${requestScope.dto.id}&hobby=${requestScope.dto.hobby.hobby}">하비삭제</a>
</body>
</html>













