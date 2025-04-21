package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.human.dto.HobbyDto;
import com.human.util.DBConn;

public class HobbyDao {

	public void insert(HobbyDto dto)
	{
		String sql = String.format("insert into hobby values(%d, '%s')", dto.getId(), dto.getHobby());
		DBConn.statementUpdate(sql);
	}
	
	public ArrayList<HobbyDto> selectAll()
	{
		ArrayList<HobbyDto> resultDtos = new ArrayList<HobbyDto>();
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from hobby order by id"));
		
		try {
			while(rs.next())
			{
				resultDtos.add(new HobbyDto(rs.getInt(1), rs.getString(2)));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return resultDtos;
	}
	
	public HobbyDto selectOne(int id, String hobby)
	{
		HobbyDto resultDto = new HobbyDto();
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from hobby where id = %d and hobby = '%s'", id, hobby));
		if(rs != null)
		{
			try {
				rs.next();
				resultDto = new HobbyDto(rs.getInt(1), rs.getString(2));
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return resultDto;
	}
	
	public void update(int id, String beforehobby, String afterhobby)
	{
		DBConn.statementUpdate(String.format("update hobby set hobby = '%s' where id = %d and hobby = '%s'", afterhobby, id, beforehobby));
	}
	
	public void delete(int id)
	{
		DBConn.statementUpdate(String.format("delete hobby where id = %d", id));
	}
	
	public void delete(int id, String hobby)
	{
		DBConn.statementUpdate(String.format("delete hobby where id = %d and hobby = '%s'", id, hobby));
	}
}
