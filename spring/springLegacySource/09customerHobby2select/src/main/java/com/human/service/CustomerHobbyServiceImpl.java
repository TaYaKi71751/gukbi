package com.human.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.ICustomerDao;
import com.human.dto.CustomerHobbyDto;
@Service
public class CustomerHobbyServiceImpl implements ICustomerHobbyService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CustomerHobbyDto> selectAll() throws Exception {
		
		ICustomerDao dao=sqlSession.getMapper(ICustomerDao.class);
		
		List<CustomerHobbyDto> dtos=dao.selectAllCustomerHobby();
		
		
		return dtos;
	}

}
