package com.lzb.employee.docs.web.rest.resource;

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


import com.lzb.employee.docs.DAO.EmployeeDAO;
import com.lzb.hr.beans.objectbeanlist.Employees;
import com.lzb.hr.beans.objectbeans.Employee;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeResource {

	@Autowired
	private EmployeeDAO employeeDao;
	
	
	//@GetMapping(path = "/", produces = "application/json")
	@GetMapping(produces = "application/json")
	public Employees getEmployees(){
		
		return employeeDao.getAllEmployees();
		
	}
	
	@PostMapping(path = "/add", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
		
		Integer id = employeeDao.getAllEmployees().getEmployeesList().size();
		employee.setId(id);
		employeeDao.addEmployee(employee);
		
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(employee.getId())
                 .toUri();

		 return ResponseEntity.created(location).build();	
		
		
	}
	
	@DeleteMapping(path = "/delete", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> deleteEmployee(@RequestBody Employee employee){
		
		employeeDao.deleteEmployee(employee.getId());
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(employee.getId())
                 .toUri();

		 return ResponseEntity.created(location).build();	
	
		
	}
	
}

