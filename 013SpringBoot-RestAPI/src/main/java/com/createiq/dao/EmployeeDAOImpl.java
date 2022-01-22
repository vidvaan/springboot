package com.createiq.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.createiq.model.Employee;

@Repository

public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Employee employee) {
	   jdbcTemplate.update("INSERT INTO EMP02_TAB VALUES(?,?,?)", new Object[] {employee.getEid(),employee.getEname(),employee.getEsal()});
		
	}

	@Override
	public void update(Employee employee) {
		 jdbcTemplate.update("UPDATE EMP02_TAB SET ENAME = ?, ESAL = ? WHERE EID = ?", new Object[] {employee.getEname(),employee.getEsal(),employee.getEid()});

	}

	@Override
	public void deleteById(Integer eid) {
		jdbcTemplate.update("DELETE FROM EMP02_TAB WHERE EID = ?", new Object[] {eid});

	}

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * FROM EMP02_TAB", new BeanPropertyRowMapper(Employee.class));
	}

	@Override
	public List<Employee> findByName(String name) {
		return jdbcTemplate.query("SELECT * FROM EMP02_TAB WHERE ENAME = ?",new Object[] {name},new int[] { Types.VARCHAR},  new BeanPropertyRowMapper(Employee.class));
	}

	@Override
	public Employee findById(Integer eid) {
		return jdbcTemplate.queryForObject("SELECT * FROM EMP02_TAB WHERE EID = ? ", new Object[] {eid}, new int[] { Types.INTEGER}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

}
