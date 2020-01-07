package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.bean.User;
import com.demo.dao.UserDao;


public class UserService {

	UserDao userDao = new UserDao();
	
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
}
