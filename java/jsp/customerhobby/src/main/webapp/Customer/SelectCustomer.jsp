<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<%
	CustomerDao customerDao = new CustomerDao();
	ArrayList<CustomerDto> dtos = customerDao.selectAll();
	request.setAttribute("customerList",dtos);
	for(CustomerDto dto : dtos) {
		System.out.println(dto);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<style>
		body {
			display: flex;
		}

        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<h2>Customer List</h2>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>age</th>
				<th>height</th>
				<th>birthday</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${customerList}">
				<tr>
					<td>${dto.id}</td>
					<td>${dto.name}</td>
					<td>${dto.age}</td>
					<td>${dto.height}</td>
					<td>${dto.birthday}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
