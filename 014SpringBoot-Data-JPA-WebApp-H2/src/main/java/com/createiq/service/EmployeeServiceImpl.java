package com.createiq.service;

import java.util.List;
import java.util.Optional;

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
		System.out.println(employeeRepository.findEmpBySalary(10000.00));
		return employeeRepository.findById(eid).get();
	}

	@Override
	public String findNameById(Integer eid) {
		return employeeRepository.findEnameByEid(eid);
	}

	@Override
	public String findNameByIdWithOp(Integer eid) {
		Optional<String> name = employeeRepository.findEnameByEidWithOp(eid);
		if(name.isPresent()) {
			return name.get();
		}
		return "";
	}

}
