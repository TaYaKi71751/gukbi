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
<br>
https://jakarta.apache.org/
taglib
jakarta-taglibs-standard-1.1.2.zip  

<br>
<!-- 기본 확인 -->
<!-- out은 속성 value에 값을 화면에 출력한다. -->
<c:out value="hello world!"/><br>
<c:out value="name:${param.name }"/><br>

<!-- set은 속성 value에 값을 var에 넣는다. -->
<c:set var="msg" value="hello"/>
\${msg }=${msg }<br>

<c:set var="msg" value="${name }"/>
\${msg }=${msg }<br>

<c:set var="age" value="30" />
\${age }=${age }<br>
<c:set var="age">
30
</c:set>
\${age }=${age }<br>


<c:set var="member" value="<%=new com.human.ex.Human() %>"/>
<c:set target="${member }" property="name" value="홍길동"/>
<c:set target="${member }" property="age" value="15"/>
\${member } = ${member } <hr>
\${member.age} = ${member.age } <hr>
 
<c:set var="add" value="${10+5 }"/>
\${add }=${add }<br>
<c:set var="flag" value="${20>5}"/>
\${flag}=${flag }<br>

</body>
</html>










