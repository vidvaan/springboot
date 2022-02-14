package com.balaji.entity;

public class User {

	private Integer uid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String role;
	private String enabled;
	
	private int enableUpdated;
	private String passwordEncoded;
	
	

	public int getEnableUpdated() {
		return enableUpdated;
	}

	public void setEnableUpdated(int enableUpdated) {
		this.enableUpdated = enableUpdated;
	}

	public String getPasswordEncoded() {
		return passwordEncoded;
	}

	public void setPasswordEncoded(String passwordEncoded) {
		this.passwordEncoded = passwordEncoded;
	}

	public User(Integer uid, String fname, String lname, String email, String password, String role, String enabled) {
		super();
		this.uid = uid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", password="
				+ password + ", role=" + role + ", enabled=" + enabled + "]";
	}

}
