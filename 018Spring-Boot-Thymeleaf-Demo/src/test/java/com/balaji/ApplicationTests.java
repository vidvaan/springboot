package com.balaji;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class ApplicationTests {

	
		public static void main(String[] args) {
			BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
			
			System.out.println(bCryptPasswordEncoder.encode("balaji"));
		}
		
		

}
