<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<body>
<h4>UPDATE</h4>
<form action="/ex/admin/user/update" method="post">
	유저명:<input type="text" name="username" value="${dto.username }"><br>
	비밀번호:<input type="text" name="password" value="${dto.password }"><br>
	권한:<input type="text" name="enabled" value="${dto.enabled }"><br>
	<input type="submit" value="수정"><br>
</form>
</body>
</html>