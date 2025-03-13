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
	String data1=request.getParameter("data1");
	String []data2=request.getParameterValues("data2");
	//브라우저 스트림에 문자열을 찍으면 브라우저에 나타나다.
	//response.setContentType("text/html; charset=UTF-8");
	//PrintWriter out=response.getWriter();
	//내장 객체를 이용해서 많이 사용하는 객체는 미리 선언해 놓고 사용한다.
	//out은 내장 객체여서 선언할 필요가 없다.
	//request response session pageContext out application
	//config page exception
	/* out.println("<html>");
	out.println("<body>");
	out.println("data1값은 :<br>");
	out.println( data1+" <br>");
	out.println("data2값은 :");
	if(data2!=null) {
		for(String str:data2) {
			out.println( str+" <br>");
		}		
	}else {
		out.println("값이 없음 <br>");	
	}
	out.println("</body>");
	out.println("</html>"); */
%>
	data1값은 :<br>
	<%=data1 %> <br>
	data2값은 :<br>
	<%
	if(data2!=null) {
		for(String str:data2) {
	%>
			 <%=str  %> <br>
	<%
		}		
	}else {
	%>
		값이 없음 <br>
	<%	
	}
	%>
</body>
</html>