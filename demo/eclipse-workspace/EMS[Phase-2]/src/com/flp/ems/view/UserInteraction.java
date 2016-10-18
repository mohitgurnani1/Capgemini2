package com.flp.ems.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.flp.ems.service.EmployeeServiceImpl;

public class UserInteraction {
private static Scanner scan;

static{
	scan=new Scanner(System.in);
}
	public static void addEmployee() {
		HashMap<String, String> emp=new HashMap<String,String>();
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		
		System.out.println("ADD EMPLOYEE\n Enter your  Information");
		
		System.out.println("Enter Name:");
		emp.put("name", scan.nextLine());
		
		System.out.println("Enter Phone no:");
		emp.put("phoneNo", scan.nextLine());
		
		System.out.println("Enter Address:");
		emp.put("address", scan.nextLine());
		
		System.out.println("Enter Date of birth (format:  yyyy-mm-dd) :");
		emp.put("dob", scan.nextLine());
		
		System.out.println("Enter Date of Joining: (format:  yyyy-mm-dd)");
		emp.put("doj", scan.nextLine());
		
		System.out.println("Enter Department:");
		
		HashMap deptlist=e.getDepartmentList();
		if(deptlist==null){
			System.out.println("No department list found. Employee couldnt be created");
			return;
		}
		Set set=deptlist.entrySet();
		HashMap projlist;	

		for(Object dept:set)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)dept;
			System.out.println((String)m.getValue()); 
		}
		String deptId=null;
