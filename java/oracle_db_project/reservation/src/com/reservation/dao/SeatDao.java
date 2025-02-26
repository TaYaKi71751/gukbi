package com.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.reservation.dto.CustomerDto;
import com.reservation.dto.SeatDto;
import com.reservation.util.DBConn;
import com.reservation.util.UserInput;

public class SeatDao {
	public Long addSeat() {
		Long currentTableId = this.getMaxId() + 1l;
		this.insert(
			new SeatDto(
				currentTableId,
				UserInput.inputLong("customer_seats"),
				UserInput.inputString("status")
			)
		);
		return currentTableId;
	}
	public Long updateSeat() {
		Long targetTableId = UserInput.inputLong("수정할 table_id");
		this.update(
			targetTableId, 
			new SeatDto(
				targetTableId,
				UserInput.inputLong("customer_seats"),
				UserInput.inputString("status")
			)
		);
		return targetTableId;
	}
	public Long deleteSeat() {
		Long targetTableId = UserInput.inputLong("삭제할 table_id");
		this.delete(targetTableId);
		return targetTableId;
	}
	public void printSeat() {
		ArrayList<SeatDto> result = this.select();
		for(SeatDto r : result) {
			System.out.println(r);
		}
	}
	public ArrayList<SeatDto> select() {
		ArrayList<SeatDto> resultDtos=new ArrayList<SeatDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from seats"));
		try {
			while(rs.next()) {
				resultDtos.add(
					new SeatDto(
						rs.getLong("table_id"), 
						rs.getLong("customer_seats"),
						rs.getString("status")
					)
				);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;	
	}
	public SeatDto selectId(int id) {
		SeatDto resultDtos = null;
		ResultSet rs=DBConn.statementQuery(String.format("select * from seats where table_id=%d", id));
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new SeatDto(
					rs.getLong("table_id"),
					rs.getLong("customer_seats"),
					rs.getString("status")
				);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
				
	public void insert(SeatDto dto) {
		Long numberOfGuests = null;
		String sql_select = String.format("select max(number_of_guests) from reservations where table_id = %d", dto.getTableId());
		ResultSet rs = DBConn.statementQuery(sql_select);
		try {
			while(rs.next()) {
				numberOfGuests = rs.getLong("number_of_guests");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numberOfGuests == null) {
			System.out.println("number_of_guests는 null입니다.");
			return;
		}
		if(dto.getCustomerSeats() < numberOfGuests) {
			System.out.println("customer_seats가 number_of_guest보다 작습니다.");
		}
		String sql=String.format("insert into seats values(%d,%d,'%s')",
				dto.getTableId(),dto.getCustomerSeats(),dto.getStatus());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	public void update(Long id,SeatDto dto) {
		String sql = String.format("update seats set table_id = %d, customer_seats = %d, status = '%s' where table_id=%d", 
				dto.getTableId(),dto.getCustomerSeats(),dto.getStatus(),id);
		DBConn.statementUpdate(sql);
		System.out.println("[수정 완료]");
	}
	public void delete(Long id) {
		String sql=String.format("delete seats where table_id=%d",id);
		DBConn.statementUpdate(sql);
		System.out.println("[삭제 완료]");
	}
	
	public ArrayList<Integer> getIds() {
		ArrayList<Integer> ids=new ArrayList<Integer>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from seats"));
		try {
			while(rs.next()) {
				ids.add(rs.getInt("table_id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return ids;
	}

	public Long getMaxId() {
		Long maxIdValue=-1l;
		ResultSet rs=DBConn.statementQuery(String.format("select max(table_id) as maxId from seats"));
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
