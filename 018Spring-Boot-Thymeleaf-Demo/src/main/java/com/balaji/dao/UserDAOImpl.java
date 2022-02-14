package com.balaji.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.balaji.entity.User;
@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User user) {
		jdbcTemplate.update("INSERT INTO USERS(FNAME,LNAME,EMAIL,PASSWORD,ROLE,ENABLE) VALUES(?,?,?,?,?,?)",new Object[] {
				user.getFname(),user.getLname(),user.getEmail(),user.getPasswordEncoded(),user.getRole(),user.getEnableUpdated()
		});
	}

}
