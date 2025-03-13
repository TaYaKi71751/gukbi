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
	public String strFunction(){
		return "<br>functionString<br>";
	}
%>
<%
	String str="MyString<br>";
%>


<%
	out.print(str);
/*
	나눠서 여러개로 기술할수 있다.
  	;사용하지 않음
*/
%>
<%=str %>
<%="직접출력<br>" %>
<%=50 %>
<%=50+20 %>
<%=strFunction() %>

</body>
</html>