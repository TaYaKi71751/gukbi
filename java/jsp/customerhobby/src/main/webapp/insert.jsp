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
	<form action="insertDB.jsp" method="get">
	이름 :<input type=text name=name ><br>
	나이 :<input type=text name=age ><br>
	키 :<input type=text name=height ><br>
	생일 :<input type="datetime-local" name=birthday ><br>
	<input type="submit" value=전송 >
	</form>


</body>
</html>
