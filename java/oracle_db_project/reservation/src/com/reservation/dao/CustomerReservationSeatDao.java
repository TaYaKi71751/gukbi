package com.reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.reservation.dto.CustomerDto;
import com.reservation.dto.CustomerReservationSeatDto;
import com.reservation.dto.ReservationDto;
import com.reservation.dto.SeatDto;
import com.reservation.util.DBConn;
import com.reservation.util.UserInput;

public class CustomerReservationSeatDao {
	public ReservationDao reservationDao = new ReservationDao();
	public CustomerDao customerDao = new CustomerDao();
	public SeatDao seatDao = new SeatDao();

	public ArrayList<CustomerReservationSeatDto> selectAll() {
		ArrayList<CustomerReservationSeatDto> resultDtos=new ArrayList<CustomerReservationSeatDto>();
		ResultSet rs=DBConn.statementQuery(String.format("select * from reservations,customers,seats where reservations.customer_id = customers.customer_id and reservations.table_id = seats.table_id"));
		try {
			while(rs.next()) {
				resultDtos.add(
					new CustomerReservationSeatDto(
						new ReservationDto(
							rs.getLong("reservation_id"), 
							rs.getLong("customer_id"), 
							rs.getLong("table_id"), 
							rs.getTimestamp("reservation_date").toLocalDateTime(),
							rs.getLong("number_of_guests")
						),
						new CustomerDto(
							rs.getLong("customer_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone")
						),
						new SeatDto(
							rs.getLong("table_id"),
							rs.getLong("customer_seats"),
							rs.getString("status")
						)
					)
				);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDtos;	
	}
	public CustomerReservationSeatDto selectCustomerId(int id) {
		CustomerReservationSeatDto resultDtos=new CustomerReservationSeatDto();
		ResultSet rs=DBConn.statementQuery(String.format("select * from reservations,customers,seats where reservations.customer_id=customers.customer_id and reservations.table_id = seats.table_id and customers.customer_id=%d", id));
		if(rs!=null) {
			try {
				rs.next();
				resultDtos=new CustomerReservationSeatDto(
					new ReservationDto(
						rs.getLong("reservation_id"), 
						rs.getLong("customer_id"), 
						rs.getLong("table_id"), 
						rs.getTimestamp("reservation_date").toLocalDateTime(),
						rs.getLong("number_of_guests")
					),
					new CustomerDto(
						rs.getLong("customer_id"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("email"),
						rs.getString("phone")
					),
					new SeatDto(
						rs.getLong("table_id"),
						rs.getLong("customer_seats"),
						rs.getString("status")
					)
				);
			}catch (SQLException e) {
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return resultDtos;
	}
				
	public void insert() {
		Long currentCustomerId = customerDao.getMaxId() + 1l;
		Long currentTableId = seatDao.getMaxId() + 1;
		Long currentReservationId = reservationDao.getMaxId() + 1l;
		customerDao.insert(
			new CustomerDto(
				currentCustomerId,
				UserInput.inputString("first_name"),
				UserInput.inputString("last_name"),
				UserInput.inputString("email"),
				UserInput.inputString("phone")
			)
		);
		seatDao.insert(
			new SeatDto(
				currentTableId,
				UserInput.inputLong("customer_seats"),
				UserInput.inputString("status")
			)
		);
		reservationDao.insert(
			new ReservationDto(
				currentReservationId, 
				currentCustomerId, 
				currentTableId, 
				UserInput.inputLocalDateTime("reservation_date"),
				UserInput.inputLong("number_of_guests")
			)
		);
		System.out.println("[입력 완료]");
	}
}
