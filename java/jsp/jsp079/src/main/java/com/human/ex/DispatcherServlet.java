package com.human.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request객체에 사용자가 원하는 데이터를 담을 수 있다.
		 * setAttribute(key,value)를 이용하여 데이터를 담는다.
		 * getAttribute(key)를  이용하여 데이터를 읽어 온다.
		 */
		request.setAttribute("name", "홍길동");
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("03dispatcer.jsp");
		dispatcher.forward(request,response);
		//forward이후에 이부분의 코드는 의미가 없다.
		
		
		/*
		 * 사용자의 아이디와 비밀번호를 입력받아(java1,1234)(java2,2345) 
		 * 틀리면 입력페이지(04login.html)로 redirect하고 
		 * 맞으면  success.jsp로 forward하여 성공 메시지와 사용자 이름을 출력하시오.
		 * 서블릿은 LoginServlet으로 한다.
		 * 프로젝트 이름은 jsp06login으로 한다.
		
		 * 
		 * 체크 박스에서 꽃이름을 선택하여 선택된 이미지들을 화면에 출력해 보자.
		 * 
		 * 
		 *  
		 * 숫자 2개 연산자 1개를 입력 받아서 연산결과를 화면에 출력하는 
		 * 프로그램을 구현해 보자.
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
