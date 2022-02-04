package com.createiq;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.createiq.controller.EmployeeController;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() {
		assertThat(employeeController).isNotNull();
	}

}
