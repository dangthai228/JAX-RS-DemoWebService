package com.thaind.model;


public class User {
	 private Integer id;
	 private String username,email,phone,address,position;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(Integer id, String username, String email, String phone, String address, String position) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	 
}
