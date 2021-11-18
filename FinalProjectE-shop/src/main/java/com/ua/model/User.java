package com.ua.model;

import java.util.List;

public class User {

	private int id;
	private String username;
	private String email;
	private String address;
	private String password;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Object getAddress(List<User> userList, String username) {
		for (User u : userList) {
			if (u.getUsername().equals(username))
				return u.getAddress();
		}
		return "";
	}

	public Object getEmail(List<User> userList, String username) {
		for (User u : userList) {
			if (u.getUsername().equals(username))
				return u.getEmail();
		}
		return "";
	}




}
