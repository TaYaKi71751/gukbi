package com.human.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;
import com.human.dto.HobbyDto;

public interface ICustomerHobbyService {
	
	public List<CustomerHobbyDto> selectAll() throws Exception;

	public void insertCustomHobby(CustomerDto dto, ArrayList<String> hobbys) throws Exception;
	
	public void deleteCustom(Integer id) throws Exception;
	public void deleteHobby(Integer id,String hobby) throws Exception;

}
