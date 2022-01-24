package com.createiq.model;

public class ResponseBean {
	
	private int stausCode;
	private Object res;
	public ResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseBean(int stausCode, Object res) {
		super();
		this.stausCode = stausCode;
		this.res = res;
	}
	public int getStausCode() {
		return stausCode;
	}
	public void setStausCode(int stausCode) {
		this.stausCode = stausCode;
	}
	public Object getRes() {
		return res;
	}
	public void setRes(Object res) {
		this.res = res;
	}
	
	

}
