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

import com.ua.dao.ProductDao;
import com.ua.model.Product;
import com.ua.model.User;
import com.ua.sortProduct.Categories;
import com.ua.sortProduct.Date;
import com.ua.sortProduct.NameDish;
import com.ua.sortProduct.PriceDish;
import com.ua.sortProduct.Years;
/**
 * Servlet, which implements functionality of showing products.
 * 
 * In method doPost we can sort products by different categories
 * 
 * @author Serhii Vyshnevskyi
 */
@WebServlet("/allDish")
public class AllDishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	List<User> userList = new ArrayList<>();
	private static List<String> cartlist = new ArrayList<>();
	List<Product> productlist = new ArrayList<>();
	private static final String ALL_PRODUCTS = "/all-products.jsp";
	private static final String PRODUCT_LIST = "productlist";
	private static final String CANNOT_FORWARD = "Cannot forward";

	private static final Logger LOGGER = Logger.getLogger(AllDishServlet.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductDao pd = new ProductDao();

		try {
			productlist = pd.findAllProducts();
			session = req.getSession();
			session.setAttribute("cartlist", cartlist);
			session.setAttribute(PRODUCT_LIST, productlist);
			try {
				req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
			} catch (Exception e) {
				LOGGER.log(Level.WARNING, CANNOT_FORWARD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("variant");

		if (page != null)

		{

			if (page.equals("page")) {
				String param = req.getParameter("sort");
				ProductDao pd1 = new ProductDao();

				if (param.equals("first")) {
					try {
						productlist = pd1.getSomeDish(1, 6);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("second")) {
					try {
						productlist = pd1.getSomeDish(7, 12);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("all")) {
					try {
						productlist = pd1.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}

					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}

			}

			if (page.equals("sortName")) {
				String param = req.getParameter("sort");
				NameDish name = new NameDish();

				if (param.equals("asc")) {
					productlist = name.fromAtoZ(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("desc")) {
					productlist = name.fromZtoA(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}

			}

			if (page.equals("sortPrice")) {
				String param = req.getParameter("sort");
				PriceDish price = new PriceDish();

				if (param.equals("asc")) {
					productlist = price.fromCheaper(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("desc")) {
					productlist = price.fromExpensive(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}

			}
			if (page.equals("sortDate")) {
				String param = req.getParameter("sort");
				Date date = new Date();

				if (param.equals("asc")) {
					productlist = date.fromNew(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("desc")) {
					productlist = date.fromOld(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}

			}
			if (page.equals("sortCateg")) {
				String param = req.getParameter("sort");
				Categories cat = new Categories();
				ProductDao pd = new ProductDao();

				if (param.equals("all")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("glass")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					productlist = cat.categoryGlass(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("kettle")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					productlist = cat.categoryKettle(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}

			}

			if (page.equals("sortYear")) {
				String param = req.getParameter("sort");
				Years year = new Years();
				ProductDao pd = new ProductDao();

				if (param.equals("all")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("2019")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					productlist = year.years2019(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("2020")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					productlist = year.years2020(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}
				if (param.equals("2021")) {
					try {
						productlist = pd.findAllProducts();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					productlist = year.years2021(productlist);
					req.setAttribute(PRODUCT_LIST, productlist);
					try {
						req.getRequestDispatcher(ALL_PRODUCTS).forward(req, resp);
					} catch (Exception e) {
						LOGGER.log(Level.WARNING, CANNOT_FORWARD);
					}
				}

			}

		}
	}

}