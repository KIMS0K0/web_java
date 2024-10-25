package com.sk.mvc.dtos;

import java.util.*;

public class ManagerDto {

	public String userId;
	public String name;
	public String password;
	public String address;
	public String email;
	public String enabled;
	public String role;
	public Date regdate;
	
	public ManagerDto() {
	
	}
	
	public ManagerDto(String userId, String name, String password, String address, String email, String enabled,
			String role, Date regdate) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.address = address;
		this.email = email;
		this.enabled = enabled;
		this.role = role;
		this.regdate = regdate;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ManagerDto [userId=" + userId + ", name=" + name + ", password=" + password + ", address=" + address
				+ ", email=" + email + ", enabled=" + enabled + ", role=" + role + ", regdate=" + regdate + "]";
	}
}
