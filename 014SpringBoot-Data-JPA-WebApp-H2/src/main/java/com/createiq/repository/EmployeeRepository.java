package com.createiq.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.createiq.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	// Select * from EMPLOYEE WHERE ENAME = ?
	List<Employee> findByEname(String ename);

	// Select * from EMPLOYEE WHERE ENAME = ? AND ESAL =?
	List<Employee> findByEnameAndEsal(String ename, Double esal);

	// SELECT ESAL FROM EMPLOYEE WHERE EID = ?
	// SELECT e.esal FROM Employee e WHERE e.eid = ?

	@Query("SELECT e.ename FROM Employee e WHERE e.eid = :eid")
	String findEnameByEid(@Param("eid") Integer eid);

	@Query("SELECT e.ename FROM Employee e WHERE e.eid = :eid")
	Optional<String> findEnameByEidWithOp(@Param("eid") Integer eid);

	@Query(name = "EMP.FindBySal")
	List<Employee> findEmpBySalary(@Param("esal") Double esal);
}
