package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet3
 */
@WebServlet("/CookieServlet3")
public class CookieUpdateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieUpdateDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//쿠키 수정  : 같은 키값에 새로운 이름을 넣는다.
		Cookie cookie=new Cookie("name1","newPsm1");
		cookie.setMaxAge(600);//쿠기 사용시간 설정 600초 동안 쿠키 유지
		response.addCookie(cookie);
		
		//쿠키 삭제
		cookie=new Cookie("name","newPsm1");
		cookie.setMaxAge(0);//삭제됨
		response.addCookie(cookie);
		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(cookie.getName()+"<br>");
		out.println(cookie.getValue()+"<br>");
		out.println(cookie.getMaxAge()+"<br>");
		out.println("</body>");
		out.println("</html>");
		
		//쿠키관리 프로그램
		//프로젝트명 : jsp10
		// main페이지에서 관리된는 웹어플리케이션으로 만들어 보자.
		// create read update delete 페이지로 이동하여
		// 해당 작업을 할 수 있도록 구현한다.
		// 최종결과는 request객체에 담아서 .jsp로 출력하자.
		// 원하는 쿠키를 생성, 삭제, 검색, 수정 가능하여야 한다.
		// 모든 사용자 요청 주소는 서블릿으로 오도록 구현한다.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
