package com.the.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServlet
 */
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청에 대한 한글처리
		//사용자 입력 한글 깨짐 처리를 위한 인코딩
		request.setCharacterEncoding("UTF-8");
		
		String data1=request.getParameter("data1");
		String []data2=request.getParameterValues("data2");
		//브라우저 스트림에 문자열을 찍으면 브라우저에 나타나다.
		//응답에 대한 한글처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("data1값은 :<br>");
		out.println( data1+" <br>");
		out.println("data2값은 :");
		if(data2!=null) {
			for(String str:data2) {
				out.println( str+" <br>");
			}		
		}else {
			out.println("값이 없음 <br>");	
		}
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost 시작");
		doGet(request, response);
		System.out.println("doPost 종료");
	}

}







