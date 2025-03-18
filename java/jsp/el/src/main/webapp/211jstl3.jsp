<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String[] movieList={"아바타","ET","공주는 외로워","쥬라기공원"};
	pageContext.setAttribute("movieList", movieList);
%>
<c:forEach var="movie" items="${movieList }">
	${movie }<br>
</c:forEach>
<br>
<table border="1" style="width:100%;text-align:center;">
<tr>
	<th>index</th><th>count</th><th>title</th>
</tr>
<c:forEach var="movie" items="${movieList }" varStatus="status">
	<tr>
		<td>${status.index}</td><td>${status.count }</td><td>${movie }</td>
	</tr>
</c:forEach>
</table>
<br>
<ul>
	<c:forEach var="movie" items="${movieList }" varStatus="status">
		<c:choose>
			<c:when test="${status.first }">
				<li style="font-weight:bold;color:red;">${movie }</li>
			</c:when>
			<c:when test="${status.last }">
				<li style="font-weight:bold;color:blue;">${movie }</li>
			</c:when>
			<c:otherwise>
				<li style="font-weight:bold;color:yellow;">${movie }</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</ul>

<br>
<c:forEach var="movie" items="${movieList }" varStatus="status">
	${movie }<c:if test="${not status.last }">,</c:if>		
</c:forEach>
<br>
<c:forEach var="cnt" begin="0" end="10" varStatus="status">
	${status.index }:${cnt }<c:if test="${not status.last }">,</c:if>
</c:forEach>
<br>
<c:forEach var="cnt" begin="7" end="10" varStatus="status">
${status.index }:${status.count }:${cnt }<c:if test="${not status.last }">,</c:if>	
</c:forEach>
<br>
<c:forEach var="cnt" begin="2" end="10" varStatus="status" step="2">
${status.index }:${status.count }:${cnt }<c:if test="${not status.last }">,</c:if>	
</c:forEach>
<br>

<br>


<c:forTokens var="city" items="서울.인천,대구.부산" delims=",">
	${city }<br>
</c:forTokens>
<c:forTokens var="city" items="서울.인천,대구.부산" delims=",.">
	${city }<br>
</c:forTokens>
<hr><hr><hr>

<hr><hr><hr>
	<c:url value="images/pic.jpg" var="data"/>
	<h3>${data }</h3>
	<img src="${data }" width="100%" height="100%">
<hr>

<%--
  <c:redirect url="http://www.google.com"></c:redirect>	
--%>
</body>
</html>















