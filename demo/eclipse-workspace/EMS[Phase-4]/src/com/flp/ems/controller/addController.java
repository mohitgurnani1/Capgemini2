package com.flp.ems.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.flp.ems.domain.Employee;
import com.flp.ems.service.EmployeeServiceImpl;

@Controller
@RequestMapping(value = "/addController")
public class addController {

	@Autowired
	EmployeeServiceImpl e;

	@Autowired
	Employee employee;
	
	 @RequestMapping(method = RequestMethod.POST)
	 public String processRegistration(@ModelAttribute("employee") Employee emp, Map<String,Object> model) {
		 
		
			if(e.AddEmployee(emp))
				out.write("<br><br><h3><font color='red'>Employee added successfully</font></h3>");
			else
				out.write("<br><br><h3><font color='red'>Employee couldnt be added</font></h3>");
			
			RequestDispatcher rd=request.getRequestDispatcher("add.jsp");
			rd.include(request,response);
		

			 
			 
		 
		 
	 
	 
		 return null;		
	 }
	
	 @ModelAttribute("employee")
	    Employee createEmployee(){
	    	System.out.println("TRYING TO CREATE AN ENTRY FOR A USER");
	    	return employee;
	    }
	   
	 
	 
}
