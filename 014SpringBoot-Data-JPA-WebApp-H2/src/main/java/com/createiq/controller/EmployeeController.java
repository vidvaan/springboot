package com.createiq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.entity.Employee;
import com.createiq.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public String info() {
		return "This is Employee Rest API - Created By Balaji G";
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(employeeService.findAll(), HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Employee employee) {
		return new ResponseEntity(employeeService.add(employee), HttpStatus.OK);
	}
	
	@GetMapping("/findById/{eid}")
	public ResponseEntity<?> findById(@PathVariable Integer eid) {
		return new ResponseEntity(employeeService.findById(eid), HttpStatus.OK);
	}
	
	@GetMapping("/findByName/{ename}")
	public ResponseEntity<?> findByName(@PathVariable String ename) {
		return new ResponseEntity(employeeService.findByName(ename), HttpStatus.OK);
	}

}