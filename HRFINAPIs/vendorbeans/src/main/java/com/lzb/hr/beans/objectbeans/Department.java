package com.lzb.hr.beans.objectbeans;

public class Department {
	
	private int deptNum;
	private String desc;
	private String location;
	
	
	
	public Department() {
		super();
	}
	public Department(int deptNum, String desc, String location) {
		super();
		this.deptNum = deptNum;
		this.desc = desc;
		this.location = location;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
