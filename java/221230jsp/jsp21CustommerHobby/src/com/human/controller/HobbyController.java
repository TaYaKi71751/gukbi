package com.human.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.service.HobbyService;
import com.human.util.DBConn;

/**
 * Servlet implementation class HobbyController
 */
@WebServlet("*.hobby")
public class HobbyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HobbyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		String viewPage = "selectAll.jsp";
		if (command.equals("/hobby/insert.hobby")) {
			viewPage = "insert.jsp";
			HobbyService.insert(request,response);

			System.out.println("insert.hobby");

		} else if (command.equals("/hobby/insertDB.hobby")) {
			viewPage = "selectAll.hobby";
			HobbyService.insertDB(request, response);
			System.out.println("insertDB.hobby");

		} else if (command.equals("/hobby/selectAll.hobby")) {
			viewPage = "selectAll.jsp";
			HobbyService.selectAll(request, response);
			System.out.println("select.hobby");

		} else if (command.equals("/hobby/selectOne.hobby")) {
			viewPage = "selectOne.jsp";
			HobbyService.selectOne(request, response);
			System.out.println("select.hobby");

		} else if (command.equals("/hobby/delete.hobby")) {
			viewPage = "selectAll.hobby";
			HobbyService.delete(request,response);
			System.out.println("delete.hobby");
		} else if (command.equals("/hobby/update.hobby")) {
			viewPage = "update.jsp";
			HobbyService.selectOne(request, response);
			System.out.println("update.hobby");
		} else if (command.equals("/hobby/updateDB.hobby")) {
			viewPage = "selectAll.hobby";
			HobbyService.update(request, response);
			System.out.println("updateDB.hobby");
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
