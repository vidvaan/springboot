package com.createiq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.createiq.controller.EmployeeController;
import com.createiq.entity.Employee;
import com.createiq.service.EmployeeService;
 
@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class StandaloneControllerTests {
 
    @MockBean
    EmployeeService employeeService;
 
    @Autowired
    MockMvc mockMvc;
 
    @Test
    public void testfindAll() throws Exception {
        Employee employee1 = new Employee(1, "Balaji", 20000.00);
        Employee employee2 = new Employee(1, "Raja", 30000.00);
        List<Employee> employees = Arrays.asList(employee1,employee2);
 
        Mockito.when(employeeService.findAll()).thenReturn(employees);
 
        mockMvc.perform(get("/emp/findAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].eid", Matchers.is(1)))
                .andExpect(jsonPath("$[0].ename", Matchers.is("Balaji")))
                .andExpect(jsonPath("$[0].esal", Matchers.is(20000.00)));
    }
 
}