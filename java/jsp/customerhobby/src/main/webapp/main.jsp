<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
	<h1>메인 메뉴</h1>
	<div id="customer">
		<a href="Customer/SelectCustomer.jsp">SelectCustomer</a>
		<a href="Customer/InsertCustomer.jsp">InsertCustomer</a>
		<a href="Customer/UpdateCustomer.jsp">UpdateCustomer</a>
		<a href="Customer/DeleteCustomer.jsp">DeleteCustomer</a>
	</div>
	<div id="hobby">
		<a href="Hobby/SelectHobby.jsp">SelectHobby</a>
		<a href="Hobby/InsertHobby.jsp">InsertHobby</a>
		<a href="Hobby/UpdateHobby.jsp">UpdateHobby</a>
		<a href="Hobby/DeleteHobby.jsp">DeleteHobby</a>
	</div>
	<div id="customerhobby">
		<a href="CustomerHobby/SelectCustomerHobby.jsp">SelectCustomerHobby</a>
		<a href="CustomerHobby/DeleteCustomerHobby.jsp">DeleteCustomerHobby</a>
	</div>
</body>
</html>
