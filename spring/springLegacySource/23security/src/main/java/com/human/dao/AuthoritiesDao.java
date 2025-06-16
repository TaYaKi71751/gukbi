package com.human.dao;

import java.util.ArrayList;
import com.human.dto.AuthoritiesDto;

public interface AuthoritiesDao {

	public void insert(AuthoritiesDto dto) throws Exception;
	public void update(AuthoritiesDto dto) throws Exception;
	public void delete(String username) throws Exception;
	public ArrayList<AuthoritiesDto> selectAll() throws Exception;
	public AuthoritiesDto selectName(String username) throws Exception;
}
