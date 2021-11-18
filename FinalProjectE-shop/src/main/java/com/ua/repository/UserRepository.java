package com.ua.repository;

import java.sql.SQLException;
import java.util.List;

import com.ua.model.User;
/**
 * UserRepository interface 
 * 
 * @author Serhii Vyshnevskyi
 */
public interface UserRepository {

	
	int checkEmailExist(String email) throws SQLException;
	
	boolean checkEmailValid(String email);
	
	User findUserEmail(String email) throws SQLException;
	
	List<User> findAllUser() throws SQLException;
	
	void addUser(User user) throws SQLException;
	
	User findOneUser(String id) throws SQLException;
	
	void updateUserStatus(User p) throws SQLException;
	
	boolean checkUser(String username, String password) throws SQLException;
	
	void deleteUser(String id) throws SQLException;
	
	
}
