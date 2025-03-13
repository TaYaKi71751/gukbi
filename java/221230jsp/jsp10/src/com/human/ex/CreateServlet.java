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
 * Servlet implementation class CookieSevlet1
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 생성 작업순서
		//1. 클라이언트에서 쿠키생성작업 페이지를 호출한다.
		//2. 쿠기생성 작업 페이지에서 쿠키를 만든다.
		//3. response객체에 담아서 클라이언트에 저장한다.
		// 쿠키 생성
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		Cookie cookie=new Cookie(name,value);
		cookie.setMaxAge(600);//쿠기 사용시간 설정 600초 동안 쿠키 유지
		// 0 삭제  //-1 문한대
		response.addCookie(cookie);
		
//		PrintWriter out=response.getWriter();
//		response.setContentType("text/html");
//		out.println("<html>");
//		out.println("<body>");
//		out.println(cookie.getName()+"<br>");
//		out.println(cookie.getValue()+"<br>");
//		out.println(cookie.getMaxAge()+"<br>");
//		out.println("</body>");
//		out.println("</html>");
		request.setAttribute("name", cookie.getName());
		request.setAttribute("value", cookie.getValue());
		request.setAttribute("age", cookie.getMaxAge());
		RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
