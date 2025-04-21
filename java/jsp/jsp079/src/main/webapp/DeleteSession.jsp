<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
세션 삭제됨
<%
    // key로 세션값 삭제
    session.removeAttribute("key");
    // 전체 세션 삭제
    session.invalidate();
%>
</body>
</html>