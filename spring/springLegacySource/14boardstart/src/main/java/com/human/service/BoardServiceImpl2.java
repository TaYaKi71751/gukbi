package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.BoardDAO;
import com.human.dto.BoardDto;

@Service
public class BoardServiceImpl2 implements BoardService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void regist(BoardDto board) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.create(board);
	}

	@Override
	public BoardDto read(Integer bId) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.read(bId);
	}

	@Override
	public void modify(BoardDto board) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.update(board);
	}

	@Override
	public void remove(Integer bId) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.delete(bId);
	}

	@Override
	public List<BoardDto> listAll() throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		List<BoardDto> dtos = dao.listAll();
		// System.out.println(dtos);
		return dtos;
	}
	@Override
	public void bHitUpdate(int bId) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.bHitUpdate(bId);
	}
	public void bLike(int bId) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.bLike(bId);
	}

	@Override
	public List<BoardDto> listMenu(String bGroupKind) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		List<BoardDto> dtos = dao.listMenu(bGroupKind);
		// System.out.println(dtos);
		return dtos;
	}

	@Override
	public List<String> menuKind() throws Exception {
	
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		List<String> dtos=dao.menuKind();
		return dtos;
	}


}






