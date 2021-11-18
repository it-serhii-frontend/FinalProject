package com.ua.sortProduct;

import java.util.ArrayList;
import java.util.List;

import com.ua.model.Product;

public class Years {
	public List<Product> years2019(List<Product> list) {
		List<Product> newCategory = new ArrayList<>();
		for (Product item : list) {
			if (item.getCreated_At().equals("2019")) {
				newCategory.add(item);
			}
		}
		return newCategory;

	}

	public List<Product> years2020(List<Product> list) {
		List<Product> newCategory = new ArrayList<>();
		for (Product item : list) {
			if (item.getCreated_At().equals("2020")) {
				newCategory.add(item);
			}
		}
		return newCategory;

	}
	public List<Product> years2021(List<Product> list) {
		List<Product> newCategory = new ArrayList<>();
		for (Product item : list) {
			if (item.getCreated_At().equals("2021")) {
				newCategory.add(item);
			}
		}
		return newCategory;
	}
	

}
