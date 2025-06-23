<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>None DTO Send</title>
</head>
<body>
    <h1>None DTO Send Result</h1>
    <p>Name: ${param.name}</p>
    <p>Age: ${param.age}</p>
    <p>Height: ${param.height}</p>
    <p>Birthday: ${param.birthday}</p>
    <p>${result}</p>
</body>
</html>
