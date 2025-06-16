package com.human.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.UserDao;
import com.human.dto.UserDto;
//실제 구현부
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insert(UserDto dto) throws Exception {
		UserDao dao=sqlSession.getMapper(UserDao.class);
		dao.insert(dto);
	}

	@Override
	public void update(UserDto dto) throws Exception {
		UserDao dao=sqlSession.getMapper(UserDao.class);
		dao.update(dto);
	}

	@Override
	public void delete(String username) throws Exception {
		UserDao dao=sqlSession.getMapper(UserDao.class);
		dao.delete(username);
	}

	@Override
	public ArrayList<UserDto> selectAll() throws Exception {
		UserDao dao=sqlSession.getMapper(UserDao.class);
		return dao.selectAll();
	}

	@Override
	public UserDto selectName(String username) throws Exception {
		UserDao dao=sqlSession.getMapper(UserDao.class);
		return dao.selectName(username);
	}
	



}
