package com.human.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.human.dao.CustomerDao;
import com.human.dao.CustomerHobbyDao;
import com.human.dao.HobbyDao;
import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;
import com.human.dto.CustomerHobbysDto;
import com.human.dto.HobbyDto;

public class CustomerHobbysService {
	public static CustomerDao customerDao=new CustomerDao();
	public static HobbyDao hobbyDao=new HobbyDao();
	public static CustomerHobbyDao customerHobbyDao=new CustomerHobbyDao();
	
	public static void insertDB(HttpServletRequest request, HttpServletResponse response) {
		
		CustomerDto customerDto=new CustomerDto(null,
				request.getParameter("name"),
				Double.parseDouble(request.getParameter("height")),
				LocalDateTime.parse(request.getParameter("birthday"))
			);
		
		customerDao.insert(customerDto);
		
		String hobbys[]=request.getParameterValues("hobbys");
		HobbyDto hobbyDto= null;
		
		int hobbyId=customerDao.getMaxId();
		
		for(String hobbyName:hobbys) {
			hobbyDao.insert(new HobbyDto(hobbyId,hobbyName));
		}		
		
	}

	//(int id, String name, double height, LocalDateTime birthday, List<HobbyDto> hobbys) {
		
	public static void selectAll(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<CustomerHobbysDto> customerHobbysDtos =new ArrayList<CustomerHobbysDto>(); 
		ArrayList<CustomerDto> customerDtos=customerDao.selectAll();
		for(CustomerDto dto:customerDtos) {
			ArrayList<HobbyDto> hobbyDtos=hobbyDao.selectId(dto.getId());
			
			customerHobbysDtos.add(new CustomerHobbysDto(
					dto.getId(),
					dto.getName(),
					dto.getHeight(),
					dto.getBirthday(),
					hobbyDtos					
					));
		}
		
		request.setAttribute("dtos",customerHobbysDtos);
	}


	public static void selectOne(HttpServletRequest request, HttpServletResponse response) {
		CustomerHobbyDto dto=customerHobbyDao.selectOneCustomerAndHobby(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("hobby")
			);
		System.out.println(dto);
		request.setAttribute("dto", dto);
	}


	public static void deleteHobby(HttpServletRequest request, HttpServletResponse response) {
		hobbyDao.delete(Integer.parseInt(request.getParameter("id"))
				, request.getParameter("hobby"));
		
	}


	public static void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		hobbyDao.delete(Integer.parseInt(request.getParameter("id")));

		customerDao.delete(Integer.parseInt(request.getParameter("id")));
	}
//	<form action="/jsp20CustommerHobby/customerHobby/update.customerHobby">
//	<input type="hidden" name="id" value=${requestScope.dto.id }>
//	<input type="hidden" name="hobby" value=${requestScope.dto.hobby.hobby }>
//	고객의 키 수정:<input type="text" name='newHeight' ><br>
//	고객의 취미 변경:<input type="text" name="newHobby"><br>
//	<input type="submit" value="수정">
//</form>


	public static void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		customerDao.update(Integer.parseInt(request.getParameter("id")),
				Double.parseDouble(request.getParameter("newHeight")));
		
		hobbyDao.update(Integer.parseInt(request.getParameter("id")),
				request.getParameter("hobby"), request.getParameter("newHobby"));
		
	}
	
}










