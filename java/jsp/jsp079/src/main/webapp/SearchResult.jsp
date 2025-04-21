<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
검색 결과 값은:
<%
	String searchString = request.getParameter("search");
	out.println(searchString);
%>
</body>
</html>