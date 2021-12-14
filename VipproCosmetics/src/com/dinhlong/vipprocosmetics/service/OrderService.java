package com.dinhlong.vipprocosmetics.service;

import java.util.List;

import com.dinhlong.vipprocosmetics.dao.CosmeticsDao;
import com.dinhlong.vipprocosmetics.dao.OrderDao;
import com.dinhlong.vipprocosmetics.entity.Cosmetics;
import com.dinhlong.vipprocosmetics.entity.Order;

public class OrderService {
	// hiển thị
	public List<Order> getAllOrder() { 
		OrderDao orderDao = new OrderDao();
		return orderDao.getAllOrder();
	}
	// xoá
	public void deleteOrder(int id) {
		OrderDao orderDao = new OrderDao();
		orderDao.deleteOrder(id);
	}
	//thêm vào
	public void insertOrder(String name, int phoneNumber, String address, long totalMoney) {
		Order newOrder= new Order();
		OrderDao orderDao = new OrderDao();

		newOrder.setName(name);
		newOrder.setName(name);
		newOrder.setPhoneNumber(phoneNumber);
		newOrder.setAddress(address);
		newOrder.setTotalMoney(totalMoney);
		newOrder.setStatus("Đã đặt hàng");

		orderDao.insertOrder(newOrder);

	}
}
