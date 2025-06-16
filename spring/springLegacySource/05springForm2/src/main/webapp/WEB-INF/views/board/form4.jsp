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
	form4
</h1>
humanDto
<P> ${humanDto.name } </P>
<P> ${humanDto.age} </P>
<P> ${humanDto.id } </P>
<P> ${humanDto.pw } </P>
newHuman
<P> ${newHuman.name } </P>
<P> ${newHuman.age} </P>
<P> ${newHuman.id } </P>
<P> ${newHuman.pw } </P>
</body>
</html>