package com.ua.dao.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.sun.mail.iap.ConnectionException;
import com.ua.dao.UserDao;
import com.ua.dbConnection.DbManager;
import com.ua.model.User;

public class UserDaoTest {
	@BeforeAll
	static void initializeConnectionPool() throws ConnectionException {
		DbManager.getInstance().dbConnect();
	}

	@Test
	public void testEmailValid() throws SQLException {
		UserDao ud = new UserDao();
		boolean actual = ud.checkEmailValid("email@gmail.com");

		assertEquals(true, actual);
	}

	@Test
	public void testEmailExists() throws SQLException {
		UserDao ud = new UserDao();
		int actual = 0;
		actual = ud.checkEmailExist("email@gmail.com");
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void testFindOne() throws SQLException {
		UserDao ud = new UserDao();
		User actual = ud.findOneUser("5");
		User expected = new User();
		expected.setId(5);
		expected.setUsername("john");
		expected.setEmail("email@gmail.com");
		expected.setAddress("ua");
		expected.setPassword("322232");
		expected.setStatus("active");

		assertEquals(expected, actual);
	}
	
	@Test
	public void checkOne() throws SQLException {
		UserDao ud = new UserDao();
		boolean actual = ud.checkUser("john", "322232");
		boolean expected = true;

		assertEquals(expected, actual);
	}
}
