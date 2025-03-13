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
//읽어오기 
/*
  값을 모두 삭제하기 위해서 크롬을 모두 닫은다음에 톰켓 서버를 제시작 한다.
*/
out.println((String)pageContext.getAttribute("page1"));
out.println((String)request.getAttribute("request1"));
out.println((String)session.getAttribute("session1"));
out.println((String)application.getAttribute("application1"));
%>
</body>
</html>