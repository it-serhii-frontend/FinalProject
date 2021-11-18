package com.ua.sortProduct.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ua.model.Product;
import com.ua.sortProduct.Categories;

public class CategoriesTest {
	private OutputStream out = new ByteArrayOutputStream();
	private static final InputStream INPUT = System.in;
	private static final PrintStream OUTPUT = System.out;

	@Before
	public void before() {
		System.setOut(new PrintStream(out));
	}

	@Test
	public void categTest() {
		Product prod = new Product("tea1", "new", "44", "чашка", "img", "2020");
		Product prod2 = new Product("tea1", "new", "44", "чайник", "img", "2020");
		Product prod3 = new Product("tea1", "new", "44", "чашка", "img", "2020");

		List<Product> list = new ArrayList<>();
		list.add(prod);
		list.add(prod2);
		list.add(prod3);

		Categories categ = new Categories();
		List<Product> actual = categ.categoryKettle(list);

		List<Product> expected = new ArrayList<>();
		expected.add(prod2);
		
		assertEquals(expected, actual);
	}
	@Test
	public void categTest1() {
		Product prod = new Product("tea1", "new", "44", "чайник", "img", "2020");
		Product prod2 = new Product("tea1", "new", "44", "чайник", "img", "2020");
		Product prod3 = new Product("tea1", "new", "44", "чашка", "img", "2020");

		List<Product> list = new ArrayList<>();
		list.add(prod);
		list.add(prod2);
		list.add(prod3);

		Categories categ = new Categories();
		List<Product> actual = categ.categoryGlass(list);

		List<Product> expected = new ArrayList<>();
		expected.add(prod3);
		
		assertEquals(expected, actual);
	}

	@After
	public void after() {
		System.setIn(INPUT);
		System.setOut(OUTPUT);
	}
}
