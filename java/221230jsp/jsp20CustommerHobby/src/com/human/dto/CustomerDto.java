package com.human.dto;

import java.time.LocalDateTime;
import java.util.Objects;

//dto에 추가해야 할것들
//1. getter,setter
//2. 생성자
//3. equals hashcode
//4. toString
public class CustomerDto {
	private Integer id;
	private String name;
	private Double height;
	private LocalDateTime birthday;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CustomerDto other = (CustomerDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public CustomerDto() {}
	public CustomerDto(Integer id, String name, Double height, LocalDateTime birthday) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "HumanDto [id=" + id + ", name=" + name + ", height=" + height + ", birthday=" + birthday + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public LocalDateTime getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDateTime birthday) {
		this.birthday = birthday;
	}
	
	
	
}
