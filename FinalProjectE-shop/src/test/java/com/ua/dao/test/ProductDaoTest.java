package com.ua.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.sun.mail.iap.ConnectionException;
import com.ua.dao.ProductDao;
import com.ua.dbConnection.DbManager;
import com.ua.model.Product;

public class ProductDaoTest {

	@BeforeAll
	static void initializeConnectionPool() throws ConnectionException {
		DbManager.getInstance().dbConnect();
	}

	@Test
	public void testFindOne_AndReturnValue() throws SQLException {
		ProductDao pd = new ProductDao();
		Product actual = pd.findOneProduct("3");
		Product expected = new Product();

		expected.setId(3);
		expected.setName("Чашка Літо");
		expected.setDescription("Літній колір. Якісне скло");
		expected.setPrice("86.00");
		expected.setCategory("чашка");
		expected.setImage("imgs/chashkaSumm.jpg");
		expected.setCreated_At("2020");

		assertEquals(expected, actual);
	}

	@Test
	public void testFindAll_AndReturnValue() throws SQLException {
		ProductDao pd = new ProductDao();
		List<Product> actual = new ArrayList<>();
		actual = pd.findAllProducts();

		List<Product> expected = new ArrayList<>();
		Product pr1 = new Product(1, "Чашка Осінь", "Осінній колір. Якісне скло", "80.50", "чашка",
				"imgs/chashkaAut.jpg", "2020");
		Product pr2 = new Product(2, "Чашка Весна", "Весняний колір. Якісне скло", "75.00", "чашка",
				"imgs/chashkaSpr.jpg", "2021");
		expected.add(pr1);
		expected.add(pr2);

		assertEquals(expected, actual);
	}

}
