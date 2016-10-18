package Main;
import java.util.*;
import java.text.SimpleDateFormat;
import myUtility.*;
import Employee.*;
import Employee.contractEmployee.Contractor;
import Employee.permanentEmployee.PermanentEmployee;
public class EmployeeCreationSystem{

static List<Employee> emp;
static Contractor contractor;
private static Scanner scan;
private static int contractno;
private static int permanentno;

public static void main(String[] args){
	
scan=new Scanner(System.in);
contractor=new Contractor("Mohit");


System.out.println("How many employees you want to create of Contract Based Category? under Mohit");
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
}






private static void createContractEmp() {

for(int i=0;i<contractno;i++)
{

System.out.println("Enter your Firstname");
String fname=scan.nextLine();
System.out.println("Enter your Lastname");
String lname=scan.nextLine();
System.out.println("Enter your grade");
String grade=scan.nextLine();
System.out.println("Enter your joining month");
String joiningmonth=scan.nextLine();
MyDate md=new MyDate(joiningmonth);

//Contractor.ContractEmployee emp;  Correct approach
Employee employee;
employee=contractor.new ContractEmployee(fname, lname, 10, 10, grade, md, "Mohit");
employee.setEmpId("EMP"+Employee.countEmployee());
emp.add(employee);
}
	

}


private static void createPermanentEmp() {
	
for(int i=contractno;i<contractno+permanentno;i++)
{

System.out.println("Enter your Firstname");
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
Employee e=new PermanentEmployee(fname,lname,salary,grade,md);
e.setEmpId("EMP"+Employee.countEmployee());
emp.add(e);
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