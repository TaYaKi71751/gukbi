<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<%
	HobbyDao hobbyDao = new HobbyDao();
	ArrayList<HobbyDto> dtos = hobbyDao.selectAll();
	request.setAttribute("hobbyList",dtos);
	for(HobbyDto dto : dtos) {
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

	<h2>Hobby List</h2>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>customerId</th>
				<th>hobby</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${hobbyList}">
			    <tr>
					<td>${dto.id}</td>
					<td>${dto.customerId}</td>
					<td>${dto.hobby}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
