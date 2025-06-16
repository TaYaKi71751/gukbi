<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var result='${msg}';
if(result=='success'){
	alert('처리가 완료되었습니다.');
}
</script>
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
	<c:forEach items="${list }" var="customerInfo">
	<tr>
		<td>${customerInfo.id }</td>
		<td>${customerInfo.name }<a href='/ex/customerHobby/deleteCustomer?id=${customerInfo.id}'>
		삭제</a>
		<a href='/ex/customerHobby/updateCustomer?id=${customerInfo.id}'>
		수정</a></td>
		<td>${customerInfo.height}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" 
		value="${customerInfo.birthday }" /> </td>
		<td>
		<c:forEach items="${customerInfo.hobbys }" var="hobby">
		${hobby}
		<a href='/ex/customerHobby/deleteHobby?id=${customerInfo.id}&hobby=${hobby}'>삭제 </a>
		<a href='/ex/customerHobby/updateHobby?id=${customerInfo.id}&hobby=${hobby}'>수정 </a>
		</c:forEach>
		</td>
	</tr>
	</c:forEach>
</table> 
<a href="/ex/customerHobby/insert">고객추가</a>
</body>
</html>

