<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
scope 영역별 데이터 등록<br>
<%
//scope종류
//1. page  해당 페이지에서만 접근가능    pageContext
pageContext.setAttribute("page1", "hello page");
//2. request 요청이 종료할때 까지 값을 유지 request
request.setAttribute("request1", "hello request");
//3. session 같은 사용자일때만 값을 유지  session
session.setAttribute("session1","hello session");
//4. application 모든 사용자가 값을 유지 application
application.setAttribute("application1", "hello application");

//읽어오기 
out.println((String)pageContext.getAttribute("page1"));
out.println((String)request.getAttribute("request1"));
out.println((String)session.getAttribute("session1"));
out.println((String)application.getAttribute("application1"));

//리다이렉트
response.sendRedirect("scopeResult.jsp");
//forword
/*  RequestDispatcher dispatcher=request.getRequestDispatcher("scopeResult.jsp");
		dispatcher.forward(request, response);  */
%>
</body>
</html>




