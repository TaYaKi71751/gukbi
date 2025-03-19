<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DeleteCustomerHobby</title>
</head>
<body>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<form action="DeleteCustomerHobbyDB.jsp" method="get">
		<%
		CustomerHobbyDao customerHobbyDao = new CustomerHobbyDao();
		ArrayList<CustomerHobbyDto> dtos = customerHobbyDao.selectCustomerHobbys();
		request.setAttribute("customerHobbyList", dtos);
		%>
		<table>
			<thead>
				<th>선택</th>
				<th>Customer.CustomerId</th>
				<th>Customer.Name</th>
				<th>Customer.Age</th>
				<th>Customer.Height</th>
				<th>Customer.BirthDay</th>
				<th>Hobby.HobbyId</th>
				<th>Hobby.CustomerId</th>
				<th>Hobby.Hobby</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="dto" items="${customerHobbyList}">
				<tr>
					<td><input type="checkbox" name="id" value="${dto.getCustomer().getId()}"></td>
					<td>${dto.getCustomer().getId()}</td>
					<td>${dto.getCustomer().getName()}</td>
					<td>${dto.getCustomer().getAge()}</td>
					<td>${dto.getCustomer().getHeight()}</td>
					<td>${dto.getCustomer().getBirthday()}</td>
					<td>${dto.getHobby().getId()}</td>
					<td>${dto.getHobby().getCustomerId()}</td>
					<td>${dto.getHobby().getHobby()}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<input type="submit" value=전송 >
	</form>

</body>
</html>
