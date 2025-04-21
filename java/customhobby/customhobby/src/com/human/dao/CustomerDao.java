package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.human.dto.CustomerDto;
import com.human.util.DBConn;

public class CustomerDao {
	
	public void insert(CustomerDto dto)
	{
		String sql = String.format(
				"insert into customer "
				+ "values(id_counter.nextval, '%s', %.2f, to_date('%s', 'YYYY:MM:DD HH24:MI:SS'))"
				,dto.getName(), dto.getHeight(),dto.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		DBConn.statementUpdate(sql);
	}
	
	public ArrayList<CustomerDto> selectAll()
	{
		ArrayList<CustomerDto> resultDtos = new ArrayList<CustomerDto>();
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from customer"));
		
		try {
			while(rs.next())
			{
				resultDtos.add(new CustomerDto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getTimestamp(4).toLocalDateTime()));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return resultDtos;
	}
	
	public CustomerDto selectId(int id)
	{
		CustomerDto resultDtos = new CustomerDto(); 
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from customer where id = %d", id));
		if(rs != null)
		{
			try {
				rs.next();
				resultDtos = new CustomerDto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getTimestamp(4).toLocalDateTime());
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return resultDtos;
	}
	
	public void update(int id, String name)
	{
		DBConn.statementUpdate(String.format("update customer set name = '%s' where id = %d", name, id));
	}
	
	public ArrayList<Integer> getIds()
	{
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		ResultSet rs = DBConn.statementQuery(String.format("select * from customer"));
		
		try {
			while(rs.next())
			{
				ids.add(rs.getInt("id"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ids;
	}
	
	public int getMaxId()
	{
		int maxIdValue = -1;
		
		ResultSet rs = DBConn.statementQuery(String.format("select max(id) as maxId from customer"));
		
		if(rs != null)
		{
			try {
				rs.next();
				maxIdValue = rs.getInt("maxId");
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return maxIdValue;
	}
	
	public void update(int id, double height)
	{
		DBConn.statementUpdate(String.format("update customer set height = %.2f where id = %d", height, id));
	}
	
	public void delete(int id)
	{
		DBConn.statementUpdate(String.format("delete customer where id = %d", id));
	}
	
}