deptNameChange:{		
		String deptName=scan.nextLine();
		deptId=null;
		boolean flagDep=false;
		for(Object dept:set)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)dept;
			if(m.getValue().equals(deptName))
				{deptId=m.getKey();
				flagDep=true;
				break;
				}
		}
	
			if(flagDep==false){
				System.out.println("Enter Department name correctly");
				break deptNameChange;
			}
	}	
		if(deptId!=null)
		emp.put("dept",deptId );
			
		System.out.println("Enter Project:");
		
	    projlist=e.getProjectList(deptId);
		if(projlist==null || projlist.isEmpty())
			{
			System.out.println("No projects available for this department. Kindly Select another department");
			return;
			}
	
		
		Set set2=projlist.entrySet();
		for(Object proj:set2)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)proj;
			System.out.println((String)m.getValue()); 
		}
		String projName=scan.nextLine();
		String projId=null;
		for(Object proj:set2)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)proj;
			if(m.getValue().equals(projName))
				{projId=m.getKey();
				break;
				}
		}
		
		if(projId!=null)
		emp.put("project",projId );
		else{
			System.out.println("Enter project name correctly");
			return;
		}
	
	

	System.out.println("Enter Roles:");
		HashMap roleslist=e.getRolesList();
	
		Set set3=roleslist.entrySet();
		for(Object role:set3)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)role;
			System.out.println((String)m.getValue()); 
		}
		String roleName=scan.nextLine();
		String roleId=null;
		for(Object role:set3)
		{
			Map.Entry<String, String> m=(Map.Entry<String, String>)role;
			if(m.getValue().equals(roleName))
				{roleId=m.getKey();
				break;
				}
		}
		
		if(roleId!=null)
		emp.put("role",roleId );
		else{
			System.out.println("Enter role name correctly");
			return;
		}
	
	
		if(e.AddEmployee(emp))
			System.out.println("Employee added successfully");
		else
			System.out.println("Employee couldnt be added");
		
	}
	

	public static void modifyEmployee() {
		
		HashMap<String, String> emp=new HashMap<String,String>();
		EmployeeServiceImpl e=new EmployeeServiceImpl();
	
		
		System.out.println("MODIFY EMPLOYEE: ");
		
		System.out.println("Enter your email Id");
		emp.put("emailId", scan.nextLine());

		
		
		int option=0;
		do{
			System.out.println("Select option you want to modify\n1. Name\n2. Phone no\n3. Address\n4. Exit");
			option=scan.nextInt();
			scan.nextLine();
			switch(option){
			case 1: 
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
				break;
			case 2:
				System.out.println("Enter Phone no");
				emp.put("phoneNo", scan.nextLine());
				break;
			case 3:
				System.out.println("Enter Address");
				emp.put("address", scan.nextLine());
				break;
			case 4:
				break;
				default:
					break;
			}
		}while(option!=4);
		
	if(e.ModifyEmployee(emp))
		System.out.println("Employee modified successfully");
	else
		System.out.println("Employee couldnt be modified");
		
	}
	

	public static void removeEmployee() {
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		
		
	System.out.println("REMOVE  EMPLOYEE: ");
		
		int option=0;
			String key=null,value=null;
			System.out.println("Search Employee by one of the given option \n1. Kin Id\n2. Email Id\n3. Name\n4. Select from Summary");
			option=scan.nextInt();
			scan.nextLine();
			switch(option){
			case 1: 
				System.out.println("Enter Kin Id");
				key="kinId";
				value=scan.nextLine();
				break;
			case 2:
				System.out.println("Enter Email Id");
				key="emailId";
				value=scan.nextLine();
				break;
			case 3:
				System.out.println("Enter Name");
				key="name";
				value=scan.nextLine();		
				break;
			case 4:
				System.out.println("Enter email Id of employee from summary you want to delete");
				getAllEmployee();
				key="emailId";
				value=scan.nextLine();	
				break;
		default:
			break;
			}
		
	System.out.println("Enter Yes/No to confirm whether you want to delete employee "+value);
	String condition=scan.nextLine();
	if(condition.equals("Yes"))
		{if(e.RemoveEmployee(key,value))
			System.out.println("Employee deleted successfully");
		else
			System.out.println("Employee couldnt be deleted");
		}
		
		
	}
	

	public static void searchEmployee() {
	
		HashMap<String, String> emp=new HashMap<String,String>();
		EmployeeServiceImpl e=new EmployeeServiceImpl();

		
		System.out.println("SEARCH  EMPLOYEE: ");
		
		int option=0;
		
			System.out.println("Search Employee by one of the given option \n1. Kin Id\n2. Email Id\n3. Name\n4. Kin Id and Email Id\n5. EmailId and Name\n6. KinId and Name\n7. All 3");
			option=scan.nextInt();
			scan.nextLine();
			switch(option){
			case 1: 
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				break;
			case 2:
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				break;
			case 3:
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
				break;
		
			case 4:
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				break;
			case 5:
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
		
				break;
			case 6:
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
		
				break;
			case 7:
				System.out.println("Enter Kin Id");
				emp.put("kinId", scan.nextLine());
				System.out.println("Enter Email Id");
				emp.put("emailId", scan.nextLine());
				System.out.println("Enter Name");
				emp.put("name", scan.nextLine());
			break;
			default:
					break;
			
			}
			
		HashMap<String,String> hm=e.SearchEmployee(emp);
		if(hm==null || hm.isEmpty())
			{System.out.println("Employee couldnt be searched");
			return;
			}
		System.out.println("Kind ID			EMAIL ID			NAME			ROLE			DEPARTMENT				PROJECT");
		System.out.println(""+hm.get("kinId")+"		"+hm.get("emailId")+"		"+hm.get("name")+"		"+hm.get("role")+"		"+hm.get("dept")+"			"+hm.get("project"));
			
	}
	

	public static void getAllEmployee() {
		HashMap<String, String> emp[];
		EmployeeServiceImpl e=new EmployeeServiceImpl();
		emp=e.getAllEmployee();
		if(emp==null || emp.length==0){
			System.out.println("No employees to display");
			return;
		}

		System.out.println("Kind ID				EMAIL ID								NAME							ROLE				DEPARTMENT				PROJECT");

		for(HashMap<String,String> hm:emp)
			System.out.println(""+hm.get("kinId")+"		"+hm.get("emailId")+"		"+hm.get("name")+"		"+hm.get("role")+"		"+hm.get("dept")+"			"+hm.get("project"));
	}

}
