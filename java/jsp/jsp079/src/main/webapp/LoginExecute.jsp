<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    String user_id = request.getParameter("user_id");
    String user_pw = request.getParameter("user_pw");

    // 로그인 성공 여부
    boolean isLoginSuccess = false;

    // 로그인 성공시
    if("java".equals(user_id) && "1234".equals(user_pw)){
        isLoginSuccess = true;
    }

    // 로그인 실��시
    if(isLoginSuccess){
        session.setAttribute("user_id", user_id);
        session.setMaxInactiveInterval(6000); // 100분간 로그인 유지
        response.sendRedirect("sessionsuccess1.jsp");
    } else {
        response.sendRedirect("sessionlogin1.jsp");
    }
%>
</body>
</html>