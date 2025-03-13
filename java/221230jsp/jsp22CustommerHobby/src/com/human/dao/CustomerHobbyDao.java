package com.human.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.human.dto.CustomerDto;
import com.human.dto.CustomerHobbyDto;
import com.human.dto.HobbyDto;
import com.human.util.DBConn;

//ctr+a 모든 코드 선택 ctr+shift+f 코드정리
public class CustomerHobbyDao {	
	public ArrayList<CustomerHobbyDto> selecAllCustomerAndHobby() {
		ArrayList<CustomerHobbyDto> resultDtos = new ArrayList<CustomerHobbyDto>();
//		select customer.*,hobby.hobby from customer, hobby
//		where customer.id=hobby.id;
		ResultSet rs = DBConn.statementQuery(String.format(
				"select customer.*,hobby.hobby from customer, hobby " + 
				"where customer.id=hobby.id(+)"));

		try {
			while (rs.next()) {
				resultDtos.add(new CustomerHobbyDto(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime(),
						new HobbyDto(rs.getInt("id"),rs.getString("hobby"))
					)
				);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultDtos;
	}

	public CustomerHobbyDto selectOneCustomerAndHobby(int id, String hobby) {
		CustomerHobbyDto resultDto = null;
//		select customer.*,hobby.hobby from customer, hobby
//		where customer.id=hobby.id;

//id가 있을때
//select customer.*,hobby.hobby from customer, hobby
//where customer.id=hobby.id(+) 
//and customer.id=31 and hobby.hobby is null;

//id가 없을때
//select customer.*,hobby.hobby from customer, hobby
//where customer.id=hobby.id(+) 
//and customer.id=101 and hobby.hobby ='1';

		String sql="";
		if(hobby.equals("")) {
			
			sql="select customer.*,hobby.hobby from customer, hobby " + 
					"where customer.id=hobby.id(+) and customer.id="+id+" and hobby.hobby is null";
		}else {
			sql="select customer.*,hobby.hobby from customer, hobby " + 
					"where customer.id=hobby.id(+) and customer.id="+id+" and hobby.hobby='"+hobby+"'";
			
		}
		ResultSet rs = DBConn.statementQuery(String.format(sql));

		try {
			while (rs.next()) {
				resultDto=new CustomerHobbyDto(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("height"),
						rs.getTimestamp("birthday").toLocalDateTime(),
						new HobbyDto(rs.getInt("id"),rs.getString("hobby"))
					);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultDto;		
	}
	
	

	
}
