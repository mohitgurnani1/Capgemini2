import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class EmployeeCreationSystem{

static List<Employee> emp;


public static void main(String[] args){

emp=new ArrayList<Employee>();

createEmp();
System.out.println("No of employees in company are "+countExistingEmp());
System.out.println("total no of employees hired so far are "+countTotalEmp());


}


public static void createEmp(){

int number=0;
Scanner scan=new Scanner(System.in);

System.out.println("How many employees you want to create?");
number=scan.nextInt();
scan.nextLine();

for(int i=0;i<number;i++)
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
Employee e=new Employee(fname,lname,salary,grade,md);
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


}