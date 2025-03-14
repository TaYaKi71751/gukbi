package com.the.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 입력 한글 처리
		request.setCharacterEncoding("UTF-8");
		// 응답에 대한 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("get실행");
		String searchString = request.getParameter("search");
		PrintWriter out = response.getWriter();
		out.println("검색한 결과 값은 : " + searchString + "<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 입력 한글 처리
		request.setCharacterEncoding("UTF-8");
		// 응답에 대한 한글 처리
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("post실행");
		String searchString = request.getParameter("search");
		PrintWriter out = response.getWriter();
		out.println("검색한 결과 값은 : " + searchString + "<br>");
	}

}
