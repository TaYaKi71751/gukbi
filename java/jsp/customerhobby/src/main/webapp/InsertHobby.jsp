<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="main.jsp">main</a><br>
	<form action="InsertHobbyDB.jsp" method="get">
	고객 ID :<input type=number name=customerId ><br>
	취미 :<input type=text name=hobby ><br>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
