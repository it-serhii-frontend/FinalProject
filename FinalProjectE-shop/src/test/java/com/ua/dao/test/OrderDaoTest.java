package com.ua.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.sun.mail.iap.ConnectionException;
import com.ua.dao.OrderDao;
import com.ua.dbConnection.DbManager;
import com.ua.model.Order;

public class OrderDaoTest {

	@BeforeAll
	static void initializeConnectionPool() throws ConnectionException {
		DbManager.getInstance().dbConnect();
	}

	@Test
	public void testFindOne_AndReturnValue() throws SQLException {
		OrderDao od = new OrderDao();
		Order actual = od.findOne(1);
		Order expected = new Order();

		expected.setId(1);
		expected.setUserId(1);
		expected.setProductId(1);
		expected.setStatus("registered");

		assertEquals(expected, actual);
	}

	@Test
	public void testFindAll_AndReturnValue() throws SQLException {
		OrderDao od = new OrderDao();
		List<Order> actual = od.findAllOrders();
		Order order = new Order();
		List<Order> expected = new ArrayList<>();

		order.setId(1);
		order.setUserId(1);
		order.setProductId(1);
		order.setStatus("registered");
		expected.add(order);

		assertEquals(expected, actual);
	}
	
	@Test
	public void testFindAllWhere_AndReturnValue() throws SQLException {
		List<Order> actual = OrderDao.findOneWhereUserId(1);
		Order order = new Order();
		List<Order> expected = new ArrayList<>();

		order.setId(1);
		order.setUserId(1);
		order.setProductId(1);
		order.setStatus("registered");
		expected.add(order);

		assertEquals(expected, actual);
	}

}
