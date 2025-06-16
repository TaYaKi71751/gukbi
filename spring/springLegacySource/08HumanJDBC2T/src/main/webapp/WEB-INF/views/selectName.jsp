<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}
#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:hover {background-color: #ddd;}
#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
  select
  <table id='customers' width=100% border="1">
	<tr>
	    <th style="width: 10px">선택</th>
		<th style="width: 10px">name</th>
		<th style="width: 100px">age</th>
		<th style="width: 200px">height</th>
		<th style="width: 40px">birthday</th>
	</tr>
		<tr>
		    <td><a href="/ex/delete?name=${dto.name }">삭제</a></td>
			<td>${dto.name }</td>
			<td >${dto.age}</td>
			<td >${dto.height }</td>
			<td >
			<fmt:parseDate value="${dto.birthday }"
 pattern="yyyy-MM-dd'T'HH:mm"
 var="now" type="both" />
			<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value= "${now}"/></td>
		</tr>
	</table>
	<a href='/ex/update?name=${dto.name }&age=${dto.age }&height=${dto.height }&
	birthday=<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value= "${now}"/>' >수정</a>
<!--
시간문자열이  2024-04-05T10:10:00 이면 2024-04-05T10:10으로
2024-04-05T10:10:01 이면 2024-04-05T10:10:01으로 날라와서
시간 문자열 오류가 발생할 수 있다.
  -->	 

</body>
</html>
