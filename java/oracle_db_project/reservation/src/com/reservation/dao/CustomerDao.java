package com.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.reservation.dto.CustomerDto;
import com.reservation.util.DBConn;
import com.reservation.util.UserInput;

public class CustomerDao {
	public Long addCustomer() {
		Long currentCustomerId = this.getMaxId() + 1l;
		this.insert(
			new CustomerDto(
				currentCustomerId,
				UserInput.inputString("first_name"),
				UserInput.inputString("last_name"),
				UserInput.inputString("email"),
				UserInput.inputString("phone")
			)
		);
		return currentCustomerId;
	}
	public Long updateCustomer() {
		Long targetCustomerId = UserInput.inputLong("수정할 customer_id");
		this.update(
			targetCustomerId,
			new CustomerDto(
				targetCustomerId,
				UserInput.inputString("first_name"),
				UserInput.inputString("last_name"),
				UserInput.inputString("email"),
				UserInput.inputString("phone")
			)
		);
		return targetCustomerId;
	}
	
	public Long deleteCustomer() {
		Long targetCustomerId = UserInput.inputLong("삭제할 customer_id");
		this.delete(targetCustomerId);
		return targetCustomerId;
	}
	public void printCustomer() {
		ArrayList<CustomerDto> result = this.select();
		for(CustomerDto r : result) {
			System.out.println(r);
		}
	}
	public ArrayList<CustomerDto> select() {
		ArrayList<CustomerDto> resultDtos=new ArrayList<CustomerDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from customers"));
		try {
			while(rs.next()) {
				resultDtos.add(
					new CustomerDto(
						rs.getLong("customer_id"), 
						rs.getString("first_name"), 
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("phone")
					)
				);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;	
	}
	public CustomerDto selectId(int id) {
		CustomerDto resultDtos=new CustomerDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from customers where customer_id=%d", id));
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new CustomerDto(
					rs.getLong("customer_id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email"),
					rs.getString("phone")
				);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
				
	public void insert(CustomerDto dto) {
		String sql=String.format("insert into customers values(%d,'%s','%s','%s','%s')",
				dto.getCustomerId(),dto.getFirstName(),dto.getLastName(),dto.getEmail(),dto.getPhone());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	public void update(Long id,CustomerDto dto) {
		String sql = String.format("update customers set customer_id=%d,first_name='%s',last_name='%s',email='%s',phone='%s' where customer_id=%d",
			dto.getCustomerId(),
			dto.getFirstName(),
			dto.getLastName(),
			dto.getEmail(),
			dto.getPhone(),
			id
		);
		DBConn.statementUpdate(sql);
		System.out.println("[수정 완료]");
	}
	public void delete(Long id) {
		String sql=String.format("delete customers where customer_id=%d",id);
		DBConn.statementUpdate(sql);
		System.out.println("[삭제 완료]");
	}
	
	public ArrayList<Integer> getIds() {
		ArrayList<Integer> ids=new ArrayList<Integer>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from customers"));
		try {
			while(rs.next()) {
				ids.add(rs.getInt("customer_id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return ids;
	}

	public Long getMaxId() {
		Long maxIdValue=-1l;
		ResultSet rs=DBConn.statementQuery(String.format("select max(customer_id) as maxId from customers"));
		if(rs!=null) {
			try {
				rs.next();
				maxIdValue=rs.getLong("maxId");	
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return maxIdValue;
	}
}