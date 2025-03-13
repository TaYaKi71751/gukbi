package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//@WebServlet("sub/myname")  중간에 /를 사용하면 안된다.
//@WebServlet("myname")		/으로 시작해야 한다.
@WebServlet("/myname")
public class MyName extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MyName() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("화면에 찍힘");
		//브라우저 스트림에 문자열을 찍으면 브라우저에 나타나다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("servletSubPage에서 에서 나의 이름은 홍길동 입니다.<br>");
		out.println("<a href='main/htmlmain.html'>htmlMain으로 이동</a><br>");
		out.println("<a href='main/jspmain.jsp'>jspMain으로 이동</a><br>");
		out.println("<a href='servletmain'>servletMain으로 이동</a><br>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
