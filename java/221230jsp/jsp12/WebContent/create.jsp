<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>coockie setting page</h1>
	<%
	request.setCharacterEncoding("utf-8");
	%>
	name : <%= request.getAttribute("name") %><br>
	value : <%= request.getAttribute("value") %> <br>
	age : <%= request.getAttribute("age") %> <br>
	<br>
	<a href="/jsp12/main.html">메인으로 이동</a>
</body>
</html>