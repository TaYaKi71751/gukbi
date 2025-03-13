package com.human.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.CustomerDao;
import com.human.dto.CustomerDto;

public class CustomerService {
	public static CustomerDao customerDao=new CustomerDao();
	
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		CustomerDto dto=new CustomerDto(null,
				request.getParameter("name"),
				Double.parseDouble(request.getParameter("height")),
				//yyyy-MM-dd'T'HH:mm
				LocalDateTime.parse(request.getParameter("birthday"))
				
		);
		System.out.println(dto);
		
		
		customerDao.insert(dto);		
		
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<CustomerDto> dtos =customerDao.selectAll();
		request.setAttribute("dtos",dtos);

	}

	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		CustomerDto dto =customerDao.selectId(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("dto", dto);
		
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		customerDao.delete(Integer.parseInt(request.getParameter("id")));
	}

	public static void update(HttpServletRequest request, HttpServletResponse response) {
		customerDao.update(Integer.parseInt(request.getParameter("id"))
				, request.getParameter("name"));
		
	}

}
