package com.lzb.hr.beans.objectbeanlist;

import java.util.ArrayList;
import java.util.List;

import com.lzb.hr.beans.objectbeans.Employee;

public class Employees {

	List<Employee> employeesList;

	

	public List<Employee> getEmployeesList() {

		if(employeesList == null){
			employeesList = new ArrayList<Employee>();
		}
	return employeesList;	
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}
	
	
	
}