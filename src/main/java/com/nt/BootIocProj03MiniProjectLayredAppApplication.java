package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootIocProj03MiniProjectLayredAppApplication {

	public static void main(String[] args) {
		//get Access to IOC container
		ApplicationContext ctx = SpringApplication.run(BootIocProj03MiniProjectLayredAppApplication.class, args);
		
		//get the controller class object
		EmployeeController controller = ctx.getBean("empController",EmployeeController.class);
		
		//invoke the business Method
		try {
			 List<Employee> list = controller.getEmployeesBydesign("CLERK", "MANAGER", "SALESMAN");
			 
			 //Lamda expression
			 list.forEach(emp -> {
				 System.out.println("final emp" +emp);
			 });
			 
		} //try 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	
	}//main

}//class
