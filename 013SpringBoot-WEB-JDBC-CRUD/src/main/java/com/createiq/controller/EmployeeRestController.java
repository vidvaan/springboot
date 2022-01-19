package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.model.Employee;
import com.createiq.service.EmployeeService;

@RestController
@RequestMapping("/rs")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/xml/allEmp", produces= "application/xml")
	public  List<Employee> findAllRS(){
		return employeeService.findAll();
	}
	
	@RequestMapping(value="/json/allEmp", produces= "application/json")
	public  List<Employee> findAllRSJson(){
		return employeeService.findAll();
	}
	
}
