package com.human.service;

import java.util.ArrayList;
import java.util.List;

import com.human.dto.HumanDto;

public interface HumanService {
	public void insert(HumanDto dto) throws Exception;
	public void update(HumanDto dto) throws Exception;
	public void delete(String name) throws Exception;
	public ArrayList<HumanDto> selectAll() throws Exception;
	public HumanDto selectName(String name) throws Exception;
}
