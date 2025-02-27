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
	public void listAll() {
		ArrayList<CustomerReservationSeatDto> results = this.selectAll();
		for(CustomerReservationSeatDto r : results) {
			System.out.println(r);
		}
	}
	public void listByCustomerId() {
		Long targetCustomerId = UserInput.inputLong("찾을 customer_id");
		ArrayList<CustomerReservationSeatDto> results = this.selectCustomerId(targetCustomerId);
		for(CustomerReservationSeatDto r : results) {
			System.out.println(r);
		}
	}
	public void listByReservationId() {
		Long targetReservationId = UserInput.inputLong("찾을 reservation_id");
		ArrayList<CustomerReservationSeatDto> results = this.selectReservationId(targetReservationId);
		for(CustomerReservationSeatDto r : results) {
			System.out.println(r);
		}
	}
	public void listByTableId() {
		Long targetTableId = UserInput.inputLong("찾을 table_id");
		ArrayList<CustomerReservationSeatDto> results = this.selectTableId(targetTableId);
		for(CustomerReservationSeatDto r : results) {
			System.out.println(r);
		}
	}
	public ArrayList<CustomerReservationSeatDto> selectAll(){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();
		String sql = "select * from customers,seats,reservations where customers.customer_id = reservations.customer_id and seats.table_id = reservations.table_id";
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				results.add(
					new CustomerReservationSeatDto(
						new CustomerDto(
							rs.getLong("customer_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone")
						),
						new ReservationDto(
							rs.getLong("reservation_id"),
							rs.getLong("customer_id"),
							rs.getLong("table_id"),
							rs.getTimestamp("reservation_time").toLocalDateTime(),
							rs.getLong("number_of_guests")
						),
						new SeatDto(
							rs.getLong("table_id"),
							rs.getLong("customer_seats"),
							rs.getString("status")
						)
					)
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public ArrayList<CustomerReservationSeatDto> selectCustomerId(Long customer_id){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();
		String sql = String.format("select * from customers,seats,reservations where customers.customer_id = %d and customers.customer_id = reservations.customer_id and seats.table_id = reservations.table_id",customer_id);
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				results.add(
					new CustomerReservationSeatDto(
						new CustomerDto(
							rs.getLong("customer_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone")
						),
						new ReservationDto(
							rs.getLong("reservation_id"),
							rs.getLong("customer_id"),
							rs.getLong("table_id"),
							rs.getTimestamp("reservation_time").toLocalDateTime(),
							rs.getLong("number_of_guests")
						),
						new SeatDto(
							rs.getLong("table_id"),
							rs.getLong("customer_seats"),
							rs.getString("status")
						)
					)
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public ArrayList<CustomerReservationSeatDto> selectReservationId(Long reservation_id){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();
		String sql = String.format("select * from customers,seats,reservations where reservations.reservation_id = %d and customers.customer_id = reservations.customer_id and seats.table_id = reservations.table_id",reservation_id);
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				results.add(
					new CustomerReservationSeatDto(
						new CustomerDto(
							rs.getLong("customer_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone")
						),
						new ReservationDto(
							rs.getLong("reservation_id"),
							rs.getLong("customer_id"),
							rs.getLong("table_id"),
							rs.getTimestamp("reservation_time").toLocalDateTime(),
							rs.getLong("number_of_guests")
						),
						new SeatDto(
							rs.getLong("table_id"),
							rs.getLong("customer_seats"),
							rs.getString("status")
						)
					)
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}

	public ArrayList<CustomerReservationSeatDto> selectTableId(Long table_id){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();
		String sql = String.format("select * from customers,seats,reservations where seats.table_id = %d and customers.customer_id = reservations.customer_id and seats.table_id = reservations.table_id",table_id);
		ResultSet rs = DBConn.statementQuery(sql);
		try {
			while(rs.next()) {
				results.add(
					new CustomerReservationSeatDto(
						new CustomerDto(
							rs.getLong("customer_id"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							rs.getString("phone")
						),
						new ReservationDto(
							rs.getLong("reservation_id"),
							rs.getLong("customer_id"),
							rs.getLong("table_id"),
							rs.getTimestamp("reservation_time").toLocalDateTime(),
							rs.getLong("number_of_guests")
						),
						new SeatDto(
							rs.getLong("table_id"),
							rs.getLong("customer_seats"),
							rs.getString("status")
						)
					)
				);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
}
