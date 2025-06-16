package com.human.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.human.dao.IHumanDao;
import com.human.dto.HumanDto;
@Service
public class HumanServiceImpl implements IHumanService {

	@Autowired
	private SqlSession sqlSession;

	@Transactional(isolation=Isolation.SERIALIZABLE)
	@Override
	public void insert(HumanDto dto) throws Exception {
		IHumanDao dao=sqlSession.getMapper(IHumanDao.class);
		dto.setName(dto.getName()+1);
		dao.insert(dto);
		int a=10/0;
		dto.setName(dto.getName()+1);
		dao.insert(dto);
		
		dto.setName(dto.getName()+1);
		dao.insert(dto);
	}

	@Override
	public void update(HumanDto dto) throws Exception {
		IHumanDao dao=sqlSession.getMapper(IHumanDao.class);
		dao.update(dto);
	}


	@Override
	public void delete(String name) throws Exception {
		IHumanDao dao=sqlSession.getMapper(IHumanDao.class);
		dao.delete(name);

	}

	@Override
	public ArrayList<HumanDto> selectAll() throws Exception {
		IHumanDao dao=sqlSession.getMapper(IHumanDao.class);
		System.out.println(dao.selectAll());
		return dao.selectAll();
	}

	@Override
	public HumanDto selectName(String name) throws Exception {
		IHumanDao dao=sqlSession.getMapper(IHumanDao.class);
		return dao.selectName(name);
	}

}
