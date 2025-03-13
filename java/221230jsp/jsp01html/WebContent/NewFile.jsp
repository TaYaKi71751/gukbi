<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	for(int i=0;i<5;i++){
%>
	안녕하세요<br>

<%} %>

<%
	out.println("hello jsp?<br>");
%>
   hello jsp! 0번
  <a href='sub/b.html'>서브 페이지</a>
  <img src='img/k.jpg'>
</body>
</html>


