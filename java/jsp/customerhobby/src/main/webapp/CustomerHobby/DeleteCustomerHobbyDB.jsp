<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.time.*"%>
<%@ page import="com.the.dao.*"%>
<%@ page import="com.the.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String[] ids = request.getParameterValues("id");
				if(ids == null || ids.length == 0){
				    out.println("값을 입력하세요.");
								return;
				}
				CustomerHobbyDao customerHobbyDao = new CustomerHobbyDao();
				for(String id:ids){
				    Long customerId = null;
								try {
								    customerId = Long.parseLong(id);
								} catch(Exception e) {
								    out.println("Invalid input");
												return;
								}
								if(customerId != null){
								    customerHobbyDao.deleteCustomerHobbys(customerId);
								}
				}

				out.println("고객 및 취미 삭제 완료");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./index.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DeleteCustomerDB</title>
</head>
<body>
	<div id="menu"><a href="../main.jsp">main</a></div>

</body>
</html>
