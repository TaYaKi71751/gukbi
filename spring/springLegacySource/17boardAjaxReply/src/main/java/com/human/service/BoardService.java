package com.human.service;

import java.util.List;

import com.human.dao.BoardDAO;
import com.human.dto.BoardDto;
//import org.zerock.domain.Criteria;
//import org.zerock.domain.SearchCriteria;
import com.human.vo.BoardVo;

public interface BoardService {

  public void regist(BoardDto board) throws Exception;

  public BoardDto read(Integer bId) throws Exception;

  public void modify(BoardDto board) throws Exception;

  public void remove(Integer bId) throws Exception;

  public List<BoardDto> listAll() throws Exception;
  
  public void bHitUpdate(int bId) throws Exception;
  
  public void bLike(int bId) throws Exception;
  public void updateReply(BoardDto vo) throws Exception;
  public List<BoardDto> listMenu(String bGroupKind) throws Exception;
  public void reply(BoardDto vo) throws Exception;
//  public void bHitUpdate(BoardDto board) throws Exception;
//  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
//
//  public int listCountCriteria(Criteria cri) throws Exception;
//
//  public List<BoardVO> listSearchCriteria(SearchCriteria cri) 
//      throws Exception;
//
//  public int listSearchCount(SearchCriteria cri) throws Exception;
  public List<BoardDto> listSearchCriteria(BoardVo vo)throws Exception;
  public List<String> menuKind() throws Exception;
  public void replyUpdate(BoardDto vo) throws Exception;
  public int listSearchCount(BoardVo vo)throws Exception;
}
