<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Test Page</title>
</head>
<body>
   <h1>Hello, model03!</h1>

  <h2>Human Data</h2>
    <p>Name: ${param.name}</p>
    <p>Age: ${param.age}</p>
    <p>Height: ${param.height}</p>
    <fmt:parseDate value="${param.birthday}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate" />
    <p>Birthday: <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm:ss" /></p>
</body>
</html>
