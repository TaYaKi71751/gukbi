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
		String sql = "select customers.*, "
	           + "reservations.reservation_id, reservations.customer_id as reservation_customer_id, "
	           + "reservations.table_id as reservations_table_id, reservations.reservation_time, reservations.number_of_guests, "
	           + "seats.table_id as seats_table_id, seats.customer_seats, seats.status "
	           + "from customers "
	           + "full outer join reservations on customers.customer_id = reservations.customer_id "
	           + "full outer join seats on seats.table_id = reservations.table_id";

		try { 
			ResultSet rs = DBConn.statementQuery(sql);
	    while (rs.next()) {
	        results.add(new CustomerReservationSeatDto(
	            new CustomerDto(
	                rs.getLong("customer_id"),
	                rs.getString("first_name"),
	                rs.getString("last_name"),
	                rs.getString("email"),
	                rs.getString("phone")
	            ),
	            new ReservationDto(
	                rs.getLong("reservation_id"),
	                rs.getLong("reservation_customer_id"),
	                rs.getLong("reservations_table_id"),
	                rs.getTimestamp("reservation_time") != null 
	                    ? rs.getTimestamp("reservation_time").toLocalDateTime() 
	                    : null,
	                rs.getLong("number_of_guests")
	            ),
	            new SeatDto(
	                rs.getLong("seats_table_id"),
	                rs.getLong("customer_seats"),
	                rs.getString("status")
	            )
	        ));
	    }
	} catch (SQLException e) {
	    e.printStackTrace(); // Consider logging instead
	}

	return results;
	}

	public ArrayList<CustomerReservationSeatDto> selectCustomerId(Long customer_id){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();

		String sql = "select customers.*, "
		           + "reservations.reservation_id, reservations.customer_id as reservation_customer_id, "
		           + "reservations.table_id as reservations_table_id, reservations.reservation_time, reservations.number_of_guests, "
		           + "seats.table_id as seat_table_id, seats.customer_seats, seats.status "
		           + "from customers "
		           + "full outer join reservations on customers.customer_id = reservations.customer_id "
		           + "full outer join seats on seats.table_id = reservations.table_id "
		           + "where customers.customer_id = " + customer_id;
	
		ResultSet rs = DBConn.statementQuery(sql);
	
		try {
		    while (rs.next()) {
		        results.add(new CustomerReservationSeatDto(
		            new CustomerDto(
		                rs.getLong("customer_id"),
		                rs.getString("first_name"),
		                rs.getString("last_name"),
		                rs.getString("email"),
		                rs.getString("phone")
		            ),
		            new ReservationDto(
		                rs.getLong("reservation_id"),
		                rs.getLong("reservation_customer_id"),
		                rs.getLong("reservations_table_id"),
		                rs.getTimestamp("reservation_time") != null 
		                    ? rs.getTimestamp("reservation_time").toLocalDateTime() 
		                    : null,
		                rs.getLong("number_of_guests")
		            ),
		            new SeatDto(
		                rs.getLong("seat_table_id"),
		                rs.getLong("customer_seats"),
		                rs.getString("status")
		            )
		        ));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	
		return results;
	}

	public ArrayList<CustomerReservationSeatDto> selectReservationId(Long reservation_id){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();
		String sql = String.format(
		    "select customers.*, "
		  + "reservations.reservation_id, reservations.customer_id as reservation_customer_id, "
		  + "reservations.table_id as reservations_table_id, reservations.reservation_time, reservations.number_of_guests, "
		  + "seats.table_id as seat_table_id, seats.customer_seats, seats.status "
		  + "from reservations "
		  + "full outer join customers on customers.customer_id = reservations.customer_id "
		  + "full outer join seats on seats.table_id = reservations.table_id "
		  + "where reservations.reservation_id = %d", reservation_id);
		ResultSet rs = DBConn.statementQuery(sql);
	
		try {
		    while (rs.next()) {
		        results.add(new CustomerReservationSeatDto(
		            new CustomerDto(
		                rs.getLong("customer_id"),
		                rs.getString("first_name"),
		                rs.getString("last_name"),
		                rs.getString("email"),
		                rs.getString("phone")
		            ),
		            new ReservationDto(
		                rs.getLong("reservation_id"),
		                rs.getLong("reservation_customer_id"),
		                rs.getLong("reservations_table_id"),
		                rs.getTimestamp("reservation_time") != null 
		                    ? rs.getTimestamp("reservation_time").toLocalDateTime() 
		                    : null,
		                rs.getLong("number_of_guests")
		            ),
		            new SeatDto(
		                rs.getLong("seat_table_id"),
		                rs.getLong("customer_seats"),
		                rs.getString("status")
		            )
		        ));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return results;
	}

	public ArrayList<CustomerReservationSeatDto> selectTableId(Long table_id){
		ArrayList<CustomerReservationSeatDto> results = new ArrayList<CustomerReservationSeatDto>();
		String sql = String.format(
		    "select customers.*, "
		  + "reservations.reservation_id, reservations.customer_id as reservation_customer_id, "
		  + "reservations.table_id as reservations_table_id, reservations.reservation_time, reservations.number_of_guests, "
		  + "seats.table_id as seat_table_id, seats.customer_seats, seats.status "
		  + "from seats "
		  + "full outer join reservations on seats.table_id = reservations.table_id "
		  + "full outer join customers on customers.customer_id = reservations.customer_id "
		  + "where seats.table_id = %d", table_id);
	
		ResultSet rs = DBConn.statementQuery(sql);
	
		try {
		    while (rs.next()) {
		        results.add(new CustomerReservationSeatDto(
		            new CustomerDto(
		                rs.getLong("customer_id"),
		                rs.getString("first_name"),
		                rs.getString("last_name"),
		                rs.getString("email"),
		                rs.getString("phone")
		            ),
		            new ReservationDto(
		                rs.getLong("reservation_id"),
		                rs.getLong("reservation_customer_id"),
		                rs.getLong("reservations_table_id"),
		                rs.getTimestamp("reservation_time") != null 
		                    ? rs.getTimestamp("reservation_time").toLocalDateTime() 
		                    : null,
		                rs.getLong("number_of_guests")
		            ),
		            new SeatDto(
		                rs.getLong("seat_table_id"),
		                rs.getLong("customer_seats"),
		                rs.getString("status")
		            )
		        ));
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	
		return results;
	}
}
