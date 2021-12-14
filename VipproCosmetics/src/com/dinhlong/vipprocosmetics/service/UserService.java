package com.dinhlong.vipprocosmetics.service;

import com.dinhlong.vipprocosmetics.dao.UserDao;
import com.dinhlong.vipprocosmetics.entity.User;

public class UserService {
	public User findByUsernameAndPassword(String username, String password) {
		UserDao userDAO = new UserDao();
		return userDAO.findByUsernameAndPassword(username, password);
	}

	public boolean insertUser(String username, String password) {
		UserDao userDAO = new UserDao();
		boolean isAccountExist = userDAO.isUsernameExists(username);
		if (isAccountExist) {
			return false;
		}
		User newUser = new User();
		newUser.setUsername(username);
		newUser.setPassword(password);
		newUser.setRole("USER");
		userDAO.insertUser(newUser);
		return true;
	}
	public User loginUser(String userName, String passWord) {
		UserDao userDao = new UserDao();
		return userDao.findByUsernameAndPassword(userName, passWord);
	}
	public User get(int id) {
		UserDao userDao = new UserDao();
		return userDao.get(id);
	}

}
