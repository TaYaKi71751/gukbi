<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  EL getParameter 처리방법 -->
<form method="get" action="03param.jsp">
<br>		설명  : <input type="text" name="name">
<br>		숫자1:<input type="text" name="num1">
<br>		숫자2:<input type="text" name="num2">
<br> 		<input type="submit" value="로그인">
</form>

<form action="03param.jsp">
	아이디:<input type="text" name="id"><br>
	다음중 회원이 키우고 있는 애완동물을 선택하십시오
	개:<input type="checkbox" name="animal" value="dog">
	고양이:<input type="checkbox" name="animal" value="cat">
	금붕어:<input type="checkbox" name="animal" value="fish">
	<input type="submit" value="send">
</form>

</body>
</html>











