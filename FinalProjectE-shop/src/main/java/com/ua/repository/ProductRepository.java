package com.ua.repository;

import java.sql.SQLException;
import java.util.List;

import com.ua.model.Product;
/**
 * ProductRepository interface 
 * 
 * @author Serhii Vyshnevskyi
 */
public interface ProductRepository {
	
	List<Product> findAllProducts() throws SQLException;
	
	void deleteProduct(String id) throws SQLException;
	
	Product findOneProduct(String id) throws SQLException;
	
	List<Product> getSomeDish(int start, int total) throws SQLException;
	
	void updateProduct(Product p) throws SQLException;
	
	void addProduct(Product p) throws SQLException;
	
	

}
