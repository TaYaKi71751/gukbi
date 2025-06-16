package com.human.dao;

import java.util.ArrayList;
import com.human.dto.UserDto;

public interface UserDao {
	
	public void insert(UserDto dto) throws Exception;
	public void update(UserDto dto) throws Exception;
	public void delete(String username) throws Exception;
	public ArrayList<UserDto> selectAll() throws Exception;
	public UserDto selectName(String username) throws Exception;
}
