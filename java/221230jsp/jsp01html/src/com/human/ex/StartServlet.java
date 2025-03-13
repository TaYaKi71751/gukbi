package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StartServlet
 */
@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StartServlet() {
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
		out.println("hello servlet1<br>");
		int sum=0;
		for(int i=1;i<10;i++) {
			out.println(String.format("sum=%d<br>", sum=sum+i));
		}
		out.println("<img src='img/k.jpg'>");
		out.println("<a href='sub/c.html'>서브 페이지</a>");
		//c.html sub페이지를 만들어 왔다갔다 하게 해보자.
		
		//3가지 방법(html,jsp,servlet)으로 본인이름 출력 하는 페이지를 만들고
		//메인 페이지에서 3가지 방법이 sub페이지로 관리 되도록 페이지를 만들어 보자.
		//관리되는 페이지란? main페이지에서 sub페이지로 이동하고 sub페이지에서 
		//main페이지로 이동할수 있는 상태를 의미한다.

		//관리페이지도 3가지방법(html,jsp,servlet)으로 3개 만들자.
		//프로젝트 이름은 jsp02로 하자.
		//총페이지 개수는 6개가 된다.
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
