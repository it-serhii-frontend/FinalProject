package com.ua.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.ua.dao.OrderDao;
import com.ua.dao.ProductDao;
import com.ua.dao.UserDao;
import com.ua.model.Order;
import com.ua.model.Product;
import com.ua.model.User;
/**
 * Controller, which implements functionality of Administrator.
 * 
 * Administrator can log in with the next data: username: admin@gmail.com and password: admin
 * 
 * In method doPost describe the next functionality: to delete product, to see all products,
 * to see all users, to see all orders, to add product, to edit product, to work with orders's and users's state
 * 
 * 
 * @author Serhii Vyshnevskyi
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static List<User> userList = new ArrayList<>();
	static List<User> blockedUsers = new ArrayList<>();
	private static final Logger LOGGER = Logger.getLogger(AdminController.class.getName());
	private static final String CANNOT_FORWARD = "Cannot forward";
	private static final String ADMIN_ALL_PRODUCTS = "admin/allProducts.jsp";
	private static final String ADMIN_ALL_ORDERS = "admin/allOrders.jsp";
	private static final String CANNOT_PARSE_INT = "Cannot parse int id";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String page = request.getParameter("page");
		if (page == null) {
			try {
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		} else {
			try {
				doPost(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, "Cannot doPost");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getContentType();
		String page = request.getParameter("page");
		if (page.equals("admin-login-form")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (username.equals("admin@gmail.com") && password.equals("admin")) {
				try {
					request.getRequestDispatcher("admin/main.jsp").forward(request, response);
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			} else {
				try {
					JOptionPane.showMessageDialog(null, "Something went wrong!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.setAttribute("username", username);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}
		}

		if (page.equals("delete")) {
			String id = request.getParameter("id");
			ProductDao db = new ProductDao();
			try {
				db.deleteProduct(id);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot delete");
			}
			try {
				request.getRequestDispatcher(ADMIN_ALL_PRODUCTS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}
		if (page.equals("main")) {
			try {
				request.getRequestDispatcher("admin/main.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}
		if (page.equals("allproducts")) {
			try {
				request.getRequestDispatcher(ADMIN_ALL_PRODUCTS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("addproduct")) {
			try {
				request.getRequestDispatcher("admin/addProduct.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("edit")) {
			String id = request.getParameter("id");
			ProductDao account = new ProductDao();
			Product p = null;
			try {
				p = account.findOneProduct(id);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot find product");
			}
			request.setAttribute("p", p);
			try {
				request.getRequestDispatcher("admin/editProduct.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("edit_product")) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String image = request.getParameter("image");
			String created = request.getParameter("created");

			Product p = new Product();
			try {
				p.setId(Integer.parseInt(id));
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_PARSE_INT);
			}
			p.setName(name);
			p.setDescription(description);
			p.setPrice(price);
			p.setCategory(category);
			p.setImage(image);
			p.setCreated_At(created);

			ProductDao account = new ProductDao();
			try {
				account.updateProduct(p);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot update product");
			}
			try {
				request.getRequestDispatcher(ADMIN_ALL_PRODUCTS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("add_product")) {
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String image = request.getParameter("image");
			String created = request.getParameter("created");

			Product p = new Product();
			p.setName(name);
			p.setDescription(description);
			p.setPrice(price);
			p.setCategory(category);
			p.setImage(image);
			p.setCreated_At(created);

			ProductDao account = new ProductDao();
			try {
				account.addProduct(p);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot add product");
			}

			try {
				JOptionPane.showMessageDialog(null, "Product added Successfully", "Info",
						JOptionPane.INFORMATION_MESSAGE);
				request.getRequestDispatcher(ADMIN_ALL_PRODUCTS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}
		if (page.equals("allusers")) {
			try {
				request.getRequestDispatcher("admin/allUsers.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}
		if (page.equals("block")) {
			String id = request.getParameter("id");
			UserDao userDao = new UserDao();
			User user = null;
			try {
				user = userDao.findOneUser(id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				user.setId(Integer.valueOf(id));
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_PARSE_INT);
			}
			user.setStatus("blocked");
			try {
				userDao.updateUserStatus(user);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot block user");
			}
			try {
				request.getRequestDispatcher("admin/allUsers.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}
		if (page.equals("active")) {
			String id = request.getParameter("id");
			UserDao userDao = new UserDao();
			User user = null;
			try {
				user = userDao.findOneUser(id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				user.setId(Integer.valueOf(id));
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_PARSE_INT);
			}
			user.setStatus("active");
			try {
				userDao.updateUserStatus(user);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot activate user");
			}
			try {
				request.getRequestDispatcher("admin/allUsers.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}
		if (page.equals("allorders")) {
			try {
				request.getRequestDispatcher(ADMIN_ALL_ORDERS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}
		if (page.equals("ready")) {
			String id = request.getParameter("id");
			OrderDao orderDao = new OrderDao();
			Order order = null;
			try {
				order = orderDao.findOne(Integer.valueOf(id));
			} catch (SQLException e1) {
				LOGGER.log(Level.WARNING, "Cannot find order");
			}
			try {
				order.setId(Integer.valueOf(id));

			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_PARSE_INT);
			}
			order.setStatus("ready");
			try {
				orderDao.updateOrderStatus(order);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot change status");
			}
			try {
				request.getRequestDispatcher(ADMIN_ALL_ORDERS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}
		if (page.equals("cancel")) {
			String id = request.getParameter("id");
			OrderDao orderDao = new OrderDao();
			Order order = null;
			try {
				order = orderDao.findOne(Integer.valueOf(id));
			} catch (SQLException e1) {
				LOGGER.log(Level.WARNING, "Cannot find order");
			}
			try {
				order.setId(Integer.valueOf(id));
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_PARSE_INT);
			}
			order.setStatus("cancel");
			try {
				orderDao.updateOrderStatus(order);
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot change status");
			}
			try {
				request.getRequestDispatcher(ADMIN_ALL_ORDERS).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}

	}
}
