package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.service.CustomerHobbysService;
import com.human.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("*.customerHobbys")
public class CustomerHobbysController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerHobbysController() {
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
				
				String viewPage = "selectAll.jsp";
				//http://localhost:8081/jsp20CustommerHobby/customer/insert.customer
				if (command.equals("/customerHobbys/insert.customerHobbys")) {
					viewPage = "insert.jsp";
					System.out.println("/customerHobbys/insert.customerHobbys");

				}else if (command.equals("/customerHobbys/insertDB.customerHobbys")) {
					viewPage = "selectAll.customerHobbys";
					CustomerHobbysService.insertDB(request, response);
					System.out.println("/customerHobbys/insertDB.customerHobbys");
				} else if (command.equals("/customerHobbys/selectAll.customerHobbys")) {
					viewPage = "selectAll.jsp";
					CustomerHobbysService.selectAll(request, response);
					
					System.out.println("/customerHobbys/selectAll.customerHobbys");
				}else if(command.equals("/customerHobbys/deleteHobby.customerHobbys")) {
					viewPage ="selectAll.customerHobbys";
					CustomerHobbysService.deleteHobby(request,response);
					System.out.println("/customerHobbys/deleteHobby.customerHobbys");
				}else if(command.equals("/customerHobbys/deleteCustomer.customerHobbys")) {
					viewPage ="selectAll.customerHobbys";
					CustomerHobbysService.deleteCustomer(request,response);
					System.out.println("/customerHobbys/deleteCustomer.customerHobbys");
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
