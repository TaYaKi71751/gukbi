<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InsertCustomer</title>
<link rel="stylesheet" type="text/css" href="./index.css">
</head>
<body>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<form action="InsertCustomerDB.jsp" method="get">
	<label>이름</label>
	<input type=text name=name ><br>
	<label>나이</label>
	<input type=text name=age ><br>
	<label>키</label>
	<input type=text name=height ><br>
	<label>생일</label>
	<input type="datetime-local" name=birthday ><br>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
