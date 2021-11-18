package com.ua.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ua.dbConnection.DbManager;
import com.ua.model.Product;
import com.ua.repository.ProductRepository;
/**
 * Class which is responsible for work with Database, table products_dish
 * 
 * @author Serhii Vyshnevskyi
 */
public class ProductDao implements ProductRepository {

	List<Product> productlist = new ArrayList<>();
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String DESCRIPTION = "description";
	private static final String PRICE = "price";
	private static final String CATEGORY = "category";
	private static final String IMAGE = "image";
	private static final String CREATED = "created";


	public List<Product> findAllProducts() throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "Select * from products_dish";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(ID);
				String name = rs.getString(NAME);
				String description = rs.getString(DESCRIPTION);
				String price = rs.getString(PRICE);
				String category = rs.getString(CATEGORY);
				String image = rs.getString(IMAGE);
				String created = rs.getString(CREATED);

				Product p = new Product();
				p.setId(id);
				p.setName(name);
				p.setDescription(description);
				p.setPrice(price);
				p.setCategory(category);
				p.setImage(image);
				p.setCreated_At(created);
				productlist.add(p);
				p = null;
			}
		} finally {
			con.commit();
			con.close();
		}

		return productlist;
	}

	public void deleteProduct(String id) throws SQLException {

		Connection con = DbManager.getInstance().dbConnect();
		try (PreparedStatement st = con.prepareStatement("Delete from products_dish where id=?");) {
			st.setString(1, id);
			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

	public Product findOneProduct(String id) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "select * from products_dish where id=?";
		Product p = new Product();
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, id);
			ResultSet rst = pstmt.executeQuery();
			while (rst.next()) {

				p.setId(rst.getInt(ID));
				p.setName(rst.getString(NAME));
				p.setDescription(rst.getString(DESCRIPTION));
				p.setPrice(rst.getString(PRICE));
				p.setCategory(rst.getString(CATEGORY));
				p.setImage(rst.getString(IMAGE));
				p.setCreated_At(rst.getString(CREATED));
			}
		} finally {
			con.close();
		}

		return p;
	}

	public List<Product> getSomeDish(int start, int total) throws SQLException {
		List<Product> list = new ArrayList<>();
		Connection con = DbManager.getInstance().dbConnect();
		try (PreparedStatement ps = con
				.prepareStatement("select * from products_dish limit " + (start - 1) + "," + total);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product pd = new Product();
				pd.setId(rs.getInt(ID));
				pd.setName(rs.getString(NAME));
				pd.setDescription(rs.getString(DESCRIPTION));
				pd.setPrice(rs.getString(PRICE));
				pd.setCategory(rs.getString(CATEGORY));
				pd.setImage(rs.getString(IMAGE));
				pd.setCreated_At(rs.getString(CREATED));

				list.add(pd);
			}
		} finally {
			con.close();
		}

		return list;
	}

	public void updateProduct(Product p) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "update products_dish set name=?, description =?, price=?,category=?, image=?, created=? where id=?";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, p.getName());
			st.setString(2, p.getDescription());
			st.setString(3, p.getPrice());
			st.setString(4, p.getCategory());
			st.setString(5, p.getImage());
			st.setString(6, p.getCreated_At());
			st.setInt(7, p.getId());
			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

	public void addProduct(Product p) throws SQLException {
		Connection con = DbManager.getInstance().dbConnect();
		String sql = "Insert into products_dish(name, description, price,category,image, created) values(?,?,?,?,?,?)";
		try (PreparedStatement st = con.prepareStatement(sql);) {
			st.setString(1, p.getName());
			st.setString(2, p.getDescription());
			st.setString(3, p.getPrice());
			st.setString(4, p.getCategory());
			st.setString(5, p.getImage());
			st.setString(6, p.getCreated_At());

			st.executeUpdate();
		} finally {
			con.commit();
			con.close();
		}

	}

}
