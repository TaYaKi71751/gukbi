package com.human.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.AuthoritiesDao;
import com.human.dto.AuthoritiesDto;

@Service
public class AuthoritiesImpl implements AuthoritiesService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(AuthoritiesDto dto) throws Exception {
		AuthoritiesDao dao = sqlSession.getMapper(AuthoritiesDao.class);
		dao.insert(dto);
	}

	@Override
	public void update(AuthoritiesDto dto) throws Exception {
		AuthoritiesDao dao = sqlSession.getMapper(AuthoritiesDao.class);
		dao.update(dto);
	}

	@Override
	public void delete(String name) throws Exception {
		AuthoritiesDao dao = sqlSession.getMapper(AuthoritiesDao.class);
		dao.delete(name);
	}

	@Override
	public ArrayList<AuthoritiesDto> selectAll() throws Exception {
		AuthoritiesDao dao = sqlSession.getMapper(AuthoritiesDao.class);
		return dao.selectAll();
	}

	@Override
	public AuthoritiesDto selectName(String name) throws Exception {
		AuthoritiesDao dao = sqlSession.getMapper(AuthoritiesDao.class);
		return dao.selectName(name);
	}

}
