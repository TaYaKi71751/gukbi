package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("*.customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
				if (command.equals("/customer/insert.customer")) {
					viewPage = "insert.jsp";
					

					System.out.println("/customer/insert.customer");

				} else if (command.equals("/customer/insertDB.customer")) {
					viewPage = "selectAll.customer";
					CustomerService.insertDB(request, response);
					System.out.println("/customer/insertDB.customer");
				} else if (command.equals("/customer/selectAll.customer")) {
					viewPage = "selectAll.jsp";
					CustomerService.selectAll(request, response);
					System.out.println("/customer/selectAll.customer");
				}else if(command.equals("/customer/selectOne.customer")) {
					viewPage = "selectOne.jsp";
					CustomerService.selectOne(request, response);
					System.out.println("/customer/selectOne.customer");
				}else if(command.equals("/customer/delete.customer")) {
					viewPage ="selectAll.customer";
					CustomerService.delete(request,response);
					System.out.println("/customer/delete.customer");
				}else if(command.equals("/customer/update.customer")) {
					viewPage = "update.jsp";
					CustomerService.selectOne(request, response);
					System.out.println("/customer/update.customer");
				}else if(command.equals("/customer/updateDB.customer")) {
					viewPage ="selectAll.customer";
					CustomerService.update(request, response);
					System.out.println("/customer/updateDB.customer");
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
