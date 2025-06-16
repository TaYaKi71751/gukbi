package com.human.dao;

import java.util.List;

import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;

public interface ICustomerDao {
	public void insert(CustomerDto dto) throws Exception;
	public CustomerDto select(int id) throws Exception;
	public List<CustomerDto> selectAll() throws Exception;
	public void delete(int id) throws Exception;
	public void update(CustomerDto dto) throws Exception;	
	public Integer selectMaxId() throws Exception;
	public List<CustomerHobbyDto> selectAllCustomerHobby() throws Exception;
}
