package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet3
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookies[] = request.getCookies();
		
		String name = request.getParameter("name");
		String updateValue = request.getParameter("updateValue");
		String value = "";//기존값
		
		
		for (int i = 0; i < cookies.length; i++) {
			if(name.equals(cookies[i].getName())) {
				value = cookies[i].getValue();//기존값
				
				// 쿠키 수정
				Cookie cookie = new Cookie(name, updateValue);
				cookie.setMaxAge(600);// 쿠기 사용시간 설정 600초 동안 쿠키 유지
				response.addCookie(cookie);
				
				request.setAttribute("name", name);
				request.setAttribute("value", value);
				request.setAttribute("updateValue", updateValue);
				request.setAttribute("age", 100);
			}
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
