<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<a href="main.jsp">main</a><br>
	<%
		request.setCharacterEncoding("UTF-8");
		CustomerDao customerDao = new CustomerDao();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String height = request.getParameter("height");
		String birthday = request.getParameter("birthday");
		if(id == null || name == null || age == null || height == null || birthday == null){
			out.println("값을 입력하세요.");
			return;
		}
		CustomerDto dto = null;
		try {
			dto = new CustomerDto(
				Long.parseLong(id), 
				name, 
				Integer.parseInt(age), 
				Double.parseDouble(height), 
				LocalDateTime.parse(birthday)
			);
		} catch (Exception e){
			out.println("Invalid input");
            return;
		}
		if(dto != null) {
			customerDao.update(dto);
		}
		out.println("고객 수정 완료");
	%>
</body>
</html>
