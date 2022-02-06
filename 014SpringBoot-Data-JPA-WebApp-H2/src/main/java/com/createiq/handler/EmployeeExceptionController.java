package com.createiq.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.createiq.exception.EmployeeNameNotFoundException;
import com.createiq.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeExceptionController {
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmployeeNameNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNameNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exceptionException(Exception exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
}