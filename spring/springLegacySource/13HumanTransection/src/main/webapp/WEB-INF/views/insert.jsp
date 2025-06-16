<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
insert
<form action="/ex/insert" method="post">
이름<input type="text" name=name ><br>
나이<input type="text" name=age ><br>
키<input type="text" name=height ><br>
생일<input type="datetime-local" name=birthday ><br>
<input type="submit" value="제출">
</form>
</body>
</html>
