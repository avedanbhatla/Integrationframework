package com.lzb.department.docs.web.rest.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lzb.department.docs.DAO.DepartmentDAO;
import com.lzb.hr.beans.objectbeanlist.Departments;
import com.lzb.hr.beans.objectbeanlist.Employees;
import com.lzb.hr.beans.objectbeans.Department;
import com.lzb.hr.beans.objectbeans.Employee;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentResource {

	@Autowired
	private DepartmentDAO departmentDao;
	
	
	//@GetMapping(path = "/", produces = "application/json")
	@GetMapping(produces = "application/json")
	public Departments getDepartments(){
		
		return departmentDao.getAllDepartments();
		
	}
	
	@PostMapping(path = "/add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> addDepartment(@RequestBody Department department){
		
		int id = departmentDao.getAllDepartments().getDepartmentList().size();
		department.setDeptNum(id);
		departmentDao.addDepartment(department);
		
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(department.getDeptNum())
                 .toUri();

		 return ResponseEntity.created(location).build();	
		
		
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> deleteDepartment(@RequestBody Department department){
		
		departmentDao.deleteDepartment(department.getDeptNum());
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(department.getDeptNum())
                 .toUri();

		 return ResponseEntity.created(location).build();	
	
		
	}
	
}

