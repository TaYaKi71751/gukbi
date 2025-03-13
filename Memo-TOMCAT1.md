# Tomcat
## [mvn create project](https://maven.apache.org/archetypes/maven-archetype-webapp/)
```shell
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.5
```
## html
### [01start.html](./java/jsp/jsp079/src/main/webapp/01start.html)
## JSP
### GET,POST
```
JSP에서 GET, POST 모두 동일하게 처리 된다.
```
### [GetServlet.jsp](./java/jsp/jsp079/src/main/webapp/GetServlet.jsp)
### JSP Tag
#### 표현식 `<%= %>`
```
화면에 출력
= 다음으로 오는 데이터를 화면에 출력
```
#### 선언식 `<%! %>`
```
전역변수나 메소드 선언시 사용
```
#### 스크립틀릿 `<% %>`
```
지역변수나 Java로직 사용
```
## Servlet
### [GetServlet](./java/jsp/jsp079/src/main/java/com/the/ex/GetServlet.java)
### [StarServlet](./java/jsp/jsp079/src/main/java/com/the/ex/StarServlet.java)
## 별찍기
### JSP
```jsp
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
    int size = Integer.parseInt(request.getParameter("size"));
    String character = request.getParameter("character");
    for(int i = 0;i < size;i++){
        for(int j = 0;j < i + 1;j++){
            out.print(character);
        }
        out.println("<br>");
    }
%>
</body>
</html>
```
### Servlet
```java
package com.the.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StarServlet
 */
@WebServlet("/StarServlet")
public class StarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String character = request.getParameter("character");
		int size = Integer.parseInt(request.getParameter("size"));
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		for(int i = 0;i < size;i++) {
			for(int j = 0;j < i + 1;j++){
				out.print(character);
			}
			out.println("<br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
```
