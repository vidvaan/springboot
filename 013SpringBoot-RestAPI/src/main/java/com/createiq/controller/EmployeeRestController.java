package com.createiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.createiq.model.Employee;
import com.createiq.model.ResponseBean;
import com.createiq.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity(employeeService.findAll(), HttpStatus.FOUND);
	}

	@GetMapping("/findByName/{ename}")
	public ResponseBean findByName(@PathVariable("ename") String ename) {
		return new ResponseBean(200, employeeService.findByName(ename));
	}

	// @GetMapping("/findById/{eid}")
	// public ResponseBean findById(@PathVariable("eid") Integer eid) {
	// ResponseBean responseBean = null;
	// try {
	// responseBean = new ResponseBean(200, employeeService.findById(eid));
	// } catch (EmptyResultDataAccessException e) {
	// responseBean = new ResponseBean(404, "Record not found");
	// } catch (Exception e) {
	// responseBean = new ResponseBean(500, "Unknown error");
	// }
	// return responseBean;
	// }

	@GetMapping("/findById/{eid}")
	public ResponseEntity<?> findById(@PathVariable("eid") Integer eid) {
		ResponseEntity responseEntity = null;
		try {
			responseEntity = new ResponseEntity(employeeService.findById(eid), HttpStatus.FOUND);
		} catch (EmptyResultDataAccessException e) {
			responseEntity = new ResponseEntity("Record not found", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			responseEntity = new ResponseEntity("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@DeleteMapping("/delete/{eid}")
	public String delete(@PathVariable("eid") Integer eid) {
		employeeService.deleteById(eid);
		return "Record delete successfully with EID : " + eid;
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
