package com.reservation.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ReservationDto {
	private Long reservationId;
	private Long customerId;
	private Long tableId;
	private LocalDateTime reservationTime;
	private Long numberOfGuests;
	public Long getReservationId() {
		return reservationId;
	}
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public LocalDateTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalDateTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public Long getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(Long numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerId, numberOfGuests, reservationId, reservationTime, tableId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationDto other = (ReservationDto) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(numberOfGuests, other.numberOfGuests)
				&& Objects.equals(reservationId, other.reservationId)
				&& Objects.equals(reservationTime, other.reservationTime) && Objects.equals(tableId, other.tableId);
	}
	@Override
	public String toString() {
		return "ReservationDto [reservationId=" + reservationId + ", customerId=" + customerId + ", tableId=" + tableId
				+ ", reservationTime=" + reservationTime + ", numberOfGuests=" + numberOfGuests + "]";
	}
	public ReservationDto() {}
	public ReservationDto(Long reservationId, Long customerId, Long tableId, LocalDateTime reservationTime,
			Long numberOfGuests) {
		super();
		this.reservationId = reservationId;
		this.customerId = customerId;
		this.tableId = tableId;
		this.reservationTime = reservationTime;
		this.numberOfGuests = numberOfGuests;
	}
	
	
}
