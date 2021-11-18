package com.ua.sortProduct;

import java.util.ArrayList;
import java.util.List;

import com.ua.model.Product;

public class Categories {
	public List<Product> categoryGlass(List<Product> list) {
		List<Product> newCategory = new ArrayList<>();
		for (Product item : list) {
			if (item.getCategory().equals("чашка")) {
				newCategory.add(item);
			}
		}
		return newCategory;

	}

	public List<Product> categoryKettle(List<Product> list) {
		List<Product> newCategory = new ArrayList<>();
		for (Product item : list) {
			if (item.getCategory().equals("чайник")) {
				newCategory.add(item);
			}
		}
		return newCategory;

	}

}
