package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/findAll")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/findById/{eid}")
	public Employee findById(@PathVariable("eid") Integer eid) {
		return employeeService.findById(eid);
	}
	
	
	@DeleteMapping("/delete/{eid}")
	public String delete(@PathVariable("eid") Integer eid) {
		employeeService.deleteById(eid);
		return "Record delete successfully with EID : "+eid;
	}
	
	@PostMapping(value = "/add")
	public String add(@RequestBody Employee employee) {
		employeeService.add(employee);
		return "Record inserted successfully ";
	}
	
	@PutMapping(value = "/update")
	public String update(@RequestBody Employee employee) {
		employeeService.update(employee);
		return "Record updated successfully ";
	}

}
