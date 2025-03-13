<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	if(<%=request.getParameter("isSuccess") %>==false){
		alert('아이디를 잘못입력하였습니다.');
	}
	if(<%=request.getParameter("isLogin") %>==false){
		alert('로그인이 해야 사용할수 있습니다.');
	}
</script>
</head>
<body>
로그인<br>
<form action="LoginServlet" method="post">
	id : <input type="text" name="id"><br>
	password: <input type="password" name="pw"><br>
	<input type="submit" value="전송">
</form>
</body>
</html>