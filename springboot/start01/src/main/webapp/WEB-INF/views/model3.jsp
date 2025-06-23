<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>Model 3</h1>
    <p>key1 : ${mapData.key1}</p>
    <p>key2 : ${mapData.key2}</p>
    <p>key3 : ${mapData.key3}</p>
    <p>name : ${humanDto.getName()}</p>
    <p>age : ${humanDto.getAge()}</p>
    <p>height : ${humanDto.getHeight()}</p>
    <p>birthday : ${humanDto.getBirthday()}</p>
</body>
</html>