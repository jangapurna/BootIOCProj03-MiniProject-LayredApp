package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDao;
import com.nt.model.Employee;

@Service("empservice")
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao iEmployeeDao;
	
	@Override
	public List<Employee> searchEmployessByDesg(String desg1, String desg2, String desg3) throws Exception {
		
		List<Employee> emplist = iEmployeeDao.showAllEmployessByDesg(desg1, desg2, desg3);
		
		//Calculate net and Gross salary
		
		emplist.forEach(emp ->{
			emp.setGrossSalary((emp.getSal()+emp.getSal()*0.4f));
			emp.setNetSalary((emp.getGrossSalary()-(emp.getGrossSalary()*.2f)));
		});
		return emplist;
	}

}
