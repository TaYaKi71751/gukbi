<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<% {
    String resetCookie = request.getParameter("resetCookie");
    if(resetCookie != null){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i = 0;i < cookies.length;i++){
                Cookie cookie = new Cookie(cookies[i].getName(),"");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
} %>
<% {
    String resetCookie = request.getParameter("resetCookie");
    if(resetCookie == null){
        String lang = request.getParameter("lang");
        if(lang != null){
            Cookie cookie = new Cookie("lang", lang);
            response.addCookie(cookie);
            response.sendRedirect(lang);
        }
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(int i = 0;i < cookies.length;i++){
                if(cookies[i].getName().equals("lang")){
                    if(cookies[i].getValue() != null && !cookies[i].getValue().isEmpty()){
                        response.sendRedirect(cookies[i].getValue());
                    }
                }
            }
        }
    }
} %>
<form action="Language.jsp" method="get">
    <input type="radio" name="lang" value="kor.jsp">한국어
    <input type="radio" name="lang" value="eng.jsp">영어
    <input type="submit" value="Submit">
</form>
</body>
</html>