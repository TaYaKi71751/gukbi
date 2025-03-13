package com.human.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.cal.CalClass;

/**
 * Servlet implementation class CalculatorEx
 */
@WebServlet("/CalculatorEx")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		myCalculator(request,response);
		
		
	}
	
	public void myCalculator(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
			request.setCharacterEncoding("utf-8");
			
			double num1 
				=Double.parseDouble(request.getParameter("num1"));
			double num2 
				=Double.parseDouble(request.getParameter("num2"));
			String operator	
				=request.getParameter("operation");
			
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("num1,num2 계산 결과<br>");
			/*if(operator.equals("+")) {
				out.println(num1+"+"+num2+"="+(num1+num2));
			}else if(operator.equals("-")) {
				out.println(num1+"-"+num2+"="+(num1-num2));
			}else if(operator.equals("*")) {
				out.println(num1+"*"+num2+"="+(num1*num2));
			}else if(operator.equals("/")) {
				out.println(num1+"/"+num2+"="+(num1/num2));
			}*/
			CalClass calClass=new CalClass();
			calClass.setNum1(num1);
			calClass.setNum2(num2);
			calClass.setOperator(operator);
			System.out.println(calClass);
			out.println(calClass);
			//주소가 리턴 toString제정의하면 제정의한 문자열이 리턴
			out.println(calClass.resultString());
			//10+20=30
			out.println("</body>");
			out.println("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


























