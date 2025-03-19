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
<link rel="stylesheet" type="text/css" href="./index.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<div id="menu"><a href="../main.jsp">main</a></div>
	<%
		request.setCharacterEncoding("UTF-8");
		HobbyDao hobbyDao = new HobbyDao();
	    Long id = hobbyDao.getMaxId() + 1;
		String hobby = request.getParameter("hobby");
		String customerId = request.getParameter("customerId");
		if(hobby == null || customerId == null){
			out.println("값을 입력하세요.");
			return;
		}
		HobbyDto dto = null;
		try {
			dto = new HobbyDto(
				id, 
				Long.parseLong(customerId), 
				hobby
			);
		} catch (Exception e) {
			out.println("Invalid input");
			return;
		}
		if(dto != null) {
			hobbyDao.insert(dto);
		}
		out.println("취미 입력 완료");
	%>
</body>
</html>
