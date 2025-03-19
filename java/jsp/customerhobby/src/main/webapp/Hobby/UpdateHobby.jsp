<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
<meta charset="UTF-8">
<title>UpdateHobby</title>
</head>
<body>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<form action="UpdateHobbyDB.jsp" method="get">
	ID :<input type=number name=id ><br>
	취미 :<input type=text name=hobby ><br>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
