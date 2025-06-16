package com.human.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.dto.BoardDto;

public interface BoardDAO {

  public void create(BoardDto vo) throws Exception;

  public BoardDto read(Integer bId) throws Exception;

  public void update(BoardDto vo) throws Exception;

  public void delete(Integer bId) throws Exception;

  public List<BoardDto> listAll() throws Exception;
  
  public void bHitUpdate(int bId) throws Exception;
  
  public void bLike(int bId) throws Exception;

  public List<BoardDto> listMenu(@Param("bGroupKind")String bGroupKind);
  
  public List<String> menuKind();

}
