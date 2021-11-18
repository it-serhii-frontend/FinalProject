package com.ua.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * Class which is responsible for connect with Database by connection pool
 * 
 * @author Serhii Vyshnevskyi
 */
public class DbManager {
	private static final Logger LOGGER = Logger.getLogger(DbManager.class.getName());
	private static DbManager instance;

	public static synchronized DbManager getInstance() {
		if (instance == null) {
			instance = new DbManager();
		}
		return instance;
	}

	private DataSource ds;

	private DbManager() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/eShop");
		} catch (NamingException ex) {
			LOGGER.log(Level.WARNING, "Cannot obtain a data source");
		}
	}

	public Connection dbConnect() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException ex) {
			LOGGER.log(Level.WARNING, "Cannot obtain a connection");
		}
		return con;
	}

}
