package com.balaji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.balaji.dao.UserDAO;
import com.balaji.entity.User;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(User user) {
		if(user !=null) {
			user.setEnableUpdated(user.getEnabled() ? 1 : 0);
			user.setPasswordEncoded(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		
		userDAO.addUser(user);
	}

}
