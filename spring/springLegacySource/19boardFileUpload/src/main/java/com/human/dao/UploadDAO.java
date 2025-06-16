package com.human.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.human.dto.BoardDTO;
import com.human.vo.PageMaker;

public interface UploadDAO {
	
	public List<String> getFiles(Integer bno)throws Exception;

	public void deleteFile(@Param("fullName")String fullName)throws Exception;

	public void addFile(@Param("fullName")String fullName, @Param("bno")Integer bno)throws Exception;
	public void deleteFileAll(Integer bno)throws Exception;
}
