package com.ua.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Product implements Comparator<Product>, Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private String price;
	private String category;
	private String image;
	private String created;

	public Product(int id, String name, String description, String price, String category, String image,
			String created) {

		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.created = created;
	}

	public String getCreated_At() {
		return created;
	}

	public void setCreated_At(String created_At) {
		this.created = created_At;
	}

	public Product() {

	}

	public Product(String name, String description, String price, String category, String image, String created) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.image = image;
		this.created = created;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductDish [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", image=" + image + ", created_At=" + created + "]";
	}

	@Override
	public int compare(Product a1, Product a2) {
		return a1.getName().compareTo(a2.getName());
	}

	public List<String> remove(List<String> cartlist, String id) {
		for (String cid : cartlist) {
			if (cid.equals(id)) {
				cartlist.remove(cid);
				break;
			}
		}
		return cartlist;
	}

}
