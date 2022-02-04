package com.createiq.service;

import java.util.List;

import com.createiq.entity.Employee;

public interface EmployeeService {
	
	public Employee add(Employee employee);
	
	public Employee update(Employee employee);
	
	public void delete(Integer eid);
	
    public List<Employee> findAll();
    
    public List<Employee> findByName(String ename);
    
    public Employee findById(Integer eid);
    
    public String findNameById(Integer eid);
    
    public String findNameByIdWithOp(Integer eid);
	
}
