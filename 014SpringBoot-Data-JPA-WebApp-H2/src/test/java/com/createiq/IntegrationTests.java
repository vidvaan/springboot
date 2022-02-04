package com.createiq;
 
import javax.xml.bind.ValidationException;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.createiq.controller.EmployeeController;
import com.createiq.entity.Employee;
 
 
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTests {
 
    @Autowired
    EmployeeController employeeController;
 
    @Test
    public void testCreateReadDelete() {
        Employee employee = new Employee();
        employee.setEname("Balaji");
        employee.setEsal(20000.00);
 
        ResponseEntity employeeResult = employeeController.add(employee);
 
        Iterable<Employee> employees = employeeController.findAll().getBody();
        Assertions.assertThat(employees).first().hasFieldOrPropertyWithValue("ename", "Balaji");
 
       
    }
 
    
}