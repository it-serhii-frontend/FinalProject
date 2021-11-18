package com.ua.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.ua.dao.OrderDao;
import com.ua.dao.ProductDao;
import com.ua.dao.UserDao;
import com.ua.mail.Mail;
import com.ua.model.Order;
import com.ua.model.Product;
import com.ua.model.User;
/**
 * The main controller, which implements functionality of registration, login,
 * logout
 * 
 * In method doPost also occur different validation and checking, which work with session
 * 
 * @author Serhii Vyshnevskyi
 */
@WebServlet("/control")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static List<Product> productlist = new ArrayList<>();
	static List<String> cartlist = new ArrayList<>();
	static List<User> userList = new ArrayList<>();
	public static String codeValue;
	private static final String CART_LIST = "cartlist";
	private static final String MAIN_PAGE = "main.jsp";
	private static final String LOGIN_PAGE = "login.jsp";
	private static final String SIGNUP_PAGE = "signup.jsp";
	private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());
	private static final String CANNOT_FORWARD ="Cannot forward";
	private static final String EMAIL = "email";
	private static final String USERNAME = "username";
	private static final String ADDRESS = "address";
	
	public static String getCodeValue() {
		return codeValue;
	}

	public static List<String> getCartlist() {
		return cartlist;
	}

	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		if (page == null || page.equals("main")) {

			ProductDao db = new ProductDao();
			try {
				productlist = db.findAllProducts();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "Cannot find products");
			}

			session = request.getSession();
			session.setAttribute(CART_LIST, cartlist);
			session.setAttribute("productlist", productlist);
			try {
				request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
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
		String page = request.getParameter("page");

		if (page.equals("login")) {
			try {
				request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("signUp")) {
			try {
				request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}
		if (page.equals("checkCode")) {
			UserDao us = new UserDao();
			String email = request.getParameter(EMAIL);
			boolean valid = us.checkEmailValid(email);

			int count = 0;

			try {
				count = us.checkEmailExist(email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (count > 0) {
				try {
					JOptionPane.showMessageDialog(null, "This email is already exists!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}
			if (!valid) {
				try {
					JOptionPane.showMessageDialog(null, "Your email is not valid!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}
			Mail m = new Mail();
			String[] arr = { email };

			try {
				m.sendMail(arr);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			codeValue = m.getCode();
			try {
				request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("signUpform")) {
			String username = request.getParameter(USERNAME);
			String email = request.getParameter(EMAIL);
			String address = request.getParameter(ADDRESS);
			String password1 = request.getParameter("password_1");
			String password2 = request.getParameter("password_2");
			String code = request.getParameter("code");
			UserDao us = new UserDao();

			int passwordLength = password1.length();
			boolean valid = us.checkEmailValid(email);

			int count = 0;

			try {
				count = us.checkEmailExist(email);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (count > 0) {
				try {
					JOptionPane.showMessageDialog(null, "This email is already exists!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}
			if (passwordLength < 6) {
				try {
					JOptionPane.showMessageDialog(null, "Your passward is not safety!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}
			if (!valid) {
				try {
					JOptionPane.showMessageDialog(null, "Your email is not valid!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}
			if (password1.equals(password2) && (code.equals(codeValue))) {

				User user = new User();
				user.setUsername(username);
				user.setAddress(address);
				user.setEmail(email);
				user.setPassword(password1);

				UserDao db = new UserDao();

				try {
					db.addUser(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute(USERNAME, username);
				try {
					JOptionPane.showMessageDialog(null, "Account created successfully, Please Login!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			} else {
				try {
					JOptionPane.showMessageDialog(null, "Passwords don't match!", "Info",
							JOptionPane.INFORMATION_MESSAGE);
					request.setAttribute(ADDRESS, address);
					request.setAttribute(EMAIL, email);
					request.setAttribute(USERNAME, username);
					request.getRequestDispatcher(SIGNUP_PAGE).forward(request, response);
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}

		}

		if (page.equals("loginForm")) {

			String username = request.getParameter(USERNAME);
			String password = request.getParameter("password");

			if (username.equals("admin") && password.equals("admin1")) {
				try {
					response.sendRedirect("adminHome.jsp");
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}
			}

			List<User> uses = new ArrayList<>();
			UserDao userDao = new UserDao();
			try {
				uses = userDao.findAllUser();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			for (User u : uses) {
				if (u.getPassword().equals(password) && u.getUsername().equals(username)
						&& u.getStatus().equals("blocked")) {
					try {
						JOptionPane.showMessageDialog(null, "You are blocked!", "Info",
								JOptionPane.INFORMATION_MESSAGE);
						response.sendRedirect(MAIN_PAGE);
						return;
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}

				}
			}

			UserDao db = new UserDao();
			User user = new User();
			boolean status = false;
			try {
				status = db.checkUser(username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (status) {
				session = request.getSession();
				session.setAttribute("session", session);

				try {
					userList = db.findAllUser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					session.setAttribute(ADDRESS, user.getAddress(userList, username));
					session.setAttribute(EMAIL, user.getEmail(userList, username));
					session.setAttribute(USERNAME, username);
					request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
					return;
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			} else {
				try {
					JOptionPane.showMessageDialog(null, "Invalid data!", "Info", JOptionPane.INFORMATION_MESSAGE);
					request.setAttribute(USERNAME, username);
					request.getRequestDispatcher(LOGIN_PAGE).forward(request, response);
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}
			}
		}

		if (page.equals("logout")) {
			session = request.getSession();
			session.invalidate();

			session = request.getSession();
			cartlist.clear();
			session.setAttribute(CART_LIST, cartlist);
			session.setAttribute("productlist", productlist);
			try {
				request.getRequestDispatcher(MAIN_PAGE).forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}

		}

		if (page.equals("addtocart")) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			cartlist.add(id);

			if (action.equals("allproducts")) {
				try {
					request.getRequestDispatcher("all-products.jsp").forward(request, response);
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, CANNOT_FORWARD);
				}

			}

		}
		if (page.equals("remove")) {
			String id = request.getParameter("id");
			Product p = new Product();
			cartlist = p.remove(cartlist, id);

			session = request.getSession();
			session.setAttribute(CART_LIST, cartlist);
			try {
				request.getRequestDispatcher("/bucket").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("success")) {
			if (session != null) {
				String orderId = request.getParameter("prodid");
				String email1 = (String) session.getAttribute(EMAIL);
				int productId = 0;
				try {
					productId = Integer.valueOf(orderId);
				} catch (Exception e) {
					LOGGER.log(Level.WARNING, "Cannot parse int id");
				}
				UserDao us = new UserDao();
				User user = null;
				try {
					user = us.findUserEmail(email1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				int userId = user.getId();
				if (userId != 0) {

					Order order = new Order(userId, productId, "registered");
					OrderDao od = new OrderDao();
					try {
						od.addOrder(order);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				request.getRequestDispatcher("check.jsp").forward(request, response);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		}

		if (page.equals("userOrder")) {
			String email1 = (String) session.getAttribute(EMAIL);
			UserDao us = new UserDao();
			User user = null;
			try {
				user = us.findUserEmail(email1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			if (session != null && user.getId() != 0) {
				List<Order> listAllOrders = new ArrayList<>();
				int userId = user.getId();
				try {
					if (!OrderDao.findOneWhereUserId(userId).isEmpty()) {
						listAllOrders = OrderDao.findOneWhereUserId(userId);

						request.setAttribute("ord", listAllOrders);
						try {
							request.getRequestDispatcher("userOrder.jsp").forward(request, response);
							return;
						} catch (Exception e) {
							LOGGER.log(Level.WARNING, CANNOT_FORWARD);
						}
					}
					try {
						JOptionPane.showMessageDialog(null, "You have not orders!", "Info",
								JOptionPane.INFORMATION_MESSAGE);
						request.getRequestDispatcher("userOrder.jsp").forward(request, response);
						return;
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				} catch (SQLException e1) {
					LOGGER.log(Level.WARNING, "User id = 0");
				}

			}
		}

	}

}
