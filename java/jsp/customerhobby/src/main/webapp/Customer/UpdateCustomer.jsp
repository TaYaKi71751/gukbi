<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
<meta charset="UTF-8">
<title>UpdateCustomer</title>
</head>
<body>
	<div id="menu">
	<a href="../main.jsp">main</a></div>
	<form action="UpdateCustomerDB.jsp" method="get">
	ID :<input type=number name=id ><br>
	이름 :<input type=text name=name ><br>
	나이 :<input type=text name=age ><br>
	키 :<input type=text name=height ><br>
	생일 :<input type="datetime-local" name=birthday ><br>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
