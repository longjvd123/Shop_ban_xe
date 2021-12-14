package com.dinhlong.vipprocosmetics.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.util.DatabaseConnectionUtil;

public class CosmeticsDao { 
	// thêm
	public void insertCosmetics(Cosmetics cosmetics) {
		String sql = "INSERT INTO `cosmetics` (`code`,`name`,`trademark`,`type`,`description`,`origin`,"
				+ "`expirydate`,`dateofmanufacture`,`quantity`,`price`,`image`)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cosmetics.getCode());
			preparedStatement.setString(2, cosmetics.getName());
			preparedStatement.setString(3, cosmetics.getTrademark());
			preparedStatement.setString(4, cosmetics.getType());
			preparedStatement.setString(5, cosmetics.getDescription());
			preparedStatement.setString(6, cosmetics.getOrigin());
			preparedStatement.setString(7, cosmetics.getExpirydate());
			preparedStatement.setString(8, cosmetics.getDateofmanufacture());
			preparedStatement.setInt(9, cosmetics.getQuantity());
			preparedStatement.setLong(10, cosmetics.getPrice());
			preparedStatement.setString(11, cosmetics.getImage());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// xoá
	public void deleteCosmetics(int id) {
		String sql = "DELETE FROM `cosmetics` WHERE id = " + id + ";";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// sửa
	public void updateCosmetics(Cosmetics cosmetics) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnectionUtil.getConnection();
			String sql = "UPDATE cosmetics SET code= ?, name = ?, trademark = ?, type = ?, description = ?, origin = ?, "
					+ "expirydate = ?,dateofmanufacture = ?, quantity = ?,price=?, image = ?" + " WHERE id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cosmetics.getCode());
			preparedStatement.setString(2, cosmetics.getName());
			preparedStatement.setString(3, cosmetics.getTrademark());
			preparedStatement.setString(4, cosmetics.getType());
			preparedStatement.setString(5, cosmetics.getDescription());
			preparedStatement.setString(6, cosmetics.getOrigin());
			preparedStatement.setString(7, cosmetics.getExpirydate());
			preparedStatement.setString(8, cosmetics.getDateofmanufacture());
			preparedStatement.setInt(9, cosmetics.getQuantity());
			preparedStatement.setFloat(10, cosmetics.getPrice());
			preparedStatement.setString(11, cosmetics.getImage());
			preparedStatement.setString(12, cosmetics.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// tìm kiếm
	public ArrayList<Cosmetics> findCosmeticsByName(String name) {
		ArrayList<Cosmetics> cosmeticsList = new ArrayList<Cosmetics>();
		String sql = "SELECT * FROM `cosmetics` WHERE name LIKE '%" + name + "%';";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				cosmeticsList.add(convertToCosmetics(resultSet));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cosmeticsList;
	}

	public Cosmetics findById(String id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnectionUtil.getConnection();
			String sql = "SELECT * FROM cosmetics WHERE id = " + id;
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Cosmetics cosmetics = convertToCosmetics(resultSet);
				return cosmetics;
			}
		} catch (SQLException e) {
			// Handle errors for JDBC
			e.printStackTrace();
		}
		return null;
	}

	// hiển thị
	public ArrayList<Cosmetics> getAllCosmetics() {
		ArrayList<Cosmetics> cosmeticsList = new ArrayList<Cosmetics>();
		String sql = "SELECT * FROM `cosmetics`";
		Connection connection = DatabaseConnectionUtil.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Cosmetics newcosmetics = convertToCosmetics(resultSet); 
				cosmeticsList.add(newcosmetics);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cosmeticsList;
	}

	private Cosmetics convertToCosmetics(ResultSet rs) {
		Cosmetics cosmetics = new Cosmetics();
		try {
			cosmetics.setId(rs.getString(1));
			cosmetics.setCode(rs.getString(2));
			cosmetics.setName(rs.getString(3));
			cosmetics.setTrademark(rs.getString(4));
			cosmetics.setType(rs.getString(5));
			cosmetics.setDescription(rs.getString(6));
			cosmetics.setOrigin(rs.getString(7));
			cosmetics.setExpirydate(rs.getString(8));
			cosmetics.setDateofmanufacture(rs.getString(9));
			cosmetics.setQuantity(rs.getInt(10));
			cosmetics.setPrice(rs.getInt(11));
			cosmetics.setImage(rs.getString(12));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cosmetics;
	}

}
