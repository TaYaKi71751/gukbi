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
	int a = Integer.parseInt(request.getParameter("a"));
	int b = Integer.parseInt(request.getParameter("b"));
	char operator = request.getParameter("operator").charAt(0);
	int result = 0;
	switch(operator){
	case '*':
		result = a * b;
		break;
	case '/':
		result = a / b;
		break;
	case '+':
		result = a + b;
		break;
	case '-':
		result = a - b;
		break;
	}
%>
<%=a %> <%=operator %> <%=b %> = <%=result %>
</body>
</html>