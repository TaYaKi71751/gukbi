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
   <h1>ArrayList Data</h1>


       <table>
        <tr>
            <th>name</th><th>age</th><th>Height</th><th>birthday</th>
        </tr>

        <c:forEach var="dto" items="${list}">
        <tr>
               <td>Name: ${dto.name}</td>
               <td>Age: ${dto.age}</td>
               <td>Height: ${dto.height}</td>
               <td>Birthday: ${dto.birthday}</td>
        </tr>
        </c:forEach>



       </table>





</body>
</html>
