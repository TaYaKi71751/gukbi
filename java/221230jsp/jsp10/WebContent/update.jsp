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
		request.setCharacterEncoding("utf-8"); 
		if(request.getAttribute("name") == null){
			out.println("<h1>없는 ID 입니다.</h1>");
		}else{
	%>
	name :<%= request.getAttribute("name") %><br> 
	변경 전 value :<%= request.getAttribute("value") %><br>
	변경 된 value :<%= request.getAttribute("updateValue") %><br> 
	age : <%= request.getAttribute("age") %><br>
	<% 
		}
	%>
	<br>
	<a href="/jsp10/main.html">메인으로 이동</a>
</body>
</html>