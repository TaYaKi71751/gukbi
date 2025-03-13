package com.human.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.CustomerDao;
import com.human.dao.HobbyDao;
import com.human.dto.HobbyDto;

public class HobbyService {
	
	public static HobbyDao hobbyDao=new HobbyDao();
	public static CustomerDao customerDao=new CustomerDao();
	
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		HobbyDto dto = new HobbyDto(Integer.parseInt(request.getParameter("id")),
				request.getParameter("hobby"));
		hobbyDao.insert(dto);
	}

	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<HobbyDto> dtos=hobbyDao.selectAll();
		request.setAttribute("dtos", dtos);
	}

	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		HobbyDto dto =hobbyDao.selectOne(Integer.parseInt(request.getParameter("id")),
				request.getParameter("hobby"));
		request.setAttribute("dto", dto);
	}

	public static void delete(HttpServletRequest request, HttpServletResponse response) {
		hobbyDao.delete(Integer.parseInt(request.getParameter("id")),request.getParameter("hobby"));
	}
	
	public static void update(HttpServletRequest request, HttpServletResponse response) {
		hobbyDao.update(Integer.parseInt(request.getParameter("id")),request.getParameter("beforehobby"),request.getParameter("afterhobby"));
	}

	public static void insert(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Integer> ids=customerDao.getIds();
		
		request.setAttribute("ids", ids);		
	}
	
	
	
	
	
	
	
}
