package com.human.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.human.dao.ReplyDao;
import com.human.dto.ReplyDto;
import com.human.vo.PageMaker;

@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void boardReplyCreate(ReplyDto reply) throws Exception {
		System.out.println(sqlSession);
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		dao.boardReplyCreate(reply);
	}
	
	@Override
	public void reReplyCreate(ReplyDto reply) throws Exception {
		System.out.println(sqlSession);
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		dao.reReplyCreate(reply);
	}
	
	@Override
	public void boardReplyStep(int rGroup, int rStep) throws Exception {
		System.out.println(sqlSession);
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		dao.boardReplyStep(rGroup, rStep);
	}
	
	@Override
	public void boardReplyUpdate(ReplyDto reply) throws Exception {
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		dao.boardReplyUpdate(reply);
	}
	
	@Override
	public void boardReplyDelete(int rId) throws Exception {
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		dao.boardReplyDelete(rId);
	}
	
	@Override
	public List<ReplyDto> replyList(int bId, PageMaker pm) throws Exception {
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		return dao.replyList(bId, pm);
	}
	
	@Override
	public int replyCount(int bId) throws Exception {
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		int count=dao.replyCount(bId);
		return count;
	}
	
	@Override
	public ReplyDto readParent(int rId) throws Exception {
		ReplyDao dao=sqlSession.getMapper(ReplyDao.class);
		return dao.readParent(rId);
	}

}
