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
    session.invalidate();
    response.sendRedirect("sessionlogin1.jsp"); // 로그인 페이지로 이동
%>
</body>
</html>