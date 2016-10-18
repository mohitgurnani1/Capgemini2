package Main;
import java.util.*;

import com.sun.security.auth.callback.TextCallbackHandler;

import BarclaysEmployee.*;
import BarclaysEmployee.contractEmployee.Contractor;
import BarclaysEmployee.permanentEmployee.PermanentEmployee;

import java.text.SimpleDateFormat;
import myUtility.*;
public class EmployeeCreationSystem{

static List<Employee> emp;
static Contractor contractor;
private static Scanner scan;
private static int contractno;
private static int permanentno;


public static void main(String[] args){

	
scan=new Scanner(System.in);
contractor=new Contractor("Mohit");


System.out.println("How many Tech Associate employees you want to create of Contract Based Category? under Mohit");
contractno=scan.nextInt();
scan.nextLine();

System.out.println("How many employees you want to create of Permanent Category?");
permanentno=scan.nextInt();
scan.nextLine();

emp=new ArrayList<Employee>();

createPermanentEmp();
createContractEmp();


System.out.println("Total No of Permanent employees hired so far are "+getPermanentTotalEmpCount());
System.out.println("total no of Contract employees hired so far are "+getContractTotalEmpCount());

System.out.println("No of employees in company are "+countExistingEmp());
System.out.println("total no of employees hired so far are "+countTotalEmp());


getEmpSalary(0);
display();


}

private static void getEmpSalary(int index){
	System.out.println("Salary of employee "+emp.get(index).getFirstName()+"  is "+emp.get(index).getSalary());
	
}

private static void display() {
	// TODO Auto-generated method stub
	
	for(int i=0;i<emp.size();i++)
		System.out.println(emp.get(i));
	
}
/*
static double getSalaryEmployee(Employee e){
	double salary=0;
	
	
	
	return salary;
}
*/




private static void createContractEmp() {

for(int i=0;i<contractno;i++)
{

System.out.println("Enter your Firstname under Contract Category");
String fname=scan.nextLine();
System.out.println("Enter your Lastname");
String lname=scan.nextLine();
System.out.println("Enter your grade");
String grade=scan.nextLine();
System.out.println("Enter your joining month");
String joiningmonth=scan.nextLine();
MyDate md=new MyDate(joiningmonth);

//Contractor.ContractEmployee emp;  Correct approach


BarclaysEmployee.contractEmployee.TechAssociate ta;
ta=new BarclaysEmployee.contractEmployee.TechAssociate(contractor, fname, lname, 10, 10, grade, md, "Mohit");
ta.setEmpId("EMP"+Employee.countEmployee());
emp.add(ta);
}
	

}


private static void createPermanentEmp() {

	BarclaysEmployee.permanentEmployee.TechAssociate td;
System.out.println("enter no of proj manager and tech associate in permanent category");
int proj,tech;
proj=scan.nextInt();
tech=scan.nextInt();
scan.nextLine();

for(int i=contractno;i<contractno+proj;i++)
{
System.out.println("Enter your Firstname(Project Manager) under Permanent");
String fname=scan.nextLine();
System.out.println("Enter your Lastname");
String lname=scan.nextLine();
System.out.println("Enter your salary");
double salary=Double.parseDouble(scan.nextLine());
System.out.println("Enter your grade");
String grade=scan.nextLine();
System.out.println("Enter your joining month");
String joiningmonth=scan.nextLine();
MyDate md=new MyDate(joiningmonth);

BarclaysEmployee.permanentEmployee.ProjectManager e=new BarclaysEmployee.permanentEmployee.ProjectManager(fname,lname,salary,grade,md);
e.setEmpId("EMP"+Employee.countEmployee());
e.setExperience(5);
e.updateSalary();
emp.add(e);
System.out.println("Mediclaim="+e.displayMediclaimCoverage());
}

for(int i=contractno+proj;i<contractno+proj+tech;i++)
{
System.out.println("Enter your Firstname(Tech Associate) under Permanent");
String fname=scan.nextLine();
System.out.println("Enter your Lastname");
String lname=scan.nextLine();
System.out.println("Enter your salary");
double salary=Double.parseDouble(scan.nextLine());
System.out.println("Enter your grade");
String grade=scan.nextLine();
System.out.println("Enter your joining month");
String joiningmonth=scan.nextLine();
MyDate md=new MyDate(joiningmonth);
BarclaysEmployee.permanentEmployee.TechAssociate e=new BarclaysEmployee.permanentEmployee.TechAssociate(fname,lname,salary,grade,md);
e.setEmpId("EMP"+Employee.countEmployee());
e.setExperience(5);
e.updateSalary();
emp.add(e);
System.out.println("Mediclaim="+e.displayMediclaimCoverage());
}
}


public static int countExistingEmp(){
return emp.size();
}

public static int countTotalEmp(){
return Employee.countEmployee();
}

public static int getPermanentTotalEmpCount(){
	return PermanentEmployee.countPEEmployee();
}


public static int getContractTotalEmpCount(){
return contractor.countCEmployee();
}

}