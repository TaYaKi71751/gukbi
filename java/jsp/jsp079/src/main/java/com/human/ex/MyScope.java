package com.human.ex;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyScope
 */
@WebServlet("/MyScope")
public class MyScope extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyScope() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page  메소드안에 변수를 생성해서 사용한다.
		String page2="hello page2";
		request.setAttribute("request2", "hello request2");
		HttpSession session=request.getSession();
		session.setAttribute("session2", "hello session2");
		//getServletContext();
		ServletContext application = getServletContext();
		application.setAttribute("application2", "hello application2");
		
		System.out.println(page2);
		System.out.println((String)request.getAttribute("request2"));
		System.out.println((String)session.getAttribute("session2"));
		System.out.println((String)application.getAttribute("application2"));
		
		response.sendRedirect("scopeResult2.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
