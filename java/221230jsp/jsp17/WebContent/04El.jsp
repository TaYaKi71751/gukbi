<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
EL에서 scope별 접근방법
scope 		특정 객체의 생명주기
page 		해당 패이지에서만 사용할수 있는 객체
request		요청이 종료될때까지 사용할 수 있는 객체
session		특정 유저만 사용할수 있는 객체
application	모든 유저가 사용할 수 있는 객체

<%
pageContext.setAttribute("name","page Name1");
request.setAttribute("name","page Name2");
session.setAttribute("name","page Name3");
application.setAttribute("name","page Name4");
%>
 page 속성: ${pageScope.name }<hr>
 request 속성 : ${requestScope.name }<hr>
 session 속성 : ${sessionScope.name }<hr>
 application 속성 : ${applicationScope.name }<hr>
 name : ${name }<hr>
 
 scop 객체 없이 키만 기술하면 page,request,session,application순으로 검색됨
 사용하지 않을것을 권장



	<%
		com.human.ex.Human human=new com.human.ex.Human("park",16);
		request.setAttribute("data",human);
		
	%>
	
	EL<br>
	 ${requestScope.data.name }<br>
	 ${requestScope.data.age }<br>
	 
	 ${human.name }<br>
	 ${human.age }<br>
 
</body>
</html>


















