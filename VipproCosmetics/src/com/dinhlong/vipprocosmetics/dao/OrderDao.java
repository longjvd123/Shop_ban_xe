package com.dinhlong.vipprocosmetics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.entity.Order;
import com.dinhlong.vipprocosmetics.util.DatabaseConnectionUtil;

public class OrderDao {
	// thêm
	public void insertOrder(Order order) {
		String sql = "INSERT INTO `order` (`name`,`phoneNumber`,`address`,`totalMoney`,`status`)"
				+ "VALUES(?,?,?,?,?);";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, order.getName());
			preparedStatement.setInt(2, order.getPhoneNumber());
			preparedStatement.setString(3, order.getAddress());
			preparedStatement.setLong(4, order.getTotalMoney());
			preparedStatement.setString(5, order.getStatus());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// xoá
	public void deleteOrder(int id) {
		String sql = "DELETE FROM `order` WHERE id = " + id + ";";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// hiển thị
	public ArrayList<Order> getAllOrder() {
		ArrayList<Order> orderList = new ArrayList<Order>();
		String sql = "SELECT * FROM `order`";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Order newOrder = convertToOrder(resultSet); 
				orderList.add(newOrder);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return orderList;
	}
	private Order convertToOrder(ResultSet rs) {
		Order order = new Order();
		try {
			order.setId(rs.getInt(1));
			order.setName(rs.getString(2));
			order.setPhoneNumber(rs.getInt(3));
			order.setAddress(rs.getString(4));
			order.setTotalMoney(rs.getLong(5));
			order.setStatus(rs.getString(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order ;
	}
}
