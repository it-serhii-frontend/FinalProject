package com.ua.sortProduct;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ua.model.Product;

public class NameDish implements Comparator<Product> {

	@Override
	public int compare(Product a1, Product a2) {
		return a1.getName().compareTo(a2.getName());
	}

	public List<Product> fromAtoZ(List<Product> list) {
		for (Product item : list) {
			String name = item.getName();
			Pattern p = Pattern.compile("\\p{InCYRILLIC}.+");
			Matcher m = p.matcher(name);
			if (m.find()) {
				char[] cyrilic = "�?аБбВвГгДдЕеЄєЖжЗзИиЙйКкЛлМм�?нОоПпРрС�?ТтУуФфХхЦцЧчШшЩщ".toCharArray();
				char[] cyrilicTo = "AaBbWwGgDdEeEeZzZzIiJjKkLlMmNnOoPpRrSsTtUuFfHhCcCcSsss".toCharArray();

				for (int i = 0; i < cyrilic.length; i++) {
					name = name.replace(cyrilic[i], cyrilicTo[i]);

					Collections.sort(list, new Product());
					return list;
				}
			}
			Collections.sort(list, new Product());
			return list;
		}
		return list;
	}

	public List<Product> fromZtoA(List<Product> list) {
		Comparator<Product> c = Collections.reverseOrder(new Product());
		Collections.sort(list, c);
		return list;

	}

}