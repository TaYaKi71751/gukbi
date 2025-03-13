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

String char1=request.getParameter("char1");
int num1=Integer.parseInt(request.getParameter("num1"));

for(int i=0;i<num1;i++) {
	//공간 찍기
	for(int j=i;j<num1;j++) {
%>		
		&nbsp;
<%
	}
	//별찍는 for
	for(int j=0;j<=i;j++) {
%>		
		*
<%
	}
%>
	<br>
<%
}
%>

</body>
</html>