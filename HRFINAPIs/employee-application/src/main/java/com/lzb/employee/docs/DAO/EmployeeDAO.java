package com.lzb.employee.docs.DAO;

import org.springframework.stereotype.Repository;


import com.lzb.hr.beans.objectbeanlist.Employees;
import com.lzb.hr.beans.objectbeans.Employee;




@Repository
public class EmployeeDAO {

	
	private static Employees list = new Employees();
	static {
		list.getEmployeesList().add(new Employee(1,"Abhinav","Vedanbhatla", "Bowling Green"));
		list.getEmployeesList().add(new Employee(2,"Neeru","Biyani", "Sylvania"));
		list.getEmployeesList().add(new Employee(3,"Laura","Chandler","Toledo"));
		
	}
	public Employees getAllEmployees() {
		// TODO Auto-generated method stub
		
			return list;
	}
	
	public void addEmployee(Employee employee){
		list.getEmployeesList().add(employee);
	}
	
	public void deleteEmployee(int id){
		list.getEmployeesList().remove(id);
	}

}