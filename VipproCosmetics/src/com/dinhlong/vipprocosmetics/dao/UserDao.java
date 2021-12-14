package com.dinhlong.vipprocosmetics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dinhlong.vipprocosmetics.entity.User;
import com.dinhlong.vipprocosmetics.util.DatabaseConnectionUtil;

public class UserDao {
	public void insertUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {	
			connection = DatabaseConnectionUtil.getConnection();
			String sql = "INSERT INTO `user` (username,password,role) VALUES (?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public boolean isUsernameExists(String username) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnectionUtil.getConnection();
			String sql = "SELECT * FROM `use`r WHERE username = '"
					+ username + "'";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} 
		return false;
	}
	
	public User findByUsernameAndPassword(String username, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnectionUtil.getConnection();
			String sql = "SELECT * FROM `user` WHERE username= ? and password = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User user = convertToUser(resultSet);
				return user;
			}
		} catch (SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		} 
		return null;
	}
	
	private static User convertToUser(ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));		
		user.setUsername(rs.getString(2));		
		user.setPassword(rs.getString(3));		
		user.setRole(rs.getString(4));	
		return user;
	}
	public User get(int id) {
		String sql = "SELECT * FROM `user` WHERE id = ? ";
		Connection connection = DatabaseConnectionUtil.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));

				return user;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
