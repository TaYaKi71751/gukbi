<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    int size = Integer.parseInt(request.getParameter("size"));
    String character = request.getParameter("character");
    for(int i = 0;i < size;i++){
        for(int j = 0;j < i + 1;j++){
            out.print(character);
        }
        out.println("<br>");
    }
%>
</body>
</html>
