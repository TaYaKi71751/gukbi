<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeleteCustomer</title>
<link rel="stylesheet" type="text/css" href="./index.css">
</head>
<body>
	<div id="menu">
	<a href="../main.jsp">main</a>
	</div>
	<form action="DeleteCustomerDB.jsp" method="get">
		<%
		CustomerDao customerDao = new CustomerDao();
		ArrayList<CustomerDto> dtos = customerDao.selectAll();
		request.setAttribute("customers", dtos);
		%>
		<table>
			<thead>
				<tr>
					<th>선택</th>
					<th>ID</th>
					<th>이름</th>
					<th>나이</th>
					<th>키</th>
					<th>생일</th>
				</tr>
			</thead>
			<tbody>
	    <c:forEach var="customer" items="${customers}" varStatus="status">
					 <tr>
							<td><input type="checkbox" name="id" value="${customer.getId()}"></td>
							<td>${customer.getId()}</td>
							<td>${customer.getName()}</td>
							<td>${customer.getAge()}</td>
							<td>${customer.getHeight()}</td>
							<td>${customer.getBirthday()}</td>
						</tr>
					</c:forEach>
			</tbody>
		</table>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
