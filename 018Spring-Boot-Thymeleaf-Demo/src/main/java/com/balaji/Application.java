package com.balaji;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.balaji.entity.User;
import com.balaji.service.UserService;

@SpringBootApplication
public class Application  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		userService.addUser(new User(2, "Ram", "H", "ram@gmail.com", "ram", "User", true));
		
	}

}
