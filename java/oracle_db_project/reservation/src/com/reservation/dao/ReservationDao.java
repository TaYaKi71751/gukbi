package com.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.reservation.dto.ReservationDto;
import com.reservation.util.DBConn;
import com.reservation.util.UserInput;

public class ReservationDao {
	public Long addReservation(Long customerId, Long tableId) {
		Long currentReservationId = this.getMaxId() + 1l;
		this.insert(
			new ReservationDto(
				currentReservationId,
				customerId,
				tableId,
				UserInput.inputLocalDateTime("reservation_time"),
				UserInput.inputLong("number_of_guests")
			)
		);
		return currentReservationId;
	}
	public Long updateReservation() {
		Long targetReservationId = UserInput.inputLong("수정할 reservation_id");
		
		this.update(
			targetReservationId,
			new ReservationDto(
				targetReservationId,
				UserInput.inputLong("customer_id"),
				UserInput.inputLong("table_id"),
				UserInput.inputLocalDateTime("reservation_time"),
				UserInput.inputLong("number_of_guests")
			)
		);
		
		return targetReservationId;
	}
	public Long deleteReservation() {
		Long targetReservationId = UserInput.inputLong("삭제할 reservation_id");
		this.delete(targetReservationId);
		return targetReservationId;
	}
	public ArrayList<ReservationDto> select() {
		ArrayList<ReservationDto> resultDtos=new ArrayList<ReservationDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from reservations"));
		try {
			while(rs.next()) {
				resultDtos.add(
					new ReservationDto(
						rs.getLong("reservation_id"), 
						rs.getLong("customer_id"), 
						rs.getLong("table_id"),
						rs.getTimestamp("reservation_time").toLocalDateTime(),
						rs.getLong("number_of_guests")
					)
				);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;	
	}
	public ReservationDto selectId(Long id) {
		ReservationDto resultDtos=new ReservationDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from reservations where reservation_id=%d", id));
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new ReservationDto(
					rs.getLong("reservation_id"),
					rs.getLong("customer_id"),
					rs.getLong("table_id"),
					rs.getTimestamp("reservation_time").toLocalDateTime(),
					rs.getLong("number_of_guests")
				);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
				
	public void insert(ReservationDto dto) {
		String sql_select = String.format("select customer_seats from seats where table_id = %d", dto.getTableId());
		Long customerSeats = null;
		ResultSet rs = DBConn.statementQuery(sql_select);
		try {
			while(rs.next()) {
				customerSeats = rs.getLong("customer_seats");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(customerSeats == null) {
			System.out.println("customer_seats가 null입니다.");
		}
		if(customerSeats < dto.getNumberOfGuests()) {
			System.out.println("customer_seats 보다 큰 number_of_guests");
			return;
		}
		String sql=String.format("insert into reservations values(%d,%d,%d,to_date('%s','YYYY-MM-DD HH24:MI:SS'),%d)",
				dto.getReservationId(),dto.getCustomerId(),dto.getTableId(),dto.getReservationTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),dto.getNumberOfGuests());
		DBConn.statementUpdate(sql);
		System.out.println("[입력 완료]");
	}
	public void update(Long id,ReservationDto dto) {
		String sql_select = String.format("select customer_seats from seats where table_id = %d", dto.getTableId());
		Long customerSeats = null;
		ResultSet rs = DBConn.statementQuery(sql_select);
		try {
			while(rs.next()) {
				customerSeats = rs.getLong("customer_seats");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(customerSeats == null) {
			System.out.println("customer_seats가 null입니다.");
		}
		if(customerSeats < dto.getNumberOfGuests()) {
			System.out.println("customer_seats 보다 큰 number_of_guests");
			return;
		}
		String sql = String.format("update reservations set reservation_id=%d,customer_id=%d,table_id=%d,reservation_time=to_date('%s','YYYY-MM-DD HH24:MI:SS'),number_of_guests=%d where customer_id=%d",
			dto.getReservationId(),
			dto.getCustomerId(),
			dto.getTableId(),
			dto.getReservationTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
			dto.getNumberOfGuests(),
			id
		);
		DBConn.statementUpdate(sql);
		System.out.println("[수정 완료]");
	}
	public void delete(Long id) {
		String sql=String.format("delete reservations where reservation_id=%d",id);
		DBConn.statementUpdate(sql);
		System.out.println("[삭제 완료]");
	}
	
	public ArrayList<Long> getIds() {
		ArrayList<Long> ids=new ArrayList<Long>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from reservations"));
		try {
			while(rs.next()) {
				ids.add(rs.getLong("customer_id"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return ids;
	}

	public Long getMaxId() {
		Long maxIdValue=-1l;
		ResultSet rs=DBConn.statementQuery(String.format("select max(reservation_id) as maxId from reservations"));
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
	public void printReservation() {
		ArrayList<ReservationDto> result = this.select();
		for(ReservationDto r : result) {
			System.out.println(r);
		}
	}
}
