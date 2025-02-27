package com.reservation.dto;

import java.util.Objects;

public class CustomerReservationSeatDto {
	CustomerDto customer;
	ReservationDto reservation;
	SeatDto seat;
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public ReservationDto getReservation() {
		return reservation;
	}
	public void setReservation(ReservationDto reservation) {
		this.reservation = reservation;
	}
	public SeatDto getSeat() {
		return seat;
	}
	public void setSeat(SeatDto seat) {
		this.seat = seat;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customer, reservation, seat);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerReservationSeatDto other = (CustomerReservationSeatDto) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(reservation, other.reservation)
				&& Objects.equals(seat, other.seat);
	}
	@Override
	public String toString() {
		return "CustomerReservationSeatDto [customer=" + customer + ", reservation=" + reservation + ", seat=" + seat
				+ "]";
	}
	public CustomerReservationSeatDto(CustomerDto customer, ReservationDto reservation, SeatDto seat) {
		super();
		this.customer = customer;
		this.reservation = reservation;
		this.seat = seat;
	}
	
}
