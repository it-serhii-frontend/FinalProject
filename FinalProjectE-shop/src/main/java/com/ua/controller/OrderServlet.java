package com.ua.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ua.dao.OrderDao;
import com.ua.model.Order;
/**
 * Servlet, which implements functionality of showing all orders
 * 
 * 
 * @author Serhii Vyshnevskyi
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Order> ordList = new ArrayList<>();
	private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderDao pd = new OrderDao();
		HttpSession session;

		try {
			ordList = pd.findAllOrders();
			session = request.getSession();
			session.setAttribute("ordList", ordList);
			request.getRequestDispatcher("/orders.jsp").forward(request, response);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Cannot find orders");
		}
	}

}
