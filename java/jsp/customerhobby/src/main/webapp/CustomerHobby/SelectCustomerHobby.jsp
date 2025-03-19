<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.time.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<%
	CustomerHobbyDao customerHobbyDao = new CustomerHobbyDao();
	ArrayList<CustomerHobbyDto> dtos = customerHobbyDao.selectCustomerHobbys();
	request.setAttribute("customerHobbyList",dtos);
	for(CustomerHobbyDto dto : dtos) {
		System.out.println(dto);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SelectCustomerHobby</title>
</head>
<body>
	<h2>Customer Hobby List</h2>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<table>
		<thead>
			<tr>
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
</body>
</html>
