package com.ua.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filter which is responsible for implementation authentication
 * 
 * @author Serhii Vyshnevskyi
 */
@WebFilter("/*")
public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String logURI = request.getContextPath() + "/login.jsp";
		String registURI = request.getContextPath() + "/signup.jsp";
		String allDishURI = request.getContextPath() + "/allDish";
		String cartURI = request.getContextPath() + "/bucket";
		String aboutUsURI = request.getContextPath() + "/aboutUs.jsp";
		String mainUsURI = request.getContextPath() + "/main.jsp";
		String buyUsURI = request.getContextPath() + "/control";
		String adminUsURI = request.getContextPath() + "/admin";

		boolean logged = session != null && session.getAttribute("username") != null;

		boolean logRequest = request.getRequestURI().equals(logURI);
		boolean registRequest = request.getRequestURI().equals(registURI);
		boolean allDishRequest = request.getRequestURI().equals(allDishURI);
		boolean cartRequest = request.getRequestURI().equals(cartURI);
		boolean aboutUsRequest = request.getRequestURI().equals(aboutUsURI);
		boolean mainUsRequest = request.getRequestURI().equals(mainUsURI);
		boolean buyUsRequest = request.getRequestURI().equals(buyUsURI);
		boolean adminRequest = request.getRequestURI().equals(adminUsURI);

		String uri = ((HttpServletRequest) request).getRequestURI();

		boolean css = uri.indexOf("/css") > 0;
		boolean img = uri.indexOf("/images") > 0;
		boolean js = uri.indexOf("/js") > 0;
		boolean jpg = uri.indexOf("/jpg") > 0;

		if (jpg || css || img || js || logged || logRequest || registRequest || allDishRequest || cartRequest
				|| aboutUsRequest || mainUsRequest || buyUsRequest || adminRequest
				|| request.getRequestURI().endsWith(".jpg") || request.getRequestURI().endsWith(".svg")) {
			chain.doFilter(request, response);
		} else {
			response.sendRedirect(registURI);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//code

	}

	@Override
	public void destroy() {
//code
	}
}