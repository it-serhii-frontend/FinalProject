package com.ua.sortProduct;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ua.model.Product;

public class PriceDish implements Comparator<Product> {

	@Override
	public int compare(Product a1, Product a2) {
		return (int) (Double.valueOf(a1.getPrice()) - Double.valueOf(a2.getPrice()));
	}

	public List<Product> fromCheaper(List<Product> list) {
		Collections.sort(list, new PriceDish());
		return list;

	}

	public List<Product> fromExpensive(List<Product> list) {
		Comparator<Product> c = Collections.reverseOrder(new PriceDish());
		Collections.sort(list, c);
		return list;

	}

}
