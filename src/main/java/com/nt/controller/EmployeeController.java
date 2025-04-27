package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("empController")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	
	public List<Employee> getEmployeesBydesign(String desg1,String desg2, String desg3) throws Exception
	{
		System.out.println("This is EmployeeController");
		List<Employee> emplist = employeeService.searchEmployessByDesg(desg1, desg2, desg3);
		return emplist;
		
	}

}
