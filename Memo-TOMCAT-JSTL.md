# Tomcat
## fmt
### fmt:requestEncoding
```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
```
### fmt:parseDate
```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:parseDate value="<%=java.time.LocalDateTime.now().withNano(0).toString()%>"
 pattern="yyyy-MM-dd'T'HH:mm:ss"
 var="now" type="both" />
```
### fmt:formatDate
```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:parseDate value="<%=java.time.LocalDateTime.now().withNano(0).toString()%>"
 pattern="yyyy-MM-dd'T'HH:mm:ss"
 var="now" type="both" />
<fmt:formatDate value="${now }"></fmt:formatDate>
date :<fmt:formatDate value="${now }" type="date"/>
time :<fmt:formatDate value="${now }" type="time"/>
both :<fmt:formatDate value="${now }" type="both"/>


	
pattern="yyyy년 MM월 dd일 hh시 mm분 ss초" :
<fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"></fmt:formatDate>
```
### fmt:formatNumber
#### type="number"
```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:formatNumber value="1234567.899" pattern="#,#00.0#"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.89" pattern="#,#00.0#"></fmt:formatNumber><br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"></fmt:formatNumber><br>
<fmt:formatNumber value="10000" type="number"></fmt:formatNumber><br>
<%-- pattern 에서 #은 해당 자릿수가 0일때 0을 표시하지 않음  --%>
<%-- pattern 에서 0은 해당 자릿수가 0일때 0을 표시함  --%>
```
#### type="currency"
```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
통화(currency) : <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
날짜 : <fmt:formatDate value="${now }"></fmt:formatDate>
<fmt:setLocale value="ja_jP"></fmt:setLocale>
ja_jP 기본 로케일 : <%=response.getLocale() %>
통화(currency) : <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
날짜 : <fmt:formatDate value="${now }"></fmt:formatDate>
<fmt:setLocale value="en_US"></fmt:setLocale>
en_US 기본 로케일 : <%=response.getLocale() %>
통화(currency) : <fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
```
#### type="percent"
```jsp
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:formatNumber value="10000" type="percent"></fmt:formatNumber><br>
```
