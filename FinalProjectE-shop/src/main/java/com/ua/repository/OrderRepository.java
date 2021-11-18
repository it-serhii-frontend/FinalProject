package com.ua.repository;

import java.sql.SQLException;

import com.ua.model.Order;
/**
 * OrderRepository interface 
 * 
 * @author Serhii Vyshnevskyi
 */
public interface OrderRepository {
	void addOrder(Order p) throws SQLException;

	void deleteOrders(String id) throws SQLException;

	void updateOrderStatus(Order p) throws SQLException;

	Order findOne(int id) throws SQLException;
}
