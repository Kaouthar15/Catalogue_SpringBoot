package com.ntt.Catalogue.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntt.Catalogue.models.Employee;

@CrossOrigin("http://localhost:4200")
@RequestMapping("api")
@RestController
public class RestApiEmployeeController {
	@GetMapping(value = "/employee", produces = "application/json")
	public List<Employee> getAllEmployees(){	
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1L,"Ahmed","Developer",20000));
		employees.add(new Employee(2L,"Sara","Analyst",20000));
		employees.add(new Employee(3L,"Mohammed","Manager",20000));
		employees.add(new Employee(4L,"Arije","Leader",20000));
		
		return employees;
	}

}
