package com.the.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.the.dto.CustomerHobbyDto;
import com.the.util.DBConn;

public class CustomerHobbyDao {
	//가장 최근에 입력한 고객ID
	public Long getCustomerMaxId() {
		Long returnValue=0L;
		String sql ="select max(id) as max_id from customer";
		ResultSet rs=DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				returnValue=rs.getLong("max_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

	public ArrayList<CustomerHobbyDto> selectCustomerHobbys(){
		ArrayList<CustomerHobbyDto> dtos=new ArrayList<CustomerHobbyDto>();
		String sql ="select customer.*,hobby.id as hobby_id,hobby.hobby from customer,hobby "
				+ "where customer.id=hobby.custom_id(+)";
		ResultSet rs=DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
//(Long id, String name, Integer age, Double height, LocalDateTime birthday, Long hobby_id,String hobby) 
				dtos.add(new CustomerHobbyDto(
						rs.getLong("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime(),
						rs.getLong("hobby_id"),
						rs.getString("hobby")));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dtos;
	}

	public void deleteCustomerHobbys(Long customId) {
		// TODO Auto-generated method stub
		DBConn.statementUpdate("delete from hobby where custom_id="+customId);
		DBConn.statementUpdate("delete from customer where id="+customId);
		
	}
}


