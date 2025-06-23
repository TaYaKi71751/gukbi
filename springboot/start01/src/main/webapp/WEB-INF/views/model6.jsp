<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>DTO Send</title>
</head>
<body>
    <h1>DTO Send Result</h1>
    <p>Name: ${humanDto.name}</p>
    <p>Age: ${humanDto.age}</p>
    <p>Height: ${humanDto.height}</p>
    <p>Birthday: ${humanDto.birthday}</p>
    <p>${result}</p>
</body>
</html>
