<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.human.dao.CustomerDao" %>
<%@ page import="com.human.dto.CustomerDto" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

메뉴
<a href='insert.jsp'>입력</a>
<a href='update.jsp'>수정</a>
<a href='select.jsp'>검색</a>
<a href='delete.jsp'>삭제</a>
<br>
검색데이터<br>
<%
	CustomerDao dao=new CustomerDao();
	ArrayList<CustomerDto> dtos = 
	dao.select(request.getParameter("name"));
	if(dtos!=null){
		for(CustomerDto dto:dtos){
	out.println(dto);
	out.println("<br>");
	
		
		}
	}
	System.out.println("end");
%>

</body>
</html>




