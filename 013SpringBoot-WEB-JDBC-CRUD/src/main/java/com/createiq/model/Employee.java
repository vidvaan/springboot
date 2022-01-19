package com.createiq.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class Employee {
	private Integer eid;
	@NotEmpty(message="Employee Name Should not be empty")
	private String ename;
	@NotNull(message="Employee Salary Should not be empty")
	private Double esal;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer eid, String ename, Double esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getEsal() {
		return esal;
	}

	public void setEsal(Double esal) {
		this.esal = esal;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
	}
	
	

}
