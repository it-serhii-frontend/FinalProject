package com.ua.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet, which show bucket's content
 * 
 * @author Serhii Vyshnevskyi
 */
@WebServlet("/bucket")
public class BucketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final  String CART = "/cart.jsp";
	private static final Logger LOGGER = Logger.getLogger(BucketServlet.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("cartList", Controller.getCartlist());
		try {
			request.getRequestDispatcher(CART).forward(request, response);

		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Cannot forward");
		}
	}

}
