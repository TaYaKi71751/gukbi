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
		boolean check = (boolean)request.getAttribute("check");
		if(check == false){
			out.println("<h1>삭제에 실패하였습니다.(없는 ID입니다.)</h1>");
		}else{%>
	삭제된 name :<%= request.getAttribute("name") %><br>
	삭제된 value :<%= request.getAttribute("value") %><br>  
	<% }
	%>
	<br>
	<a href="/jsp10/main.html">메인으로 이동</a>
</body>
</html>