<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
	ID :<input type=number name=id ><br>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
