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


    <p>msg:${msgStr}</p>
    <script>
        let msg="${msgStr}";
        if(msg=='success'){
            alert(msg);
        }
    </script>
    <p>tag:${tagStr}</p>
    <p><c:out value="${tagStr}"/></p>


</body>
</html>
