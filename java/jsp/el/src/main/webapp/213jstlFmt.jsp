<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>

<c:set var="now" value="<%=java.time.LocalDateTime.now()%>"></c:set>
\${now } : ${now }

<fmt:parseDate value="<%=java.time.LocalDateTime.now().withNano(0).toString()%>"
 pattern="yyyy-MM-dd'T'HH:mm:ss"
 var="now" type="both" />

<fmt:formatDate value="${now }"></fmt:formatDate>
date :<fmt:formatDate value="${now }" type="date"/>
time :<fmt:formatDate value="${now }" type="time"/>
both :<fmt:formatDate value="${now }" type="both"/>


	
pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" :
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"></fmt:formatDate>
</pre>


<%
	java.time.LocalDateTime ld=java.time.LocalDateTime.now().withNano(0);
	request.setAttribute("ld", ld);
%>
<hr>
-${requestScope.ld }-
<fmt:parseDate value="${requestScope.ld }"
 pattern="yyyy-MM-dd'T'HH:mm:ss"
 var="now" type="both" />
<hr>
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"></fmt:formatDate>
<hr>
<!-- 2일차 -->

default : <c:out value="${now }"></c:out>
Korea KST : <fmt:formatDate value="${now }" type="both" dateStyle="full" 
				timeStyle="full"></fmt:formatDate>
<fmt:timeZone value="GMT">
Swiss GMT : <fmt:formatDate value="${now }" type="both" dateStyle="full" 
				timeStyle="full"></fmt:formatDate>
</fmt:timeZone>
<fmt:timeZone value="GMT-8">
NewYork GMT-8 : <fmt:formatDate value="${now }" type="both" dateStyle="full" 
				timeStyle="full"></fmt:formatDate>
</fmt:timeZone>

로케일 사용자 사용환경을 확인할 수있다.
톰캣 서버의 기본 로케일 : <%=response.getLocale() %>
<fmt:setLocale value="ko_kr"/>
ko_kr 기본 로케일 : <%=response.getLocale() %>

통화(currency) : <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
날짜 : <fmt:formatDate value="${now }"></fmt:formatDate>
<fmt:setLocale value="ja_jP"></fmt:setLocale>
ja_jP 기본 로케일 : <%=response.getLocale() %>
통화(currency) : <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
날짜 : <fmt:formatDate value="${now }"></fmt:formatDate>
<fmt:setLocale value="en_US"></fmt:setLocale>
en_US 기본 로케일 : <%=response.getLocale() %>
통화(currency) : <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
날짜 : <fmt:formatDate value="${now }"></fmt:formatDate>

<!-- 인코딩 -->
<fmt:requestEncoding value="utf-8"/>
<test></test>
<test/>



<fmt:formatNumber value="10000" type="currency"/><br>
<fmt:formatNumber value="10000" type="number"></fmt:formatNumber><br>
<fmt:formatNumber value="10000" type="percent"></fmt:formatNumber><br>
<hr>
<fmt:formatNumber value="1234567.89"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.89" type="number">
</fmt:formatNumber><br>
<fmt:formatNumber value="1234567.89" type="number" groupingUsed="false">
</fmt:formatNumber><br>
<hr>
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"></fmt:formatNumber><br>
<fmt:formatNumber value="10000" type="number"></fmt:formatNumber><br>
<fmt:formatNumber value="0.5" type="percent"></fmt:formatNumber><br>
<hr>
<fmt:formatNumber value="1234567.89"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.899" pattern="#,#00.0#"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.89" pattern="#,#00.0#"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.8" pattern=".000"></fmt:formatNumber><br>

</body>
</html>
