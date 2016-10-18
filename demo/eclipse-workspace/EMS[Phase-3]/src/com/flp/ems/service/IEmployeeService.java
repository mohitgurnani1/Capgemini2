package com.flp.ems.service;

import java.util.HashMap;

public interface IEmployeeService {

	public boolean AddEmployee(HashMap<String,String> emp);
	public boolean ModifyEmployee(HashMap<String,String> emp);
	public boolean RemoveEmployee(String key,String value);
	public HashMap<String,String> SearchEmployee(HashMap<String, String> emp);
	public HashMap<String,String>[] getAllEmployee();

}
