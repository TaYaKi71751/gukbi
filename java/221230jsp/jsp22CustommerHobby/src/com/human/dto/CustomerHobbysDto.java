package com.human.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CustomerHobbysDto {
	private int id;
	private String name;
	private double height;
	private LocalDateTime birthday;
	
	private List<HobbyDto> hobbys;

	
	public CustomerHobbysDto() {}
	public CustomerHobbysDto(int id, String name, double height, LocalDateTime birthday, List<HobbyDto> hobbys) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.birthday = birthday;
		this.hobbys = hobbys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((hobbys == null) ? 0 : hobbys.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerHobbysDto other = (CustomerHobbysDto) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (hobbys == null) {
			if (other.hobbys != null)
				return false;
		} else if (!hobbys.equals(other.hobbys))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CustomerHobbysDto [id=" + id + ", name=" + name + ", height=" + height + ", birthday=" + birthday
				+ ", hobbys=" + hobbys + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public LocalDateTime getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}

	public List<HobbyDto> getHobbys() {
		return hobbys;
	}

	public void setHobbys(List<HobbyDto> hobbys) {
		this.hobbys = hobbys;
	}
	
	

}
