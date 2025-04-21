<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


(스크릿틀립)<br>
설명 : <%=request.getParameter("name") %><br>
숫자1 :<%=request.getParameter("num1") %> <br>
숫자2 : <%=request.getParameter("num2") %><br>
(EL방식)<br>
설명 : ${param.name }<br>
숫자1 :${param.num1} <br>
숫자2 :${param.num2 } <br>


사용자 입력 즁 <br>
한개의 데이터는 param에 받고 여러개의 데이터는 paramValues로 받는다.
아이디:${param.id }:${param["id"] }<br>

선택한동물:${paramValues.animal[0]}<br>
${paramValues.animal[1]}<br>
${paramValues.animal[2]}<br>

${paramValues['animal'][0] }<br>
${paramValues['animal'][1] }<br>
${paramValues['animal'][2] }<br>

나중에 jstl배워서 반복문으로 출력하면 유동적인 데이터를 처리할 수 있다.
<br>


empty 널인지 비어 있는지 확인하여 true,false값이 리턴
 	<%
	   request.setAttribute("str1", null);
	   request.setAttribute("str2", "hello");
	%>

	${empty str1}==true
	${empty str2}==false
	${not empty str2}==true
	

(스크릿틀립)<br>
<%= request.getParameter("name") == null ? false : request.getParameter("name").equals("park") %><br>
(EL방식)<br>
EL ==연산자 사용 결과 : ${param.name=="park" }<br>

null를 넣었을때<br>
request null : <%=request.getParameter("id") %><br>
EL null : ${param.id }<br>

(스크릿틀립)<br>
넘어온값 연산<br>
<br>
<%
	Integer num1 = null;
	Integer num2 = null;
try{
	num1=Integer.parseInt(request.getParameter("num1")); 
	num2=Integer.parseInt(request.getParameter("num2")); 
} catch(Exception e){

}
%>
<%=num1 %>+<%=num2 %>=<%= num1 != null && num2 != null ? num1 + num2 : 0 %> <br>
el 사용한 방법<br>
${param.num1 }+${param.num2 }=${param.num1+parma.num2 }<br>


 
</body>
</html>


















