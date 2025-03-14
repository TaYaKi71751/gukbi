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
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 사용자 입력 한글 처리
        request.setCharacterEncoding("UTF-8");
        // 응답에 대한 한글 처리
        response.setContentType("text/html; charset=UTF-8");
        int a = Integer.parseInt(request.getParameter("a"));
        int b = Integer.parseInt(request.getParameter("b"));
        char operator = request.getParameter("operator").charAt(0);
        PrintWriter out = response.getWriter();
        out.print(a + " " + operator + " " + b + " = ");
        switch (operator) {
            case '*':
                out.println(a * b);
                break;
            case '/':
                out.println(a / b);
                break;
            case '+':
                out.println(a + b);
                break;
            case '-':
                out.println(a - b);
                break;
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
