package com.flp.ems.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.flp.ems.domain.Department;
import com.flp.ems.domain.Employee;
import com.flp.ems.domain.Project;
import com.flp.ems.domain.Role;

public class EmployeeDaoImplForList implements IEmployeeDao {
private ArrayList<Employee> empList;
private ArrayList<Department> deptList;
private ArrayList<Project> projectList;
private ArrayList<Role> roleList;
private static EmployeeDaoImplForList dao=null;

 private EmployeeDaoImplForList() {

dao=this;
empList=new ArrayList<Employee>(); 
deptList=new ArrayList<Department>();
projectList=new ArrayList<Project>();
roleList=new ArrayList<Role>();
 

deptList.add(new Department("d1","APPLY","good"));
deptList.add(new Department("d2","ETL","good"));
deptList.add(new Department("d3","BAPI","good"));
deptList.add(new Department("d4","CCD","good"));
deptList.add(new Department("d5","MOBILE","good"));


projectList.add(new Project("p1", "Acquisition", "good", "d1"));
projectList.add(new Project("p2", "App", "good", "d5"));
projectList.add(new Project("p3", "Appian Integration", "good", "d3"));
projectList.add(new Project("p4", "API", "good", "d3"));


roleList.add(new Role("r1", "Developer", "BA3-BA4"));
roleList.add(new Role("r2", "Tech Lead", "BA4-VP"));
roleList.add(new Role("r3", "Manager", "BA4-VP"));
 }

synchronized public static  EmployeeDaoImplForList getDaoReference(){
	 if(dao==null)
		 return new EmployeeDaoImplForList();
	 else
		 return dao;
 }
 
 
 
	@Override
	public void AddEmployee(Employee emp) {
		empList.add(emp);
	}

	@Override
	public boolean ModifyEmployee(Employee emp) {
		String emailId=emp.getEmailId();
		Employee temp=null;
		for(Employee e: empList){
			if(e.getEmailId().equals(emailId))
			{
			temp=e;
			break;
			}
		}
		if(temp!=null){
		empList.remove(temp);
		empList.add(emp);
		return true;
		}
		else
		return false;
	}

	@Override
	public boolean RemoveEmployee(String key, String value) {
		Employee temp=null;
		
		if(key.equals("kinId"))
			for(Employee e: empList){
				if(e.getKinId().equals(value))
				{
				temp=e;
				break;
				}
			}
			else if(key.equals("name"))
			{
				
				for(Employee e: empList){
					if(e.getName().equals(value))
					{
					temp=e;
					break;
					}

				}
			}
			else{
				
				for(Employee e: empList){
					if(e.getEmailId().equals(value))
					{
					temp=e;
					break;
					}
				
			}

		}
		
		if(temp!=null){
		empList.remove(temp);
		return true;
		}
			
		return false;
	}

	@Override
	public Employee SearchEmployee(HashMap<String, String> emp) {
		Employee temp=null;
		if(emp.containsKey("kinId"))
		for(Employee e: empList){
			if(e.getKinId().equals(emp.get("kinId")))
			{
			temp=e;
			break;
			}
		}
		else if(emp.containsKey("name"))
		{
			
			for(Employee e: empList){
				if(e.getName().equals(emp.get("name")))
				{
				temp=e;
				break;
				}

			}
		}
		else{
			
			for(Employee e: empList){
				if(e.getEmailId().equals(emp.get("emailId")))
				{
				temp=e;
				break;
				}
			
		}
		
		}	
		
		if(temp!=null){
		return temp;
		}
		else
		return null;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
	return empList;
	}

	public ArrayList<Department> getDepartmentList() {
		return deptList;
	}

	public Department getDeptById(String deptid){
		for(Department d:deptList)
		{
			if(d.getDeptId().equals(deptid)){
				return d;
			}
		}
		return null;
	}
	
	public Role getRoleById(String roleId){
		for(Role r:roleList)
		{
			if(r.getRoleId().equals(roleId)){
				return r;
			}
		}
		return null;
	}
		
	public Project getProjectById(String projId){
		for(Project p:projectList)
		{
			if(p.getProjId().equals(projId)){
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Project> getProjectList(String deptid) {
		Department d=getDeptById(deptid);
		ArrayList<Project> temp=new ArrayList<Project>();
		for(Project p:projectList)
		{
			if(p.getDeptId().equals(deptid))
				temp.add(p);
		}		
		return temp;
	}

	public ArrayList<Role> getRoleList() {
		return roleList;
	}

	public Employee getEmployeeByEmailId(String emailId) {
		for(Employee e:empList)
		{
			if(e.getEmailId().equals(emailId)){
				return e;
			}
		}
		return null;
	}

}
