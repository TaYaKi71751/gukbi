package com.reservation.dto;

import java.util.Objects;

public class SeatDto {
	private Long tableId;
	private Long customerSeats;
	private String status;
	public Long getTableId() {
		return tableId;
	}
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	public Long getCustomerSeats() {
		return customerSeats;
	}
	public void setCustomerSeats(Long customerSeats) {
		this.customerSeats = customerSeats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(customerSeats, status, tableId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeatDto other = (SeatDto) obj;
		return Objects.equals(customerSeats, other.customerSeats) && Objects.equals(status, other.status)
				&& Objects.equals(tableId, other.tableId);
	}
	@Override
	public String toString() {
		return "SeatDto [tableId=" + tableId + ", customerSeats=" + customerSeats + ", status=" + status + "]";
	}
	public SeatDto(Long tableId, Long customerSeats, String status) {
		super();
		this.tableId = tableId;
		this.customerSeats = customerSeats;
		this.status = status;
	}
	
}
