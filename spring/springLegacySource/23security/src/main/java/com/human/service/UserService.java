package com.human.service;

import java.util.ArrayList;
import com.human.dto.UserDto;

public interface UserService {
	
	public void insert(UserDto dto) throws Exception;
	public void update(UserDto dto) throws Exception;
	public void delete(String username) throws Exception;
	public ArrayList<UserDto> selectAll() throws Exception;
	public UserDto selectName(String username) throws Exception;
}
