<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Member페이지 관리자와 Member가 사용
<form:form action="${pageContext.request.contextPath}/user/logout" method="POST">
    <input type="submit" value="로그아웃" />
</form:form>
</body>
</html>