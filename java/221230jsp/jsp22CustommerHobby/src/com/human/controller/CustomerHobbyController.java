package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.service.CustomerHobbyService;
import com.human.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("*.customerHobby")
public class CustomerHobbyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerHobbyController() {
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
				if (command.equals("/customerHobby/insert.customerHobby")) {
					viewPage = "insert.jsp";
					System.out.println("/customerHobby/insert.customerHobby");

				} else if (command.equals("/customerHobby/insertDB.customerHobby")) {
					viewPage = "selectAll.customerHobby";
					CustomerHobbyService.insertDB(request, response);
					System.out.println("/customerHobby/insertDB.customerHobby");
				} else if (command.equals("/customerHobby/selectAll.customerHobby")) {
					viewPage = "selectAll.jsp";
					CustomerHobbyService.selectAll(request, response);
					
					System.out.println("/customerHobby/selectAll.customerHobby");
				}else if(command.equals("/customerHobby/selectOne.customerHobby")) {
					viewPage = "selectOne.jsp";
					CustomerHobbyService.selectOne(request, response);
					System.out.println("/customerHobby/selectOne.customerHobby");
				}else if(command.equals("/customerHobby/deleteCustomer.customerHobby")) {
					viewPage ="selectAll.customerHobby";
					CustomerHobbyService.deleteCustomer(request,response);
					System.out.println("/customerHobby/deleteCustomer.customerHobby");
				}else if(command.equals("/customerHobby/deleteHobby.customerHobby")) {
					viewPage ="selectAll.customerHobby";
					CustomerHobbyService.deleteHobby(request,response);
					System.out.println("/customerHobby/deleteHobby.customerHobby");
				}else if(command.equals("/customerHobby/update.customerHobby")) {
					viewPage ="selectAll.customerHobby";
					CustomerHobbyService.update(request,response);
					System.out.println("/customerHobby/update.customerHobby");
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
