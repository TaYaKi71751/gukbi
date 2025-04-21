package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("*.Servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				// URI:/jsp10/hello.do
				// conPath:/jsp10
				// command:/hello.do
				String uri = request.getRequestURI();
				System.out.println("URI:" + uri);
				// 원하는 수소에 대한 처리 방법
				String conPath = request.getContextPath();
				System.out.println("conPath:" + conPath);

				String command = uri.substring(conPath.length());
				System.out.println("command:" + command);

				String viewPage = "sessionlogin.jsp";
				if (command.equals("/Login.Servlet")) {
					viewPage = "sessionsuccess.jsp";
					String user_id= request.getParameter("user_id");
					String user_pw= request.getParameter("user_pw");
					if(user_id.trim().equals("java")&&user_pw.trim().equals("1234")) {
						HttpSession session=request.getSession();
						session.setAttribute("user_id",user_id);
						session.setMaxInactiveInterval(600);
					} else {
						viewPage="sessionlogin.jsp";
						//response.sendRedirect("login.jsp?isSuccess=false");
						//foword와 같이 사용하면 문제가 발생한다.
					}
					System.out.println("Login.Servlet");

				} else if (command.equals("/Logout.Servlet")) {
					viewPage = "sessionlogin.jsp";
					HttpSession session=request.getSession();
					session.invalidate();
					
					System.out.println("Logout.Servlet");

				} 
				System.out.println(viewPage);
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
