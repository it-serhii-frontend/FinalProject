package com.ua.model;

public class Order {

	private int id;
	private int userId;
	private int productId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Order(int userId, int productId, String status) {
		this.userId = userId;
		this.productId = productId;
		this.status = status;
	}

	public Order(int id, int userId, int productId, String status) {
		this.id = id;
		this.userId = userId;
		this.productId = productId;
		this.status = status;
	}

	public Order() {
	}

}
