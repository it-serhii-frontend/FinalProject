package com.ua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ua.dbConnection.DbManager;
import com.ua.model.Order;
import com.ua.repository.OrderRepository;
/**
 * Class which is responsible for work with Database, table orders
 * 
 * @author Serhii Vyshnevskyi
 */
public class OrderDao implements OrderRepository {
	List<Order> list = new ArrayList<>();
	private static final String ID = "id";
	private static final String USERID = "userId";
	private static final String PRODUCTID = "productId";
	private static final String STATUS = "status";

	public void addOrder(Order p) throws SQLException {

		Connection con = DbManager.getInstance().dbConnect();
		try (PreparedStatement ps1 = con.prepareStatement("select max(id) from orders");) {
			ResultSet rs = ps1.executeQuery();
			int id = 0;

			if (rs.next()) {
				id = rs.getInt(1);
				id++;
				String sql = "Insert into orders values(?,?,?,?)";
				PreparedStatement st = con.prepareStatement(sql);

				st.setInt(1, id);
				st.setInt(2, p.getUserId());
				st.setInt(3, p.getProductId());
				st.setString(4, p.getStatus());
				st.executeUpdate();
			}
		} finally {
			con.commit();
			con.close();
		}

	}

	public void deleteOrders(String id) throws SQLException {

		Connection con = DbManager.getInstance().dbConnect();
		try (PreparedStatement st = con.prepareStatement("Delete from orders where id=?");) {
			st.setString(1, id);
			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

	public void updateOrderStatus(Order p) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "update orders set status=? where id=?";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, p.getStatus());
			st.setInt(2, p.getId());
			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

	public Order findOne(int id) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		Order pd = null;
		try (PreparedStatement ps = con.prepareStatement("select * from orders where id='" + id + "'");) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pd = new Order();
				pd.setId(rs.getInt(ID));
				pd.setUserId(rs.getInt(USERID));
				pd.setProductId(rs.getInt(PRODUCTID));
				pd.setStatus(rs.getString(STATUS));
			}
		} finally {
			con.commit();
			con.close();
		}
		return pd;

	}

	public static List<Order> findOneWhereUserId(int id) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		Order pd = null;
		List<Order> orders = new ArrayList<>();
		try (PreparedStatement ps = con.prepareStatement("select * from orders where userId='" + id + "'");) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				pd = new Order();
				pd.setId(rs.getInt(ID));
				pd.setUserId(rs.getInt(USERID));
				pd.setProductId(rs.getInt(PRODUCTID));
				pd.setStatus(rs.getString(STATUS));

				orders.add(pd);
			}
		} finally {
			con.commit();
			con.close();
		}

		return orders;

	}

	public List<Order> findAllOrders() throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "Select * from orders";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ID);
				int userId = rs.getInt(USERID);
				int productId = rs.getInt(PRODUCTID);
				String status = rs.getString(STATUS);

				Order p = new Order();
				p.setId(id);
				p.setUserId(userId);
				p.setProductId(productId);
				p.setStatus(status);

				list.add(p);
				p = null;
			}
		} finally {
			con.commit();
			con.close();

		}

		return list;
	}

	public static void main(String[] args) throws SQLException {
//code
	}
}
