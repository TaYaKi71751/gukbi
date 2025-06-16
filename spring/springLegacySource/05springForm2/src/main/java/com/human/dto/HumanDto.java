package com.human.dto;

public class HumanDto {
	private String id;
	private Integer pw;
	private String name;
	private Integer age;
	
	
	@Override
	public String toString() {
		return "HumanDto [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + "]";
	}


	public HumanDto(){}
	public HumanDto(String id, Integer pw, String name, Integer age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getPw() {
		return pw;
	}
	public void setPw(Integer pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
