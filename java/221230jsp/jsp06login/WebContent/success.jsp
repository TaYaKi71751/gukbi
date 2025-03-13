<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	로그인 성공 페이지
	<br>
	<%
		if(request.getAttribute("id")==null){
			//response.sendRedirect("/jsp06login/login.jsp?isLogin=false");
			out.println("<script>location.href='/jsp06login/login.jsp?isLogin=false'</script>");
		}
	%>
	<%=request.getAttribute("id") %>님이 로그인 하였습니다.
</body>
</html>