<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
<meta charset="UTF-8">
<title>DeleteHobby</title>
</head>
<body>
	<div id="menu">
	<a href="../main.jsp">main</a></div>
	<form action="DeleteHobbyDB.jsp" method="get">
		<%
		HobbyDao hobbyDao = new HobbyDao();
		ArrayList<HobbyDto> dtos = hobbyDao.selectAll();
		request.setAttribute("hobbyList", dtos);
		%>
		<table>
			<thead>
				<tr>
					<th>선택</th>
					<th>ID</th>
					<th>고객ID</th>
					<th>취미</th>
				</tr>
			</thead>
			<tbody>
	    <c:forEach var="dto" items="${hobbyList}" varStatus="status">
			<tr>
				<td><input type="checkbox" name="id" value="${dto.getId()}"></td>
				<td>${dto.getId()}</td>
				<td>${dto.getCustomerId()}</td>
				<td>${dto.getHobby()}</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
