package com.human.service;

import java.util.List;

import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;
import com.human.dto.HobbyDto;

public interface ICustomerHobbyService {
	public List<CustomerHobbyDto> selectAll() throws Exception;

}
