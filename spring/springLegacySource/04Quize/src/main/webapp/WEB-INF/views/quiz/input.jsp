<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	요청 주소 /ex/quize/input <br>
	사용자 입력  <br>
</h1>
<form action="/ex/quize/result" method="get">
	id:<input type=text name=id ><br>
	pw:<input type=text name=pw ><br>
	name:<input type=text name=name ><br>
	age:<input type=text name=age ><br>
	<input type= submit value=전송 ><br>
</form>


</body>
</html>