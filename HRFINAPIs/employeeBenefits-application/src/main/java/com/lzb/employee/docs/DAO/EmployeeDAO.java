package com.lzb.employee.docs.DAO;

import org.springframework.stereotype.Repository;

import com.lzb.hr.beans.objectbeanlist.EmployeeBenefitsList;
import com.lzb.hr.beans.objectbeans.EmployeeBenefits;





@Repository
public class EmployeeDAO {

	
	private static EmployeeBenefitsList list = new EmployeeBenefitsList();
	static {
		list.getEmployeesList().add(new EmployeeBenefits(1,"MED12","DEN13","VIS14"));
		list.getEmployeesList().add(new EmployeeBenefits(2,"MED12","DEN13","VIS14"));
		list.getEmployeesList().add(new EmployeeBenefits(3,"MED12","DEN13","VIS14"));
		
	}
	public EmployeeBenefitsList getAllEmployees() {
		// TODO Auto-generated method stub
		
			return list;
	}
	
	public void addEmployee(EmployeeBenefits employee){
		list.getEmployeesList().add(employee);
	}
	
	public void deleteEmployee(int id){
		list.getEmployeesList().remove(id);
	}

}