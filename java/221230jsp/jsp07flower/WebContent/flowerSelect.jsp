<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
출력을 원하는 꽃을 선택하세요.
<form action="FlowerServlet" method="get">
	<input type="checkbox" name="flower" value="cosmos.png">코스모스
	<input type="checkbox" name="flower" value="rose.jpg">장미
	<input type="checkbox" name="flower" value="sunflower.jpg">해바라기
	<input type="submit" value="확인">
</form>

</body>
</html>