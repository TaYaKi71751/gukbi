package com.human.dao;

import java.util.List;

import com.human.dto.BoardDto;
import com.human.vo.BoardVo;
//import org.zerock.domain.Criteria;
//import org.zerock.domain.SearchCriteria;

public interface BoardDAO {

  public void create(BoardDto vo) throws Exception;

  public BoardDto read(Integer bId) throws Exception;

  public void update(BoardDto vo) throws Exception;

  public void delete(Integer bId) throws Exception;

  public List<BoardDto> listAll() throws Exception;
  
  public void bHitUpdate(int bId) throws Exception;
  
  public void bLike(int bId) throws Exception;
  
  public void updateReply(BoardDto vo) throws Exception;
  
  public List<BoardDto> listMenu(String bGroupKind) throws Exception;
  
  public List<String> menuKind() throws Exception;
  public void reply(BoardDto vo) throws Exception;
  public void replyUpdate(BoardDto vo) throws Exception;
  public List<BoardDto> listSearch(BoardVo vo)throws Exception;
  public int listSearchCount(BoardVo vo)throws Exception; 
//  public void bHitUpdate(BoardDto vo) throws Exception;
 // public List<BoardVO> listPage(int page) throws Exception;

//  public List<BoardVO> listCriteria(Criteria cri) throws Exception;
//
//  public int countPaging(Criteria cri) throws Exception;
//  
//  //use for dynamic sql
//  
//  public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;
//  
//  public int listSearchCount(SearchCriteria cri)throws Exception;

}
