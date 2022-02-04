package com.createiq;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.createiq.entity.Employee;
import com.createiq.repository.EmployeeRepository;
 
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {
 
  @Autowired
  EmployeeRepository employeeRepository;
 
  @Test
  public void testCreateReadDelete() {
    Employee employee = new Employee();
    employee.setEname("Balaji");
    employee.setEsal(20000.00);
 
    employeeRepository.save(employee);
 
    Iterable<Employee> employees = employeeRepository.findAll();
    System.out.println(employees);
    Assertions.assertThat(employees).extracting(Employee::getEname).containsOnly("Balaji");

    employeeRepository.deleteAll();
    Assertions.assertThat(employeeRepository.findAll()).isEmpty();
  }
}