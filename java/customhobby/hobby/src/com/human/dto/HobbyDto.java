package com.human.dto;

import java.util.Objects;

public class HobbyDto {
	private Integer id;
	private String hobby;
	
	@Override
	public String toString() {
		return "HobbyDto [id=" + id + ", hobby=" + hobby + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(hobby, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HobbyDto other = (HobbyDto) obj;
		return Objects.equals(hobby, other.hobby) && Objects.equals(id, other.id);
	}

	public HobbyDto() {}
	public HobbyDto(Integer id, String hobby) {
		super();
		this.id = id;
		this.hobby = hobby;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
