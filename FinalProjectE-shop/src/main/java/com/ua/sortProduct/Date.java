package com.ua.sortProduct;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ua.model.Product;


public class Date implements Comparator<Product> {

	@Override
	public int compare(Product a1, Product a2) {
		return a1.getCreated_At().compareTo(a2.getCreated_At());
	}

	public List<Product> fromOld(List<Product> list) {
		Collections.sort(list, new Date());
		return list;

	}

	public List<Product> fromNew(List<Product> list) {
		Comparator<Product> c = Collections.reverseOrder(new Date());
		Collections.sort(list, c);
		return list;

	}

}