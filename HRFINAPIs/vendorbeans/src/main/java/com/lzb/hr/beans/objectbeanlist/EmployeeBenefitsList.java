package com.lzb.hr.beans.objectbeanlist;

import java.util.ArrayList;
import java.util.List;

import com.lzb.hr.beans.objectbeans.EmployeeBenefits;

public class EmployeeBenefitsList {

	List<EmployeeBenefits> employeesList;

	

	public List<EmployeeBenefits> getEmployeesList() {

		if(employeesList == null){
			employeesList = new ArrayList<EmployeeBenefits>();
		}
	return employeesList;	
	}

	public void setEmployeesList(List<EmployeeBenefits> employeesList) {
		this.employeesList = employeesList;
	}
	
	
	
}