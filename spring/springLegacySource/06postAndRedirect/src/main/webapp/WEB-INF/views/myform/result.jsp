<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	get과 post 값 출력
</h1>

<P>  get value ${getId }</P>
<P>  post value ${postId }</P>
404 요청한 주소가 없을때 발생<br>
500 자바문법 에러<br>
405 잘못된 전송방식<br>
<br>

</body>
</html>