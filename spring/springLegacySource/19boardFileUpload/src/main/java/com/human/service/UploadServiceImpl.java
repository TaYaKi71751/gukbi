package com.human.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.ReplyDAO;
import com.human.dao.UploadDAO;
@Service
public class UploadServiceImpl implements UploadService {


	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<String> getFiles(Integer bno) throws Exception {
		 UploadDAO dao=sqlSession.getMapper(UploadDAO.class);
		  
		return dao.getFiles(bno);
	}

	@Override
	public void deleteFile(String fullName) throws Exception {
		UploadDAO dao=sqlSession.getMapper(UploadDAO.class);
		  dao.deleteFile(fullName);

	}

	@Override
	public void addFile(String fullName, Integer bno) throws Exception {
		UploadDAO dao=sqlSession.getMapper(UploadDAO.class);
		  dao.addFile(fullName, bno);
	}

	@Override
	public void deleteFileAll(Integer bno) throws Exception {
		UploadDAO dao=sqlSession.getMapper(UploadDAO.class);
		  dao.deleteFileAll(bno);

	}

}
