package com.checkIn.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {

	@Id
	private String username;
	private String password;
	private String roles;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(String username, String password, String roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
