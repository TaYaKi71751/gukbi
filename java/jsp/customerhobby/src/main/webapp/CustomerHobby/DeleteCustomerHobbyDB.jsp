<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.stream.*"%>
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
				HobbyDao hobbyDao = new HobbyDao();
				CustomerHobbyDao customerHobbyDao = new CustomerHobbyDao();
				ArrayList<CustomerHobbyDto> dtos = customerHobbyDao.selectCustomerHobbys();
				ArrayList<Long> customerIds = new ArrayList<>();
				for(CustomerHobbyDto dto:dtos){
				    for(String id:ids){
								    Long hobbyId = null;
												try {
												    hobbyId = Long.parseLong(id);
												} catch(Exception e){
												    out.println("Invalid input");
																return;
												}
												if(hobbyId == dto.getHobby().getId()){
												    customerIds.add(dto.getCustomer().getId());
												}
								}
				}
				for(Long customerId:customerIds){
				    ArrayList<CustomerHobbyDto> _dtos = dtos.stream().filter(dto -> dto.getCustomer().getId() == customerId).collect(Collectors.toCollection(ArrayList::new));
								_dtos = _dtos.stream().filter(dto -> {
								    for(String id:ids){
								        Long hobbyId = null;
												    try {
												        hobbyId = Long.parseLong(id);
												    } catch(Exception e){
																				return false;
												    }
												    if(hobbyId == dto.getHobby().getId()){
																    return false;
												    }
												}
												return true;
								}).collect(Collectors.toCollection(ArrayList::new));
								if(_dtos.size() == 0){
								    customerHobbyDao.deleteCustomerHobbys(customerId);
								}
				}
				for(String id:ids){
				    Long hobbyId = null;
								try {
								    hobbyId = Long.parseLong(id);
								} catch(Exception e) {
								    out.println("Invalid input");
												return;
								}
								if(hobbyId != null){
								    hobbyDao.delete(hobbyId);
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
