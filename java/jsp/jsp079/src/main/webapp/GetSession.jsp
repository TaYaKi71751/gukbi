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
    String key = (String)session.getAttribute("key");
%>
저장된 key의 값은 <%= key %> 입니다.
</body>
</html>