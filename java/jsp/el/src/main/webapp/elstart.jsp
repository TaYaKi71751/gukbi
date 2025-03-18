<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!-- 표현어 EL expression language -->
${"hello"}<br>
<%="hello"%> 표현식<br>
<% out.println("hello"); %> 스크립틀릿<br>

<!-- EL로 표시할 수 있는 자료형 -->
정수형 : ${10}<br>
실수형 : ${20.3}<br>
문자형 : ${"park"}<br>
논리형 : ${true}<br>
null  :${null}<br>
표현식이나 스크립틀릿에서는 null을 표시하지만 EL에서는 null을 표시하지 않는다.<br>
<!-- el 연산 -->
\${5+2} = ${5+2}<br>
\${5/2} = ${5/2}<br>
\${5 div 2} = ${5 div 2}<br>
\${5 mod 2} = ${5 mod 2}<br>
\${5>2} = ${5>2}<br>
\${2 gt 10} = ${2 gt 10}<br>
\${5>2?5:2} = ${5>2?5:2}<br>
\${(5>2)||(2<10)} = ${(5>2)||(2<10)}<br>



</body>
</html>