package com.flp.ems.dao;
import com.flp.ems.domain.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public interface IEmployeeDao {

	public void AddEmployee(Employee emp);
	public boolean  ModifyEmployee(Employee emp);
	public boolean RemoveEmployee(String key,String value);
	public Employee SearchEmployee(HashMap<String, String> emp);
	public ArrayList<Employee> getAllEmployee();
	
}
