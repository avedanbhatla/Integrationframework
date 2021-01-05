package com.lzb.hr.beans.objectbeanlist;

import java.util.ArrayList;
import java.util.List;

import com.lzb.hr.beans.objectbeans.Department;
import com.lzb.hr.beans.objectbeans.Employee;


public class Departments {
	List<Department> departmentList;

	public List<Department> getDepartmentList() {
		if(departmentList == null){
			departmentList = new ArrayList<Department>();
		}
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
	
	
}
