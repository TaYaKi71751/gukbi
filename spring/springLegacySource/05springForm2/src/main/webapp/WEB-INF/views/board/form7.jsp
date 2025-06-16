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
	Hello world!  ${names }<br>
	Hello world!  ${names[0] }<br>
	Hello world!  ${names[1] }<br>
	jstl for-each사용<br>
</h1>


</body>
</html>