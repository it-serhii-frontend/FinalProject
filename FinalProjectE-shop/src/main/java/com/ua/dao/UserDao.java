package com.ua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.ua.dbConnection.DbManager;
import com.ua.model.User;
import com.ua.repository.UserRepository;
/**
 * Class which is responsible for work with Database, table users
 * 
 * @author Serhii Vyshnevskyi
 */
public class UserDao implements UserRepository {

	List<User> userList = new ArrayList<>();
	private static final String ID = "id";
	private static final String USERNAME = "username";
	private static final String ADDRESS = "address";
	private static final String STATUS = "status";

	public int checkEmailExist(String email) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		int count = 0;
		try (Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("select * from users where email='" + email + "'");
			while (rs.next()) {
				count++;
			}
		} finally {
			con.commit();
			con.close();
		}
		return count;

	}

	public boolean checkEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);

		return pat.matcher(email).matches();

	}

	public User findUserEmail(String email) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "select * from users where email=?";
		User p = new User();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, email);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {
				p.setId(rst.getInt(ID));
				p.setUsername(rst.getString(USERNAME));
				p.setAddress(rst.getString(ADDRESS));
				p.setStatus(rst.getString(STATUS));
			}
		} finally {
			con.commit();
			con.close();
		}

		return p;
	}

	public List<User> findAllUser() throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "Select * from users";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(ID);
				String username = rs.getString(USERNAME);
				String email = rs.getString("email");
				String address = rs.getString(ADDRESS);
				String password = rs.getString("password");
				String status = rs.getString(STATUS);

				User u = new User();
				u.setId(id);
				u.setUsername(username);
				u.setEmail(email);
				u.setAddress(address);
				u.setPassword(password);
				u.setStatus(status);
				userList.add(u);
				u = null;
			}
		} finally {
			con.commit();
			con.close();
		}
		return userList;
	}

	public void addUser(User user) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		try (PreparedStatement ps1 = con.prepareStatement("select max(id) from users");) {
			ResultSet rs = ps1.executeQuery();
			int id = 0;
			if (rs.next()) {
				id = rs.getInt(1);
				id++;

				String sql = "Insert into users values(?,?,?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, id);
				st.setString(2, user.getUsername());
				st.setString(3, user.getEmail());
				st.setString(4, user.getAddress());
				st.setString(5, user.getPassword());
				st.setString(6, "active");

				st.executeUpdate();
			}
		} finally {
			con.commit();
			con.close();
		}

	}

	public User findOneUser(String id) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "select * from users where id=?";
		User p = new User();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);
			ResultSet rst = pstmt.executeQuery();

			while (rst.next()) {

				p.setUsername(rst.getString(USERNAME));
				p.setEmail(rst.getString("email"));
				p.setAddress(rst.getString(ADDRESS));
				p.setPassword(rst.getString("password"));
				p.setStatus(rst.getString(STATUS));
			}
		} finally {
			con.commit();
			con.close();
		}

		return p;
	}

	public void updateUserStatus(User p) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "update users set status=? where id=?";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, p.getStatus());
			st.setInt(2, p.getId());
			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

	public boolean checkUser(String username, String password) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		int count = 0;
		String sql = "Select * from users where username = ? and password = ?";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, username);
			st.setString(2, password);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				count = 1;
			}
		} finally {
			con.close();
		}

		if (count == 0) {
			return false;
		}

		return true;
	}

	public void deleteUser(String id) throws SQLException {

		Connection con = DbManager.getInstance().dbConnect();
		try (PreparedStatement st = con.prepareStatement("Delete from users where id=?");) {
			st.setString(1, id);
			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

	public static void main(String[] args) throws SQLException {
//code
	}

}
