<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test Page</title>
</head>
<body>
    <h1>Model 4</h1>
    <p>title : ${title}</p>
    <p>age : ${age}</p>

    List of items:
    <table border="1">
        <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Height</th>
                <th>Birthday</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.age}</td>
                    <td>${item.height}</td>
                    <td>
                        <fmt:parseDate value="${item.birthday}" pattern="yyyy-MM-dd'T'hh:mm" var="parsedDate"/>
                        <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd hh:mm"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>