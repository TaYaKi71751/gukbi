package com.the.dto;
import java.time.LocalDateTime;
import java.util.Objects;

public class CustomerHobbyDto {
	private CustomerDto customer;
	private HobbyDto hobby;

	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public HobbyDto getHobby() {
		return hobby;
	}
	public void setHobby(HobbyDto hobby) {
		this.hobby = hobby;
	}
	public CustomerHobbyDto() {}
	public CustomerHobbyDto(CustomerDto customer, HobbyDto hobby) {
        this.customer = customer;
        this.hobby = hobby;
    }
	public boolean equals(Object o) {
		if (this == o) return true;
        if (!(o instanceof CustomerHobbyDto)) return false;
        CustomerHobbyDto that = (CustomerHobbyDto) o;
        return Objects.equals(customer, that.customer) && Objects.equals(hobby, that.hobby);
	}
	/**
	  * Returns a string representation of the CustomerHobbyDto object.
	  * 
	  * This method overrides the default toString() method to provide a custom
	  * string representation of the CustomerHobbyDto, including the customer and hobby details.
	  *
	  * @return A string representation of the CustomerHobbyDto object in the format:
	  *         "CustomerHobbyDto [customer=<customer>, hobby=<hobby>]"
	  */
	public String toString() {
    	return "CustomerHobbyDto [customer=" + customer + ", hobby=" + hobby + "]";
	}
}

