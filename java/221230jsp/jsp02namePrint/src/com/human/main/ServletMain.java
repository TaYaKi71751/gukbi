package com.human.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletmain")
public class ServletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletMain() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("화면에 찍힘");
		//브라우저 스트림에 문자열을 찍으면 브라우저에 나타나다.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("servletMain 페이지<br>");
		out.println("<a href='sub/myname.html'>htmlSub</a>으로 이동<br>");
		out.println("<a href='sub/myname.jsp'>jspSub</a>으로 이동<br>");
		out.println("<a href='myname'>servletSub</a>으로 이동<br>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
