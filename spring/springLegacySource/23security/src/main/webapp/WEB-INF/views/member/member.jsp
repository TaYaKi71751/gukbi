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
Member 페이지<br>
회원과 관리자만 들어 올 수 있습니다.

<form:form action="${pageContext.request.contextPath}/user/logout" method="POST">
    <input type="submit" value="로그아웃" />
</form:form>

</body>
</html>