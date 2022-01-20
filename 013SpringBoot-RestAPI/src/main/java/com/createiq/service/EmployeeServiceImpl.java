package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.dao.EmployeeDAO;
import com.createiq.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

		

	public void update(Employee employee) {
		employeeDAO.update(employee);
	}

	public void deleteById(Integer eid) {
		employeeDAO.deleteById(eid);
	}

	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	@Override
	public List<Employee> findByName(String name) {
		return employeeDAO.findByName(name);
	}

	@Override
	public void add(Employee employee) {
		System.out.println("Employee Service Add method : " + employee);
		employeeDAO.add(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeDAO.findById(eid);
	}
}
