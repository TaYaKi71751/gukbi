package com.human.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerHobbyDto {
	private int id;
	private String name;
	private double height;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm")
	private Date birthday;
	
	String hobby;

	
	@Override
	public String toString() {
		return "CustomerHobbyDto [id=" + id + ", name=" + name + ", height=" + height + ", birthday=" + birthday
				+ ", hobby=" + hobby + "]";
	}

	public CustomerHobbyDto() {}
	
	public CustomerHobbyDto(int id, String name, double height, Date birthday, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.birthday = birthday;
		this.hobby = hobby;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	
	
	

}
