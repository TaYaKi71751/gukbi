package com.human.service;

import java.util.ArrayList;

import com.human.dao.CustomerDao;
import com.human.dto.CustomerDto;

public class CustomerService {
	private CustomerDao dao=new CustomerDao();
	public ArrayList<CustomerDto> select() {
		return dao.select();
	}
	public void insert(CustomerDto dto) {
		dao.insert(dto);
	}
	public void update(String updateName, int updateid) {
		dao.update(updateName, updateid);
	}
	public void delete(int id) {
		dao.delete(id);
	}	
}
