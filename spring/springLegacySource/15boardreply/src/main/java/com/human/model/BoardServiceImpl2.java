package com.human.model;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.human.dto.BoardDto;
//import org.zerock.domain.Criteria;
//import org.zerock.domain.SearchCriteria;
import com.human.dao.BoardDAO;

@Service
public class BoardServiceImpl2 implements BoardService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void regist(BoardDto board) throws Exception {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.create(board);
	}
	public void reply(BoardDto vo) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.reply(vo);
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
	public void replyUpdate(BoardDto vo) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.replyUpdate(vo);
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
	public List<BoardDto> listMenu(String bGroupKind) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		List<BoardDto> dtos= dao.listMenu(bGroupKind);
		return dtos;
	}
	@Override
	public void bHitUpdate(int bId) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.bHitUpdate(bId);
	}
	@Override
	public void bLike(int bId) throws Exception{
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		dao.bLike(bId);
	}
	@Override
	public void updateReply(BoardDto vo) throws Exception{
		BoardDAO dao =sqlSession.getMapper(BoardDAO.class);
		dao.updateReply(vo);
	}
	@Override
	public List<String> menuKind() throws Exception{
		BoardDAO dao=sqlSession.getMapper(BoardDAO.class);
		List<String> dtos= dao.menuKind();
		return dtos;
	}
//	@Override
//	public void bHitUpdate(BoardDto board) throws Exception{
//		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
//		dao.bHitUpdate(board);
//	}


//  @Override
//  public List<BoardVO> listCriteria(Criteria cri) throws Exception {
//
//    return dao.listCriteria(cri);
//  }
//
//  @Override
//  public int listCountCriteria(Criteria cri) throws Exception {
//
//    return dao.countPaging(cri);
//  }
//
//  @Override
//  public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {
//
//    return dao.listSearch(cri);
//  }
//
//  @Override
//  public int listSearchCount(SearchCriteria cri) throws Exception {
//
//    return dao.listSearchCount(cri);
//  }

}
