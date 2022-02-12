package com.createiq.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.createiq.exception.EmployeeNameNotFoundException;
import com.createiq.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public String info() {
		return "This is Employee Rest API - Created By Balaji G";
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity(employeeService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {
		return new ResponseEntity(employeeService.add(employee), HttpStatus.OK);
	}

	@GetMapping("/findById/{eid}")
	public ResponseEntity<?> findById(@PathVariable Integer eid) {
		Employee employee = employeeService.findById(eid);
		if(employee.getEname() == null) {
			throw new EmployeeNameNotFoundException("Employee name is Null");
		}
		return new ResponseEntity(employee, HttpStatus.OK);
	}

	@GetMapping("/findEnameById/{eid}")
	public ResponseEntity<?> findEnameById(@PathVariable Integer eid) {
		return new ResponseEntity(employeeService.findNameById(eid), HttpStatus.OK);
	}

	@GetMapping("/findEnameByIdWithOp/{eid}")
	public ResponseEntity<?> findEnameByIdWithOp(@PathVariable Integer eid) {
		return new ResponseEntity(employeeService.findNameByIdWithOp(eid), HttpStatus.OK);
	}

	@GetMapping("/findByName/{ename}")
	public ResponseEntity<?> findByName(@PathVariable String ename) {
		return new ResponseEntity(employeeService.findByName(ename), HttpStatus.OK);
	}

}
