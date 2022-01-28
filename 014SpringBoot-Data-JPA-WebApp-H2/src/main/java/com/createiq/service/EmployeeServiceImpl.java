package com.createiq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.entity.Employee;
import com.createiq.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee add(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Integer eid) {
		employeeRepository.deleteById(eid);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> findByName(String ename) {
		return employeeRepository.findByEname(ename);
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeRepository.findById(eid).get();
	}

}
