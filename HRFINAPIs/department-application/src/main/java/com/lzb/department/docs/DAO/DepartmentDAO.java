package com.lzb.department.docs.DAO;

import org.springframework.stereotype.Repository;

import com.lzb.hr.beans.objectbeanlist.Departments;

import com.lzb.hr.beans.objectbeans.Department;





@Repository
public class DepartmentDAO {

	
	private static Departments list = new Departments();
	static {
		list.getDepartmentList().add(new Department(1,"00105","Monroe"));
		list.getDepartmentList().add(new Department(2,"00106", "CSC"));
		list.getDepartmentList().add(new Department(3,"00107","Monroe"));
		
	}
	public Departments getAllDepartments() {
		// TODO Auto-generated method stub
		
			return list;
	}
	
	public void addDepartment(Department department){
		list.getDepartmentList().add(department);
	}
	
	public void deleteDepartment(int id){
		list.getDepartmentList().remove(id);
	}

}