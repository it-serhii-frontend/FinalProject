package com.ua.dbConnection.test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ua.dbConnection.DbManager;

public class ConnectionPoolTest {

	@Test
	public void testInstance_Return_Always_TheSameClass() {
		DbManager first = DbManager.getInstance();
		DbManager second = DbManager.getInstance();

		assertEquals(first, second);
	}

	
}