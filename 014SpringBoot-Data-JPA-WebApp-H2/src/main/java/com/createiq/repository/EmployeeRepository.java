package com.createiq.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.createiq.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//Select * from EMPLOYEE WHERE ENAME = ?
	List<Employee> findByEname(String ename);

	//Select * from EMPLOYEE WHERE ENAME = ? AND ESAL =?
	List<Employee> findByEnameAndEsal(String ename,Double esal);
	
}
