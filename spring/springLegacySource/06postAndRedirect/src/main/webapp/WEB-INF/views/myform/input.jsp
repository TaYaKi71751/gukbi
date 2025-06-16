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
	get 요청방식
</h1>
<P>
	<form action="/ex/myform/result" method="get">
		id:<input type="text" name="id">
		<input type="submit" value="전송">
	</form>
</P>
<h1>
	post 요청방식
</h1>
<P>
	<form action="/ex/myform/result" method="post">
		id:<input type="text" name="id">
		<input type="submit" value="전송">
	</form>
</P>

</body>
</html>