package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieController
 */
@WebServlet("*.Servlet")
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieController() {
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
			
			String viewPage="main.html";
			if(command.equals("/Create.Servlet")) {
				viewPage="create.jsp";
				String name = request.getParameter("name");
				String value = request.getParameter("value");
				Cookie cookie=new Cookie(name,value);
				cookie.setMaxAge(600);//쿠기 사용시간 설정 600초 동안 쿠키 유지
				// 0 삭제  //-1 문한대
				response.addCookie(cookie);
				

				request.setAttribute("name", cookie.getName());
				request.setAttribute("value", cookie.getValue());
				request.setAttribute("age", cookie.getMaxAge());
			}else if(command.equals("/Read.Servlet")) {
				Cookie cookies[] = request.getCookies();
				request.setAttribute("cookies", cookies);
				
				viewPage="read.jsp";
			}else if(command.equals("/Update.Servlet")) {
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
				
				
				viewPage="update.jsp";
				
				
			}else if(command.equals("/Delete.Servlet")) {
				viewPage="delete.jsp";
				
				Cookie cookies[] = request.getCookies();
				String delName = request.getParameter("delName");
				boolean check = false;
				
				String name = "";
				String value = "";
				for (int i = 0; i < cookies.length; i++) {
					if (delName.equals(cookies[i].getName())) {
						check = true;
						name = cookies[i].getName();
						value = cookies[i].getValue();
						cookies[i].setMaxAge(0);// 삭제됨
						response.addCookie(cookies[i]);
						
						request.setAttribute("name", name);
						request.setAttribute("value", value);
					}
				}
				request.setAttribute("check", check);				
			} 
			
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
