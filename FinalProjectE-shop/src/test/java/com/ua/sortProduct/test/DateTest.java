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
import com.ua.sortProduct.Date;

public class DateTest {
	private OutputStream out = new ByteArrayOutputStream();
	private static final InputStream INPUT = System.in;
	private static final PrintStream OUTPUT = System.out;

	@Before
	public void before() {
		System.setOut(new PrintStream(out));
	}

	@Test
	public void dateTest() {
		Product prod = new Product("tea1", "new", "44", "чашка", "img", "2010");
		Product prod2 = new Product("tea1", "new", "44", "чайник", "img", "2015");
		Product prod3 = new Product("tea1", "new", "44", "чашка", "img", "2008");

		List<Product> list = new ArrayList<>();
		list.add(prod);
		list.add(prod2);
		list.add(prod3);

		Date date = new Date();
		List<Product> actual = date.fromNew(list);

		List<Product> expected = new ArrayList<>();
		expected.add(prod2);
		expected.add(prod);
		expected.add(prod3);
		assertEquals(expected, actual);
	}
	@Test
	public void dateTest1() {
		Product prod = new Product("tea1", "new", "44", "чашка", "img", "2010");
		Product prod2 = new Product("tea1", "new", "44", "чайник", "img", "2015");
		Product prod3 = new Product("tea1", "new", "44", "чашка", "img", "2008");

		List<Product> list = new ArrayList<>();
		list.add(prod);
		list.add(prod2);
		list.add(prod3);

		Date date = new Date();
		List<Product> actual = date.fromOld(list);

		List<Product> expected = new ArrayList<>();
		expected.add(prod3);
		expected.add(prod);
		expected.add(prod2);

		assertEquals(expected, actual);
	}

	@After
	public void after() {
		System.setIn(INPUT);
		System.setOut(OUTPUT);
	}
}
