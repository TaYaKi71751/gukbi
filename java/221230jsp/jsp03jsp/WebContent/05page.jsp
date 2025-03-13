<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//page 지시자는 현재 페이지 정보나 특정 클래스를 import할때 사용한다.
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//page지시자로 임포트하여 줄여서 출력하였다.
String formatDate = LocalDateTime.now()
		.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
String formatDate2 = java.time.LocalDateTime.now()
	.format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd"));
%>
<%=formatDate %><br>
<%=formatDate2 %>
<!--
Import java.util.Arrays;
int[] iArr = {10, 20, 30};
System.out.println( Arrays.toString(iArr) );
다음 자바코드를 jsp로 구현하시오
-->
</body>
</html>




