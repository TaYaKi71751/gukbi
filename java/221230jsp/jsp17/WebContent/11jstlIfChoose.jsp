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


<form action="12jstlIfChoose.jsp">
색생을 선택하세요<br>
	<select id="color" name="color">
		<option value="1" > 빨강</option>
		<option value="2" > 노랑</option>
		<option value="3" > 파랑</option>
	</select>
	<input type="submit" value="전송">
</form>


<form method="get" action="12jstlIfChoose.jsp">
	<input type="checkbox" name="items" value="신발">신발
	<input type="checkbox" name="items" value="가방">가방
	<input type="checkbox" name="items" value="벨트">벨트
	<input type="checkbox" name="items" value="모자">모자
	<input type="checkbox" name="items" value="시계">시계
	<input type="checkbox" name="items" value="쥬얼리">쥬얼리
	<input type="submit" value="전송">
</form>


</body>
</html>















