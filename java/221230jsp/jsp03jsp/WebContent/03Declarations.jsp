<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
// 클래스 맴버로 사용되 함수나 클래스 변수를 선언 할때 사용
	String str1="1";
%>

<%
	String str2="1";

	str1=str1+"1";
	str2=str2+"1";

%>
<%=str1 %>
<br>
<%=str2 %>
</body>
</html>


