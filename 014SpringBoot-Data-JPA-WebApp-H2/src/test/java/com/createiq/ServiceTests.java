package com.createiq;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.createiq.entity.Employee;
import com.createiq.repository.EmployeeRepository;
import com.createiq.service.EmployeeService;
import com.createiq.service.EmployeeServiceImpl;

 
@ExtendWith(MockitoExtension.class)
public class ServiceTests 
{
    @InjectMocks
    EmployeeServiceImpl service;
      
    @Mock
    EmployeeRepository dao;
     
    @Test
    public void testFindAllEmployees()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee();
        empOne.setEid(1);
        empOne.setEname("Balaji");
        empOne.setEsal(20000.00);
        Employee empTwo = new Employee();
        empTwo.setEid(2);
        empTwo.setEname("Raja");
        empTwo.setEsal(30000.00);
          
        list.add(empOne);
        list.add(empTwo);
          
        when(dao.findAll()).thenReturn(list);
          
        //test
        List<Employee> empList = service.findAll();
          
        assertEquals(2, empList.size());
        verify(dao, times(1)).findAll();
    }
     
    @Test
    public void testCreateOrSaveEmployee()
    {
        Employee empOne = new Employee();
        empOne.setEname("Balaji");
        empOne.setEsal(20000.00);
          
        service.add(empOne);
          
        verify(dao, times(1)).save(empOne);
    }
}