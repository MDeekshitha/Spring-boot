package com.demo.model;

public class Department {
	private int deptId;
	private String deptName;
	private String deptLocation;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String string) {
		this.deptName = string;
	}
	public String getDeptLocation() {
		return deptLocation;
	}
	public void setDeptLocation(String string) {
		this.deptLocation = string;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", location=" + deptLocation + "]";
	}
	
}
