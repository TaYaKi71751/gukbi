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
   <h1>Map Data</h1>
       <p>Key1: ${mapdata.key1}</p>
       <p>Key2: ${mapdata.key2}</p>
       <p>Key3: ${mapdata.key3}</p>

       <!-- HumanDto 객체 출력 -->
       <h2>HumanDto Data (Key4)</h2>
       <p>Name: ${mapdata.key4.name}</p>
       <p>Age: ${mapdata.key4.age}</p>
       <p>Height: ${mapdata.key4.height}</p>
       <p>Birthday: ${mapdata.key4.birthday}</p>

</body>
</html>
